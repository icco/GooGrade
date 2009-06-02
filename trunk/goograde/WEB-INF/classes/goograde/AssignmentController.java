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
 * @author vgerdin
 * @version 0.42
 */
public class AssignmentController extends HttpServlet
{

    /**
     * doPost performs actions
     * @param req request
     * @param resp response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {

        String action = req.getParameter("action"); //the action to be done

        // Determine which action needs to be taken 
        if (action != null)
        {
            //We want to delete
            if (action.equals("delete"))
            {
                //choose teh appropriate assignment to modify and then modify 
                //and then delete it
                Assignment.deleteAssignment(req.getParameter("AssgnId"));
            }
            //We want to add
            else if (action.equals("add"))
            {
                // Parse Date into Date Object 
                String dateFormatString = "MM-dd-yy";
                SimpleDateFormat format = new SimpleDateFormat(dateFormatString);
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

                // Create the new Assignment with the input
                try
                {
                    Assignment.addAssignment(new Integer(req.getParameter("id")),
                            req.getParameter("type"),
                            newDate,
                            req.getParameter("newAssgnTitle"),
                            new Integer(req.getParameter("newAssgnTotal")));
                }
                catch (Exception ex)
                {
                    Logger.getLogger(AssignmentController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

            }
            //We want to edit
            else if (action.equals("edit"))
            {
                this.editAssignment(req.getParameter("AssignId"),
                        req.getParameter("newAssgnDate"),
                        req.getParameter("newAssgnTitle"),
                        req.getParameter("newAssgnTotal"),
                        req.getParameter("newAssgnType"));
            }
        }

        this.doGet(req, resp);
    }

    /**
     * doGet receives things
     * @param req request
     * @param resp respones
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view =
                req.getRequestDispatcher("/teacher/ManageAssignments.jsp");

        req.setAttribute("id", (String) req.getParameter("id"));
        req.setAttribute("teachCourseList",
                (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        req.setAttribute("currentCourse", 
                new Course(new Integer(req.getParameter("id"))));
        req.setAttribute("AssignmentList", (ArrayList<Assignment>) new Course(
                new Integer((String) req.getAttribute("id"))).getAssignments());
        System.out.println("Retreiveing from database");

        req.setAttribute("user", Utils.getUseridCookie(req));
        
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

    /**
     * This is a privet method to edit the assignmetn
     * @param assId  to change
     * @param assDate to change
     * @param assName to change
     * @param assTotal to change
     * @param assType to change
     * 
     * @todo Make better javadoc comments
     */
    private void editAssignment(String assId, 
            String assDate, 
            String assName, 
            String assTotal,
            String assType)
    {
        Assignment ass = new Assignment(new Integer(assId));
        //We do not like null pointer exceptions
        if (assDate != null)
        {
            /*Parse Date into Date Object */
            //String dateFormatString = "EEE MMM dd HH:mm:ss zzz yyyy";
            String dateFormatString = "MM-dd-yy";
            SimpleDateFormat format = new SimpleDateFormat(dateFormatString);
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
        //We do not like null pointer exceptions
        if (assName != null)
        {
            ass.setName(assName);
        }
        //We do not like null pointer exceptions
        if (assTotal != null)
        {
            ass.setTotal(new Integer(assTotal));
        }
        //We do not like null pointer exceptions
        if (assType != null)
        {
            ass.setType(assType);
        }
        ass.save();

    }
}

