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

/**
 * Methods for modifying a course and it's related actions.
 *
 * @author bluGoo
 * @version 0.42
 */
public class RosterController extends HttpServlet
{

    /**
     * 
     * @param req request class
     * @param resp response class
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)       
    {
        // This is a hack
        doGet(req, resp);
    }

    /**
     * 
     * @param req reqest class
     * @param resp response class
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = 
                req.getRequestDispatcher("/teacher/ViewRoster.jsp");
        req.setAttribute("teachCourseList",
            (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        
        Course roster = new Course(new Integer(req.getParameter("id")));
        req.setAttribute("id", req.getParameter("id"));

        req.setAttribute("currentCourse", roster);
        req.setAttribute("studentList", roster.getRoster());
        
        try
        {
            req.setAttribute("user", Utils.getUseridCookie(req));
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(TeacherController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(TeacherController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}




