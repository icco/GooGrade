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
 *   This class controlls Teacher Assistants. It is an extension of AccountController.
 *  
 *   @author bluGoo
 *   @version 0.42
 */
public class TeacherAssistantController extends HttpServlet
{

    /**
     * Controller post method also processes results from a doGet
     * which ends up redirected to this method
     * @param req a servlet request
     * @param resp a servlet response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {

        RequestDispatcher view = req.getRequestDispatcher("/teacherassistant.jsp");

        req.setAttribute("teacherAssistantList", 
                (ArrayList<TeacherAssistant>) TeacherAssistant.allTeacherAssistants());
        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(TeacherAssistantController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(TeacherAssistantController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Controller get method only redirects this call to the doPost above
     * @param request   a servlet with request info
     * @param response  a servlet with response info
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
            doPost(request, response); 
    }

    
    /**
     * editCourse asks for information from the user and updates the Course with it
     * @param course the course to be updated
     * @return the new, edited Course
     */
    public Course editCourse(Course course)
    {
        return course;
    }

    /**
     * removeCourse marks a course for deletion. 
     * @param course the course marked for deletion
     * @return true if no errors occur
     */
    public boolean removeCourse(Course course)
    {
        return true;
    }
    
     /**
     * Adds a new course.
      * @param course the course to be added
     * @return true if no errors occur
     */
    public boolean addCourse(Course course)
    {
        return true;
    }
}

