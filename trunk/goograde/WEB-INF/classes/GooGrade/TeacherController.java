package GooGrade;

import java.io.IOException;
import javax.servlet.ServletException;
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
public class TeacherController extends AccountController
{

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String action = req.getParameter("action");

        if (action.equals("change"))
        {
            this.editCourse(new Course());
        }
        else if (action.equals("add"))
        {
            this.addCourse(new Course());
        }
        else if (action.equals("remove"))
        {
            this.removeCourse(new Course());
        }
        else
        {
            //throw new InvalidOption();
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
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

    /** 
     * createAnnouncement gathers information from the user to make a new Announcement with
     * @param which The course to add an announcement for.
     * @return the new, created Announcement.
     * @TODO Implement me! for release 2
     */
    public Announcement createAnnouncement(Course which)
    {
        return new Announcement();
    }

}
