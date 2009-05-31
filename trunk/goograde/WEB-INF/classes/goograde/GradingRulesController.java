package goograde;

import java.io.IOException;
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
 * @author Blugoo
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
        req.setAttribute("user", user1);

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
}

