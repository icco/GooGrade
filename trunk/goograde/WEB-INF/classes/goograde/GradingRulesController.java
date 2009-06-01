package goograde;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
        Map para = req.getParameterMap();
        Integer courseId = new Integer(req.getParameter("id"));
        Course crs = new Course(courseId);
        GradingRules gr = new GradingRules(crs.getGradingRulesId());
        
        gr.setA(new Integer(req.getParameter("aVal")));
        gr.setB(new Integer(req.getParameter("bVal")));
        gr.setC(new Integer(req.getParameter("cVal")));
        gr.setD(new Integer(req.getParameter("dVal")));
        gr.save();
        
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
        Course crs = new Course(courseId);
        GradingRules gr = new GradingRules(crs.getGradingRulesId());
        int width = 300;
        int height = 200;
        int bar = 10;

        view = req.getRequestDispatcher("/teacher/GradingRules.jsp");

        req.setAttribute("user", user1);
        req.setAttribute("teachCourseList", (ArrayList<Course>) 
                (Teacher.allTeachers().get(0).getCourses()));

        req.setAttribute("imgsrc1", Metrics.gradeDistroPie(crs, width, height, bar));
        req.setAttribute("imgsrc2", Metrics.gradeCourseCurvePie(crs, width, height, bar));
        req.setAttribute("ain", gr.getA());
        req.setAttribute("bin", gr.getB());
        req.setAttribute("cin", gr.getC());
        req.setAttribute("din", gr.getD());
        
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

