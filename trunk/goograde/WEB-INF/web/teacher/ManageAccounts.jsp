<%-- 
    Document   : ManageAccounts
    Created on : Apr 26, 2009, 9:47:24 PM
    Author     : pphu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../libs.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ManageAccounts</title>
    </head>
    <body>
        
        <div id="wrap">
            
            <%@ include file="../header.jspf" %>
            
            <div id="content">
                <div class="cornerBox">
                    <div class="corner TL"></div>
                    <div class="corner TR"></div>
                    <div class="corner BL"></div>
                    <div class="corner BR"></div>
                    <div class="cornerBoxInner">
                        <h3>Manage Accounts</h3>
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
                                            <form action="<c:url value="/teacher/accounts?id=${course.id}" />" method="post">
                                                <input type="hidden" name="action" value="delete" />
                                                <input type="hidden" name="accountRef" value="${user.id}" />
                                                <input type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr> 
                                    <form action="<c:url value="/teacher/accounts?id=${course.id}" />" method="post">
                                        <td><input type="hidden" name="action" value="add" /></td>
                                        <td><input size ="10" name="newUserName" type="text" /></td>
                                        <td><input size ="10" name="newEmailAddr" type="text" /></td>
                                        <td><input size ="10" name="newFullName" type="text" /></td>
                                        <td>.</td>
                                        <td>.</td>
                                        <td><input type="submit" value="Engage!" /></td>
                                    </form>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
