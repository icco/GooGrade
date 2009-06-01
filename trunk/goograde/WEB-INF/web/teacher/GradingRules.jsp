<%-- 
    Document   : ManageCourses
    Created on : May 30, 10pm
    Author     : nwelch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../libs.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Grading Curve</title>
        <style>
            th {
                text-align: center;
            }    
        </style>
        
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
                        <h3>Manage Grading Rules</h3>
                        <div id="data">
                            <div>
                                <img src="${imgsrc1}"> <img src="${imgsrc2}">
                            </div>
                            <div>     
                                <form method="post">
                                    <table>
                                        <tr>
                                            <th>+</th>
                                            <th>+</th>
                                            <th>+</th>
                                            <th>+</th>
                                        </tr>
                                        <tr>
                                            
                                            <td>
                                                A: <input type="text" size="2" name="aVal" value="${ain}" />
                                            </td>
                                            <td>
                                                B: <input type="text" size="2" name="bVal" value="${bin}" />
                                            </td>
                                            <td>
                                                C: <input type="text" size="2" name="cVal" value="${cin}" />
                                            </td>
                                            <td>
                                                D: <input type="text" size="2" name="dVal" value="${din}" />
                                            </td>
                                            
                                        </tr>
                                        <tr>
                                            <th>-</th>
                                            <th>-</th>
                                            <th>-</th>
                                            <th>-</th>
                                        </tr>
                                    </table>
                                    <input type="submit">
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
