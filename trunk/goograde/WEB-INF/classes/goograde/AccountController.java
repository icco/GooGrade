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
 * @author bluGoo, vgerdin
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

        members.addAll(thiscourse.getTeacherAssistants());
        members.addAll(thiscourse.getStudents());


        req.setAttribute("accountList", members);
        req.setAttribute("tas", thiscourse.getTeacherAssistants());

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
                    AccountController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        temp.delete();
    }

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

    private boolean doActionDelete(HttpServletRequest req)
    {
        boolean ret = false;
        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        try
        {
            ret = thiscourse.removeStudent(null, 
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
                ret = thiscourse.addStudent(null, toAdd);
            }
            //We want to add this one as a ta
            else if (type.equals("teacherAssistant"))
            {
                ret = thiscourse.addTA(null, toAdd);
            }
        }
        return ret;
    }

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
        tmp.setEmailAddress(new EmailAddress(req.getParameter("newEmailAddr")));
        tmp.setFullName(req.getParameter("newFullName"));

        ret = tmp.save();
        return ret;
    }
    
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
                ret = thiscourse.addStudent(null, toAdd);
            }
            //We want to add this one as a ta
            else if (type.equals("teacherAssistant"))
            {
                ret = thiscourse.addTA(null, toAdd);
            }
        }
        return ret;
    }
}

