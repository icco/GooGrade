<%-- 
    Document   : response
    Created on : Apr 14, 2009, 8:12:31 PM
    Author     : vgerdin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h2>Tadaa!</h2>
    
    <jsp:useBean id="magicalBean" scope="session" class="prototype.User" />
    <jsp:setProperty name="magicalBean" property="id" />
    <jsp:setProperty name="magicalBean" property="name" />
    <jsp:setProperty name="magicalBean" property="email" />
    
    Id: <jsp:getProperty name="magicalBean" property="id" /><br />
    Name: <jsp:getProperty name="magicalBean" property="name" /><br />
    Email: <jsp:getProperty name="magicalBean" property="email" /><br />
    </body>
</html>
