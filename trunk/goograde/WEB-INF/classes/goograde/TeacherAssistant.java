package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *   This class keeps information about Teacher Assistants.
 *  
 *   @author bluGoo
 *   @version 0.42
 */
public class TeacherAssistant extends Account
{

    /* List of courses a TA assists a Teacher with */
    private ArrayList<Course> assists;

    /**
     * Constructor for Teacher Assistant.
     * @param granted This TA only has permissions outlined in this param
     */
    public TeacherAssistant(Permissions granted)
    {
        /* Are permissions stored locally, or checked every time? */
    }

    /**
     * Constructor for Teacher Assistant. No permissions are passed in
     * and a default, minimal permission set will be initiated. 
     */
    public TeacherAssistant()
    {
    }

    /**
     * Constructor for use with the allTeacherAssistants method
     * @param id        incoming user id
     * @param username  incoming user name
     * @param name      incoming full name
     * @param email     incoming email address
     */
    public TeacherAssistant(Integer id, String username, String name, String email)
    {
        super(id, username, name, email);
    }

    /**
     * Returns an array of all of the teachers.
     * 
     * @return and arraylist of all the teachers
     */
    public static ArrayList<TeacherAssistant> allTeacherAssistants()
    {
        ArrayList<TeacherAssistant> ret = new ArrayList<TeacherAssistant>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();
        int index = 0;

        try
        {
            out = conn.query("select accounts.id as id,username,name,email " 
                    + "from tas, accounts where tas.id = accounts.id" 
                    + " group by accounts.id");
            
            /* For each query result, create and populate a new TeacherAssistant obj */
            for (ArrayList<Object> row : out)
            {
                ret.add(new TeacherAssistant((Integer) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++)));
            }
            
            conn.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(TeacherAssistant.class.getName())
                    .log(Level.SEVERE, "Error in TeacherAssistant", ex);
        }
        finally
        {
            Logger.getLogger(TeacherAssistant.class.getName())
                    .log(Level.WARNING, ret.toString());
        }
        return ret;
    }

    /**
     * Editing of a current course is done here
     * @param course the course to edit
     * @return the new, edited Course
     */
    public Course editCourse(Course course)
    {
        return course;
    }

    /**
     * Creation of a new course
     * @return a new course as specified by the Teacher's input.
     */
    public Course createCourse()
    {
        return null; //new Course();

    }

    /**
     * A course is marked for deletion. 
     * @param course the course to remove
     * @return true if no errors occur
     */
    public boolean removeCourse(Course course)
    {
        return true;
    }

    /**
     * Grade information in a Student is filled in
     * @param who the Student to be graded.
     * @return nobody knows
     */
    public boolean gradeStudent(Student who)
    {
        return false;
    }

    /**
     * A new Assignment with the TA's specifications is created. 
     * @return the new Assignment
     */
    public Assignment createAssignment()
    {
        return null;
    }

    /**
     * Assignment details are changed to fit the TA's preferences.
     * @return the modified Assignment
     */
    public Assignment editAssignment()
    {
        return null;
    }

    /**
     * An Assignment is marked for removal from the system
     * @return the Assignment deleted
     */
    public Assignment deleteAssignment()
    {
        return null;
    }

    /** 
     * GradingRules are modified for a specific Course
     * @return the GradingRules that were modified
     */
    public GradingRules adjustCurve()
    {
        return null;
    }

    /**
     * Object checker to verify whether it is of rank TeacherAssistant
     * @return true always, as it is a Teacher Assistant
     */
    @Override
    public boolean isTeacherAssistant()
    {
        return true;
    }
}

