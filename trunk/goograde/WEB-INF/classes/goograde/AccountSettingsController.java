package goograde;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        //Course thiscourse = new Course(new Integer(req.getParameter("id")));
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
        tmp.setEmailAddress(new String(req.getParameter("selfEmailAddr")));
        tmp.setFullName(req.getParameter("selfFullName"));

        tmp.save();

        this.doGet(req, resp);
    }

    /**
     * Called automagically when a HTTP GET is made. This is usually called within
     * a iFrame, which does not support cookies.
     * 
     * @param req the incoming HttpServletRequest
     * @param resp the outgoing HttpServletResponse
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = null;
        Account user1;
        try
        {
            String temp = req.getParameter("userId");
            user1 = new Account(new Integer(temp));
            //user1 = Utils.getUseridCookie(req);
            req.setAttribute("user", user1);
            Logger.getLogger(TeacherController.class.getName()).log(Level.INFO, user1.toString());
        }
        catch (Exception ex)
        {
            Logger.getLogger(AccountSettingsController.class.getName()).log(
                    Level.SEVERE, "failure to get attribute.", ex);
        }
        view = req.getRequestDispatcher("/AccountSettings.jsp");
                
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
        temp.setEmailAddress(eAddr);
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

