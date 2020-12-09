<%-- 
    Document   : Register
    Created on : 08-Dec-2020, 10:18:50
    Author     : K00240022
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register LIT Gallery</title>
    </head>
    <body>
          
        <form action="StudentServlet" method="get">
         <input type="hidden" name="action" value="RequestAddStudent">
         <input type="submit" value="Register as a Student" >
        </form>
        
         <form action="ViewerServlet" method="get">
         <input type="hidden" name="action" value="RequestAddViewer">
         <input type="submit" value="Register as a Viewer" >
        </form>
        
        
    </body>
</html>
