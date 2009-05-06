<%-- 
    Document   : ManageGrades
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
        <title>[${currentCourse.department}-${currentCourse.number}-${currentCourse.section}] - Manage Grades</title>
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
                        <h3>Manage Grades</h3>
                        
                        <div id="data">
                            <table>
                                <th>
                                    
                                </th>
                                <c:forEach var="assignment" items="${assArray}">
                                    <th>
                                        ${assignment.name}
                                    </th>
                                </c:forEach>
                                <c:forEach var="stu" items="${stuArray}">
                                    <tr class="color">
                                        <td>
                                            ${stu.fullName}
                                        </td>
                                        <c:forEach var="assignment" items="${assArray}">
                                            <c:forEach var="grade" items="${gradeList}">
                                                <c:if test="${(grade.student.id == stu.id) && (grade.assignment.id == assignment.id)}">
                                                    <td>
                                                        <input type="text" name="${stu.id}@${assignment.id}" value="${grade.grade}" size="4" maxlength="5" />
                                                        /${assignment.total}
                                                    </td>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                            </table>
                            <input type="submit" value="Grade" />
                            
                        </div>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
