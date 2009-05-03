<%-- 
    Document   : Student Index
    Created on : Apr 26, 2009, 9:47:24 PM
    Author     : nwelch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../libs.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Student</title>
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
                        <h3>Your Courses</h3>
                        <p>
                            ${stud.userName}
                        </p>
                        <table>
                            <tr>
                                <td>Title</td>
                                <td>Department</td>
                                <td>Number</td>
                                <td>Section</td>
                            </tr>
                            
                            <c:forEach var="course" items="${enrolledCourseList}">
                                <tr>
                                    <td>${course.title}</td>
                                    <td>${course.department}</td>
                                    <td>${course.number}</td>
                                    <td>${course.section}</td>
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
