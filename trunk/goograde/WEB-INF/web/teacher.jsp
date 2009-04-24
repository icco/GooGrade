<%-- 
    Document   : teacher
    Created on : Apr 23, 2009, 9:24:31 PM
    Author     : nwelch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teachers</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <h2>Teacher List</h2>
        <table>
            <tr>
                <td>Title</td>
                <td>Department</td>
                <td>Number</td>
                <td>Section</td>
            </tr>
            <c:forEach var="Teacher" items="${TeacherList}">
                <tr>
                    <td>${Teacher.TeacherTitle}</td>
                    <td>${Teacher.TeacherDepartment}</td>
                    <td>${Teacher.TeacherNumber}</td>
                    <td>${Teacher.TeacherSection}</td>
                    <td>
                        <form action="<c:url value="/Teacher.do" />" method="post">
                            <input type="hidden" name="action" value="delete" />
                            <input type="hidden" name="TeacherRef" value="${Teacher.id}" />
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <%@ include file="foot.jsp" %>
    </body>
</html>
