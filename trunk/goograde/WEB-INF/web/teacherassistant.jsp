<%-- 
    Document   : teacherassistant
    Created on : Apr 26, 2009
    Author     : mduder
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TeacherAssistants</title>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <h2>Teacher Assistant List</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>User Name</th>
                    <th>Email Address</th>
                    <th>Full Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="assist" items="${teacherAssistantList}">
                    <tr>
                        <td>${assist.userName}</td>
                        <td>${assist.emailAddress}</td>
                        <td>${assist.fullName}</td>
                        
                        
                        <td>
                            <form action="<c:url value="/TeacherAssistant.do" />" method="post">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="TeacherAssistantRef" value="${assist.id}" />
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
