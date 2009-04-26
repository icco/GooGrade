<%-- 
    Document   : navside
    Created on : Apr 24, 2009, 3:07:57 AM
    Author     : pphu
--%>




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
            <div id=accordion>
                <h3 class="trigger"><a href="#">CSC 308-01</a></h3>
                <div class="toggle_container">
                    <div class="block">
                        <ul>
                            <li>
                                Manage Accouncements <br />
                            </li>
                            <li>
                            Manage Grades
                            </li>
                            <li>
                            Manage Assignments
                            </li>
                            <li>
                            Manage Acconts
                            </li>
                            <li>
                            Send Email
                            </li>
                            <li>
                            Take Attendance
                            </li>
                            <li>
                            View Roster
                            </li>
                            <li>
                            Adjust Grading Curve
                            </li>
                        </ul>
                    </div>
                    
                </div>
                <h3 class="trigger"><a href="#">CSC 103-05</a></h3>
                <div class="toggle_container">
                    <div class="block">
                        <ul>
                            <li>
                                Manage Accouncements <br />
                            </li>
                            <li>
                            Manage Grades
                            </li>
                            <li>
                            Manage Assignments
                            </li>
                            <li>
                            Manage Acconts
                            </li>
                            <li>
                            Send Email
                            </li>
                            <li>
                            Take Attendance
                            </li>
                            <li>
                            View Roster
                            </li>
                            <li>
                            Adjust Grading Curve
                            </li>
                        </ul>
                    </div>
                    
                </div>
                <h3 class="trigger"><a href="#">CSC 471-02</a></h3>
                <div class="toggle_container">
                    <div class="block">
                        <ul>
                            <li>
                                Manage Accouncements <br />
                            </li>
                            <li>
                            Manage Grades
                            </li>
                            <li>
                            Manage Assignments
                            </li>
                            <li>
                            Manage Acconts
                            </li>
                            <li>
                            Send Email
                            </li>
                            <li>
                            Take Attendance
                            </li>
                            <li>
                            View Roster
                            </li>
                            <li>
                            Adjust Grading Curve
                            </li>
                        </ul>
                    </div>
                    
                </div>
                
                
            </div>
        </div>
        
    </div>
</div>




