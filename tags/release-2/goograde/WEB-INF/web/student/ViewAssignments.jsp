<%-- 
    Document   : ViewAssignments
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
        <title>[${currentCourse.department}-${currentCourse.number}-${currentCourse.section}] - View Assignments</title>
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
                        <h3>View Assignments</h3>
                        <div id="data"> 
                            <c:choose>
                                <c:when test="${!empty AssignmentList}">
                                    <table >
                                        <tr>
                                            <th>Assignment</th>
                                            <th>Assignment Total</th>
                                            <th>Due Date</th>
                                            <th>Type</th>
                                        </tr>
                                        <c:forEach var = 'assg' items="${AssignmentList}">
                                            <tr class="color">
                                                <td><a href="#TB_inline?height=60&width=700&inlineId=AssDesc${assg.id}a" title="${assg.name} Description" class="thickbox">${assg.name}</a></td>
                                                <td>${assg.total}</td>
                                                <%-- http://www.servletsuite.com/servlets/datetime.htm --%>
                                                <td>${assg.dueDate}</td>
                                                <td>${assg.type}</td>
                                            </tr>
                                            <div id="AssDesc${assg.id}a" style="display: none">
                                                <p>${assg.description}</p>
                                            </div>
                                        </c:forEach>
                                        <tr class="color">
                                            <td style="border:0px;background-color:#e5ecf3">Total:</td>
                                            <td>${AssignmentTotals}</td>
                                        </tr>
                                    </table>
                                </c:when>
                                <c:otherwise>
                                    <h3 style="color: #e40000">No Assignments Exist.</h3>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
