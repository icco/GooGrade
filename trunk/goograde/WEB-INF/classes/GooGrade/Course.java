package GooGrade;


import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
 
    /** Id used to fetch in database*/
    private Integer id;
    /** The Course's title */
    private String title;
    /** The Course's department */
    private String department;
    /** The Course's section */
    private Integer section;
    /** The Course's number */
    private Integer number;
    /** The set of grade boundaries for this class*/
    private Integer gradingRulesId;
    /** An array of Students who are enrolled in the Course */
    private ArrayList<Student> roster;
    /** An array of Assignments that are associatet with the Course */
    private ArrayList<Assignment> assignments;

    
    /**
     * Constructors
     */
    
    public Course()
    {
    }
    
    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     */
    public Course(Integer id)
    {
        this.id = id;
    }

    Course(String title, String department, Integer integer, Integer integer0)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
     * Sets
     */
    
    /**
     * setId sets this.id to provided argument
     * @param id Integer to set store
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * setTitle saves a new Couse title over the old.
     * @param newTitle the new title to save
     * @return true if no errors 
     */
    public boolean setTitle(String newTitle)
    {
        this.title = newTitle;
        return true;
    }

    /**
     * setDepartment sets this.department to provided argument
     * @param newDepartment
     * @return true if no errors
     */
    public boolean setDepartment(String newDepartment)
    {
        this.department = newDepartment;
        return true;
    }
        
    /** 
     * setNumber replaces the course number with a new one
     * @param newNumber is the new course number to save
     * @return true if no errors occurred. 
     */
    public boolean setNumber(int newNumber)
    {
        this.number = newNumber;
        return true;
    }

    /**
     * setSection saves a new section number over the old one
     * @param newSection is the number of the new section to save
     * @return true if no errors occurred
     */
    public boolean setSection(int newSection)
    {
        this.section = newSection;
        return true;
    }
    
    /**
     * setGradingRules saves a new Grading Rules over the old.
     * @param newScale the new grading rules to save
     * @return true if no errors 
     */
    public boolean setGradingRulesId(Integer newRulesId)
    {
        this.gradingRulesId = newRulesId;
        return true;
    }
    
    /**
     * setRoster sets this.roster to provided argument
     * @param roster list of students enrolled in the course
     * @return true if no errors
     */
    public boolean setRoster(ArrayList<Student> roster)
    {
        this.roster = roster;
        return true;
    }
    
    /**
     * setAssignments sets this.assignments provided argument
     * @param assignments list of assignments associated with the course
     * @return true if no errors
     */
    public boolean setAssignments(ArrayList<Assignment> assignments)
    {
        this.assignments = assignments;
        return true;
    }

    /**
     * Gets - Standard
     */    

    /**
     * getId returns this.id
     * @return id Integer to identify correct course in db
     */
    public Integer getId()
    {
        return this.id;
    }
    
    /**
     * getTitle gets the title
     * @return the title
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * getDepartment gets the deparment code (eg "CSC")
     * @return the department code
     */
    public String getDepartment()
    {
        return this.department;
    }
    
    /**
     * getNumber gets the number
     * @return the number
     */
    public Integer getNumber()
    {
        return this.number;
    }
    
    /**
     * getSection gets the section
     * @return the section
     */
    public Integer getSection()
    {
        return this.section;
    }
    
    /**
     * 
     * @return
     * @todo write comment
     */  
    public Integer getGradingRulesId()
    {
        return this.gradingRulesId;
    }
    
    /**
     * getRoster gets the roster attribute for this course 
     * roster is no set untill first called, if roster
     * is null then query the database and create it
     * @return list of enrolled students
     * @todo build roster
     */
    public ArrayList<Student> getRoster()
    {
        if(this.roster != null)
        {
            return this.roster;
        }
        else
        {
            this.roster = new ArrayList<Student>();
            //Build roster from enrolled and Students
            return this.roster;
        }
    }
    
    /**
     * getRoster gets the assignments attribute for this course 
     * assignments is no set untill first called, if assignments
     * is null then query the database and create it
     * @return list of associated Assignments
     * @todo build assignments
     */
    public ArrayList<Assignment> getAssignments()
    {
        if(this.assignments != null)
        {
            return this.assignments;
        }
        else
        {
            this.assignments = new ArrayList<Assignment>();
            //Build assignments from ----- and Assignments
            return this.assignments;
        }
    }
    
    /**
     * Gets - Special
     */
    
    /**
     * getTeachers gets the Teacher attribute from this course
     * @return teacher of this course
     * @todo 
     */
    public ArrayList<Teacher> getTeachers()
    {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        /*
         * Query and fill list from table teaches
         */
        return teachers;
    }

    /**
     * getTeacherAssistant gets the TeacherAssistant attribute from this course
     * @return assistants of this course
     */
    public ArrayList<TeacherAssistant> getTeacherAssistants()
    {
        ArrayList<TeacherAssistant> assistants = new ArrayList<TeacherAssistant>();
        /*
         * Query and fill list from table assists
         */
        return assistants;
    }
    
    /**
     * getGradingRules generates a GradingRules object
     * according to gradingRulesId and returns it 
     * @return the associated GradingRules object
     * @todo fix GradingRules class accordingly
     */
    public GradingRules getGradingRules()
    {
        if(this.gradingRulesId != null)
        {
            GradingRules rules = new GradingRules(this.getGradingRulesId());
            
            if(rules.fetch()) //true if valid gradingRulesId in database, else false
            {
                return rules;
            }
        }
        return null;
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

    




    
    static public ArrayList<Course> allCourses()
    {
        ArrayList<Course> courses = new ArrayList<Course>();
        
        StorageConnection conn = new StorageConnection();
        ArrayList<Array> result = conn.query("SELECT id FROM Courses");
        conn.close();
        
        
        for(int i = 0; i < result.size(); i++)
        {
            Course course = null;
            try
            {
                course = new Course(new Integer(result.get(i).getResultSet().getInt("id")));
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(course != null && course.fetch())
            {
                courses.add(course);
            }
        }
        
        return courses;
    }

    public boolean deleteCourse()
    {
        
        StorageConnection conn = new StorageConnection();
        conn.query(
            "DELETE FROM Courses WHERE id=" + this.getId().toString());
        conn.close();
        return true;
    }
    
    public boolean addCourse(){
        return true;
    }
    
    /**
     * Searches the database table Courses according
     * to this.id and sets all instance variables from there
     * @return true if found in database, else false
     * @todo improve StorageConnection.query return handling
     * @todo write it
     */
    public boolean fetch(){
        StorageConnection conn = new StorageConnection();
        String query = "SELECT title, department, number, section, gradingRulesId FROM Courses WHERE id = " + this.getId().toString();
        ArrayList<Array> result = conn.query(query);
        conn.close();
        
        if(result.size() < 1)
        {
            return false;
        }
        try
        {
            ResultSet rs = result.get(0).getResultSet();
            this.setTitle(rs.getString("title"));
            this.setDepartment(rs.getString("department"));
            this.setNumber(new Integer(rs.getInt("number")));
            this.setSection(new Integer(rs.getInt("section")));
            this.setGradingRulesId(new Integer(rs.getInt("gradingRulesId")));
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, "SQL error occurred when trying to fetch Course" +
                    "with id = " + this.getId().toString(), ex);
        }
        return true;
    }
}
