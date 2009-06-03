package goograde;

import java.io.IOException;
import java.text.NumberFormat;
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
     * to scale the percentages properly
     */
    static final int kPercentFactor = 10;
    /**
     * to scale the percentages properly, but the other way
     */
    static final int kHundred = 100;
        
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

        user1 = Utils.getUseridCookie(req);

        view = req.getRequestDispatcher("/student/GradePredictor.jsp");
        
        Student student = null;
        try
        {
            student = new Student(user1.getId());
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    GradePredictorController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        ArrayList<Grade> gradedList = this.getGradedList(crse, student);
        
        Character letter = (Character) req.getParameter("wishedGrade").charAt(0);
        Float grade = crse.getGradingRules().getCurve(letter).floatValue();
        ArrayList<Grade> ungradedList = this.getPredictedList(crse, student, grade);
        
        String msg = "";
        //set message whether the grade is achievable or not
        if(ungradedList == null)
        {
            msg = "Grade Not Possible";
            ungradedList = new ArrayList<Grade>();
        }
        else
        {
            msg = "Predicted Grade: " + letter;
        }
        
        req.setAttribute("msg", msg);
        ArrayList<Course> enrolledCourseList = this.getEnrolledCourseList(student);
        
        req.setAttribute("currentCourse", crse);
        req.setAttribute("id", courseId);
        req.setAttribute("gradedList", gradedList);
        req.setAttribute("ungradedList", ungradedList);
        req.setAttribute("enrolledCourseList", enrolledCourseList);
        req.setAttribute("user", Utils.getUseridCookie(req));
        req.setAttribute("currentGrade", NumberFormat.getPercentInstance().format(
                student.getCurrentGrade(crse)*kPercentFactor));
        req.setAttribute("currentGradeLetter", student.getCurrentGradeLetter(crse));
        
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
        }
        
        catch (IOException ex)
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

        user1 = Utils.getUseridCookie(req);

        view = req.getRequestDispatcher("/student/GradePredictor.jsp");
        
        Student student = null;
        try
        {
            student = new Student(user1.getId());
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    GradePredictorController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        ArrayList<Grade> gradedList = this.getGradedList(crse, student);

        ArrayList<Grade> ungradedList = 
                (ArrayList<Grade>) req.getAttribute("ungradedList");
        
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
        req.setAttribute("enrolledCourseList", enrolledCourseList);
        req.setAttribute("user", Utils.getUseridCookie(req));
        req.setAttribute("msg", " ");
        req.setAttribute("currentGrade", 
                NumberFormat.getPercentInstance().
                format(student.getCurrentGrade(crse)*kPercentFactor));
        req.setAttribute("currentGradeLetter", student.getCurrentGradeLetter(crse));
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
    private ArrayList<Grade> getPredictedList(
            Course course, 
            Student student, 
            Float grade)
    {
        ArrayList<Grade> toReturn = Grade.predictGrades(
                course, student, (grade/kHundred));
        return toReturn;
    }
}
