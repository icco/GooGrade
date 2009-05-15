<%-- 
    Document   : AccountSettings
    Created on : Apr 26, 2009, 12:37:07 AM
    Author     : pphu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--
Read http://jquery.com/demo/thickbox/ for more infomation. 
I am using an iFrame (2nd to last demo)
--%>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" href="/GooGrade1.1/styles/popups.css" type="text/css"/>
    <body>
        <h2>Account Settings</h2>
        <table>
            <form action="<c:url value="/settings" />" method="post">
                <tr class="color">
                    <input type="hidden" name="id" value="${currentCourse.id}" />
                    <input type="hidden" name="accountRef" value="${user.id}" />
                    <input type="hidden" name="action" value="add" />
                    <td>Login Name:<input name="selfUserName" type="text" value="${user.userName}" /></td>
                    <td>Email:<input name="selfEmailAddr" type="text" value="${user.emailAddress}"  /></td>
                    <td>Full Name:<input name="selfFullName" type="text" value="${user.fullName}"  /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Change" onclick="parent.tb_remove(); parent.location.reload();parent.location.reload()"/></td>
                </tr>
            </form>
        </table>
        
    </body>
</html>
