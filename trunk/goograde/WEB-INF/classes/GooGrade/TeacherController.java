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
 * This is a controller for teacher. It should be noted that controllers work by
 * running doPost or something similiar, then calling a function which then calls
 * the model.
 *
 * @author bluGoo
 * @version 0.42
 */
public class TeacherController extends HttpServlet
{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String action = req.getParameter("action");

        if (action != null)
        {
            if (action.equals("delete"))
            {
                this.deleteTeacher(new Integer(req.getParameter("accountRef")));
            }
            else if (action.equals("add"))
            {
                this.addTeacher(req.getParameter("newUserName"),
                        req.getParameter("newFullName"),
                        req.getParameter("newEmailAddr"));
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
        RequestDispatcher view = req.getRequestDispatcher("/teacher.jsp");

        //req.setAttribute("teacherList", (ArrayList<Teacher>) Teacher.allTeachers());
        req.setAttribute("teachCourseList", (ArrayList<Course>)(Teacher.allTeachers().get(0).getCourses()));
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

    /**
     * editCourse asks for information from the user and updates the Course 
     * with the new information.
     * 
     * @param course The course to edit
     * @return the new, edited Course
     */
    public Course editCourse(
            Course course)
    {
        return course;
    }

    /**
     * removeCourse marks a course for deletion from the list of classes a 
     * teacher has taught. 
     * 
     * @param course the course to remove.
     * @return true if no errors occur
     */
    public boolean removeCourse(Course course)
    {
        return true;
    }

    /**
     * Adds a new course to the teachers list of taught courses.
     * 
     * @param course the course to add
     * @return true if no errors occur
     */
    public boolean addCourse(Course course)
    {
        return true;
    }

    /** 
     * createAnnouncement gathers information from the user to make a new Announcement with
     * 
     * @param which The course to add an announcement for.
     * @return the new, created Announcement.
     * @TODO Implement me! for release 2
     */
    public Announcement createAnnouncement(
            Course which)
    {
        return new Announcement();
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
