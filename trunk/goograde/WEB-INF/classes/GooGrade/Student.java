package GooGrade;

import java.util.ArrayList;



/**
 * This class keeps information about Students. It is an extension of Account. 
 * Students have files. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class Student extends Account
{
    private Float totalGrade;
    private ArrayList<Course> enrolled;


    /**
     * Constructors
     */    
    
    /**
     * Standard constructor, should not be used, kept for now
     */
    public Student()
    {
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
    }
    
    /**
     * Gets the student grade in the course.
     * @return percentage the student has in the course
     * @param course A string which maches a course name, or other identifier.
     * @param ass An assignment to get the grade for.
     */
    int getGrade(String course, Assignment ass)
    {
        return 0;
    }

    /**
     * Get a list of courses a student is enrolled in.
     * @return an Array list of Courses.
     */
    public ArrayList<Course> viewEnrolledCourses()
    {
        return null;
    }
    
    /**
     * 
     * @param username is the username of the student who needs to be fetched
     * @return true if successful, false otherwise
     */
    
    /*private boolean fetch(Integer id)
    {
        try {
          if (this.getConn() == null) {
                this.setConn(DriverManager.getConnection(this.getJdbcConnectionString()));
 	    }
            Statement stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT course FROM enrolled WHERE student = " + id.toString());

            while (rs.next()) {
                getEnrolled().add(new Course(rs.getInt(1), rs.getString(2)));
            }
        }
        catch (SQLException ex) {
            System.err.println(
                    "Error retrieving student information from the database:\n" +
                    ex.getMessage());
        }
 	
        return false;
    }*/

    public Float getTotalGrade()
    {
        return totalGrade;
    }

    public void setTotalGrade(Float totalGrade)
    {
        this.totalGrade = totalGrade;
    }

    public ArrayList<Course> getEnrolled()
    {
       return null;
    }

    public void setEnrolled(ArrayList<Course> enrolled)
    {
        this.enrolled = enrolled;
    }
    
}
