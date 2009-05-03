<%-- 
    Document   : ManageCourses
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
        <title>Manage Courses</title>
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
                        <h3>Manage Courses</h3>
                        <div id="data">
                            <table>
                                <tr>
                                    <th>Title</th>
                                    <th>Department</th>
                                    <th>Number</th>
                                    <th>Section</th>
                                </tr>
                                <c:forEach var="course" items="${teachCourseList}">
                                    <c:choose>
                                        <c:when test = "${course.id % 2 == 1}">
                                            <tr>
                                            
                                            <td>${course.title}</td>
                                            <td>${course.department}</td>
                                            <td>${course.number}</td>
                                            <td>${course.section}</td>
                                            <td>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td class="alt">${course.title}</td>
                                                <td class="alt">${course.department}</td>
                                                <td class="alt">${course.number}</td>
                                                <td class="alt">${course.section}</td>
                                                <td class="alt">
                                                </c:otherwise>
                                            </c:choose>
                                            
                                            <form action="<c:url value="course" />" method="post">
                                                <input type="hidden" name="action" value="delete" />
                                                <input type="hidden" name="courseRef" value="${course.id}" />
                                                <input type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <input alt="#TB_inline?height=60&width=700&inlineId=Form" 
                                   title="Add Course" 
                                   class="thickbox" 
                                   type="button"
                                   value="Add Course">
                            <div id="Form" style="display: none">
                                <form id="Form"  action="<c:url value="course"/>" method="post">
                                    <input type="hidden" name="action" value="add" />
                                    <table>
                                        <tr>
                                            <td>
                                                Title<input type="text" name="newCourseTitle" />
                                            </td>
                                            <td>
                                                Department<input type="text" size="5" name="newCourseDepartment" />
                                            </td>
                                            <td>
                                                Number <input type="text" size="5" name="newCourseNumber" />
                                            </td>
                                            
                                            <td>
                                                Section <input type="text" size="5" name="newCourseSection" />
                                            </td>
                                            <td>
                                                <input  type="submit" value="Add" />
                                            </td>
                                        </tr>
                                    
                                    </table>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
