package goograde;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class deals with controlling Students. It is an extension of AccountController. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class StudentController extends HttpServlet
{
    /**
     * method called from form tag with method="post"
     * @param req request
     * @param resp response
     * @throws javax.servlet.ServletException on error
     * @throws java.io.IOException on error
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {

        String action = req.getParameter("action");
        RequestDispatcher view = null;

        resp.addCookie(new Cookie("userid",req.getParameter("who")));

        view = req.getRequestDispatcher("/student/viewStudent.jsp");
        Student user1 = null;
        try
        {
            user1 = new Student(new Integer(req.getParameter("who")));
            req.setAttribute("who",user1.getId());
        }
        catch (Exception ex)
        {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("stud", (Student) (user1));
        req.setAttribute("enrolledCourseList", 
                (ArrayList<Course>) (user1.getEnrolled()));
        
        try
        {
            view.forward(req, resp);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE,
                    "Problem loading page", ex);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;

        view = req.getRequestDispatcher("/student/index.jsp");

        
        req.setAttribute("studentList", (ArrayList<Student>) (Student.allStudents()));

        try
        {
            view.forward(req, resp);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE,
                    "Problem loading page", ex);
        }
        finally
        {
        }
    }
}


