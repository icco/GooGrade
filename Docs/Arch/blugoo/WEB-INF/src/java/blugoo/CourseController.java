package blugoo;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * This class keeps information about Courses. It's a JavaBean since
 * it implements java.io.Serializable. It too uses StorageConnection
 * to store and get things out of the storage system.
 *
 * @author bluGoo
 * @version 0.42
 */
public class CourseController
{
	/** 
	 * addStudent adds a new student to this course. 
	 * @param permission the permission of the user who calls this function
	 * @param student the student that is to be added to the course
	 * @return true if no errors were enountered
	 */
	public boolean addStudent(Permissions permission, Student student)
	{
		return false;
	}

	/** 
	 * removeStudent removes a particular student from the course.
	 * @param permission the permission of the user who calls this function
	 * @param student the student to be removed from this course
	 * @return true if no errors were encountered in removal.
	 */
	public boolean removeStudent(Permissions permission, Student student)
	{
		return false;
	}

	/** 
	 * addTA assignes a new TeacherAssistant to this course.
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be assigned to this course
	 * @return true if no errors have occured 
	 */
	public boolean addTA(Permissions permission, TeacherAssistant ta)
	{
		return false;
	}

	/**
	 * removeTA removes a TeacherAssistant from this course
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be removed to this course
	 * @return true if no errors have occured  
	 */
	public boolean removeTA(Permissions permission, TeacherAssistant ta)
	{
		return false;
	}
}
