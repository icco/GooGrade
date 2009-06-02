<%-- 
    Document   : ViewGrades
    Created on : Apr 26, 2009, 9:47:24 PM
    Author     : vgerdin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
  "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<%@ include file="../libs.jspf" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>[${currentCourse.department}-${currentCourse.number}-${currentCourse.section}] - Grade Predictor</title>
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
                        <h3>Grade Predictor</h3>
                        
                        <div id="data">
                            <c:choose>
                            <c:when test = "${!empty gradedList || !empty ungradedList}">
                                <c:choose>
                                <c:when test = "${fn:length(msg)>3 || !empty ungradedList}">
                                    <form action="<c:url value="predictor" />" method="post">
                                        <input type="hidden" name="id" value="${id}" />
                                        <input type=radio name="wishedGrade" onclick="this.form.submit();" value="A"/>A
                                        <input type=radio name="wishedGrade" onclick="this.form.submit();" value="B"/>B
                                        <input type=radio name="wishedGrade" onclick="this.form.submit();" value="C"/>C
                                        <input type=radio name="wishedGrade" onclick="this.form.submit();" value="D"/>D
                                    </form>
                                </c:when>
                            </c:choose>
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
                                            <c:forEach var="grade" items="${gradedList}">
                                                <tr class="color">
                                                    <td width="200">
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
                                            <tr class="color">
                                                <td>Current Grade: ${currentGradeLetter} (${currentGrade})</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                 </c:when>
                                
                                <c:otherwise>
                                    <h3 style="color: #e40000">No Graded Assignments Exist.</h3>
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
                                                    <td width="200">
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
                                            <c:if test="${fn:length(msg) > 3}">
                                            <tr class="color">
                                                <td>${msg}</td>
                                            </tr>
                                        </c:if>
                                        </tbody>
                                    </table>
                                    
                                </c:when>
                                
                                <c:otherwise>
                                    <h3 style="color: #e40000">${msg}</h3>
                                </c:otherwise>
                                </c:choose>
                                <c:choose>
                                <c:when test = "${fn:length(msg)<3 && empty ungradedList}">
                                    <h3 style="color: #e40000">No More Ungraded Assignments.</h3>
                                </c:when>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <h3 style="color: #e40000">No Assignments In This Course</h3>
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
