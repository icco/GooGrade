<%-- 
    Document   : ManageAssignments
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
        <title>Manage Assignments</title>
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
                        <h3>Manage Assignments</h3>
                        <div id="data"> 
                            <table border="0" cellspacing="30" cellpadding="2">
                                <thead>
                                    <tr>
                                        <th>Assignment</th>
                                        <th>Assignment Total</th>
                                        <th>Due Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var = 'assg' items="${teachCourseList}">
                                    <tr>
                                        <td>${assg.name}</td>
                                        <td>${assg.total}</td>
                                        <td>${assg.dueDate}</td>
                                        <td>
                                            <form action="<c:url value="course" />" method="post">
                                                <input type="hidden" name="action" value="delete" />
                                                <input type="hidden" name="courseRef" value="${assg.id}" />
                                                <input type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <input alt="#TB_inline?height=60&width=700&inlineId=Form" 
                                   title="Add New Assignment" 
                                   class="thickbox" 
                                   type="button"
                                   value="Add New Assignment">
                            <div id="Form" style="display: none">
                                <form id="Form"  action="<c:url value="ManageAssignments.jsp"/>" method="post">
                                    <input type="hidden" name="action" value="add" />
                                    <table>
                                        <tr>
                                            <td>
                                                Title<input type="text" name="newAssgnTitle" />
                                            </td>
                                            <td>
                                                Due Date<input type="text" size="5" name="newAssgnDate" />
                                            </td>
                                            <td>
                                                Total Points <input type="text" size="5" name="newAssgnTotal" />
                                            </td>

                                                <td>
                                                    Type: 
                                                    <select name="Type" size="1">
                                                        <option>Homework</option>
                                                        <option>Quiz</option>
                                                        <option>Test</option>
                                                        <option>Final</option>
                                                        <option>Participation</option>
                                                        <option>Other</option>
                                                    </select>
                                                    
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
