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
        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        String action = req.getParameter("action");

        if (action != null)
        {
            //Do something depending on the hidden field
            if (action.equals("delete"))
            {
                try
                {
                    thiscourse.removeStudent(null, new Student(new Integer(req.getParameter("accountRef"))));
                }
                catch (Exception ex)
                {
                    Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, "Error Unenrolling a student.", ex);
                }
            }
            else if (action.equals("add"))
            {
                Account toAdd = new Account(req.getParameter("newUserName"),
                        req.getParameter("newFullName"),
                        req.getParameter("newEmailAddr"));
                toAdd.save();
                toAdd.fetch();
                thiscourse.addStudent(null, toAdd);
            }
            else if (action.equals("edit"))
            {
                Account tmp = null;
                try
                {
                    tmp = new Account(new Integer(req.getParameter("userRef")));
                }
                catch (Exception ex)
                {
                    Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tmp.setUserName(req.getParameter("newUserName"));
                tmp.setEmailAddress(new EmailAddress(req.getParameter("newEmailAddr")));
                tmp.setFullName(req.getParameter("newFullName"));
                
                tmp.save();
            }
        }

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
        RequestDispatcher view = req.getRequestDispatcher("/teacher/ManageAccounts.jsp");
        req.setAttribute("teachCourseList",
                (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));

        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        req.setAttribute("id", req.getParameter("id"));
                req.setAttribute("currentCourse", thiscourse);
        ArrayList<Account> members = new ArrayList<Account>();

        members.addAll(thiscourse.getTeacherAssistants());
        members.addAll(thiscourse.getStudents());

        req.setAttribute("accountList", members);
        
        req.setAttribute("currentCourse", thiscourse);

        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(TeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(TeacherController.class.getName()).log(Level.SEVERE, null, ex);
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

