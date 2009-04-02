package blugoo;

import java.util.*;
import java.lang.*;


/**
 * This class keeps information about Students. It is an extension of Account. 
 * Students have files. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class Student extends Account
{
	ArrayList<Course> enrolled;

	/**
	 * Gets the student grade in the course.
	 * @return percentage the student has in the course
	 * @param course A string which maches a course name, or other identifier.
	 * @param ass An assignment to get the grade for.
	 */
	int getGrade(String course, Assignment ass)
	{
		return 0;
	}

}
