<%-- 
    Document   : index
    Created on : Apr 23, 2009, 10:19:12 PM
    Author     : pphu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
  "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Welcome to GooGrade!</title>
        <%@ include file="libs.jspf" %>
    </head>
    <body>
        
        <div id="wrap">
            
            <%
            Cookie killMyCookie = new Cookie("userid", null);
            killMyCookie.setMaxAge(0);
            killMyCookie.setPath("/");
            response.addCookie(killMyCookie);
            %>
                              
            <div id="index-content">
                <div class="cornerBox">
                    <div class="corner TL"></div>
                    <div class="corner TR"></div>
                    <div class="corner BL"></div>
                    <div class="corner BR"></div>
                    <div class="cornerBoxInner">
                        <div class="logo">
                            <img class="frontlogo" src="styles/blugooLOGO.gif" alt="Our logo" />
                        </div>
                        <div class="loginlinks">
                            <div class="cornerBox-blue" style="position: relative; top: -20px;">
                                <div class="corner-blue TL"></div>
                                <div class="corner-blue TR"></div>
                                <div class="corner-blue BL"></div>
                                <div class="corner-blue BR"></div>
                                <div class="cornerBoxInner-blue">    
                                    <ul class="iconlist">
                                        
                                        <li class="student">
                                            <h3><a href="student/student">Student's Page</a></h3>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                            <div class="cornerBox-blue" style="position: relative; top: 0px;">
                                <div class="corner-blue TL"></div>
                                <div class="corner-blue TR"></div>
                                <div class="corner-blue BL"></div>
                                <div class="corner-blue BR"></div>
                                <div class="cornerBoxInner-blue">
                                    
                                    <ul class="iconlist">
                                        <li class="teacher">
                                            <h3><a href="teacher/teacher">Teacher's Page</a></h3>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="cornerBox-blue" style="position: relative; top: 20px;">
                                <div class="corner-blue TL"></div>
                                <div class="corner-blue TR"></div>
                                <div class="corner-blue BL"></div>
                                <div class="corner-blue BR"></div>
                                <div class="cornerBoxInner-blue">
                                    
                                    <ul class="iconlist">
                                        <li class="teacher">
                                            <h3><a href="about">About Page</a></h3>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            
            
        </div>
        
        <%@ include file="footer.jspf" %>
        
        
    </body>
</html>
