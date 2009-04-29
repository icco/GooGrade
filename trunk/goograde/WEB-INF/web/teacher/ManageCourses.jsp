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
                        <table>
                            <tr>
                                <td>Title</td>
                                <td>Department</td>
                                <td>Number</td>
                                <td>Section</td>
                            </tr>
                            <c:forEach var="course" items="${teachCourseList}">
                                <tr>
                                    <td>${course.title}</td>
                                    <td>${course.department}</td>
                                    <td>${course.number}</td>
                                    <td>${course.section}</td>
                                    <td>
                                        <form action="<c:url value="course" />" method="post">
                                            <input type="hidden" name="action" value="delete" />
                                            <input type="hidden" name="courseRef" value="${course.id}" />
                                            <input type="submit" value="Delete">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="5">
                                    <a href="#">Add Course?</a>
                                </td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>Title</td>
                                <td>Department</td>
                                <td>Number</td>
                                <td>Section</td>
                            </tr>
                                <form action="<c:url value="course" />" method="post">
                                    <input type="hidden" name="action" value="add" />
                                    <td><input type="text" name="newCourseTitle" /></td>
                                    <td><input type="text" name="newCourseDepartment" /></td>
                                    <td><input type="text" name="newCourseNumber" /></td>
                                    <td><input type="text" name="newCourseSection" /></td>
                                    <td><input type="submit" value="Add" /></td>
                                </form>
                            </tr>
                        </table>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
