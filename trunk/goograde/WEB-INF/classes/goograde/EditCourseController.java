/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author vgerdin
 */
public class EditCourseController extends HttpServlet
{

    /**
     * doPost handles a HTTP POST request
     * @param req the request
     * @param resp the response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String action = req.getParameter("action");

        /*If an action is requested, fulfill it */
        if (action != null)
        {
            /*Only action carried out is edit. Edit the course if this is the case */
            if (action.equals("edit"))
            {
                this.editCourse((String) req.getAttribute("courseRef"),
                        (String) req.getAttribute("title"),
                        (String) req.getAttribute("department"),
                        (String) req.getAttribute("number"),
                        (String) req.getAttribute("section"));
            }
        }
        /*try
        {*/
            req.setAttribute("id", req.getAttribute("courseRef"));
            this.doGet(req, resp);
        /*}*/
        /*catch (ServletException ex)
        {
            Logger.getLogger(
                    AccountController.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(
                    AccountController.class.getName()).log(Level.SEVERE,
                    null, ex);
        } */

    }

    /**
     * doGet handles a HTTP GET request. 
     * @param req the request
     * @param resp the response
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        RequestDispatcher view = 
                req.getRequestDispatcher("/teacher/EditCourse.jsp");

        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("currentCourse", thiscourse);

        req.setAttribute("teachCourseList",
                (ArrayList<Course>) 
                (Teacher.allTeachers().get(0).getCourses()));

        try
        {
            String idString = (String) req.getParameter("id");
            
            /*get the id */
            if (idString == null)
            {
                idString = (String) req.getAttribute("id");
            }
            req.setAttribute("course", new Course(new Integer(idString)));
        }
        catch (Exception ex)
        {
            Logger.getLogger(EditCourseController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        try
        {
            view.forward(req, resp);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(
                    EditCourseController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(
                    EditCourseController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    /**
     * editCourse takes input and saves course changes. 
     * @param courseRef the course reference
     * @param title the name of the course
     * @param department the name of the course's department
     * @param number the number of the course
     * @param section the section number of the course
     * @return true if edit succeeded
     */
    private boolean editCourse(String courseRef, String title,
            String department, String number, String section)
    {
        boolean pass = true;
        boolean ret = false;
        
        pass = validateCourse(number, section);

        /* Edit course only if the input has been validated*/
        if (pass)
        {
            Course course = new Course(new Integer(courseRef));
            
            /*Set the course varaibles */
            if (course.setTitle(title) && course.setDepartment(department) 
                    && course.setNumber(new Integer(number)) 
                    && course.setSection(new Integer(section)))
            {
                ret = course.save();
            }
        }

        return ret;
    }
    
    private boolean validateCourse(String number, String section)
    {
        boolean pass = false;
        /*make sure the course number is valid */
        if (!Course.validateNumber(number))
        {
            pass = false;
        }
        
        /*make sure the section number */
        if (!Course.validateSection(section))
        {
            pass = false;
        }
        return pass;
    }
}
