package goograde;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
public class AccountSettingsController extends HttpServlet
{

    /**
     * Called automagically when a HTTP POST is made.
     * 
     * @param req the incoming HttpServletRequest
     * @param resp the outgoing HttpServletResponse
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        //NOTE/TODO integer parse failure here.
        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        String action = req.getParameter("action");
        String type = req.getParameter("type");
        Account tmp = null;
        RequestDispatcher view = req.getRequestDispatcher("/AccountSettings.jsp");

        try
        {
            tmp = new Account(new Integer(req.getParameter("accountRef")));
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    AccountSettingsController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        tmp.setUserName(req.getParameter("selfUserName"));
        tmp.setEmailAddress(new EmailAddress(req.getParameter("selfEmailAddr")));
        tmp.setFullName(req.getParameter("selfFullName"));

        tmp.save();

        this.doGet(req, resp);
    }

    /**
     * Called automagically when a HTTP GET is made.
     * 
     * @param req the incoming HttpServletRequest
     * @param resp the outgoing HttpServletResponse
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;
        view = req.getRequestDispatcher("/AccountSettings.jsp");
        Account user1 = new Account();
        //For each cookie we find
        for (Cookie cook : req.getCookies())
        {
            //We want the cookie named "userid"
            if (cook.getName().equals("userid"))
            {
                user1.setId(new Integer(cook.getValue()));
                user1.fetch();
            }
        }

        req.setAttribute("user", (Account) (user1));

        try
        {
            view.forward(req, resp);
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
     * Add an account to the system.
     * 
     * @param uName User name of new account
     * @param fName Full Name of new account
     * @param eAddr email address of new account
     */
    private void addAccount(String uName, String fName, String eAddr)
    {
        Account temp = null;
        temp = new Account();
        temp.setEmailAddress(new EmailAddress(eAddr));
        temp.setUserName(uName);
        temp.setFullName(fName);
        temp.save();


    }

    /**
     * Delete an account.
     * 
     * @param in ID of account to delete
     */
    private void deleteAccount(Integer in)
    {
        Account temp = null;
        try
        {
            temp = new Account(in);
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    AccountSettingsController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        temp.delete();
    }
}

