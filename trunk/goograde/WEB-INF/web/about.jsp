<%-- 
    Document   : about
    Created on : Apr 28, 2009, 3:16:50 PM
    Author     : nwelch
    This is for the training assignment. 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About GooGrade</title>
        <%@ include file="libs.jspf" %>
    </head>
    <body>
        <div id="wrap">
            
            <%@ include file="header.jspf" %>
            
            <div id="content">
                <div class="cornerBox">
                    <div class="corner TL"></div>
                    <div class="corner TR"></div>
                    <div class="corner BL"></div>
                    <div class="corner BR"></div>
                    <div class="cornerBoxInner">
                        <h3>About GooGrade</h3>
                        
                        <%-- Defect #174 fixed here.Make sure it shows at /about 
                        on the website to verify fix. --%>
                        <dt>Team Leader & Web Lead</dt>
                        <dd>Nat Welch</dd>
                        
                        <%-- Defect #166 fixed here --%>
                        <dt>Assistant programmer & QA manager:</dt>
                        <dd> Matt Duder</dd>
                        
                        <%--Defect 175 fixed here  --%>
                        <dt>Testing Manager</dt>
                        <dd>Katherine Blizard</dd>
                        
                        <%-- Defect #176 fixed here --%>
                        <dt>Implementation Manager & Architecture/Designer</dt>
                        <dd>Paul Phu</dd>

                        <%-- Put your about here --%>
                        
                    </div>
                </div>
            </div>
            <%@ include file="naviside.jspf" %>
        </div>
        <%@ include file="footer.jspf" %>
    </body>
</html>


