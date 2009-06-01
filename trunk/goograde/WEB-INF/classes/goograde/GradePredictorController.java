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
 * Controls server interactions for grades. Tells what views to serve and gets 
 * data from the model, and related models.
 * @author vgerdin
 */
public class GradePredictorController extends HttpServlet
{

    /**
     * Fetches the information from a cookie and places it into an Account.
     * @param user1 the Account being modified
     * @param req the request ServeletRequest. 
     * @return the accoutn modified. 
     */
    private Account getCookie(Account user1, HttpServletRequest req)
    {
        // Gets the cookie we want
        for (Cookie cook : req.getCookies())
        {
            /*Get the id of the account in order to load it */
            if (cook.getName().equals("userid"))
            {
                user1.setId(new Integer(cook.getValue()));
                user1.fetch();
            }
        }
        
        return user1;
    }

        
    /**
     * doPost performs actions
     * 
     * @param req request
     * @param resp response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;

        Account user1 = new Account();
        Integer courseId = new Integer(req.getParameter("id"));
        req.setAttribute("id", req.getParameter("id"));
        Course crse = new Course(courseId);

        user1 = getCookie(user1, req);

        view = req.getRequestDispatcher("/student/GradePredictor.jsp");
        
        Student student = (Student) user1;
        ArrayList<Grade> gradedList = this.getGradedList(crse, student);
        
        Character letter = (Character) req.getParameter("wishedGrade").charAt(0);
        ArrayList<Grade> ungradedList = this.getPredictedList(crse, student, crse.getGradingRules().getCurve(letter).floatValue());
        
        String msg = "";
        if(ungradedList == null)
        {
            msg = "Grade " + letter + "cannot be reached. Sorry.";
            ungradedList = new ArrayList<Grade>();
        }
        
        req.setAttribute("msg", msg);
        
        ArrayList<Course> enrolledCourseList = this.getEnrolledCourseList(student);
        
        req.setAttribute("currentCourse", crse);
        req.setAttribute("id", courseId);
        req.setAttribute("gradedList", gradedList);
        req.setAttribute("ungradedList", ungradedList);
        req.setAttribute("enrolledCourseList",enrolledCourseList);
        req.setAttribute("user", Utils.getUseridCookie(req));

        viewForward(view, req, resp);
    }

    /**
     * viewForward is a wrapper for view.forward with included try and catch
     * @param view the RequestDispatcher for the view. 
     * @param req the request
     * @param resp teh response
     */
    private void viewForward(RequestDispatcher view, HttpServletRequest req,
            HttpServletResponse resp)
    {
        try
        {
            view.forward(req, resp);
        } 
 
        catch (ServletException ex)
        {
            Logger.getLogger(GradePredictorController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }        catch (IOException ex)
        {
            Logger.getLogger(GradePredictorController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    /**
     * doGet receives things
     * @param req request
     * @param resp respones
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;

        Account user1 = new Account();
        Integer courseId = new Integer(req.getParameter("id"));
        req.setAttribute("id", req.getParameter("id"));
        Course crse = new Course(courseId);

        user1 = getCookie(user1, req);

        view = req.getRequestDispatcher("/student/GradePredictor.jsp");
        
        Student student = null;
        try
        {
            student = new Student(user1.getId());
        }
        catch (Exception ex)
        {
            Logger.getLogger(GradePredictorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Grade> gradedList = this.getGradedList(crse, student);

        ArrayList<Grade> ungradedList = (ArrayList<Grade>) req.getAttribute("ungradedList");
        
        //if not set (first call) reset
        if(ungradedList == null)
        {
            this.getUngradedList(crse, student);
        }
        
        ArrayList<Course> enrolledCourseList = this.getEnrolledCourseList(student);
        
        req.setAttribute("currentCourse", crse);
        req.setAttribute("id", courseId);
        req.setAttribute("gradedList", gradedList);
        req.setAttribute("ungradedList", ungradedList);
        req.setAttribute("enrolledCourseList",enrolledCourseList);
        req.setAttribute("user", Utils.getUseridCookie(req));
        
        viewForward(view, req, resp);
    }
    
    private ArrayList<Grade> getGradedList(Course course, Student student)
    {
        ArrayList<Grade> toReturn = Grade.getGrades(course, student, 1);
        //mustn't return null
        if(toReturn == null)
        {
            toReturn = new ArrayList<Grade>();
        }
        
        return toReturn;
    }
    
    private ArrayList<Grade> getUngradedList(Course course, Student student)
    {
        ArrayList<Grade> toReturn = Grade.getGrades(course, student, -1);
        //mustn't return null
        if(toReturn == null)
        {
            toReturn = new ArrayList<Grade>();
        }
        
        return toReturn;
    }
    
    private ArrayList<Course> getEnrolledCourseList(Student student)
    {
        ArrayList<Course> toReturn = student.getEnrolled();
        //mustn't return null
        if(toReturn == null)
        {
            toReturn = new ArrayList<Course>();
        }
        
        return toReturn;
    }
    
    private ArrayList<Grade> getPredictedList(Course course, Student student, Float grade)
    {
        ArrayList<Grade> toReturn = Grade.predictGrades(course, student, (grade/100));
        return toReturn;
    }
}
