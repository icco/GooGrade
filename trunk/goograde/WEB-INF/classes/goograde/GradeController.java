package goograde;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controls server interactions for grades. Tells what views to serve and gets 
 * data from the model, and related models.
 * @author nwelch
 */
public class GradeController extends HttpServlet
{

    @Override
    /**
     * doPost performs actions
     * 
     * @param req request
     * @param resp response
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;
        String action = req.getParameter("action"); //the action to be done
        Account user1 = new Account();
        Integer courseId = new Integer(req.getParameter("id"));
        Course crse = new Course(courseId);

        for (Cookie cook : req.getCookies())
        {
            if (cook.getName().equals("userid"))
            {
                user1.setId(new Integer(cook.getValue()));
                user1.fetch();
            }
        }

        if (user1.isTeacher() || user1.isTeacherAssistant())
        {
            view = req.getRequestDispatcher("/teacher/ManageGrades.jsp");

            Teacher user3;
            try
            {
                user3 = new Teacher(user1.getId());
                req.setAttribute("teachCourseList", (ArrayList<Course>) (user3.getCourses()));
            }
            catch (Exception ex)
            {
                Logger.getLogger(GradeController.class.getName()).log(Level.SEVERE, "Teacher Does Not Exist", ex);
            }
            

            /*Determine which action needs to be taken */
            if (action != null)
            {
                if (action.equals("delete"))
                {
                }
                else if (action.equals("add"))
                {
                }
                else if (action.equals("edit"))
                {
                }
            }
            
            ArrayList<Grade> gradearray = new ArrayList<Grade>();
            for(Assignment ass : crse.getAssignments())
            {
                gradearray.addAll(ass.getGrades());
            }
            
            req.setAttribute("assArray", crse.getAssignments());
            req.setAttribute("gradeList", gradearray);
            req.setAttribute("stuArray",crse.getStudents());
        }
        else // Is a student
        {
            try
            {
                Student user2 = new Student(user1.getId());
                view = req.getRequestDispatcher("/student/ViewGrades.jsp");
                ArrayList<Grade> gradelist = user2.getGrades(crse);
                req.setAttribute("enrolledCourseList", (ArrayList<Course>) (user2.getEnrolled()));
                req.setAttribute("gradeList",gradelist);
            }
            catch (Exception ex)
            {
                Logger.getLogger(GradeController.class.getName()).log(Level.SEVERE, "Student Does Not Exist", ex);
            }
        }

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

    @Override
    /**
     * doGet receives things
     * @param req request
     * @param resp respones
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        doPost(req, resp);

    /*
    RequestDispatcher view = null;
    view = req.getRequestDispatcher("/student/ViewGrades.jsp");
    req.setAttribute("gradeList", (ArrayList<Grade>) (Grade.allGrades()));
    
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
     */
    }
}
