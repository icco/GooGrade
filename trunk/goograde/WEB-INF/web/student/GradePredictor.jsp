<%-- 
    Document   : ViewGrades
    Created on : Apr 26, 2009, 9:47:24 PM
    Author     : vgerdin
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
                                <c:when test = "${!empty gradedList}">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Assignment</th>
                                                <th>Your Grade</th>
                                                <th>Possible Points</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="grade" items="${gradeList}">
                                                <tr class="color">
                                                    <td>
                                                        ${grade.assignment.name}
                                                    </td>
                                                    <td>
                                                        ${grade.grade}
                                                    </td>
                                                    <td>
                                                        ${grade.assignment.total}
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:when>
                                
                                <c:otherwise>
                                    <h3 style="color: #e40000">There are no current grades in this course.</h3>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test = "${!empty ungradedList}">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Assignment</th>
                                                <th>Needed Grade</th>
                                                <th>Possible Points</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="ungrade" items="${ungradedList}">
                                                <tr class="color">
                                                    <td>
                                                        ${ungrade.assignment.name}
                                                    </td>
                                                    <td>
                                                        ${ungrade.grade}
                                                    </td>
                                                    <td>
                                                        ${ungrade.assignment.total}
                                                    </td>
                                                </tr>
                                            </c:forEach>
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
