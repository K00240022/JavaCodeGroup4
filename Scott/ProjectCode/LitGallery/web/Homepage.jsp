<%-- 
    Document   : Homepage
    Created on : 07-Dec-2020, 14:51:35
    Author     : K00240022
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           <!DOCTYPE html>
           <html>
           <head>
           <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Lit </title>
           <style>
               #Register{
                   width: 33%;
                   border:2px solid black;
               }


           </style>
</head>
<body>
    <h1>Welcome to the Lit Gallery</h1>
    <div id = "Register">
        <h2> Register </h2>

        
        
        <form action="StudentServlet" method="get">
         <input type="hidden" name="action" value="RequestRegister">
         <input type="submit" value="Register" >
         <br>
         
    </form>
 
        <form action="StudentServlet" method="get">
         <input type="hidden" name="action" value="RequestLogin">
         <input type="submit" value="Login" >
         <br>

        </form>
      
    </div>

</body>
</html>
