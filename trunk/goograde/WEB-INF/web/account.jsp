<%-- 
    Document   : account
    Created on : Apr 23, 2009, 9:24:31 PM
    Author     : nwelch
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accounts</title>
        <%@ include file="includes.jspf" %>
    </head>
    <body>
        <%@ include file="head.jsp" %>
        <h2>Teacher List</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User Name</th>
                    <th>Email Address</th>
                    <th>Full Name</th>
                    <th>Teacher?</th>
                    <th>TA?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${accountList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.emailAddress}</td>
                        <td>${user.fullName}</td>
                        <td>.</td>
                        <td>.</td>
                        <td>
                            <form action="<c:url value="/accounts/" />" method="post">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="accountRef" value="${user.id}" />
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr> 
                <form action="<c:url value="/accounts/" />" method="post">
                    <td><input type="hidden" name="action" value="add" /></td>
                    <td><input name="newUserName" type="text" /></td>
                    <td><input name="newEmailAddr" type="text" /></td>
                    <td><input name="newFullName" type="text" /></td>
                    <td>.</td>
                    <td>.</td>
                    <td><input type="submit" value="Engage!" /></td>
                </form>
            </tr>
            </tbody>
        </table>
        <%@ include file="foot.jsp" %>
    </body>
</html>
