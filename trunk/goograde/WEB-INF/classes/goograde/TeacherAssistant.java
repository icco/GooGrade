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
        super();
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param newId identification Integer used to fetch data from db
     * @throws Exception calls Account constructor, with Exception on invalid id
     */
    public TeacherAssistant(Integer newId) throws Exception
    {
        super(newId);
        this.assists = getCourses();

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
        this.assists = getCourses();
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
                index = 0;
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
            /*
            Logger.getLogger(TeacherAssistant.class.getName())
                    .log(Level.WARNING, ret.toString());
             */ 
        }
        return ret;
    }

    /**
     * Gets all of the courses a teacher assistant assists
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
            query = "select course as id from assists where ta = " + this.getId();
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
            Logger.getLogger(TeacherAssistant.class.getName()).log(Level.SEVERE,
                    "Error in TeacherAssistant", ex);
        }
        finally
        {
            /*
            Logger.getLogger(TeacherAssistant.class.getName()).log(Level.WARNING,
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
     * Calls Account.equals();
     * @param otherTA The other object to be compared with
     * @return a string representation of the Teacher
     */
    public boolean equals(TeacherAssistant otherTA)
    {
        return super.equals(otherTA);
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

