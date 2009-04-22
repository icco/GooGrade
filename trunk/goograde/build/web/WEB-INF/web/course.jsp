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
        <title>Course</title>
    </head>
    <body>
        <jsp:useBean id="course" scope="session" class="GooGrade.Course" />
        <h2><jsp:getProperty name="course" property="courseTitle" /></h2>
        Class title: <jsp:getProperty name="course" property="courseTitle" /><br />
        Class reference: <jsp:getProperty name="course" property="courseDepartment" /><jsp:getProperty name="course" property="courseNumber" /><br />
        Class section: <jsp:getProperty name="course" property="courseSection" /><br />
        
        <form action="<c:url value="/Course.do" />" method="post">
            <hidden name="action" value="create" />
            Title <input type="text" name="newcoursetitle"  /><br />
            Number <input type="text" name="newcoursenumber" /><br />
            <input type="submit" value="Create new course"/>
        </form>
    </body>
</html>
