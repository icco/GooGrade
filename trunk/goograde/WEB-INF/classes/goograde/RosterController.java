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
     * @param req
     * @param resp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException
    {
        // This is a hack
        doGet(req,resp);
    }

    /**
     * 
     * @param req
     * @param resp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        RequestDispatcher view = req.getRequestDispatcher("/teacher/ViewRoster.jsp");
        req.setAttribute("teachCourseList",
            (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        
        Course roster = new Course(new Integer(req.getParameter("id")));
        
        req.setAttribute("course", roster);
        req.setAttribute("studentList", roster.getRoster());
        
        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(TeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(TeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




