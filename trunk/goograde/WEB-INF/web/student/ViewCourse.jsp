<%-- 
    Document   : ViewCourse
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
        <title>[${currentCourse.department}-${currentCourse.number}-${currentCourse.section}] - View Course</title>
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
                        <h3>View Course</h3>
                        <table>
                            <tr>
                                <th>Title</th>
                                <th>Department</th>
                                <th>Number</th>
                                <th>Section</th>
                            </tr>
                            <tr class="color">
                                <td>${currentCourse.title}</td>
                                <td>${currentCourse.department}</td>
                                <td>${currentCourse.number}</td>
                                <td>${currentCourse.section}</td>
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
