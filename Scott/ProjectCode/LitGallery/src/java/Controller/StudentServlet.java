/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import java.io.IOException;
import java.util.ArrayList;
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
public class StudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //coding here 
        String action = request.getParameter("action");
        System.out.println("action = " + action);
        HttpSession session = request.getSession();

        String nextPage = "";
        switch (action) {
            case "RequestAddStudent":
                nextPage = "/AddStudent.html";
                break;
            case "addStudent":
                nextPage = processAddStudent(request, session, nextPage);
                break;
            case "RequestRegister":
                nextPage = "/Register.jsp";
                break;
            case "RequestLoginStudent":
                nextPage = "/LoginStudent.jsp";
                break;
             case "RequestLogin":
                nextPage = "/Login.jsp";
                break;
            case "LoginStudent":
                nextPage = processLogin(request, session);
                break;
            default:

        }

        gotoPage(nextPage, request, response);
    }

    private String processAddStudent(HttpServletRequest request, HttpSession session, String nextPage) {
        System.out.println("In processAddStudent");

        String name = request.getParameter("name");
        String knumber = request.getParameter("knumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneString = request.getParameter("phone");
        String department = request.getParameter("department");
        String course = request.getParameter("course");
        String year = request.getParameter("year");

        //make price a double
        int phone = Integer.parseInt(phoneString);

        Student s = new Student(name, knumber, username, password, email, phone, department, course, year);

        if (s.createStudent()) {
            //send the user a message to say it was added-> view
            String message = "Student " + s.getUsername() + " was added to the system.";
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
    }// </edit

    private String processLogin(HttpServletRequest request, HttpSession session) {
        String nextPage;
        System.out.println("Student Login");
        //get book details
        Student StudentDetails = new Student();

        //get bookid from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Login for user  =" + username);

        StudentDetails = StudentDetails.Login(username, password);

        session.setAttribute("Student", StudentDetails);

        StudentDetails.print();

        nextPage = "/Homepage.jsp";
        return nextPage;
    }
}
