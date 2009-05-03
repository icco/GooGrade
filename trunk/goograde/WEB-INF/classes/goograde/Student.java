package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class keeps information about Students. It is an extension of Account. 
 * Students have files. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class Student extends Account
{

    private ArrayList<Course> enrolled;

    /**
     * Standard constructor, should not be used, kept for now
     */
    public Student()
    {
        super();
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     */
    public Student(Integer id)
    {
        super(id);
        this.enrolled = getEnrolled();
    }

    /**
     * Large constructor with all data
     * @param id identification Integer used to fetch data from db
     * @param username used to log into system
     * @param name student's real name
     * @param email student's email
     */
    public Student(Integer id, String username, String name, String email)
    {
        super(id, username, name, email);
        this.enrolled = getEnrolled();
    }

    /**
     * Gets the student grade in the course.
     * @return percentage the student has in the course
     * @param course A string which maches a course name, or other identifier.
     * @param ass An assignment to get the grade for.
     */
    Float getGrade(Course crse, Assignment ass)
    {
        return (new Grade(ass.getId(), this.getId())).getGrade();
    }

    /**
     * gets a list of all courses a student is enrolled in
     * @return list of all courses the student is enrolled in
     */
    public ArrayList<Course> getEnrolled()
    {
        ArrayList<Course> ret = new ArrayList<Course>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;

        try
        {
            result = conn.query("select course as id from enrolled" 
                    + " where student = " + this.getId());
            /*add all returned rows into ret ArrayList*/
            for (ArrayList<Object> row : result)
            {
                ret.add(new Course((Integer) row.get(0)));
            }

            conn.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE,
                    "Error in Student", ex);
        }
        finally
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.WARNING, ret.toString());
        }


        return ret;
    }

    /**
     * Sets this.enrolled
     * @param enrolled ArrayList of Course objects the student is enrolled in
     */
    public void setEnrolled(ArrayList<Course> enrolled)
    {
        this.enrolled = new ArrayList<Course>(enrolled);
    }
    
    /**
     * static function to return all students in all classes
     * @return ArrayList of all students
     */
    public static ArrayList<Student> allStudents()
    {

        ArrayList<Student> ret = new ArrayList<Student>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();

        try
        {
            out = conn.query("select accounts.id as id, username, name, email"
                    + " from students, accounts"
                    + " where students.id = accounts.id");
            
            int index = 0;
            /*For each resultant row, add into ret ArrayList*/
            for (ArrayList<Object> row : out)
            {
                ret.add(new Student((Integer) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++)));
            }
            
            conn.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE,
                    "Error in Student", ex);
        }
        finally
        {
            Logger.getLogger(Student.class.getName()).log(Level.WARNING, ret.toString());
        }

        return ret;
    }
    
    /**
     * specialized toString method uses Account.toString()
     * @return Account.toString()
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
}
