<%-- 
    Document   : AccountSettings
    Created on : Apr 26, 2009, 12:37:07 AM
    Author     : pphu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--
Read http://jquery.com/demo/thickbox/ for more infomation. 
I am using an iFrame (2nd to last demo)
--%>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" href="styles/popups.css" type="text/css"/>
    <body>
        <h2>Account Settings</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User Name</th>
                    <th>Email Address</th>
                    <th>Full Name</th>
                </tr>
            </thead>
            <tbody>
                
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.emailAddress}</td>
                    <td>${user.fullName}</td>
                </tr>
                
                <tr> 
                    
                </tr>
            </tbody>
        </table>
        
        <h3>Edit Account</h3>
        <form action="<c:url value="/settings" />" method="post">
            <td><input type="hidden" name="action" value="add" /></td>
            <td>Login Name:<input name="selfUserName" type="text" /></td>
            <td>Email:<input name="selfEmailAddr" type="text" /></td>
            <td>Full Name:<input name="selfFullName" type="text" /></td>
            <tr>
                <td><input type="submit" value="Enter" /></td>
            </tr>
        </form>
        
    </body>
</html>
