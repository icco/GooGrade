<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GooGrade Help</title>
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
                        <h3>Help</h3>
                        <div id="data">
                            <p> Pressing the submit button sends the information on the page to the application.
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="naviside.jspf" %>
        </div>
        <%@ include file="footer.jspf" %>
    </body>
</html>
