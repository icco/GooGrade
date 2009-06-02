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
 * @version 2.42
 */
public class GradePredictorController extends HttpServlet
{

    /**
     * Fetches the information from a cookie and places it into an Account.
     * @param user1 the Account being modified
     * @param req the request ServeletRequest. 
     * @return the accoutn modified. 
     * @author vgerdin
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
     * doPost performs actions requested by the client
     * 
     * @param req request from the client
     * @param resp response to the client
     * @author vgerdin
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;

        Account user1 = new Account();
        Integer courseId = new Integer(req.getParameter("id"));
        req.setAttribute("id", courseId);
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
        
        Character letter = (Character) req.getParameter("wishedGrade").charAt(0);
        Float grade = crse.getGradingRules().getCurve(letter).floatValue();
        ArrayList<Grade> ungradedList = this.getPredictedList(crse, student, grade);
        
        String msg = "";
        if(ungradedList == null)
        {
            msg = "Grade Not Possible";
            ungradedList = new ArrayList<Grade>();
        }
        else
        {
            msg = "To get the grade " + letter + " you need to get:";
        }
        
        req.setAttribute("msg", msg);
        ArrayList<Course> enrolledCourseList = this.getEnrolledCourseList(student);
        
        req.setAttribute("currentCourse", crse);
        req.setAttribute("id", courseId);
        req.setAttribute("gradedList", gradedList);
        req.setAttribute("ungradedList", ungradedList);
        req.setAttribute("enrolledCourseList",enrolledCourseList);
        req.setAttribute("user", Utils.getUseridCookie(req));
        req.setAttribute("currentGradeLetter", this.getCurrentGradeLetter(student, crse));
        
        viewForward(view, req, resp);
    }

    /**
     * viewForward is a wrapper for view.forward with included try and catch
     * @param view the RequestDispatcher for the view. 
     * @param req the request
     * @param resp the response
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
     * doGet processes requests from the client
     * @param req request from the client
     * @param resp respones to the client
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
            ungradedList = this.getUngradedList(crse, student);
        }
        
        ArrayList<Course> enrolledCourseList = this.getEnrolledCourseList(student);
        
        req.setAttribute("currentCourse", crse);
        req.setAttribute("id", courseId);
        req.setAttribute("gradedList", gradedList);
        req.setAttribute("ungradedList", ungradedList);
        req.setAttribute("enrolledCourseList",enrolledCourseList);
        req.setAttribute("user", Utils.getUseridCookie(req));
        req.setAttribute("msg", " ");
        req.setAttribute("currentGradeLetter", this.getCurrentGradeLetter(student, crse));
        viewForward(view, req, resp);
    }
    
    /**
     * getGradedList fetches a graded list of grades
     * @param course teh course of the grades
     * @param student the owner of the grade specified
     * @return a list of grades belonging to this student in this course
     */
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
    
    /**
     * getUngradedList get a list of ungraded grades specifed by course and student
     * @param course
     * @param student
     * @return a list of ungraded grades
     */
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
    
    /**
     * getEnrolledCourseList returns a list of courses this student is in
     * @param student
     * @return an arraylist of courses this student is in
     */
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
    
    /**
     * getPredictedList returns a list of predicted grades for a particular student
     * @param course the course this pertains to
     * @param student the student inquiring
     * @param grade the grade desired
     * @return an arraylist of predicted grades
     */
    private ArrayList<Grade> getPredictedList(Course course, Student student, Float grade)
    {
        ArrayList<Grade> toReturn = Grade.predictGrades(course, student, (grade/100));
        return toReturn;
    }
    
    /**
     * generate the letter grade (A,B,C,D or F) for a student in a course
     * @param student Student object whos grade we want
     * @param course Course in which the grade is in
     * @return Character letter grade A through F
     */
    private Character getCurrentGradeLetter(Student student, Course course)
    {
        Float grade = student.getCurrentGrade(course);
        Character ret = 'F';
        //If higher than A
        if(grade > course.getGradingRules().getA())
        {
            ret = 'A';
        }
        //If higher than B
        else if(grade > course.getGradingRules().getB())
        {
            ret = 'B';
        }
        //If higher than C
        else if(grade > course.getGradingRules().getC())
        {
            ret = 'C';
        }
        //If higher than D
        else if(grade > course.getGradingRules().getD())
        {
            ret = 'D';
        }
        
        return ret;
    }
}
