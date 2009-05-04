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
                            <tr>
                                <th>ID</th>
                                <th>User Name</th>
                                <th>Email Address</th>
                                <th>Full Name</th>
                                <th>Teacher?</th>
                                <th>TA?</th>
                            </tr>
                            <c:forEach var="user" items="${accountList}">
                                <tr class="color">
                                    <td>${user.id}</td>
                                    <td>${user.userName}</td>
                                    <td>${user.emailAddress}</td>
                                    <td>${user.fullName}</td>
                                    <td>.</td>
                                    <td>.</td>
                                    <td>
                                        <input alt="#TB_inline?height=60&width=700&inlineId=Edit${user.id}a" 
                                               title="Edit Course" 
                                               class="thickbox" 
                                               type="button"
                                               value="Edit"
                                               />
                                        <div id="Edit${user.id}a" style="display: none">
                                            <form id="Edit${user.id}a"  action="<c:url value="/teacher/accounts"/>" method="post">
                                                <input type="hidden" name="action" value="edit" />
                                                <input type="hidden" name="id" value="${id}" />
                                                <input type="hidden" name="accountRef" value="${user.id}" />
                                                <table>
                                                    <tr>
                                                        <td>Username <input size ="10" name="newUserName" type="text" value="${user.userName}" /></td>
                                                        <td>Email Address <input size ="10" name="newEmailAddr" type="text" value="${user.emailAddress}" /></td>
                                                        <td>Full Name <input size ="10" name="newFullName" type="text" value="${user.fullName}" /></td>
                                                        <td>
                                                            <input  type="submit" value="Save" />
                                                        </td>
                                                    </tr>
                                                </table>
                                            </form>
                                        </div>
                                    </td>
                                    <td>
                                        <form action="<c:url value="/teacher/accounts" />" method="post">
                                            <input type="hidden" name="id" value="${id}" />
                                            <input type="hidden" name="action" value="delete" />
                                            <input type="hidden" name="accountRef" value="${user.id}" />
                                            <input type="submit" value="Delete">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <input alt="#TB_inline?height=140&width=700&inlineId=Form" 
                               title="Add Student" 
                               class="thickbox" 
                               type="button"
                               value="Add Student">
                        <div id="Form" style="display: none">
                            <table>
                                <tr><td colspan="6">Add a new account:</td></tr>
                                <form action="<c:url value="/teacher/accounts" />" method="post">
                                    <input type="hidden" name="action" value="add" />
                                    <input type="hidden" name="id" value="${id}" />
                                    <tr>
                                        <td>Username <input size ="10" name="newUserName" type="text" /></td>
                                        <td>Email Address <input size ="10" name="newEmailAddr" type="text" /></td>
                                        <td>Full Name <input size ="10" name="newFullName" type="text" /></td>
                                        <td>TA <input type="radio" name="type" value="teacherAssistant" /></td>
                                        <td>Student <input type="radio" name="type" value="student" checked="checked" /></td>
                                        <td><input  type="submit" value="Add" /></td>
                                    </tr>
                                </form>
                                <tr><td colspan="6">Add an existing account:</td></tr>
                                <form action="<c:url value="/teacher/accounts" />" method="post">
                                    <input type="hidden" name="action" value="addOld" />
                                    <input type="hidden" name="id" value="${id}" />
                                    <tr>
                                        <td colspan="3">Username <select name="accountRef">
                                                <c:forEach var="oldUser" items="${allAccountList}">
                                                    <option value="${oldUser.id}">${oldUser.userName}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>TA <input type="radio" name="type" value="teacherAssistant" /></td>
                                        <td>Student <input type="radio" name="type" value="student" checked="checked" /></td>
                                        <td><input type="submit" value="Add" /></td>
                                    </tr>
                                </form>
                            </table>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
