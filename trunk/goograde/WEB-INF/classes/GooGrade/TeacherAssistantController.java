package GooGrade;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   This class controlls Teacher Assistants. It is an extension of AccountController.
 *  
 *   @author bluGoo
 *   @version 0.42
 */
public class TeacherAssistantController extends AccountController
{

    /**
     * I have no idea what this is supposed to do
     * @param req a servlet request
     * @param resp a servlet response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String action = req.getParameter("action");

        /* TA wishes to change course details */
        if (action.equals("change"))
        {
            this.editCourse(new Course());
        }
        
        /* TA wishes to add a course*/
        else if (action.equals("add"))
        {
            this.addCourse(new Course());
        }
        
        /* TA wishes to remove a course */
        else if (action.equals("remove"))
        {
            this.removeCourse(new Course());
        }
        
        else
        {
            throw new InvalidOption();
        }
    }
    
    /**
     * I have no idea what this is supposed to do
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setAttribute("taList", (List) TeacherAssistant.allTAs());
     RequestDispatcher view = request.getRequestDispatcher("/teacherassistant.jsp");
        view.forward(request, response);   
    }

    
    /**
     * editCourse asks for information from the user and updates the Course with it
     * @return the new, edited Course
     */
    public Course editCourse(Course course)
    {
        return course;
    }

    /**
     * removeCourse marks a course for deletion. 
     * @return true if no errors occur
     */
    public boolean removeCourse(Course course)
    {
        return true;
    }
    
     /**
     * Adds a new course.
     * @return true if no errors occur
     */
    public boolean addCourse(Course course)
    {
        return true;
    }
}

