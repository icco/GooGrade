package goograde;

import java.util.*;
import java.lang.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Methods for modifying a course and it's related actions.
 *
 * @author bluGoo
 * @version 0.42
 */
public class CourseController extends HttpServlet
{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");
        Course course = null;
        
        if(action != null && action.equals("create")){ 
            String title = request.getParameter("newcoursetitle");
            int num = new Integer(request.getParameter("newcoursetitle")).intValue();
            course = new Course(num, title);
        }
        else{
            course = new Course();
        }
        request.setAttribute("course", course);

        RequestDispatcher view = request.getRequestDispatcher("/course.jsp");
        view.forward(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        doPost(request,response);
    }
    
    
        /** 
	 * addStudent adds a new student to this course. 
	 * @param permission the permission of the user who calls this function
	 * @param student the student that is to be added to the course
	 * @return true if no errors were enountered
	 */
	public boolean addStudent(Permissions permission, Student student, Course course)
	{
		return false;
	}

	/** 
	 * removeStudent removes a particular student from the course.
	 * @param permission the permission of the user who calls this function
	 * @param student the student to be removed from this course
	 * @return true if no errors were encountered in removal.
	 */
	public boolean removeStudent(Permissions permission, Student student, Course course)
	{
		return false;
	}

	/** 
	 * addTA assignes a new TeacherAssistant to this course.
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be assigned to this course
	 * @return true if no errors have occured 
	 */
	public boolean addTA(Permissions permission, TeacherAssistant ta, Course course)
	{
		return false;
	}

	/**
	 * removeTA removes a TeacherAssistant from this course
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be removed to this course
	 * @return true if no errors have occured  
	 */
	public boolean removeTA(Permissions permission, TeacherAssistant ta, Course course)
	{
		return false;
	}
}
