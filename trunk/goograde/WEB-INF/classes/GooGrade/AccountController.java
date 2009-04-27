package GooGrade;

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

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String action = req.getParameter("action");

        if(action.equals("delete"))
        {
            this.deleteAccount(new Integer(req.getParameter("accountRef")));
        }
        else if(action.equals("add"))
        {
            this.addAccount(req.getParameter("newUserName"),
                    req.getParameter("newFullName"),
                    req.getParameter("newEmailAddr"));
        }
        
        try
        {
            this.doGet(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        RequestDispatcher view = req.getRequestDispatcher("/account.jsp");

        req.setAttribute("accountList", (ArrayList<Account>) Teacher.allAccounts());
        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void addAccount(String uName, String fName, String eAddr)
    {
        Account temp = null;
        temp = new Account();
        temp.setEmailAddress(new EmailAddress(eAddr));
        temp.setUserName(uName);
        temp.setFullName(fName);
        temp.save();
    }

    private void deleteAccount(Integer in)
    {
        Account temp = new Account(in);
        temp.delete();
    }
}

