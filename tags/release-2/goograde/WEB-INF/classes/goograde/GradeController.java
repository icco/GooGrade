package goograde;

import java.io.IOException;
//import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controls server interactions for grades. Tells what views to serve and gets 
 * data from the model, and related models.
 * @author nwelch
 * @author kblizard
 * @version 2.42
 */
public class GradeController extends HttpServlet
{

    /**
     * to scale the percentages properly
     */
    static final int kPercentFactor = 10;
    static final int kChartSize = 200;
    /**
     * teacherSet fulfills the POST teacher request from doPost()
     * @param req the request serveletRequest
     * @param user1 the Account to use
     * @param courseId teh ID of the course being modified. 
     * @param crse the course being used. 
     * @return the view
     * @author bluGoo
     */
    private RequestDispatcher teacherSet(HttpServletRequest req, Account user1,
            Integer courseId, Course crse)
    {
        
        RequestDispatcher view =
                req.getRequestDispatcher("/teacher/ManageGrades.jsp");
         
        Teacher user3;
        try
        {
            user3 = new Teacher(user1.getId());
            req.setAttribute("teachCourseList",
                    (ArrayList<Course>) (user3.getCourses()));
        }
        catch (Exception ex)
        {
            Logger.getLogger(GradeController.class.getName()).log(Level.SEVERE,
                    "Teacher Does Not Exist", ex);
        }
       

        req.setAttribute("currentCourse", crse);
        req.setAttribute("id", courseId);
        req.setAttribute("assArray", crse.getAssignments());
        req.setAttribute("stuArray",
                (ArrayList<Student>) crse.getStudents());
        return view;
    }

    /**
     * addGrades dictate how a new grade is added to the database
     * @param req
     * @param currentCourse
     * @return the Request sent in as the paramater
     * @author bluGoo
     */
    private HttpServletRequest addGrades(HttpServletRequest req,
            Course currentCourse)
    {
        ArrayList<Assignment> asslist = currentCourse.getAssignments();
        ArrayList<Student> stulist = currentCourse.getStudents();

        //For every assignment and student, add the new grade if it is greater than 0.0
        for (Assignment ass : asslist)
        {
            // Must be n^2 since it has to update everything
            for (Student stu : stulist)
            {
                System.out.println("a" + ass.getId() + "@" + stu.getId());
                /*next */
                if (req.getParameter("a" + ass.getId() + "@" + stu.getId()) != null)
                {
                    System.out.println("hello world");
                    Float grade = new Float((String) req.getParameter("a"
                            + ass.getId() + "@" + stu.getId()));
                    //0.0 means it hasn't been updated
                    if (grade != 0.0f)
                    {
                        System.out.println("yeah");
                        // if grade is != to the current grade at stu's grade 
                        //then update grade
                        if (grade != stu.getGrade(ass))
                        {
                            System.out.println("Updating");
                            Grade newGrade = new Grade(ass, stu);
                            newGrade.updateGrade(grade);
                        }
                        else
                        {
                            System.out.println("adding");
                            Grade.addGrade(stu, ass, grade);
                        }

                    }
                }

            }

        }

        return req;
    }

