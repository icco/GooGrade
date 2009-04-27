package GooGrade;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Teacher is an Account type that has the most permissions. It acts as the
 * administrator of its installation. Models work by making all sql calls and dealing
 * with that side of things.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Teacher extends Account
{

    /** 
     * A list of courses owned by the Teacher 
     */
    private ArrayList<Course> teaches;

    /**
     * Constructors
     */
    /** 
     * Constructor for Teacher. All permissions are granted to the Teacher by  default.  
     */
    public Teacher()
    {
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     */
    public Teacher(Integer id)
    {
        super(id);
    }

    /**
     * Builds a Teacher with information we have already grabbed because we are
     * fly like that. Note that this just calls Accounts constructor.
     * 
     * @param id The ID from the Database
     * @param username Teachers username
     * @param name Teachers real name
     * @param email Teachers Email address
     */
    public Teacher(Integer id, String username, String name, String email)
    {
        super(id, username, name, email);
    }

    /**
     * Returns an array of all of the teachers.
     * 
     * @return and arraylist of all the teachers
     */
    static public ArrayList<Teacher> allTeachers()
    {

        ArrayList<Teacher> ret = new ArrayList<Teacher>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();

        try
        {
            out = conn.query("select accounts.id as id, username, name, email"
                    + " from teachers, accounts" 
                    + " where teachers.id = accounts.id" 
                    + " group by accounts.id");
            for(ArrayList<Object> row : out)
            {
                ret.add(new Teacher((Integer)row.get(0), 
                        (String)row.get(1),
                        (String)row.get(2), 
                        (String)row.get(3)));
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, 
                    "Error in Teacher", ex);
        }

        return ret;
    }

    /**
     * createCourse provides the overhead for creating a new class. The method prompts the user for information.
     * @return a new course as specified by the Teacher's input.
     */
    public Course createCourse()
    {
        return null; //new Course();
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
        return false;
    }

    /**
     * createUser creates a new Account based on the user's preferences. 
     * If a Teacher Assistant is being created, their permissions may be given. 
     * The new account will be stored in userStorage until they are given a Course, if none specified. 
     * @return the created Account
     */
    public Account createUser()
    {
        return null;
    }

    /**
     * removeUser removes a User from a Course. If the user is not on any remaining courses, the account is marked for deletion
     * @return the Account removed
     */
    public Account removeUser(Account user)
    {
        return null;
    }

    /**
     * editUser provides overhead for Teacher to edit User information
     * @return the Account that was edited
     */
    public Account editUser()
    {
        return null;
    }

    /**
     * createAssignment creates a new Assignment with the Teacher's specifications. 
     * @return the new Assignment
     */
    public Assignment createAssignment()
    {
        return null;
    }

    /**
     * editAssignment changes the information in the Assignment to fit the Teacher's preferences.
     * @return the modified Assignment
     */
    public Assignment editAssignment()
    {
        return null;
    }

    /**
     * deleteAssignment marks an Assignment for removal from the system
     * @return the Assignment deleted
     */
    public Assignment deleteAssignment()
    {
        return null;
    }

    /** 
     * adjustCruve modifies the GradingRules to a specific Course
     * @return the GradingRules that were modified
     */
    public GradingRules adjustCurve()
    {
        return null;
    }

    /**
     * takeAttendance adjusts the Participation portion of a grade for Students
     * @return true if no errors occurred
     */
    public boolean takeAttendance()
    {
        return false;
    }
}
