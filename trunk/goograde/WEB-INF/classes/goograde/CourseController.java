package goograde;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

    /**
     * called from form method = "post"
     * @param req request
     * @param resp response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) 
    {
        String action = req.getParameter("action");
        Account user1 = new Account();
        RequestDispatcher view = null;

        /*get all cookies*/
        for (Cookie cook : req.getCookies())
        {
            /*we are looking for cookie "userid"*/
            if (cook.getName().equals("userid"))
            {
                user1.setId(new Integer(cook.getValue()));
                user1.fetch();
                req.setAttribute("user", user1);

            }
        }

        /*if user is teacher or ta*/
        if (user1.isTeacher() || user1.isTeacherAssistant())
        {
            this.doTeacher(req, user1, action);
            
            view = req.getRequestDispatcher("/teacher/ManageCourses.jsp");
            
        }
        else
        {
            view = req.getRequestDispatcher("/student/ViewCourse.jsp");

            this.doStudent(req, user1);
            
        }
        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(
                    CourseController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(
                    CourseController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    /**
     * called to display a page
     * @param req request
     * @param resp response
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        this.doPost(req, resp);
    }

    /**
     * controller function to delete a Course
     * @param courseRef id of course to be deleted
     * @return true if no errors
     */
    private boolean deleteCourse(String courseRef)
    {
        boolean pass = true;
        boolean ret = false;
        
        /*if courseRef is a valid Id*/
        if (!Course.validateId(courseRef))
        {
            pass = false;
        }
        /*if validation passed*/
        if (pass)
        {
            ret = Course.deleteCourse(null, new Integer(courseRef));
        }

        return ret;
    }

    /**
     * controller function to add a course 
     * @param title Course Title
     * @param department Course Department
     * @param number Course Number
     * @param section Course Section
     * @return true if no errors
     */
    private boolean addCourse(String title, String department,
            String number, String section)
    {
        boolean pass = true;
        boolean ret = false;

        /*if title is a valid title*/
        if (!Course.validateTitle(title))
        {
            pass = false;
        }
        /*if department is a valid department*/
        if (!Course.validateDepartment(department))
        {
            pass = false;
        }
        /*if number is a valid number*/
        if (!Course.validateNumber(number))
        {
            pass = false;
        }
        /*if section is a valid section*/
        if (!Course.validateSection(section))
        {
            pass = false;
        }
        /*if validation is passed*/
        if (pass)
        {
            ret = Course.addCourse(null, title, department, new Integer(number),
                    new Integer(section), Teacher.allTeachers().get(0));
        }

        return ret;
    }

    private void doStudent(HttpServletRequest req, Account user1)
    {
        Integer courseId = new Integer(req.getParameter("id"));
        Course crse = new Course(courseId);
        req.setAttribute("currentCourse", crse);
        Student user2 = null;

        try
        {
            user2 = new Student(user1.getId());
            req.setAttribute("enrolledCourseList", user2.getEnrolled());
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    CourseController.class.getName()).log(
                    Level.SEVERE, "Error With Student View", ex);
        }
    }

    private boolean preEditCourse(String courseRef, String title, 
            String department, String number, String section)
    {
        boolean pass = true;
        
        /*if courseRef is a valid id*/
        if (!Course.validateId(courseRef))
        {
            pass = false;
        }
        /*if title is a valid title*/
        if (!Course.validateTitle(title))
        {
            pass = false;
        }
        /*if department is a valid department*/
        if (!Course.validateDepartment(department))
        {
            pass = false;
        }
        /*if number is a valid number*/
        if (!Course.validateNumber(number))
        {
            pass = false;
        }
        /*if section is a valid section*/
        if (!Course.validateSection(section))
        {
            pass = false;
        }
        
        return pass;
    }
    
    /**
     * controller function to alter a course
     * @param courseRef id of course
     * @param title new title
     * @param department new department
     * @param number new number
     * @param section new section
     * @return true if no errors
     */
    private boolean editCourse(String courseRef, String title, 
            String department, String number, String section)
    {
        boolean pass = this.preEditCourse(courseRef, title, department, number, section);
        boolean ret = false;
        
        /*if validation is passed*/
        if (pass)
        {
            Course course = new Course(new Integer(courseRef));
            /*if we succeed in setting all*/
            if (course.setTitle(title) 
                    && course.setDepartment(department) 
                    && course.setNumber(new Integer(number)) 
                    && course.setSection(new Integer(section)))
            {
                ret = course.save();
            }

        }
        return ret;
    }
    /**
     * performs specified action
     * @param req Http Servlet request
     * @param action String of what we want to do
     * @return true if no errors
     */
    private boolean doAction(HttpServletRequest req, String action)
    {
        boolean ret = false;
        /*if we want to delete a course*/
        if (action.equals("delete"))
        {
            ret = this.deleteCourse(req.getParameter("courseRef"));
        }
        /*if we want to add a course*/
        else if (action.equals("add"))
        {
            ret = this.addCourse(req.getParameter("newCourseTitle"),
                req.getParameter("newCourseDepartment"),
                req.getParameter("newCourseNumber"),
                req.getParameter("newCourseSection"));
        }
        /*if we want to edit a course*/
        else if (action.equals("edit"))
        {
            ret = this.editCourse((String) req.getParameter("courseRef"),
                (String) req.getParameter("title"),
                (String) req.getParameter("department"),
                (String) req.getParameter("number"),
                (String) req.getParameter("section"));
        }
        
        return ret;
    }

    private void doTeacher(HttpServletRequest req, Account user1, String action)
    {
        /*if we have an action do*/
        if (action != null)
        {
            this.doAction(req, action);
        }
        Teacher user3 = null;
        try
        {
            user3 = new Teacher(user1.getId());
            req.setAttribute("teachCourseList", user3.getCourses());
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                   CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
