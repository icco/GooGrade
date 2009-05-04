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
                                
                                
                                <script type="text/javascript">
                                    var index = 0;
                                </script>
                                <script type="text/javascript">
                                    function setEditCourseRef(id)
                                    {
                                        var editCourseRef = id;
                                    }
                                        
                                    function getEditCourseRef()
                                    {
                                        return editCourseRef;
                                    }
                                </script>
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
                                        <td>
                                            <form>
                                                <input alt="#TB_inline?height=60&width=700&inlineId=Edit${course.id}" 
                                                       title="Edit Course" 
                                                       class="thickbox" 
                                                       type="button"
                                                       value="Edit"
                                                       />
                                                <div id="Edit${course.id}" style="display: none">
                                                    <form id="Edit${course.id}"  action="<c:url value="course"/>" method="post">
                                                        <input type="hidden" name="action" value="edit" />
                                                        <input type="hidden" name="courseRef" value="${course.id}" />
                                                        <table class="fuckingshit">
                                                            <tr class="fuckingshit">
                                                                <td>
                                                                    Title<input type="text" size="18" maxlength="100" name="title" value="${course.title}" />
                                                                </td>
                                                                <td>
                                                                    Department<input type="text" size="5" maxlength="4" name="department" value="${course.department}" />
                                                                </td>
                                                                <td>
                                                                    Number <input type="text" size="5" maxlength="3" name="number" value="${course.number}"/>
                                                                </td>
                                                                
                                                                <td>
                                                                    Section <input type="text" size="5" maxlength="1" name="section" value="${course.section}"/>
                                                                </td>
                                                                <td>
                                                                    <input  type="submit" value="Save" />
                                                                </td>
                                                            </tr>
                                                            
                                                        </table>
                                                    </form>
                                                </div>
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
                                                Title<input type="text" maxlength="100" name="newCourseTitle" />
                                            </td>
                                            <td>
                                                Department<input type="text" size="5" maxlength="4" name="newCourseDepartment" />
                                            </td>
                                            <td>
                                                Number <input type="text" size="5" maxlength="3" name="newCourseNumber" />
                                            </td>
                                            
                                            <td>
                                                Section <input type="text" size="5" maxlength="1" name="newCourseSection" />
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
