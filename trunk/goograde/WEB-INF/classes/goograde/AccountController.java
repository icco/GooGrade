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
 * the Account controller. It is the buffer between the model and the jsp's
 * 
 * @author bluGoo 
 * @author vgerdin
 * @version 0.42
 */
public class AccountController extends HttpServlet
{

    /**
     * Called automagically when a HTTP POST is made.
     * 
     * @param req the incoming HttpServletRequest
     * @param resp the outgoing HttpServletResponse
     * @author vgerdin
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {

        String action = req.getParameter("action");

        //We do not like null pointer exceptions
        if (action != null)
        {
            this.doAction(req, action);
        }

        this.doGet(req, resp);
    }

    /**
     * Called automagically when a HTTP GET is made.
     * 
     * @param req the incoming HttpServletRequest
     * @param resp the outgoing HttpServletResponse
     * @author vgerdin
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = req.getRequestDispatcher("/teacher/ManageAccounts.jsp");
        req.setAttribute("teachCourseList",
                (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));

        req.setAttribute("allAccountList", Student.allAccounts());

        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("currentCourse", thiscourse);
        ArrayList<Account> members = new ArrayList<Account>();

        members.addAll(thiscourse.getStudents());

        req.setAttribute("user", Utils.getUseridCookie(req));

        req.setAttribute("accountList", members);

        req.setAttribute("currentCourse", thiscourse);

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
     * Add a new account to the system.
     * 
     * @param uName User name of new account
     * @param fName Full Name of new account
     * @param eAddr email address of new account
     * @author vgerdin
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
     * @author vgerdin
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
                    AccountController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        temp.delete();
    }

    /**
     * doAction fulfills the request in doPost or doGet, modifying the info
     * from the models and saving to the database VIA the models.
     * @param req
     * @param action
     * @return true if no errors occurred
     * @authro vgerdin
     */
    private boolean doAction(HttpServletRequest req, String action)
    {
        boolean ret = false;
        
        //Do something depending on the hidden field
        //We want to delete
        if (action.equals("delete"))
        {
            ret = doActionDelete(req);
        }
        //We want to add a new
        else if (action.equals("add"))
        {
            ret = doActionAdd(req);
        }
        //We want to edit
        else if (action.equals("edit"))
        {
            ret = doActionEdit(req);
        }
        //We want to add an old
        else if (action.equals("addOld"))
        {
            ret = doActionAddOld(req);
            
        }
        return ret;
    }

    /**
     * doActionDelete specifically deletes an Account from the system
     * @param req the servlet request
     * @return true delete is successful
     * @author vgerdin
     */
    private boolean doActionDelete(HttpServletRequest req)
    {
        boolean ret = false;
        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        try
        {
            ret = thiscourse.removeStudent(
                    new Student(new Integer(req.getParameter("accountRef"))));
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    AccountController.class.getName()).log(
                    Level.SEVERE, "Error Unenrolling a student.", ex);
        }
        return ret;
    }
    
    /**
     * doActionAdd specifically adds a new Account to the system
     * @param req the servlet request
     * @return true if add is successful
     * @author vgerdin
     */
    private boolean doActionAdd(HttpServletRequest req)
    {
        boolean ret = false;
        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        String type = req.getParameter("type");
        Account toAdd = new Account(req.getParameter("newUserName"),
                        req.getParameter("newFullName"),
                        req.getParameter("newEmailAddr"));
        toAdd.save();
        toAdd.fetch();
        //We do not like null pointer exceptions
        if (type != null)
        {
            //We want to add this one as a student
            if (type.equals("student"))
            {
                ret = thiscourse.addStudent(toAdd);
            }
        }
        return ret;
    }

    /**
     * doActionedit specificllay edits a course
     * @param req the servlet request
     * @return true if edit is successful
     * @author vgerdin
     */
    private boolean doActionEdit(HttpServletRequest req)
    {
        boolean ret = false;
        Account tmp = null;
        try
        {
            tmp = new Account(new Integer(req.getParameter("accountRef")));
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    AccountController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        tmp.setUserName(req.getParameter("newUserName"));
        tmp.setEmailAddress(req.getParameter("newEmailAddr"));
        tmp.setFullName(req.getParameter("newFullName"));

        ret = tmp.save();
        return ret;
    }
    
    /**
     * adds an existing account.
     * @param req the servlet request
     * @return true if add is successful
     * @author vgerdin
     */
    private boolean doActionAddOld(HttpServletRequest req)
    {
        boolean ret = false;
        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        String type = req.getParameter("type");
        Account toAdd = null;
        try
        {
            toAdd = new Account(new Integer(req.getParameter("accountRef")));
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    AccountController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        //We do not like null pointer exceptions
        if (type != null)
        {
            //We want to add this one as a studet
            if (type.equals("student"))
            {
                ret = thiscourse.addStudent(toAdd);
            }
        }
        return ret;
    }
}

