package GooGrade;

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
 * Does all of the work on the Assignment, it is the controller. 
 * We haven't really speced out what this is going to do yet.
 *
 * @author bluGoo
 * @version 0.42
 */
public class AssignmentController extends HttpServlet
{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String action = req.getParameter("action");

        if (action != null)
        {
            if (action.equals("delete"))
            {
                //this.deleteTeacher(new Integer(req.getParameter("accountRef")));
            }
            else if (action.equals("add"))
            {
                //this.addAssignment(req.getParameter("newUserName"),
                        }
        }

        try
        {
            this.doGet(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        RequestDispatcher view = null;

        view = req.getRequestDispatcher("/teacher/ManageAssignments.jsp");

        req.setAttribute("teacherList", (ArrayList<Teacher>) Teacher.allTeachers());
        req.setAttribute("teachCourseList", (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
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

