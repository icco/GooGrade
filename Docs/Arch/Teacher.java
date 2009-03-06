import java.util.*;
import java.lang.*;

/**
 * A Teacher is an Account type that has the most permissions. It acts as the administrator of its installation. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class Teacher extends Account
{
    /** An array of Announcements owned by the Teacher */
    private Announcement announcements[];

    /** A list of courses owned by the Teacher */
    private ArrayList<Course> courses;

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

	/** Constructor for Teacher. All permissions are granted to the Teacher by  default.  
	 */
	public Teacher()
	{
	}

	/**CreateCourse provides the overhead for creating a new class. The method prompts the user for information.
	 * @return a new course as specified by the Teacher's input.
	 */
	public Course CreateCourse()
	{
		return new Course();
	}

	/**EditCourse asks for information from the user and updates the Course with it
	 * @return the new, edited Course
	 */
	public Course EditCourse(Course course)
	{
		return course;
	}

	/**RemoveCourse marks a course for deletion. 
	 * @return true if no errors occur
	 */
	public boolean RemoveCourse(Course course)
	{
		return true;
	}

	/** CreateAnnouncement gathers information from the user to make a new Announcement with
	 * @return the new, created Announcement.
	 */
	public Annoucement CreateAnnouncement()
	{
		return new Announcement();
	}

	/** EditAnnouncement takes information from the user to adjust an existing account
	 * @return the adjusted announcement
	 */
	public Announcement EditAnnouncement(Announcement announcement)
	{
		return announcement;
	}

	/**RemoveAnnouncement marks an Announcement for removal
	 *@return true if no errors occur
	 */
	public boolean RemoveAnnouncement(Announcement announcement) 
	{
	}

	/**GradeStudent adjusts information in a Student specified by the user
	 * @return the Student that was graded.
	 */ 
	public Student GradeStudent()
	{
	}

	/**CreateUser creates a new Account based on the user's preferences. 
	 * If a Teacher Assistant is being created, their permissions may be given. 
	 * The new account will be stored in userStorage until they are given a Course, if none specified. 
	 * @return the created Account
	 */
	public Account CreateUser()
	{
	}

	/**RemoveUser removes a User from a Course. If the user is not on any remaining courses, the account is marked for deletion
	 * @return the Account removed
	 */
	public Account RemoveUser(Account user)
	{
	}


	/**EditUser provides overhead for Teacher to edit User information
	 * @return the Account that was edited
	 */
	public Account EditUser()
	{
	}


	/**CreateAssignment creates a new Assignment with the Teacher's specifications. 
	 * @return the new Assignment
	 */ 
	public Assignment CreateAssignment()
	{
	}


	/**EditAssignment changes the information in the Assignment to fit the Teacher's preferences.
	 * @return the modified Assignment
	 */
	public Assignment EditAssignment()
	{
	}

	/**DeleteAssignment marks an Assignment for removal from the system
	 * @return the Assignment deleted
	 */
	public Assignment DeleteAssignment()
	{
	}

	/**SendEmail creates a new Email and send it to an address specified by the Teacher.
	 *@returns the sent email
	 */
	public Email SendEmail()
	{
	}	

	/**AdjustCruve modifies the GradingRules to a specific Course
	 * @return the GradingRules that were modified
	 */
	public GradingRules AdjustCurve()
	{
	}

	/**TakeAttendance adjusts the Participation portion of a grade for Students
	 * @return true if no errors occurred
	 */
	public boolean TakeAttendance
	{
	}

}
