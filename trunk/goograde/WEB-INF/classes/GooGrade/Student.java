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
    private Float totalGrade;
    private ArrayList<Course> enrolled;

    public Student (String jdbcDriver, String jdbcConnectionString, String username)
    {
        try {
            Class.forName(jdbcDriver).newInstance();
        }
        catch (Exception ex) {
            System.err.println("Error loading database driver " + jdbcDriver +
            ":\n" + ex.getMessage());
        }
        //super(jdbcDriver, jdbcConnectionString, username); need proper constructor in Account
        //this.fetch(this.getId());
        this.setJdbcConnectionString("jdbcConnectionString");
        this.setJdbcDriver("jdbcDriver");
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
        if(this.enrolled == null){
            try {
                if (this.getConn() == null) {
                    this.setConn(DriverManager.getConnection(this.getJdbcConnectionString()));
                }
                Statement stmt = getConn().createStatement();
                ResultSet rs = stmt.executeQuery("SELECT course FROM enrolled WHERE student = " + this.getId().toString());

                while (rs.next()) {
                    this.enrolled.add(new Course(this.getJdbcDriver(), this.getJdbcConnectionString(), new Integer(rs.getInt(1))));
                }
            }
            catch (SQLException ex) {
                System.err.println(
                    "Error retrieving student courses from the database:\n" +
                    ex.getMessage());
            }
        }
        return this.enrolled;
    }

    public void setEnrolled(ArrayList<Course> enrolled)
    {
        this.enrolled = enrolled;
    }
}
