/**
 * This class keeps information about Students. It is an extension of Account. 
 * Students have files. 
 *
 * @author bluGoo
 * @version 0.42
 */

import java.util.*;
import java.lang.*;

public class Student extends Account
{

	/**
	 * Gets the student grade in the course.
	 * @return percentage the student has in the course
	 * @param course A string which maches a course name, or other identifier.
	 */
	int GetGrade(String course)
	{
		return 0;
	}

	int getGrade(String course, String assignment)
	{
		return 0;
	}

	void uploadFile(String assignment, String course)
	{


	}

	@Override
	public ArrayList<Object> buildArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> buildArray(Comparator condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Object in) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Object> selectFrom(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
