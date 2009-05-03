package goograde;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Does all of the work on the Assignment, it is the controller. 
 * We haven't really speced out what this is going to do yet.
 *
 * @author bluGoo
 * @version 0.42
 */
public class AssignmentController extends HttpServlet
{

    @Override
    /**
     * doPost performs actions
     * @param req request
     * @param resp response
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {

        String action = req.getParameter("action"); //the action to be done

        /*Determine which action needs to be taken */
        if (action != null)
        {
            if (action.equals("delete"))
            {
                //choose teh appropriate assignment to modify and then modify 
                //and then delete it
                Assignment.deleteAssignment(req.getParameter("AssgnId"));
            } else if (action.equals("add"))
            {
                //this.addAssignment(req.getParameter("newUserName"),
                Assignment.addAssignment(req.getParameter("Type"),
                        new Date(req.getParameter("NewAssgnDate")),
                        req.getParameter("NewAssgnName"),
                        new Integer(req.getParameter("NewAssgnTotal")));

            } else if (action.equals("edit"))
            {
                /* Assignment.modifyAssignment(req.getParamater("EditType"), 
                new Float(req.getParamater("EditMax")), 
                new Float(req.getParamater("EditMin")), 
                new Float(req.getParamater("EditAverage")),
                new Date (req.getParamater("EditDueDate")),
                req.getParamater("EditName"), 
                new Integer(req.getParamater("EditTotal"))); */
            }
        }

        try
        {
            this.doGet(req, resp);
        } catch (ServletException ex)
        {
            Logger.getLogger(AccountController.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(AccountController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    @Override
    /**
     * doGet receives things
     * @param req request
     * @param resp respones
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        RequestDispatcher view = req.getRequestDispatcher("/teacher/ManageAssignments.jsp");
        
        req.setAttribute("teachCourseList",
                (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));

        req.setAttribute("AssignmentList", (ArrayList<Assignment>) Assignment.allAssignments());


        /*req.setAttribute("AssignmentList", (ArrayList<Course>) 
        (Teacher.allTeachers().get(0).getCourses())); */
        try
        {
            view.forward(req, resp);
        } catch (ServletException ex)
        {
            Logger.getLogger(AssignmentController.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(AssignmentController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    private void modifyAssignment(String type, float max, float min,
            float average, Date dueDate, String name, Integer total, Assignment current)
    {
        Assignment temp = current;
        if (type != null)
        {
            temp.setType(type);
        }
        if (max >= 0)
        {
            temp.setMax(max);
        }
        if (min >= 0)
        {
            temp.setMin(min);
        }
        if (average >= 0)
        {
            temp.setAvg(average);
        }
        if (dueDate != null)
        {
            temp.setDueDate(dueDate);
        }
        if (name != null)
        {
            temp.setName(name);
        }
        if (total != null)
        {
            temp.setTotal(total);
        }
    }

    private void addAssignment(int id, String type, float max, float min,
            float average, Date dueDate, String name, Integer total)
    {
        Assignment temp = new Assignment(id);
        modifyAssignment(type, max, min, average, dueDate, name, total, temp);
    }
}

