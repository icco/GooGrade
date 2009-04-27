<%-- 
    Document   : navside
    Created on : Apr 24, 2009, 3:07:57 AM
    Author     : pphu
--%>

<!-- Begin Nav -->
<script type="text/javascript">
    $(document).ready(function(){
        $("#accordion").accordion(
        { 
            active: false, 
            alwaysOpen: false, 
            collapsible: true,
            autoHeight: true
        });

    });
</script>

<div id="side">
    <div class="cornerBox">
        <div class="corner TL"></div>
        <div class="corner TR"></div>
        <div class="corner BL"></div>
        <div class="corner BR"></div>
        <div class="cornerBoxInner">
            <h1>Goo<span style="color: #518ac1;">Grade</span></h1>
            <h2>Teacher's Control Panel</h2>
            <div id=coursepanel>
                <div class="cornerBox-blue">
                    <div class="corner-blue TL"></div>
                    <div class="corner-blue TR"></div>
                    <div class="corner-blue BL"></div>
                    <div class="corner-blue BR"></div>
                    <div class="cornerBoxInner-blue">
                        
                        <ul class="iconlist">
                            <li class="import" >
                                <img src="styles/import.png" style=" position: relative; top: 3px;">Import Course
                            </li>
                            <li class="add">
                                <img src="styles/add.png" style=" position: relative; top: 3px;">Add Course
                            </li>
                            <li class="export" >
                                <img src="styles/export.png" style=" position: relative; top: 3px;">Export Course
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <div id="accordion">
                <c:forEach var="course" items="${teachCourseList}">
                    <h3 class="trigger"><a href="#">${course.title}</a></h3>
                    <div class="toggle_container">
                        <div class="block">
                            <ul>
                                <%--
                            <li>
                                <a href="ManageAccouncements.jsp">Manage Accouncements</a>
                            </li>
                                --%>
                                <li>
                                    <a href="ManageGrades.jsp">Manage Grades</a>
                                </li>
                                <li>
                                    <a href="ManageAssignments.jsp">Manage Assignments</a>
                                </li>
                                <li>
                                    <a href="ManageAccounts.jsp">Manage Accounts</a>
                                </li>
                                <%-- For Release 2
                            <li>
                                <a href="SendEmail.jsp">Send Email</a>
                            </li>
                            <li>
                                <a href="TakeAttendance.jsp">Take Attendance</a>
                            </li>
                                --%>
                                <li>
                                    <a href="ViewRoster.jsp">View Roster</a>
                                </li>
                                <li>
                                    <a href="EditCourse.jsp">Edit Course</a>
                                </li>
                                <%-- For Release 2
                            <li>
                                <a href="AdjustGradingCurve.jsp">Adjust Grading Curve</a>
                            </li> 
                                --%>
                            </ul>
                        </div>  
                    </div>  
                </c:forEach>
            </div>
        </div>
        
    </div>
</div>

<!-- End Nav -->
