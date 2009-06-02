<%-- 
    Document   : ViewGrades
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
        <title>[${currentCourse.department}-${currentCourse.number}-${currentCourse.section}] - View Grades</title>
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
                        <h3>View Grades</h3>
                        
                        <div id="data">
                            <c:choose>
                                <c:when test = "${!empty gradeList}">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Assignment</th>
                                                <th>Grade</th>
                                                <th>Total Points</th>
                                                <th>Mode</th>
                                                <th>Mean</th>
                                                <th>Due Date</th>
                                                <th>Type</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="user" items="${gradeList}">
                                                <tr class="color">
                                                    <td>
                                                        ${user.assignment.name}
                                                    </td>
                                                    <td>
                                                        <c:if test="${user.graded}" >
                                                            ${user.grade}
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        ${user.assignment.total}
                                                    </td>
                                                    <td>
                                                        ${user.assignment.mode}
                                                    </td>
                                                    <td>
                                                        ${user.assignment.mean}
                                                    </td>
                                                    <td>
                                                        ${user.assignment.dueDate}
                                                    </td>
                                                    <td>
                                                        ${user.assignment.type}
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <tr class ="color">
                                                <td width="200">
                                                    Current Grade: ${currentGradeLetter} (${currentGrade})
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </c:when>
                                
                                <c:otherwise>
                                    <h3 style="color: #e40000">There are no current grades in this course.</h3>
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
