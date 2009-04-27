<%-- 
    Document   : teacher
    Created on : Apr 23, 2009, 9:24:31 PM
    Author     : nwelch
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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
        <table border="1">
            <thead>
                <tr>
                    <th>User Name</th>
                    <th>Email Address</th>
                    <th>Full Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="teach" items="${teacherList}">
                    <tr>
                        <td>${teach.userName}</td>
                        <td>${teach.emailAddress}</td>
                        <td>${teach.fullName}</td>
                        
                        
                        <td>
                            <form action="<c:url value="/Teacher.do" />" method="post">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="TeacherRef" value="${teach.id}" />
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%@ include file="foot.jsp" %>
    </body>
</html>
