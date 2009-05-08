<%-- 
    Document   : Student Index
    Created on : Apr 26, 2009, 9:47:24 PM
    Author     : nwelch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Grades</title>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <link REL="SHORTCUT ICON" HREF="/GooGrade/favicon.ico" />
        
    </head>
    
    <body>
        <div style="width: 500px; margin-right: auto; margin-left: auto;">
            <p>
                <strong>
                    Select the student you want to pretend you are.
                </strong>
            </p>
            
            <form action="<c:url value="student" />" method="post">
                
                <ul style="list-style: none">
                    <c:forEach var="student" items="${studentList}">
                        <li >
                            <input type="radio" name="who" value="${student.id}" /> ${student.userName} : ${student.fullName}
                        </li>    
                    </c:forEach>
                </ul>
                
                <input type="submit" />
                
            </form>
            
            
        </div>    
        
    </body>
</html>
