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
 * @author pphu
 */
public class GradeController extends HttpServlet
{
        @Override
    /**
     * doPost performs actions
     * @param req request
     * @param resp response
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {

        String action = req.getParameter("action"); //the action to be done

        /*Determine which action needs to be taken */
        if (action != null)
        {

        }

        try
        {
            this.doGet(req, resp);
        } catch (ServletException ex)
        {
            Logger.getLogger(GradeController.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex)
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
        RequestDispatcher view = req.getRequestDispatcher("/teacher/ManageGrades.jsp");
        
        req.setAttribute("teachCourseList",
                (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));

        


        /*req.setAttribute("AssignmentList", (ArrayList<Course>) 
        (Teacher.allTeachers().get(0).getCourses())); */
        try
        {
            view.forward(req, resp);
        } catch (ServletException ex)
        {
            Logger.getLogger(GradeController.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(GradeController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
}
