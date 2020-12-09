<%-- 
    Document   : LoginAdmin
    Created on : 09-Dec-2020, 11:06:28
    Author     : K00240022
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
       <form action="AdminServlet" method="get">
         <input type="hidden" name="action" value="LoginAdmin">
         
         <label for="username">Username:</label>
         <input type="text" id="username" name="username"><br>
         
         <label for="password">Password:</label>
         <input type="text" id="password" name="password"><br>
         
         <input type="submit" value="Login" >
        </form>

    </body>
</html>
