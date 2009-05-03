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
                            <form action="<c:url value="editCourse" />" method="post">
                                <input type="hidden" name="action" value="save" />
                                <input type="text" name="title" value="${course.title}" />
                                <input type="text" name="department" value="${course.department}" size="5" />
                                <input type="text" name="number" value="${course.number}" size="5" />
                                <input type="text" name="section" value="${course.section}" size="5" />
                                <input type="submit" value="save" />
                            </form>
<%--
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
                            --%>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <%@ include file="navside.jspf" %>
            
        </div>
        
        <%@ include file="../footer.jspf" %>
        
        
    </body>
</html>
