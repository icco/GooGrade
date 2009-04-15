<%-- 
    Document   : index
    Created on : Apr 14, 2009, 4:19:59 PM
    Author     : pphu
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
        <h2>Hello Kitty!</h2>
        
        <form name="member" action="response.jsp">
            Select a member: 
            <select name="id">
                <option value="1">Nat</option>
                <option value="2">Vic</option>
                <option value="3">Mat</option>
                <option value="4">Kat</option>
                <option value="5">Pat</option>
            </select>
            <input type="submit" value="OK" />
        </form>
    </body>
</html>
