package goograde;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            }
            else if (action.equals("add"))
            {
                /*Parse Date into Date Object */
                String dateFormatString = "MM-dd-yy";
                SimpleDateFormat format = new 
                        SimpleDateFormat(dateFormatString);
                Date newDate = new Date();
                
                try
                {
                    newDate = format.parse(req.getParameter("newAssgnDate"));
                }
                catch (ParseException ex)
                {
                    Logger.getLogger(AssignmentController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

                //Create the new Assignment with the input
                try
                {
                    Assignment.addAssignment(req.getParameter("type"),
                        newDate,
                        req.getParameter("newAssgnName"),
                        new Integer(req.getParameter("newAssgnTotal")));
                }
                catch(Exception E)
                {
                    System.out.println(E.toString());
                }

            }
            else if (action.equals("edit"))
            {
                this.editAssignment(req.getParameter("AssignId"),
                        req.getParameter("newAssgnDate"),
                        req.getParameter("newAssgnName"),
                        req.getParameter("newAssgnTotal")
                        );
            }
        }

        try
        {
            this.doGet(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(AccountController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
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
        RequestDispatcher view = 
                req.getRequestDispatcher("/teacher/ManageAssignments.jsp");
        
        req.setAttribute("id", (String)req.getParameter("id"));
        req.setAttribute("teachCourseList",
                (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));

        req.setAttribute("AssignmentList", 
                (ArrayList<Assignment>) Assignment.allAssignments());


        /*req.setAttribute("AssignmentList", (ArrayList<Course>) 
        (Teacher.allTeachers().get(0).getCourses())); */
        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(AssignmentController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AssignmentController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    private void editAssignment(String assId, String assDate, String assName, String assTotal)
    {
        Assignment ass = new Assignment(new Integer(assId));
        
        if (assDate != null)
        {
            /*Parse Date into Date Object */
            String dateFormatString = "MM-dd-yy";
            SimpleDateFormat format = new 
                    SimpleDateFormat(dateFormatString);
            Date newDate = new Date();
            
            try
            {
                newDate = format.parse(assDate);
            }
            catch (ParseException ex)
            {
                Logger.getLogger(AssignmentController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            ass.setDueDate(newDate);
        }
        if (assName != null)
        {
            ass.setName(assName);
        }
        if (assTotal != null)
        {
            ass.setTotal(new Integer(assTotal));
        }
              
    }

    /*
    private void addAssignment(int id, String type, float max, float min,
            float average, Date dueDate, String name, Integer total)
    {
        Assignment temp = new Assignment(id);
        modifyAssignment(type, max, min, average, dueDate, name, total, temp);
    }
    */
}

