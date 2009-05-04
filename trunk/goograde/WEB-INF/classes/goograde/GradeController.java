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
 *
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

        user1.setId(new Integer((String) req.getAttribute("who")));
        user1.fetch();
        req.setAttribute("who", user1.getId());

        if (user1.isTeacher() || user1.isTeacherAssistant())
        {
            view = req.getRequestDispatcher("/teacher/ManageGrades.jsp");

            req.setAttribute("teachCourseList", (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));

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
        }
        else // Is a student
        {
            view = req.getRequestDispatcher("/student/ViewGrades.jsp");

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
            throws ServletException, IOException
    {
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

    }
}
