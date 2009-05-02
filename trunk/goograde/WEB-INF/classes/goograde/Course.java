package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class keeps information about Courses. 
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
     * Standard constructor, should not be used, kept for now
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
        this.fetch();
    }

    /**
     * Secondary constructor used when creating new Courses
     * @param title
     * @param department
     * @param number
     * @param section
     */
    public Course(String title, String department, Integer number, Integer section)
    {
        this.setTitle(title);
        this.setDepartment(department);
        this.setNumber(number);
        this.setSection(section);
    }

    /**
     * setId sets this.id to provided argument
     * @param id Integer to set store
     */
    public boolean setId(Integer id)
    {
        this.id = id;
        return true;
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
     * @param newRulesId the new grading rules to save
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
     * @return this.gradingRulesId 
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
     * @return list of enrolled students, null if unset and this.id is null
     * @todo build roster
     */
    public ArrayList<Student> getRoster()
    {
        if (this.roster != null)
        {
            return this.roster;
        }
        else
        {
            if (this.getId() != null)
            {
                this.roster = new ArrayList<Student>();
                String query = "SELECT Accounts.id as id FROM Accounts, enrolled " +
                        "WHERE Accounts.id = enrolled.student AND enrolled.course = " + this.getId();

                StorageConnection conn = new StorageConnection();
                ArrayList<ArrayList<Object>> result = conn.query(query);
                conn.close();
            }

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
        if (this.assignments != null)
        {
            return this.assignments;
        }
        else
        {
            this.assignments = new ArrayList<Assignment>();
            //Build assignments from ----- and Assignments
            //Just like above but unclear on db structure
            //How do we store Assignments and what course they belong to?
            return this.assignments;
        }
    }

    /**
     * getCode gets the course code (eg. "CSC309")
     * @return the course code as a String
     */
    public String getCode()
    {
        return this.getDepartment() + this.getNumber();
    }

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
        if (this.gradingRulesId != null)
        {
            GradingRules rules = new GradingRules(this.getGradingRulesId());

            if (rules.fetch()) //true if valid gradingRulesId in database, else false
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

    /**
     * addTeacher assignes a new Teacher to this course.
     * @param permission Permission of the user who calls this function
     * @param teacher Teacher to be added to this course
     * @return true if no errors have occured
     */
    public boolean addTeacher(Permissions permission, Teacher teacher)
    {
        return false;
    }

    /**
     * removeTeacher removes a Teacher from this course.
     * @param permission Permission of the user who calls this function
     * @param teacher Teacher to be removed from this course
     * @return true if no errors have occured
     */
    public boolean removeTeacher(Permissions permission, Teacher teacher)
    {
        return false;
    }

    /**
     * allCourses (static) queries the db for all
     * courses and returns a list of Course objects
     * @return list of all Courses in the database
     */
    static public ArrayList<Course> allCourses()
    {

        ArrayList<Course> courses = new ArrayList<Course>();
        String query = "SELECT id FROM Courses";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();


        for (int i = 0; i < result.size(); i++)
        {
            Course course = null;
            try
            {
                course = new Course((Integer) result.get(i).get(0));
            }
            catch (Exception ex)
            {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, "Error msg TBD", ex);
            }
            if (course != null && course.fetch())
            {
                courses.add(course);
            }
        }

        return courses;

    }

    /**
     * deleteCourse (static) removes the course, if exists, with 
     * provided id from the database.
     * 
     * @param permission Permission to remove a course
     * @param id Id of Course to be deleted
     * @return true if deleted, false otherwise
     * @todo StorageConnection.query does not do deletes
     * @todo Implement Permissions
     */
    static public boolean deleteCourse(Permissions permission, Integer id)
    {
        String query;
        StorageConnection conn;
        boolean ret = false;

        if (id != null)
        {
            query = "DELETE FROM Courses WHERE id=" + id.toString();
            conn = new StorageConnection();
            ret = conn.updateQuery(query);

            query = "DELETE FROM teaches WHERE course=" + id.toString();
            ret = conn.updateQuery(query);
            conn.close();
        }

        return ret;
    }

    /**
     * delete removes the current course, if exists,
     * from the database
     * @param permission Permission to remove the 
     * @return true if deleted, false otherwise
     * @todo Implement Permissions
     */
     
    public boolean delete(Permissions permission)
    {        
        boolean ret = false;
        if (this.getId() != null)
        {
            
            String query = "DELETE FROM Courses ";
            query += "WHERE id = " + this.getId();
            StorageConnection conn = new StorageConnection();
            ret = conn.updateQuery(query);
            conn.close();
        }
        
        return ret;
    }

    /**
     * addCourse (static) adds a course with the given parameters to the 
     * database.
     * 
     * @param permission Permission to add a Course
     * @param title new Course's title
     * @param department new Course's department
     * @param number new Course's number
     * @param section new Course's section
     * @return true if added, false otherwise
     */
    static public boolean addCourse(Permissions permission, String title, String department, Integer number, Integer section, Teacher teacher)
    {
        
        boolean ret = false;
        
        Course course = new Course(title, department, number, section);
        ret = course.save();
        
        if(ret)
        {
            ret = course.setTeacher(teacher);
        }
        /*
        if (title != null && department != null && number != null && section != null)
        {
            String query = "INSERT INTO Courses (title, department, number, section) " +
                    "VALUES (\"" + title + "\",\"" + department + "\",\"" + number + "\",\"" + section + "\")";
            StorageConnection conn = new StorageConnection();
            conn.updateQuery(query);
            conn.close();

            return true;
        }
        */

        return ret;
    }

    /**
     * Searches the database table Courses according
     * to this.id and sets all instance variables from there.
     * 
     * @return true if found in database, else false
     * @todo improve StorageConnection.query return handling
     * @todo write it
     */
    public boolean fetch()
    {
        String query = "SELECT title, department, number, section, gradingRulesId FROM Courses " +
                "WHERE id = " + this.getId().toString();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        ArrayList<Object> temp = null;
        conn.close();

        if (result.size() < 1)
        {
            return false;
        }
        try
        {
            temp = result.get(0);
            this.setTitle((String) temp.get(0));
            this.setDepartment((String) temp.get(1));
            this.setNumber((Integer) temp.get(2));
            this.setSection((Integer) temp.get(3));
            this.setGradingRulesId((Integer) temp.get(4));
        }
        catch (Exception ex)
        {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                    "SQL error occurred when trying to fetch Course" +
                    "with id = " + this.getId().toString(), ex);
        }

        return true;
    }

    /**
     * refresh resets all variables according to
     * database entry, a rollback 
     * @return true if successful, else false
     */
    public boolean refresh()
    {
        if (this.getId() != null)
        {
            this.setRoster(null);
            this.setAssignments(null);
            return this.fetch();
        }
        return false;
    }

    /**
     * save, stores current instance in database
     * if id already exists, update
     * else, insert
     * @return true if successfull, else false
     */
    public boolean save()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;
        String query = "";
        
        if(this.getId() == null)
        {
            query = "INSERT INTO Courses (title, department, number, section) " +
                    "VALUES (\"" + this.getTitle() + "\",\"" + this.getDepartment() + 
                    "\",\"" + this.getNumber() + "\",\"" + this.getSection() + "\")";
            
            if(!(ret = conn.updateQuery(query)))
            {
                return ret;
            }
            
            query = "SELECT max(id) FROM Courses";
            ArrayList<ArrayList<Object>> result = conn.query(query);
            conn.close();
            
            if(result.isEmpty())
            {
                return false;
            }
            
            ret = this.setId((Integer)result.get(0).get(0));
        }
        
        else
        {
            query = "SELECT id FROM Courses WHERE id = " + this.getId();
            ArrayList<ArrayList<Object>> result = conn.query(query);
            
            if(result.isEmpty())
            {
                query = "INSERT INTO Courses (id, title, department, number, section) " +
                    "VALUES (\"" + this.getId() + "\",\"" + this.getTitle() + "\",\"" + this.getDepartment() + 
                    "\",\"" + this.getNumber() + "\",\"" + this.getSection() + "\")";
                
                ret = conn.updateQuery(query);
                conn.close();
            }
            else
            {
                query = "UPDATE Courses SET " +
                    "title = \"" + this.getTitle() + "\"," +
                    "department = \"" + this.getDepartment() + "\"," +
                    "number = \"" + this.getNumber() + "\"," +
                    "section = \"" + this.getSection() + "\" " +
                    "WHERE id = \"" + this.getId() + "\"";
                
                ret = conn.updateQuery(query);
                conn.close();
            }
        }

        return ret;
                
    }

    @Override
    public String toString()
    {
        String ret = new String();
        ret += this.id + ", ";
        ret += this.title + ", ";
        ret += this.department + ", ";
        ret += this.section + ", ";
        ret += this.number;

        return ret;
    }
    
    private boolean setTeacher(Teacher teacher)
    {
        boolean ret = false;
        
        if(teacher != null && this.getId() != null)
        {
            String query = "INSERT INTO teaches (teacher, course) " +
                    "VALUES (\"" + teacher.getId() + "\",\"" + this.getId() + "\")";
            StorageConnection conn = new StorageConnection();
            ret = conn.updateQuery(query);
            conn.close();
        }
        
        return ret;
    }
}
