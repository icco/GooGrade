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
                            <table >
                                <tr>
                                    <th>Assignment</th>
                                    <th>Assignment Total</th>
                                    <th>Due Date</th>
                                    <th>Type</th>
                                </tr>
                                
                                <%--TODO, do display "no assignments exist" --%>
                                <c:forEach var = 'assg' items="${AssignmentList}">
                                    <tr>
                                        <td>${assg.name}</td>
                                        <td>${assg.total}</td>
                                        <%-- http://www.servletsuite.com/servlets/datetime.htm --%>
                                        <td>${assg.dueDate}</td>
                                        <td>${assg.type}</td>
                                        <td>
                                            <form action="<c:url value="course" />" method="post">
                                                <input type="hidden" name="action" value="delete" />
                                                <input type="hidden" name="AssgnId" value="${assg.id}" />
                                                <input type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <input alt="#TB_inline?height=300&width=700&inlineId=FormPopUp" 
                                   title="Add New Assignment" 
                                   class="thickbox" 
                                   type="button"
                                   value="Add New Assignment">
                            <div id="FormPopUp" style="display: none">
                                <script>
                                    $(document).ready(function(){
                                        $("#datepicker").datepicker({ dateFormat: 'mm-dd-y' });
                                    });
                                </script>
                                <form action="<c:url value="assignment"/>" method="post">
                                    <input type="hidden" name="action" value="add" />
                                    <table>
                                        <tr>
                                            <td>
                                                Title<input type="text" name="newAssgnTitle" />
                                            </td>
                                            <td>
                                                Due Date
                                                
                                                <input id="datepicker" type="date" size="5" name="newAssgnDate" />
                                            </td>
                                            <td>
                                                Total Points <input type="integer" size="5" name="newAssgnTotal" />
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
