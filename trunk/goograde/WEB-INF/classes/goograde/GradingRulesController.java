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
 * The GradingRulesController class is the GradingRules controller. 
 *
 * @author nwelch
 * @version 0.42
 */
public class GradingRulesController extends HttpServlet
{

    /**
     * 
     * @param req request
     * @param resp response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        this.doGet(req, resp);
    }

    /**
     * called to display a page
     * @param req request
     * @param resp response
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        Account user1 = Utils.getUseridCookie(req);
        RequestDispatcher view = null;
        Integer courseId = new Integer(req.getParameter("id"));
        
        System.out.println(courseId);

        view = req.getRequestDispatcher("/teacher/GradingRules.jsp");
        
        req.setAttribute("user", user1);
        req.setAttribute("teachCourseList", (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        
        req.setAttribute("imgsrc1",Metrics.gradeDistroBars(new Course(courseId), 400, 500, 5));
        

        try
        {
            view.forward(req, resp);
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    CourseController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}

