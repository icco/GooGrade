<%-- 
    Document   : course
    Created on : Apr 21, 2009, 9:23:55 AM
    Author     : vgerdin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course</title>
    </head>
    <body>
        <h2>Course List</h2>
        <table>
            <tr>
                <td>Title</td>
                <td>Department</td>
                <td>Number</td>
                <td>Section</td>
            </tr>
            <c:forEach var="course" items="${courseList}">
                <tr>
                    <td>${course.courseTitle}</td>
                    <td>${course.courseDepartment}</td>
                    <td>${course.courseNumber}</td>
                    <td>${course.courseSection}</td>
                    <td><form action="<c:url value="/Course.do" />" method="post">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="courseRef" value="${course.id}" />
                        <input type="submit" value="Delete">
                    </form></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
