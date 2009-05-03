package goograde;

import java.io.IOException;
import java.util.ArrayList;
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
public class AccountController extends HttpServlet
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
        String action = new String();
        action = req.getParameter("action");

        // Make sure the post was legit
        if (action != null)
        {
            //Do something depending on the hidden field
            if (action.equals("delete"))
            {
                this.deleteAccount(new Integer(req.getParameter("accountRef")));
            }
            else if (action.equals("add"))
            {
                this.addAccount(req.getParameter("newUserName"),
                        req.getParameter("newFullName"),
                        req.getParameter("newEmailAddr"));
            }

            try
            {
                this.doGet(req, resp);
            }
            catch (Exception ex)
            {
                Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE,
                        "Post Error", ex);
            }

        }
    }

    /**
     * Called automagically when a HTTP GET is made.
     * 
     * @param req the incoming HttpServletRequest
     * @param resp the outgoing HttpServletResponse
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        RequestDispatcher view = req.getRequestDispatcher("/account.jsp");

        req.setAttribute("accountList", (ArrayList<Account>) Teacher.allAccounts());
        req.setAttribute("teachCourseList",
            (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        
        try
        {
            view.forward(req, resp);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, 
                    "Get Error", ex);
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
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        temp.delete();
    }
}

