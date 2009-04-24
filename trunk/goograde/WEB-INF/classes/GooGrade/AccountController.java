package GooGrade;

import java.util.*;
import java.lang.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * This class does most of the work on the Account. It is 
 * the Account controller. Not really sure what it should be 
 * doing, but we'll get to that.
 * 
 * @author bluGoo
 * @version 0.42
 */
public abstract class AccountController extends HttpServlet
{

    /**
     * For processing incoming post requests.
     * 
     * @param req The request submitted by the view
     * @param resp The response sent to the view
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }
}

