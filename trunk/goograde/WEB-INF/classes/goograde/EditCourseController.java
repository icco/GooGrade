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
public class EditCourseController extends HttpServlet {
   
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action != null)
        {
            if (action.equals("save"))
            {
                //this.saveCourse();
            }
        }
        try
        {
            this.doGet(req, resp);
        }
        catch (ServletException ex)
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
        }

    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        RequestDispatcher view = req.getRequestDispatcher("/teacher/EditCourse.jsp");

        req.setAttribute("teachCourseList",
            (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));
        
        try
        {
            req.setAttribute("course", new Course(new Integer(req.getParameter("id"))));
        }
        catch (Exception ex)
        {
            Logger.getLogger(EditCourseController.class.getName()).log(Level.SEVERE, null, ex);
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

}
