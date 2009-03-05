import java.util.ArrayList;
import java.util.Comparator;

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
    
    /** An array of Teacher Assistants who are associated with the Course */
    private TeacherAssistant assistant;

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

	/** Constructor of Couse class
	 */
	public Course()
	{
	}

	public boolean EditCourseTitle(String newTitle)
	{
		return false;
	}

	/** AddStudent adds a new student to this course. 
	 * @param permission the permission of the user who calls this function
	 * @param student the student that is to be added to the course
	 * @return true if no errors were enountered
	 */
	public boolean AddStudent(Permissions permission, Student student)
	{
		return false;
	}

	/** RemoveStudent removes a particular student from the course
	 * @param permission the permission of the user who calls this function
	 * @param student the student to be removed from this course
	 * @return true if no errors were encountered in removal.
	 */
	public boolean RemoveStudent(Permissions permission, Student student)
	{
		return false;
	}

	/** RemoveStudent removes a particular student from the course
	 * @param permission the permission of the user who calls this function
	 * @param student the name of the student to be removed from this course
	 * @return true if no errors were encountered in removal.
	 */
	public boolean RemoveStudent(Permissions permission, String student)
	{
		return false;
	}

	/** AddTA assignes a new TeacherAssistant to this course.
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be assigned to this course
	 * @return true if no errors have occured 
	 */
	public boolean AddTA(Permissions permission, TeacherAssistant ta)
	{
		return false;
	}

	/**RemoveTA removes a TeacherAssistant from this course
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be assigned to this course
	 * @return true if no errors have occured  
	 */
	public boolean RemoveTA(Permissions permission, TeacherAssistant ta)
	{
		return false;
	}
}
