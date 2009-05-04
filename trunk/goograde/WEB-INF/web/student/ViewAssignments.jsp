<%-- 
    Document   : ViewAssignments
    Created on : Apr 26, 2009, 9:47:24 PM
    Author     : pphu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="libs.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Assignments</title>
    </head>
    
    <body>
        
        <div id="wrap">
            
            <%@ include file="header.jsp" %>
            
            <div id="content">
                <div class="cornerBox">
                    <div class="corner TL"></div>
                    <div class="corner TR"></div>
                    <div class="corner BL"></div>
                    <div class="corner BR"></div>
                    <div class="cornerBoxInner">
                        <h3>View Assignmnents</h3>
                        <div id="data"> 
                            <table >
                                <tr>
                                    <th>Assignment</th>
                                    <th>Assignment Total</th>
                                    <th>Due Date</th>
                                    <th>Type</th>
                                </tr>
                                
                                <%--TODO, do display "no assignments exist" --%>
                                <c:forEach var = 'assg' items="${AssignmentList}">
                                    <tr>
                                        <td>${assg.name}</td>
                                        <td>${assg.total}</td>
                                        <%-- http://www.servletsuite.com/servlets/datetime.htm --%>
                                        <td>${assg.dueDate}</td>
                                        <td>${assg.type}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jsp" %>
            
        </div>
        
        <%@ include file="footer.jsp" %>
        
        
    </body>
</html>
