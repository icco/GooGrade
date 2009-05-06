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
     * @throws javax.servlet.ServletException on error
     * @throws java.io.IOException on error
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");
        Account user1 = new Account();
        Teacher user3;
        Student user2;
        RequestDispatcher view;

        for (Cookie cook : req.getCookies())
        {
            if (cook.getName().equals("userid"))
            {
                user1.setId(new Integer(cook.getValue()));
                user1.fetch();
                req.setAttribute("user", user1);

            }
        }

        if (user1.isTeacher() || user1.isTeacherAssistant())
        {
            try
            {
                user3 = new Teacher(user1.getId());
                req.setAttribute("teachCourseList", user3.getCourses());
            }
            catch (Exception ex)
            {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
            }

            view = req.getRequestDispatcher("/teacher/ManageCourses.jsp");

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
                else if (action.equals("edit"))
                {
                    this.editCourse((String) req.getParameter("courseRef"),
                            (String) req.getParameter("title"),
                            (String) req.getParameter("department"),
                            (String) req.getParameter("number"),
                            (String) req.getParameter("section"));
                }
            }
        }
        else
        {
            view = req.getRequestDispatcher("/student/ViewCourse.jsp");

            Integer courseId = new Integer(req.getParameter("id"));
            Course crse = new Course(courseId);
            req.setAttribute("currentCourse", crse);

            try
            {
                user2 = new Student(user1.getId());
                req.setAttribute("enrolledCourseList", user2.getEnrolled());
            }
            catch (Exception ex)
            {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, "Error With Student View", ex);
            }
        }

        view.forward(req, resp);
    }

    /**
     * called to display a page
     * @param req request
     * @param resp response
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            this.doPost(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(
                    TeacherController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(
                    TeacherController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
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

        if (!Course.validateId(courseRef))
        {
            pass = false;
        }

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

        if (!Course.validateTitle(title))
        {
            pass = false;
        }
        if (!Course.validateDepartment(department))
        {
            pass = false;
        }
        if (!Course.validateNumber(number))
        {
            pass = false;
        }
        if (!Course.validateSection(section))
        {
            pass = false;
        }

        if (pass)
        {
            ret = Course.addCourse(null, title, department, new Integer(number),
                    new Integer(section), Teacher.allTeachers().get(0));
        }

        return ret;
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
    private boolean editCourse(String courseRef, String title, String department, String number, String section)
    {
        boolean pass = true;
        boolean ret = false;
        if (!Course.validateId(courseRef))
        {
            pass = false;
        }
        if (!Course.validateTitle(title))
        {
            pass = false;
        }
        if (!Course.validateDepartment(department))
        {
            pass = false;
        }
        if (!Course.validateNumber(number))
        {
            pass = false;
        }
        if (!Course.validateSection(section))
        {
            pass = false;
        }

        if (pass)
        {
            Course course = new Course(new Integer(courseRef));
            if (course.setTitle(title) && course.setDepartment(department) && course.setNumber(new Integer(number)) && course.setSection(new Integer(section)))
            {
                ret = course.save();
            }

        }

        return ret;
    }
}
