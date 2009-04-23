<%-- 
    Document   : course
    Created on : Apr 21, 2009, 9:23:55 AM
    Author     : vgerdin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Account</title>
    </head>
    <body>
        <jsp:useBean id="account" scope="session" class="GooGrade.Account" />
        <h2><jsp:getProperty name="account" property="fullName" /></h2>
        .... : <jsp:getProperty name="account" property="courseTitle" /><br />
        .... : <jsp:getProperty name="account" property="courseDepartment" /><jsp:getProperty name="account" property="" /><br />
        .... : <jsp:getProperty name="account" property="courseSection" /><br />
        
        <form action="<c:url value="/Course.do" />" method="post">
            <input type="hidden" name="action" value="change" />
            Title <input type="text" name="newcoursetitle" value="<jsp:getProperty name="course" property="courseTitle" />" /><br />
            Department <input type="text" name="newcoursedepartment" value="<jsp:getProperty name="course" property="courseDepartment" />" /><br />
            Number <input type="text" name="newcoursenumber" value="<jsp:getProperty name="course" property="courseNumber" />"/><br />
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
