package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a controller for teacher. It should be noted that controllers work by
 * running doPost or something similiar, then calling a function which then calls
 * the model.
 *
 * @author bluGoo
 * @version 0.42
 */
public class TeacherController extends HttpServlet
{
    /**
     * Connects models to views.
     * 
     * @param req request
     * @param resp response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String action = req.getParameter("action");
        RequestDispatcher view = null;

        resp.addCookie(new Cookie("userid", req.getParameter("who")));

        view = req.getRequestDispatcher("/teacher/teacher.jsp");
        Teacher user1 = null;
        try
        {
            user1 = new Teacher(new Integer(req.getParameter("who")));
            req.setAttribute("who", user1.getId());
        }
        catch (Exception ex)
        {
            Logger.getLogger(StudentController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        /*Setting the attributes accessible from teh jsp */
        req.setAttribute("user", (Account) (user1));
        req.setAttribute("teach", (Teacher) (user1));
        req.setAttribute("teachCourseList", (ArrayList<Course>)
                (Teacher.allTeachers().get(0).getCourses()));

        /*Determines the action asked for and performs it */
        if (action != null)
        {
            /*Delete this Teacher if necessary */
            if (action.equals("delete"))
            {
                this.deleteTeacher(new Integer(req.getParameter("accountRef")));
            }
            /*If user wishes to add, take infor from jsp and create a new Teacher*/
            else if (action.equals("add"))
            {
                this.addTeacher(req.getParameter("newUserName"),
                        req.getParameter("newFullName"),
                        req.getParameter("newEmailAddr"));
            }
        }
        /*Forward the view to viewer */
        try
        {
            view.forward(req, resp);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AccountController.class.getName()).
                    log(Level.SEVERE, "Problem loading page", ex);
        }

    }

    /**
     * Connects models to views.
     * 
     * @param req request
     * @param resp response
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;

        view = req.getRequestDispatcher("/teacher/index.jsp");

        req.setAttribute("teacherList", (ArrayList<Teacher>) 
                (Teacher.allTeachers()));
        req.setAttribute("teacherAssistantList", (ArrayList<TeacherAssistant>) 
                (TeacherAssistant.allTeacherAssistants()));
        req.setAttribute("teachCourseList", (ArrayList<Course>) 
                (Teacher.allTeachers().get(0).getCourses()));

        try
        {
            view.forward(req, resp);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AccountController.class.getName()).
                    log(Level.SEVERE, "Problem loading page", ex);
        }
    }

    private void addTeacher(String uName, String fName, String eMailAddr)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void deleteTeacher(Integer id)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
