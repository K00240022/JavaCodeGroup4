<%-- 
    Document   : Login
    Created on : 08-Dec-2020, 10:26:33
    Author     : K00240022
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

        <form action="StudentServlet" method="get">
            <input type="hidden" name="action" value="RequestLoginStudent">
            <input type="submit" value="Login as a Student" >
        </form>
        <br>
        <form action="ViewerServlet" method="get">
            <input type="hidden" name="action" value="RequestLoginViewer">
            <input type="submit" value="Login as a Viewer" >
            <br>
        </form>
        <form action="AdminServlet" method="get">
            <input type="hidden" name="action" value="RequestLoginAdmin">
            <input type="submit" value="Login as a Admin" >
            <br>
        </form>
    </body>
</html>
