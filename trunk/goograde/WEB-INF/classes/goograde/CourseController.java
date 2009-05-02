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
public class CourseController extends HttpServlet
{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action != null)
        {
            if (action.equals("delete"))
            {
                this.deleteCourse(req.getParameter("courseRef"));
            }
            else if (action.equals("add"))
            {
                this.addCourse(req.getParameter("newCourseTitle"),
                        req.getParameter("newCourseDepartment"),
                        req.getParameter("newCourseNumber"),
                        req.getParameter("newCourseSection"));
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
        RequestDispatcher view = req.getRequestDispatcher("/teacher/ManageCourses.jsp");

        //req.setAttribute("courseList", (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        req.setAttribute("teachCourseList", (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        //req.setAttribute("teachCourseList", (ArrayList<Course>) (Course.allCourses()));
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
     * addStudent adds a new student to this course. 
     * @param permission the permission of the user who calls this function
     * @param student the student that is to be added to the course
     * @return true if no errors were enountered
     */
    public boolean addStudent(Permissions permission, Student student, Course course)
    {
        return false;
    }

    /** 
     * removeStudent removes a particular student from the course.
     * @param permission the permission of the user who calls this function
     * @param student the student to be removed from this course
     * @return true if no errors were encountered in removal.
     */
    public boolean removeStudent(Permissions permission, Student student, Course course)
    {
        return false;
    }

    /** 
     * addTA assignes a new TeacherAssistant to this course.
     * @param permission the permission of the user who calls this function
     * @param ta the TeacherAssistant to be assigned to this course
     * @return true if no errors have occured 
     */
    public boolean addTA(Permissions permission, TeacherAssistant ta, Course course)
    {
        return false;
    }

    /**
     * removeTA removes a TeacherAssistant from this course
     * @param permission the permission of the user who calls this function
     * @param ta the TeacherAssistant to be removed to this course
     * @return true if no errors have occured  
     */
    public boolean removeTA(Permissions permission, TeacherAssistant ta, Course course)
    {
        return false;
    }

    private void deleteCourse(String courseRef)
    {
        Course.deleteCourse(null, new Integer(courseRef));
    }

    private void addCourse(String title, String department, String number, String section)
    {
        Course.addCourse(null, title, department, new Integer(number), new Integer(section), Teacher.allTeachers().get(0));
    }
}
