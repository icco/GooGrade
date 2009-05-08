package goograde;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Does all of the work on the Assignment, it is the controller. 
 * We haven't really speced out what this is going to do yet.
 *
 * @author bluGoo
 * @version 0.42
 */
public class StudentAssignmentController extends HttpServlet
{

    
    /**
     * doPost performs actions
     * @param req request
     * @param resp response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {

        this.doGet(req, resp);
    }

    
    /**
     * doGet receives things
     * @param req request
     * @param resp respones
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
       
        RequestDispatcher view =
                req.getRequestDispatcher("/student/ViewAssignments.jsp");

        Student user1 = new Student();
        Integer courseId = new Integer(req.getParameter("id"));
        Course crse = new Course(courseId);

        /*Check cookies to ger a student */
        for (Cookie cook : req.getCookies())
        {
            /*Fetching Id needed, then creating the Student */
            if (cook.getName().equals("userid"))
            {
                try
                {
                    user1 = new Student(new Integer(cook.getValue()));
                }
                catch (Exception ex)
                {
                    Logger.getLogger(StudentAssignmentController.class.
                            getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
        req.setAttribute("user", Utils.getUseridCookie(req));
        req.setAttribute("id", (String) req.getParameter("id"));
        req.setAttribute("enrolledCourseList", user1.getEnrolled());
        req.setAttribute("currentCourse", crse);
        req.setAttribute("AssignmentList", (ArrayList<Assignment>)
                crse.getAssignments());

        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(StudentAssignmentController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(StudentAssignmentController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
}

