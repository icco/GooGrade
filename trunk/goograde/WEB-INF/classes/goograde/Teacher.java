package goograde;

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
    public Teacher(Integer id) throws Exception
    {
        super(id);
        this.teaches = getCourses();

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
        this.teaches = getCourses();
    }

    /**
     * Returns an array of all of the teachers.
     * 
     * @return and arraylist of all the teachers
     */
    public static ArrayList<Teacher> allTeachers()
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
           
            // For each row, create a new Teacher
            for (ArrayList<Object> row : out)
            {
                ret.add(new Teacher((Integer) row.get(0),
                        (String) row.get(1),
                        (String) row.get(2),
                        (String) row.get(3)));
            }
            
            conn.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE,
                    "Error in Teacher", ex);
        }
        finally
        {
            /*
            Logger.getLogger(Teacher.class.getName()).log(Level.WARNING, ret.toString());
             */ 
        }

        return ret;
    }

    /**
     * Gets all of the courses a teacher teaches
     * 
     * @return an ArrayList of Courses
     */
    public ArrayList<Course> getCourses()
    {
        ArrayList<Course> ret = new ArrayList<Course>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;
        String query = new String();
        
        try
        {
            query = "select course as id from teaches where teacher = " + this.getId();
            result = conn.query(query);
            
            // for each row returned from database create a new Course
            for (ArrayList<Object> row : result)
            {
                ret.add(new Course((Integer)row.get(0)));
            }
            
            conn.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE,
                    "Error in Teacher", ex);
        }
        finally
        {
            /*
            Logger.getLogger(Teacher.class.getName()).log(Level.WARNING,
                    ret.toString());
             */ 
        }

        
        return ret;
    }
    
    /**
     * Calls Account.toString();
     * 
     * @return a string representation of the Teacher
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
    
    /**
     * returns true.
     * 
     * @return true if teacher.
     */
    @Override
    public boolean isTeacher()
    {
        return true;
    }
}
