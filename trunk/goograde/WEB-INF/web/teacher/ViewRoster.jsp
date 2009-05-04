<%-- 
    Document   : ViewRoster
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
        <title>[${currentCourse.department}-${currentCourse.number}-${currentCourse.section}] - View Roster</title>
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
                        <h3>View Roster</h3>                     
                        <div id="data">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>User Name</th>
                                        <th>Email Address</th>
                                        <th>Full Name</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${studentList}">
                                        <tr class="color">
                                            <td>${user.id}</td>
                                            <td>${user.userName}</td>
                                            <td>${user.emailAddress}</td>
                                            <td>${user.fullName}</td>
                                        </tr>
                                    </c:forEach>
                                    
                                </tbody>
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
