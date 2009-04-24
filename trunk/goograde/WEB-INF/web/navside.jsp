<%-- 
    Document   : navside
    Created on : Apr 24, 2009, 3:07:57 AM
    Author     : pphu
--%>
<script type="text/javascript" src="styles/jquery-latest.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        
        $(".toggle_container").hide();

        $("h3.trigger").toggle(function(){
            $(this).addClass("active"); 
        }, function () {
            $(this).removeClass("active");
        });
        
        $("h3.trigger").click(function(){
            $(this).next(".toggle_container").slideToggle("slow,");
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
            <h3 class="trigger"><a href="#">CSC 308-01</a></h3>
            <div class="toggle_container">
                <div class="block">
                    Manage Accouncements <br />
                    Manage Grades<br />
                    Manage Assignments<br />
                    Manage Acconts<br />
                    Send Email<br />
                    Take Attendance<br />
                    View Roster<br />
                    Adjust Grading Curve<br />
                </div>
                
            </div>
            <h3 class="trigger"><a href="#">CSC 103-05</a></h3>
            <div class="toggle_container">
                <div class="block">
                    Manage Accouncements <br />
                    Manage Grades<br />
                    Manage Assignments<br />
                    Manage Acconts<br />
                    Send Email<br />
                    Take Attendance<br />
                    View Roster<br />
                    Adjust Grading Curve<br />
                    <!--Content-->
                </div>
                
            </div>
            <h3 class="trigger"><a href="#">CSC 471-02</a></h3>
            <div class="toggle_container">
                <div class="block">
                    Manage Accouncements <br />
                    Manage Grades<br />
                    Manage Assignments<br />
                    Manage Acconts<br />
                    Send Email<br />
                    Take Attendance<br />
                    View Roster<br />
                    Adjust Grading Curve<br />
                </div>
                
            </div>
            
        </div>
    </div>
</div>
</div>