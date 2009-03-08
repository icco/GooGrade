import java.util.*;
import java.util.*;

/**
 * This class keeps information about Courses
 *
 * @author bluGoo
 * @version 0.42
 */
public class Course implements Storage
{
    /** The grading rules for the Course */
    private int gradingRules;
    
    /** The Course's title */
    private String courseTitle;
    
    /** The Course's section */
    private short courseSection;
    
    /** The Course's number */
    private int courseNumber;
    
    /** An array of Students who are enrolled in the Course */
    private ArrayList<Student> students;
    
    /** An instance of Teacher Assistant who is associated with the Course */
    private TeacherAssistant assistant;

    /** An instance of Teacher who is teaching the Course*/
    private Teacher teacher;

	public ArrayList<Object> buildArray()
	{
		/// @TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Object> buildArray(Comparator condition)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Object in)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Object> selectFrom(String query)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Constructor of Course class
	 */
	public Course()
	{
	}

	/**EditCourseTitle saves a new Couse title over the old
	 * @param newTitle the new title to save
	 * @return true if no errors 
	 */
	public boolean EditCourseTitle(String newTitle)
	{
	}

	/**EditCourseSection saves a new section number over the old one
	 * @param newSection is the number of the new section to save
	 * @return true if no errors occurred
	 */
	public boolean EditCourseSection(short newSection)
	{
	}

	/** Edit Course number replaces the course number with a new one
	 * @param newNumber is the new course number to save
	 * @return true if no errors occurred. 
	 */
	public boolean EditCourseNumber(int newNumber)
	{
	}

	/** AddStudent adds a new student to this course. 
	 * @param permission the permission of the user who calls this function
	 * @param student the student that is to be added to the course
	 * @return true if no errors were enountered
	 */
	public boolean AddStudent(Permissions permission, Student student)
	{
	}

	/** RemoveStudent removes a particular student from the course
	 * @param permission the permission of the user who calls this function
	 * @param student the student to be removed from this course
	 * @return true if no errors were encountered in removal.
	 */
	public boolean RemoveStudent(Permissions permission, Student student)
	{
	}

	/** RemoveStudent removes a particular student from the course
	 * @param permission the permission of the user who calls this function
	 * @param student the name of the student to be removed from this course
	 * @return true if no errors were encountered in removal.
	 */
	public boolean RemoveStudent(Permissions permission, String student)
	{
	}

	/** AddTA assignes a new TeacherAssistant to this course.
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be assigned to this course
	 * @return true if no errors have occured 
	 */
	public boolean AddTA(Permissions permission, TeacherAssistant ta)
	{
	}

	/**RemoveTA removes a TeacherAssistant from this course
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be removed to this course
	 * @return true if no errors have occured  
	 */
	public boolean RemoveTA(Permissions permission, TeacherAssistant ta)
	{
	}

	/**SetTeacher sets the Teacher attribute for this course
	 * @param t the Teacher to be assigned to this course
	 * @return true if no error have occured
	 */
	public boolean SetTeacher(Teacher t)
	{
	}

	/**GetTeacher gets the Teacher attribute from this course
	 * @return teacher of this course
	 */
	public Teacher GetTeacher()
	{
	}
}
