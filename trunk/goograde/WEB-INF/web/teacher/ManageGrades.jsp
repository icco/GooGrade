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
                            <c:forEach var="assignment" items="${assArray}">
                                <tr>
                                    <form id="Edit${assignment.id}" method="post" action="<c:url value="grades"/>" >
                                        <th>
                                            ${assignment.name} 
                                        </th>    
                                        <c:forEach var="stu" items="${assignment.course.roster}">
                                            <td>
                                                <input type="text" name="${stu.id}" value="" size="5" maxlength="6" />
                                            </td>
                                        </c:forEach>
                                        <td>
                                            <hidden name="ass" value="${assignment.id}" />
                                            <input type="submit" value="Grade" />
                                        </td>
                                    </form>
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
