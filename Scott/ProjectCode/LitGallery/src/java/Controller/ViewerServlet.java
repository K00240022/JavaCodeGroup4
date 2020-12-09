/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import Model.Viewer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author K00240022
 */
public class ViewerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //coding here 
        String action = request.getParameter("action");
        System.out.println("action = " + action);
        HttpSession session = request.getSession();

        String nextPage = "";
        switch (action) {
            case "RequestAddViewer":
                nextPage = "/AddViewer.html";
                break;
            case "addViewer":
                nextPage = processAddViewer(request, session, nextPage);
                break;
            case "RequestRegister":
                nextPage = "/Register.jsp";
                break;
            case "RequestLoginViewer":
                nextPage = "/LoginViewer.jsp";
                break;
            case "RequestLogin":
                nextPage = "/Login.jsp";
                break;
            case "LoginViewer":
                nextPage = processLogin(request, session);
                break;
            default:

        }

        gotoPage(nextPage, request, response);
    }

    private String processAddViewer(HttpServletRequest request, HttpSession session, String nextPage) {
        System.out.println("In processAddViewer");
        //get information from the user - isbn, author price title

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneString = request.getParameter("phone");
        String address = request.getParameter("address");

        //make price a double
        int phone = Integer.parseInt(phoneString);
        Viewer v = new Viewer(name, username, password, email, address, phone);
      

        if (v.createViewer()) {
            //send the user a message to say it was added-> view
            String message = "Viewer " + v.getUsername() + " was added to the system.";
            request.setAttribute("message", message);
            //display the page again - need a new list to reflect deleted book

            //   return this.(session);
            nextPage = "/Login.jsp";
        }
        return nextPage;
    }

    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // private String processRequestAllStudents(HttpSession session) {
    // }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </ed

    private String processLogin(HttpServletRequest request, HttpSession session) {
       String nextPage;
        System.out.println("Viewer Login");
       
      
        Viewer ViewerDetails = new Viewer();
       
        //get bookid from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Login for user  =" + username);

        
       
        ViewerDetails= ViewerDetails.Login(username,password);
        
        session.setAttribute("Viewer", ViewerDetails);

       
          ViewerDetails.print();
        
        nextPage = "/Homepage.jsp";
        return nextPage;
    }
}
