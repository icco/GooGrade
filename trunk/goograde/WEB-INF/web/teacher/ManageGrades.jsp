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
                        <ul>
                            
                            <c:forEach var="assignment" items="${assArray}">
                            
                                <li><h4>${assignment.name}</h4> </li>
                                <ul> 
                                    <c:forEach var="stu" items="${assignment.course.roster}">
                                        <form id="edit" method="post" action="<c:url value="grades"/>">
                                            <li>
                                                ${stu.fullName}
                                                <c:forEach var="grade" items="gradeList">
                                                    <c:choose>
                                                        <c:when test="${(grade.assignment.id == assignment.id) && (grade.student.id == stu.id) }">
                                                        
                                                            <input type="text" name="grade" value="${grade.grade}" size="5" maxlength="6" />
                                                        </c:when>
                                                        
                                                        <c:otherwise>
                                                            <c:if test="${(grade.assignment.id == assignment.id)">
                                                        </c:otherwise>
                                                    </c:choose> 
                                                </c:forEach>
                                                <c:if var="changed" test=""
                                                      <input type="text" name="grade" value="" size="5" maxlength="6" />
                                                      <hidden name="ass" value="${assignment.id}" />
                                                      <hidden name="stu" value="${stu.id}" />
                                                      <input type="submit" value="Grade" />
                                                  </li>
                                              </form>
                                    </c:forEach>
                                </ul>
                            </c:forEach>
                            
                        </ul>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
