package GooGrade;

import java.util.*;
import java.lang.*;

import java.sql.*;

/**
 * This class keeps information about Courses. 
 *
 * The constructor should query the DB and deal with stuff.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Course implements java.io.Serializable
{
    /** Database connection String */
    private String jdbcConnectionString;
    /** Database connection Driver */
    private String jdbcDriver;
    /** Database connection holder*/
    private Connection conn;
    
    /** The Course's title */
    private String courseTitle;
    /** The Course's department */
    private String courseDepartment;
    /** The Course's section */
    private Integer courseSection;
    /** The Course's number */
    private Integer courseNumber;
    /** An array of Students who are enrolled in the Course */
    private ArrayList<Student> students;
    /** An instance of Teacher Assistant who is associated with the Course */
    private TeacherAssistant assistant;
    /** An instance of Teacher who is teaching the Course*/
    private Teacher teacher;
    /** The set of grade boundaries for this class*/
    private GradingRules scale;
    /** Id used to fetch in database*/
    private Integer id;

    public Course()
    {
    }
    
    public Course(String jdbcDriver, String jdbcConnectionString)
    {
        this.jdbcConnectionString = jdbcConnectionString;
        this.jdbcDriver = jdbcDriver;
        
        try {
            Class.forName(jdbcDriver).newInstance();
        }
        catch (Exception ex) {
            System.err.println("Error loading database driver " + jdbcDriver +
            ":\n" + ex.getMessage());
        }
    }
    
    public Course(String jdbcDriver, String jdbcConnectionString, Integer id)
    {
        this.id = id;
        this.jdbcDriver = jdbcDriver;
        this.jdbcConnectionString = jdbcConnectionString;
        
        try {
            Class.forName(jdbcDriver).newInstance();
        }
        catch (Exception ex) {
            System.err.println("Error loading database driver " + jdbcDriver +
            ":\n" + ex.getMessage());
        }
        
        try {
          if (this.getConn() == null) {
                this.setConn(DriverManager.getConnection(this.getJdbcConnectionString()));
 	    }
            Statement stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, title, department, number, section FROM Courses WHERE id = " + this.getId().toString());

            if(rs.next()) {
                this.courseTitle = rs.getString("title");
                this.courseDepartment = rs.getString("department");
                this.courseNumber = new Integer(rs.getInt("number"));
                this.courseSection = new Integer(rs.getInt("section"));
            }
            else{
                System.err.println(
                    "Could not find course with id: " + this.id.toString());
            }
            getConn().close();
        }
        catch (SQLException ex) {
            System.err.println(
                    "Error retrieving student courses from the database:\n" +
                    ex.getMessage());
        }
    }
    
    private Course(String jdbcDriver, String jdbcConnectionString, Integer id, String title, String department, Integer number, Integer section)
    {
        this.id = id;
        this.courseTitle = title;
        this.courseDepartment = department;
        this.courseNumber = number;
        this.courseSection = section;
        
        try {
            Class.forName(jdbcDriver).newInstance();
        }
        catch (Exception ex) {
            System.err.println("Error loading database driver " + jdbcDriver +
            ":\n" + ex.getMessage());
        }
    }
    
    /**
     * setGradingRules saves a new Grading Rules over the old.
     * @param newScale the new grading rules to save
     * @return true if no errors 
     */
    public boolean setGradingRules(GradingRules newScale)
    {
        return false;
    }

    /**
     * setTitle saves a new Couse title over the old.
     * @param newTitle the new title to save
     * @return true if no errors 
     */
    public boolean setCourseTitle(String newTitle)
    {
        
        this.courseTitle = newTitle;
        return true;
    }

    /**
     * setSection saves a new section number over the old one
     * @param newSection is the number of the new section to save
     * @return true if no errors occurred
     */
    public boolean setCourseSection(int newSection)
    {
        this.courseSection = newSection;
        return true;
    }

    /** 
     * setNumber replaces the course number with a new one
     * @param newNumber is the new course number to save
     * @return true if no errors occurred. 
     */
    public boolean setCourseNumber(int newNumber)
    {
        this.courseNumber = newNumber;
        return true;
    }

    /**
     * setTeacher sets the Teacher attribute for this course
     * @param t the Teacher to be assigned to this course
     * @return true if no error have occured
     */
    public boolean setTeacher(Teacher t)
    {
        return false;
    }

    /**
     * setTeacherAssistant sets the TeacherAssistant attribute for this course
     * @param ta the TeacherAssistant to be assigned to this course
     * @return true if no error have occured
     */
    public boolean setTeacherAssistant(TeacherAssistant ta)
    {
        return false;
    }

    /**
     * getTeacher gets the Teacher attribute from this course
     * @return teacher of this course
     */
    public Teacher getTeacher()
    {
        return teacher;
    }

    /**
     * getTeacherAssistant gets the TeacherAssistant attribute from this course
     * @return assistant of this course
     */
    public TeacherAssistant getTeacherAssistant()
    {
        return assistant;
    }

    /**
     * getCourseNumber gets the courseNumber
     * @return the courseNumber
     */
    public Integer getCourseNumber()
    {
        return courseNumber;
    }

    /**
     * getCourseSection gets the courseSection
     * @return the courseSection
     */
    public Integer getCourseSection()
    {
        return courseSection;
    }

    /**
     * getCourseTitle gets the courseTitle
     * @return the courseTitle
     */
    public String getCourseTitle()
    {
        return courseTitle;
    }

    /**
     * getGradingRules gets the scale attribute for this course 
     * @return the scale attribute for this course
     */
    public GradingRules getGradingRules()
    {
        return scale;
    }

    /**
     * getStudents gets the students attribute for this course 
     * @return the students attribute for this course
     */
    public ArrayList<Student> getStudents()
    {
        return students;
    }

    /**
     * addStudent adds a new student to this course.
     * @param permission the permission of the user who calls this function
     * @param student the student that is to be added to the course
     * @return true if no errors were enountered
     */
    public boolean addStudent(Permissions permission, Student student)
    {
        return false;
    }

    /**
     * removeStudent removes a particular student from the course.
     * @param permission the permission of the user who calls this function
     * @param student the student to be removed from this course
     * @return true if no errors were encountered in removal.
     */
    public boolean removeStudent(Permissions permission, Student student)
    {
        return false;
    }

    /**
     * addTA assignes a new TeacherAssistant to this course.
     * @param permission the permission of the user who calls this function
     * @param ta the TeacherAssistant to be assigned to this course
     * @return true if no errors have occured
     */
    public boolean addTA(Permissions permission, TeacherAssistant ta)
    {
        return false;
    }

    /**
     * removeTA removes a TeacherAssistant from this course
     * @param permission the permission of the user who calls this function
     * @param ta the TeacherAssistant to be removed to this course
     * @return true if no errors have occured
     */
    public boolean removeTA(Permissions permission, TeacherAssistant ta)
    {
        return false;
    }

    public String getCourseDepartment()
    {
        return courseDepartment;
    }

    public boolean setCourseDepartment(String courseDepartment)
    {
        this.courseDepartment = courseDepartment;
        return true;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public ArrayList<Course> allCourses()
    {
        ArrayList<Course> courses = new ArrayList<Course>();
        
        try {
            if (this.getConn() == null) {
                //this.setConn(DriverManager.getConnection(this.getJdbcConnectionString()));
                this.setConn(DriverManager.getConnection(this.getJdbcConnectionString()));
            }
            Statement stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, title, department, number, section FROM Courses");

            while (rs.next()) {
                courses.add(new Course(this.getJdbcDriver(), this.getJdbcConnectionString(), new Integer(rs.getInt("id")), rs.getString("title"), 
                        rs.getString("department"), new Integer(rs.getInt("number")), new Integer(rs.getInt("section"))));
            }
        }
        catch (SQLException ex) {
            System.err.println(
                    "Error retrieving student courses from the database:\n" +
                    ex.getMessage());
        }
        
        return courses;
    }

    public String getJdbcConnectionString()
    {
        return this.jdbcConnectionString;
    }

    public void setJdbcConnectionString(String jdbcConnectionString)
    {
        this.jdbcConnectionString = jdbcConnectionString;
    }

    public Connection getConn()
    {
        return this.conn;
    }

    public void setConn(Connection conn)
    {
        this.conn = conn;
    }

    public String getJdbcDriver()
    {
        return this.jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver)
    {
        this.jdbcDriver = jdbcDriver;
    }
    
    public boolean deleteCourse(){
        
        try {
            if (this.getConn() == null || this.getConn().isClosed()) {
                this.setConn(DriverManager.getConnection(this.getJdbcConnectionString()));
            }
            PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM Courses WHERE id=?");
            stmt.setInt(1, this.getId().intValue());
            stmt.executeUpdate();
            
            getConn().close();
        }
        catch (SQLException ex) {
            System.err.println(
                    "Error deleting courses from the database:\n" +
                    ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean addCourse(){
        return true;
    }
}
