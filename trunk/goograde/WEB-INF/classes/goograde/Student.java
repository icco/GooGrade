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

    public ArrayList<Course> getEnrolled()
    {
        ArrayList<Course> ret = new ArrayList<Course>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;

        try
        {
            result = conn.query("select course as id from enrolled" +
                    " where student = " + this.getId());

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

    public void setEnrolled(ArrayList<Course> enrolled)
    {
        this.enrolled = new ArrayList<Course>(enrolled);
    }
    
     static public ArrayList<Student> allStudents()
    {

        ArrayList<Student> ret = new ArrayList<Student>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();

        try
        {
            out = conn.query("select accounts.id as id, username, name, email"
                    + " from students, accounts"
                    + " where students.id = accounts.id");
            
            for (ArrayList<Object> row : out)
            {
                ret.add(new Student((Integer) row.get(0),
                        (String) row.get(1),
                        (String) row.get(2),
                        (String) row.get(3)));
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
     
    @Override
    public String toString()
    {
        return super.toString();
    }
}
