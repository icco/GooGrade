import java.util.*;
import java.lang.*;

/**
 * A Teacher is an Account type that has the most permissions. It acts as the
 * administrator of its installation. There are a lot of methods in here
 * that really should not be in here. I mean seriously. most of the create,
 * edit, and remove methods SHOULD NOT be in here. It makes me cringe everytime I think about it.
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

	/** Constructor for Teacher. All permissions are granted to the Teacher by  default.  
	 */
	public Teacher()
	{
	}

	/**
	 * createCourse provides the overhead for creating a new class. The method prompts the user for information.
	 * @return a new course as specified by the Teacher's input.
	 */
	public Course createCourse()
	{
		return new Course();
	}

	/**
	 * editCourse asks for information from the user and updates the Course with it
	 * @return the new, edited Course
	 */
	public Course editCourse(Course course)
	{
		return course;
	}

	/**
	 * removeCourse marks a course for deletion. 
	 * @return true if no errors occur
	 */
	public boolean removeCourse(Course course)
	{
		return true;
	}

	/** 
	 * createAnnouncement gathers information from the user to make a new Announcement with
	 * @param which The course to add an announcement for.
	 * @return the new, created Announcement.
	 */
	public Announcement createAnnouncement(Course which)
	{
		return new Announcement();
	}


	/**
	 * gradeStudent adjusts information in a Student specified by the user
	 * @param who the Student to be graded.
	 */ 
	public boolean gradeStudent(Student who)
	{
	}

	/**
	 * createUser creates a new Account based on the user's preferences. 
	 * If a Teacher Assistant is being created, their permissions may be given. 
	 * The new account will be stored in userStorage until they are given a Course, if none specified. 
	 * @return the created Account
	 */
	public Account createUser()
	{
	}

	/**
	 * removeUser removes a User from a Course. If the user is not on any remaining courses, the account is marked for deletion
	 * @return the Account removed
	 */
	public Account removeUser(Account user)
	{
	}


	/**
	 * editUser provides overhead for Teacher to edit User information
	 * @return the Account that was edited
	 */
	public Account editUser()
	{
	}


	/**
	 * createAssignment creates a new Assignment with the Teacher's specifications. 
	 * @return the new Assignment
	 */ 
	public Assignment createAssignment()
	{
	}


	/**
	 * editAssignment changes the information in the Assignment to fit the Teacher's preferences.
	 * @return the modified Assignment
	 */
	public Assignment editAssignment()
	{
	}

	/**
	 * deleteAssignment marks an Assignment for removal from the system
	 * @return the Assignment deleted
	 */
	public Assignment deleteAssignment()
	{
	}

	/**
	 * SendEmail creates a new Email and send it to an address specified by the Teacher.
	 * @returns the sent email
	 */
	public Email sendEmail()
	{
	}	

	/** 
	 * adjustCruve modifies the GradingRules to a specific Course
	 * @return the GradingRules that were modified
	 */
	public GradingRules adjustCurve()
	{
	}

	/**
	 * takeAttendance adjusts the Participation portion of a grade for Students
	 * @return true if no errors occurred
	 */
	public boolean TakeAttendance()
	{
	}
}