    /**
     * doPost perform a specified action set by the browser. The action depends
     * if the user is a Teacher or a Student. 
     * 
     * @param req request from client
     * @param resp response to client
     * @author bluGoo
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;

        Account user1 = new Account();
        Integer courseId = new Integer((String) req.getParameter("id"));
        Course crse = new Course(courseId);
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> res = new ArrayList<ArrayList<Object>>();
        user1 = Utils.getUseridCookie(req);
        Student user2 = null;
        Teacher user3 = null;

        res = conn.query("Select * from teaches where teacher = " + user1.getId());

        //iterate over the array
        for (ArrayList<Object> arr : res)
        {
            //objects iteration
            for (Object barr : res)
            {
                try
                {
                    user3 = new Teacher(user1.getId());
                }
                catch (Exception ex)
                {
                    Logger.getLogger(GradeController.class.getName()).log(
                            Level.SEVERE, "Teacher Does Not Exist", ex);
                }
            }
        }

        // Are we a student or a teacher
        if (user3 != null)
        {
            addGrades(req, crse);
            req.setAttribute("currentCourse", crse);
            req.setAttribute("id", (String) req.getParameter("id"));
            view = teacherSet(req, user1, courseId, crse);
        }
        else // Is a student
        {
            try
            {
                user2 = new Student(user1.getId());
                req = studentHelper(req, user1, user2, crse, view);
            }
            catch (Exception ex)
            {
                Logger.getLogger(
                        GradeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        req.setAttribute("user", user1);
        doGet(req, resp);
        viewForward(view, req, resp);
    }

    /**
     * student helper does doPost for students
     * @param req the request
     * @param user1 an account 
     * @param user2 student 
     * @param crse the course 
     * @param view the view
     * @return the http request
     */
    private HttpServletRequest studentHelper(HttpServletRequest req, 
            Account user1, Student user2, Course crse, RequestDispatcher view)
    {
        try
            {
                
                view = req.getRequestDispatcher("/student/ViewGrades.jsp");
                ArrayList<Grade> gradelist = user2.getGrades(crse);
                req.setAttribute("enrolledCourseList",
                        (ArrayList<Course>) (user2.getEnrolled()));
                req.setAttribute("gradeList", gradelist);
                req.setAttribute("currentCourse", crse);
                req.setAttribute("id", (String) req.getParameter("id"));
            }
            catch (Exception ex)
            {
                Logger.getLogger(GradeController.class.getName()).log(
                        Level.SEVERE, "Student Does Not Exist", ex);
            }
        return req;
    }
    /**
     * viewForward is a wrapper for view.forward with included try and catch
     * @param view the RequestDispatcher for the view. 
     * @param req the request
     * @param resp teh response
     * @author bluGoo
     */
    private void viewForward(RequestDispatcher view, HttpServletRequest req,
            HttpServletResponse resp)
    {
        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(GradeController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(GradeController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    /**
     * doGet handles requests from the clients
     * @param req request from the client
     * @param resp response to the client
     * @author bluGoo
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;
        Account user1 = new Account();
        Integer courseId = new Integer(req.getParameter("id"));
        req.setAttribute("id", req.getParameter("id"));
        Course crse = new Course(courseId);
        user1 = Utils.getUseridCookie(req);

        // Are we a student or a teacher
        if (user1.isTeacher())
        {
            view = req.getRequestDispatcher("/teacher/ManageGrades.jsp");
            req = teacherHelper(req, resp, view, user1, courseId, crse);
        }
        else // Is a student
        {
            try
            {
                Student user2 = new Student(user1.getId());
                view = req.getRequestDispatcher("/student/ViewGrades.jsp");
                ArrayList<Grade> gradelist = Grade.getGrades(crse, user2, 0);
                req.setAttribute("enrolledCourseList",
                        (ArrayList<Course>) (user2.getEnrolled()));
                req.setAttribute("gradeList", gradelist);
                req.setAttribute("currentCourse", crse);
                req.setAttribute("id", (String) req.getParameter("id"));
                req.setAttribute("currentGrade", user2.getCurrentGrade(crse) 
                        + "%");
                req.setAttribute("currentGradeLetter", 
                        user2.getCurrentGradeLetter(crse));
                req.setAttribute("graph", 
                        Metrics.gradeDistroBars(crse, kChartSize,
                        kChartSize, kPercentFactor));
            }
            catch (Exception ex)
            {
                Logger.getLogger(GradeController.class.getName()).log(
                        Level.SEVERE, "Student Does Not Exist", ex);
            }
        }

        req.setAttribute("user", Utils.getUseridCookie(req));
        viewForward(view, req, resp);
    }

    /**
     * teacher helper is doGet for teachers. 
     * @param req request
     * @param resp response
     * @param view the view
     * @param user1 a user
     * @param courseId the identification of the course
     * @param crse the course the request pertains to. 
     * @return the http request
     */
    private HttpServletRequest teacherHelper(HttpServletRequest req, 
            HttpServletResponse resp, RequestDispatcher view, Account user1,
            Integer courseId, Course crse)
    {
        
            Teacher user3;
            ArrayList<Grade> gradelist = gradeListHelper();

            try
            {
                user3 = new Teacher(user1.getId());
                req.setAttribute("teachCourseList",
                        (ArrayList<Course>) (user3.getCourses()));
            }
            catch (Exception ex)
            {
                Logger.getLogger(GradeController.class.getName()).log(
                        Level.SEVERE, "Teacher Does Not Exist", ex);
            }

            req.setAttribute("currentCourse", crse);
            req.setAttribute("id", courseId);
            req.setAttribute("gradeList", gradelist);
            req.setAttribute("assArray", crse.getAssignments());
            req.setAttribute("stuArray", (ArrayList<Student>) crse.getStudents());
            return req;
    }
    /**
     * gradeListHelper is a helper method fetch all grades and log any problems
     * from fetching all the grades. 
     * @return An ArrayList of all grades
     * @author bluGoo
     */
    private ArrayList<Grade> gradeListHelper()
    {
        ArrayList<Grade> gradelist = null;
        try
        {
            gradelist = Grade.allGrades();
        }
        catch (Exception ex)
        {
            Logger.getLogger(GradeController.class.getName()).log(
                    Level.SEVERE, "All Grades Query Error", ex);
        }
        return gradelist;
    }
}
