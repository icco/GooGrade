package GooGrade;

import java.util.*;
import java.lang.*;
import java.sql.*;

/**
 * This class keeps information about Students. It is an extension of Account. 
 * Students have files. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class Student extends Account
{

    Float totalGrade;
    ArrayList<File> files;
    ArrayList<Course> enrolled;

    public Student (String jdbcDriver, String jdbcConnectionString, String username)
    {
        //super(jdbcDriver, jdbcConnectionString, username); need proper constructor in Account
        this.fetch(username);
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
    private boolean fetch(String username)
    {
        try {
          if (this.conn == null) {
              this.conn = DriverManager.getConnection(this.jdbcConnectionString);
 	    }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT todoid, todo FROM todo");

        }
        catch (SQLException ex) {
            System.err.println(
                    "Error retrieving student information from the database:\n" +
                    ex.getMessage());
        }
 	
        return false;
    }
}
