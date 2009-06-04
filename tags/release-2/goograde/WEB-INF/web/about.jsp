<%-- 
    Document   : about
    Created on : Apr 28, 2009, 3:16:50 PM
    Author     : nwelch
    This is for the training assignment. 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
  "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About GooGrade</title>
        <%@ include file="libs.jspf" %>
        <style>
            <!--
            dd {
                padding-left: 20px;
            }
            
            dt {
                padding-top: 10px;
                font-weight:900
            }
            -->
        </style>
    </head>
    <body>
        <div id="wrap">
            
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
                        <dt>Team Leader &amp; Web Lead</dt>
                        <dd>Nat Welch</dd>
                        
                        <%-- Defect #166 fixed here --%>
                        <dt>Assistant programmer &amp; QA manager:</dt>
                        <dd> Matt Duder</dd>
                        
                        <%--Defect 175 fixed here  --%>
                        <dt>Testing Manager</dt>
                        <dd>Katherine Blizard</dd>
                        
                        <%-- Defect #176 fixed here --%>
                        <dt>Implementation Manager, Architect, &amp; Designer</dt>
                        <dd>Paul Phu</dd>
                        
                        <%-- Defect #179 fixed here --%>
                        <dt>Change Mangager &amp; Analyst</dt>
                        <dd>Viktor Gerdin</dd>
                    </div>
                </div>
            </div>
            <%@ include file="naviside.jspf" %>
        </div>
        <%@ include file="footer.jspf" %>
    </body>
</html>


