package GooGrade;

import java.util.*;
import java.lang.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This class deals with controlling Students. It is an extension of AccountController. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class StudentController extends AccountController
{
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }
     
    
    
	/** 
	 * Get a list of courses a student is enrolled in.
	 * @return an Array list of Courses.
	 */
	public ArrayList<Course> viewEnrolledCourses()
	{
		return null;
	}

}
