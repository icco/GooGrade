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

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action != null)
        {
            if (action.equals("edit"))
            {
                this.editCourse((String) req.getAttribute("courseRef"),
                        (String) req.getAttribute("title"),
                        (String) req.getAttribute("department"),
                        (String) req.getAttribute("number"),
                        (String) req.getAttribute("section"));
            }
        }
        try
        {
            req.setAttribute("id", req.getAttribute("courseRef"));
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

        Course thiscourse = new Course(new Integer(req.getParameter("id")));
        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("currentCourse", thiscourse);

        req.setAttribute("teachCourseList",
                (ArrayList<Course>) (Teacher.allTeachers().get(0).getCourses()));

        try
        {
            String idString = (String) req.getParameter("id");
            if (idString == null)
            {
                idString = (String) req.getAttribute("id");
            }
            req.setAttribute("course", new Course(new Integer(idString)));
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

    private boolean editCourse(String courseRef, String title, String department, String number, String section)
    {
        boolean pass = true;
        boolean ret = false;
        if (!Course.validateNumber(number))
        {
            pass = false;
        }
        if (!Course.validateSection(section))
        {
            pass = false;
        }

        if (pass)
        {
            Course course = new Course(new Integer(courseRef));
            if (course.setTitle(title) && course.setDepartment(department) && course.setNumber(new Integer(number)) && course.setSection(new Integer(section)))
            {
                ret = course.save();
            }
        }

        return ret;
    }
}
