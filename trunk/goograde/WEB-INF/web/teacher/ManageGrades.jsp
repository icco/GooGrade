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
                        <table>
                            <tr>
                                <th>
                                    
                                </th>
                                <c:forEach var="assignment" items="${assArray}">
                                
                                    <th>
                                        ${assignment.name} (${assignment.total})
                                    </th>
                                    
                                </c:forEach>
                            </tr>
                            <%--             
             req.setAttribute("assArray", crse.getAssignments());
            req.setAttribute("gradeList", gradearray);
            req.setAttribute("stuArray",crse.getStudents());
                            --%>
                            <c:forEach var="student" items="${stuArray}">
                                <tr class="color">
                                    <td>
                                        ${student.userName}
                                    </td>
                                    <c:forEach var="assignment" items="${assArray}">
                                    
                                        <td>

                                        </td>
                                        
                                    </c:forEach>
                                </tr>
                            </c:forEach>       
                        </table>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
