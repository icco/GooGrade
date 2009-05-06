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
    private static final int kTITLEMINLEN = 3;
    private static final int kTITLEMAXLEN = 100;
    private static final int kDEPARTMENTMINLEN = 2;
    private static final int kDEPARTMENTMAXLEN = 4;

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
     * @param title Title of course
     * @param department Department of course
     * @param number course number
     * @param section section of course
     */
    public Course(String title, String department, Integer number, Integer section)
    {
        this.setTitle(title);
        this.setDepartment(department);
        this.setNumber(number);
        /*default value for section is 1*/
        if (section == null)
        {
            this.setSection(new Integer(1));
        }
        else
        {
            this.setSection(section);
        }
    }

    /**
     * setId sets this.id to provided argument
     * @param newId Integer to store
     * @return true if no errors
     */
    public boolean setId(Integer newId)
    {
        boolean ret = false;
        /*id must not be set to null*/
        if (newId != null)
        {
            this.id = newId;
            ret = true;
        }
        return ret;
    }

    /**
     * setTitle saves a new Couse title over the old.
     * @param newTitle the new title to save
     * @return true if no errors 
     */
    public boolean setTitle(String newTitle)
    {
        boolean ret = false;
        /*title must not be set to null*/
        if (newTitle != null)
        {
            this.title = newTitle;
            ret = true;
        }
        return ret;
    }

    /**
     * setDepartment sets this.department to provided argument
     * @param newDepartment department tag (eg. "CSC")
     * @return true if no errors
     */
    public boolean setDepartment(String newDepartment)
    {
        boolean ret = false;
        /*department must not be set to null*/
        if (newDepartment != null)
        {
            this.department = newDepartment;
            ret = true;
        }
        return ret;
    }

    /** 
     * setNumber replaces the course number with a new one
     * @param newNumber is the new course number to save
     * @return true if no errors occurred. 
     */
    public boolean setNumber(Integer newNumber)
    {
        boolean ret = false;
        /*number must not be set to null*/
        if (newNumber != null)
        {
            this.number = newNumber;
            ret = true;
        }
        return ret;
    }

    /**
     * setSection saves a new section number over the old one
     * @param newSection is the number of the new section to save
     * @return true if no errors occurred
     */
    public boolean setSection(Integer newSection)
    {
        boolean ret = false;
        /*section must not be set to null*/
        if (newSection != null)
        {
            this.section = newSection;
            ret = true;
        }
        return ret;
    }

    /**
     * setGradingRules saves a new Grading Rules over the old.
     * @param newRulesId the new grading rules to save
     * @return true if no errors 
     */
    public boolean setGradingRulesId(Integer newRulesId)
    {
        boolean ret = false;
        /*rulesId must not be set to null*/
        if (newRulesId != null)
        {
            this.gradingRulesId = newRulesId;
            ret = true;
        }
        return ret;
    }

    /**
     * setRoster sets this.roster to provided argument
     * @param newRoster list of students enrolled in the course
     * @return true if no errors
     */
    public boolean setRoster(ArrayList<Student> newRoster)
    {
        boolean ret = false;
        /*this will always happen but keep same look as rest in case of change*/
        if (true)
        {
            this.roster = newRoster;
            ret = true;
        }
        return ret;
    }

    /**
     * setAssignments sets this.assignments provided argument
     * @param newAssignments list of assignments associated with the course
     * @return true if no errors
     */
    public boolean setAssignments(ArrayList<Assignment> newAssignments)
    {
        boolean ret = false;
        /*this will always happen but keep same look as rest in case of change*/
        if (true)
        {
            this.assignments = newAssignments;
            ret = true;
        }
        return ret;
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
     * A simple wrapper for getRoster so we have a slightly more consistent api
     * @return an arraylist of students
     */
    public ArrayList<Student> getStudents()
    {
        return this.getRoster();
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
        Student toAdd = null;

        /*if we have a roster, return it */
        if (this.roster != null)
        {
            return this.roster;
        }
        /*else fetch it from db and return */
        else
        {
            /*avoid null pointer exceptions, we must have an id to fetch from db*/
            if (this.getId() != null)
            {
                this.roster = new ArrayList<Student>();
                String query = "SELECT Accounts.id as id FROM Accounts, enrolled " +
                        "WHERE Accounts.id = enrolled.student " +
                        "AND enrolled.course = " + this.getId();

                StorageConnection conn = new StorageConnection();
                ArrayList<ArrayList<Object>> result = conn.query(query);
                conn.close();

                /* For each student result, add it to the roster */
                for (int indx = 0; indx < result.size(); indx++)
                {
                    try
                    {
                        toAdd = new Student((Integer) result.get(indx).get(0));
                        this.roster.add(toAdd);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Invalid roster: " + ex);
                    }
                }

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
        Assignment toAdd = null;

        /*if we have a list of assignments return it*/
        if (this.assignments != null)
        {
            return this.assignments;
        }
        /*if list of assignments are missing, fetch it from db*/
        else
        {
            /*avoid null pointer exceptions, we must have an id to fetch from db*/
            if (this.getId() != null)
            {
                this.assignments = new ArrayList<Assignment>();
                String query = "SELECT id FROM Assignments " +
                        "WHERE courseId = " + this.getId();

                StorageConnection conn = new StorageConnection();
                ArrayList<ArrayList<Object>> result = conn.query(query);
                conn.close();

                /* For each query result, add an assignment to the list */
                for (int indx = 0; indx < result.size(); indx++)
                {
                    try
                    {
                        toAdd = new Assignment((Integer) result.get(indx).get(0));
                        this.assignments.add(toAdd);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Invalid assignments: " + ex);
                    }
                }
            }
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
     */
    public ArrayList<Teacher> getTeachers()
    {
        ArrayList<Teacher> teachers = null;
        Teacher toAdd = null;
        /*avoid null pointer exceptions, we must have an id to fetch from db*/
        if (this.getId() != null)
        {
            teachers = new ArrayList<Teacher>();
            String query = "SELECT Accounts.id as id" +
                    " FROM Accounts, teaches " +
                    "WHERE Accounts.id = teaches.teacher " +
                    "AND teaches.course = " + this.getId();

            StorageConnection conn = new StorageConnection();
            ArrayList<ArrayList<Object>> result = conn.query(query);
            conn.close();

            /* For each query result, add a teacher to the list */
            for (int indx = 0; indx < result.size(); indx++)
            {
                try
                {
                    toAdd = new Teacher((Integer) result.get(indx).get(0));
                    teachers.add(toAdd);
                }
                catch (Exception ex)
                {
                    System.out.println("Invalid Teacher list: " + ex);
                }
            }
        }
        return teachers;
    }

    /**
     * getTeacherAssistant gets the TeacherAssistant attribute from this course
     * @return assistants of this course
     */
    public ArrayList<TeacherAssistant> getTeacherAssistants()
    {
        ArrayList<TeacherAssistant> assistants = null;
        TeacherAssistant toAdd = null;
        /*avoid null pointer exceptions, we must have an id to fetch from db*/
        if (this.getId() != null)
        {
            assistants = new ArrayList<TeacherAssistant>();
            String query = "SELECT Accounts.id as id " +
                    "FROM Accounts, assists " +
                    "WHERE Accounts.id = assists.ta " +
                    "AND assists.course = " + this.getId();

            StorageConnection conn = new StorageConnection();
            ArrayList<ArrayList<Object>> result = conn.query(query);
            conn.close();

            /* For each query result, add a TeacherAssistant to the list */
            for (int indx = 0; indx < result.size(); indx++)
            {
                try
                {
                    toAdd = new TeacherAssistant((Integer) result.get(indx).get(0));
                    assistants.add(toAdd);
                }
                catch (Exception ex)
                {
                    System.out.println("Invalid TA list: " + ex);
                }
            }
        }
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
        
        GradingRules rules = null;
        /*if no id is set, get one from db*/
        if (this.gradingRulesId != null)
        {
            rules = new GradingRules(this.getGradingRulesId());
            /*true if valid gradingRulesId in database, else false*/
            if (!rules.fetch())
            {
                rules = null;
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
    public boolean addStudent(Permissions permission, Account student)
    {
        boolean ret = false;
        boolean isInRoster = false;

        /* Only add a student if the representing object has an id */
        if (student != null && student.getId() != null && this.getId() != null)
        {
            ArrayList<Student> currentRoster = this.getRoster();
            int indx;
            /* Go through every line item in the roster */
            for (indx = 0; indx < currentRoster.size(); indx++)
            {
                /* Confirm the student received is at this index in the roster */
                if (student.equals(currentRoster.get(indx)))
                {
                    isInRoster = true;
                    break;
                }
            }
            /*if student is not in the roster, we add him*/
            if (!isInRoster)
            {
                String query = "INSERT INTO enrolled (course, student) " +
                        "VALUES (\"" + this.getId() +
                        "\",\"" + student.getId() + "\")";
                StorageConnection conn = new StorageConnection();
                ret = conn.updateQuery(query);
                conn.close();
                this.setRoster(null);
            /*setting roster to null will force new 
            generation a next get*/
            }
        }

        return ret;
    }

    /**
     * removeStudent removes a particular student from the course.
     * @param permission the permission of the user who calls this function
     * @param student the student to be removed from this course
     * @return true if no errors were encountered in removal.
     */
    public boolean removeStudent(Permissions permission, Account student)
    {
        boolean ret = false;
        boolean isInRoster = false;

        /* Only proceed if the received student object has a valid id */
        if (student != null && student.getId() != null && this.getId() != null)
        {
            ArrayList<Student> currentRoster = this.getRoster();
            int indx;
            /* Walk through the roster */
            for (indx = 0; indx < currentRoster.size(); indx++)
            {
                /* Verify the student received is at this location in the roster */
                if (student.equals(currentRoster.get(indx)))
                {
                    isInRoster = true;
                    break;
                }
            }

            /* Proceed if the student was found */
            if (isInRoster)
            {
                String query = "DELETE FROM enrolled " +
                        "WHERE student = \"" +
                        student.getId() +
                        "\" AND course = \"" + this.getId() + "\"";
                StorageConnection conn = new StorageConnection();
                ret = conn.updateQuery(query);
                conn.close();
                this.setRoster(null);
            /*setting roster to null will force new 
            generation a next get*/
            }

        }
        return ret;
    }

    /**
     * addTA assignes a new TeacherAssistant to this course.
     * @param permission the permission of the user who calls this function
     * @param ta the TeacherAssistant to be assigned to this course
     * @return true if no errors have occured
     */
    public boolean addTA(Permissions permission, Account ta)
    {
        boolean ret = false;
        boolean isAssisting = false;

        /* Check for valid id in teacher assistant object before proceeding */
        if (ta != null && ta.getId() != null && this.getId() != null)
        {
            ArrayList<TeacherAssistant> currentTAs = this.getTeacherAssistants();
            int indx;
            /* Walk through the list of teacher assistants */
            for (indx = 0; indx < currentTAs.size(); indx++)
            {
                /* Confirm the received assistant is at this list location */
                if (ta.equals(currentTAs.get(indx)))
                {
                    isAssisting = true;
                    break;
                }
            }
            /*if student is not in the roster, we add him*/
            if (!isAssisting)
            {
                String query = "INSERT INTO assists (course, ta) " +
                        "VALUES (\"" + this.getId() +
                        "\",\"" + ta.getId() + "\")";
                StorageConnection conn = new StorageConnection();
                ret = conn.updateQuery(query);
                conn.close();
            }
        }
        return ret;
    }

    /**
     * removeTA removes a TeacherAssistant from this course
     * @param permission the permission of the user who calls this function
     * @param ta the TeacherAssistant to be removed to this course
     * @return true if no errors have occured
     */
    public boolean removeTA(Permissions permission, Account ta)
    {
        boolean ret = false;
        boolean isAssisting = false;

        /* Validate the id of the teacher assistant before proceeding */
        if (ta != null && ta.getId() != null && this.getId() != null)
        {
            ArrayList<TeacherAssistant> currentTAs = this.getTeacherAssistants();
            int indx;
            /* walk through the teacher assistant list */
            for (indx = 0; indx < currentTAs.size(); indx++)
            {
                /* confirm the received TA is the same as the one at this list loc */
                if (ta.equals(currentTAs.get(indx)))
                {
                    isAssisting = true;
                    break;
                }
            }

            /* Proceed if a teacher assistant was found */
            if (isAssisting)
            {
                String query = "DELETE FROM assists " +
                        "WHERE ta = \"" + ta.getId() +
                        "\" AND course = \"" + this.getId() + "\"";
                StorageConnection conn = new StorageConnection();
                ret = conn.updateQuery(query);
                conn.close();
            }
        }
        return ret;
    }

    /**
     * addTeacher assignes a new Teacher to this course.
     * @param permission Permission of the user who calls this function
     * @param teacher Teacher to be added to this course
     * @return true if no errors have occured
     */
    public boolean addTeacher(Permissions permission, Account teacher)
    {
        boolean ret = false;
        boolean isTeaching = false;

        /* validate incoming teacher's ID before proceeding */
        if (teacher != null && teacher.getId() != null && this.getId() != null)
        {
            ArrayList<TeacherAssistant> currentTAs = this.getTeacherAssistants();
            int indx;
            /* Loop through the list retrieved */
            for (indx = 0; indx < currentTAs.size(); indx++)
            {
                /* Proceed if a teacher is found */
                if (teacher.equals(currentTAs.get(indx)))
                {
                    isTeaching = true;
                    break;
                }
            }
            /*if teacher is not teaching, we add him*/
            if (!isTeaching)
            {
                String query = "INSERT INTO teaches (course, teacher) " +
                        "VALUES (\"" + this.getId() + "\",\"" +
                        teacher.getId() + "\")";
                StorageConnection conn = new StorageConnection();
                ret = conn.updateQuery(query);
                conn.close();
            }
        }
        return ret;
    }

    /**
     * removeTeacher removes a Teacher from this course.
     * @param permission Permission of the user who calls this function
     * @param teacher Teacher to be removed from this course
     * @return true if no errors have occured
     */
    public boolean removeTeacher(Permissions permission, Account teacher)
    {
        boolean ret = false;
        boolean isTeaching = false;

        /* validate teacher id before proceeding */
        if (teacher != null && teacher.getId() != null && this.getId() != null)
        {
            ArrayList<Teacher> currentTeachers = this.getTeachers();
            int indx;
            /* Loop through the teacher list */
            for (indx = 0; indx < currentTeachers.size(); indx++)
            {
                /* Proceed if a teacher is found to match the received one */
                if (teacher.equals(currentTeachers.get(indx)))
                {
                    isTeaching = true;
                    break;
                }
            }

            /* Proceed if a teacher was found */
            if (isTeaching)
            {
                String query = "DELETE FROM teaches " + "WHERE teacher = \"" +
                        teacher.getId() + "\" AND course = \"" + this.getId() + "\"";
                StorageConnection conn = new StorageConnection();
                ret = conn.updateQuery(query);
                conn.close();
            }
        }
        return ret;
    }

    /**
     * allCourses (static) queries the db for all
     * courses and returns a list of Course objects
     * @return list of all Courses in the database
     */
    public static ArrayList<Course> allCourses()
    {

        ArrayList<Course> courses = new ArrayList<Course>();
        String query = "SELECT id FROM Courses";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();

        /*for all in result, add to returned course list*/
        for (int index = 0; index < result.size(); index++)
        {
            Course course = null;
            try
            {
                course = new Course((Integer) result.get(index).get(0));
            }
            catch (Exception ex)
            {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                        "Could not retrieve any courses", ex);
            }
            /*avoid null pointer exceptions and fetch is successful*/
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
    public static boolean deleteCourse(Permissions permission, Integer id)
    {
        String query;
        StorageConnection conn;
        boolean ret = false;
        /*only delete if id is not null*/
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
        /*we can only delete if id is not null*/
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
     * @param teacher set the teacher for the class
     * @return true if added, false otherwise
     */
    public static boolean addCourse(Permissions permission, String title,
            String department, Integer number, Integer section, Teacher teacher)
    {

        boolean ret = false;

        Course course = new Course(title, department, number, section);
        ret = course.save();
        /*if we have not failed already, continue*/
        if (ret)
        {
            ret = course.setTeacher(teacher);
        }

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
        String query = "SELECT title, department, number, section, ";
        query += "gradingRulesId FROM Courses ";
        query += "WHERE id = " + this.getId();
        
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        ArrayList<Object> temp = null;
        conn.close();
        /*if nothing was found we could not find anything in db*/
        if (result.size() < 1)
        {
            return false;
        }
        try
        {
            int index = 0;
            temp = result.get(0);
            this.setTitle((String) temp.get(index++));
            this.setDepartment((String) temp.get(index++));
            this.setNumber((Integer) temp.get(index++));
            this.setSection((Integer) temp.get(index++));
            this.setGradingRulesId((Integer) temp.get(index++));
        }
        catch (Exception ex)
        {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                    "SQL error occurred when trying to fetch Course " +
                    "with id = " +
                    this.getId().toString(), ex);
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
        /*can only refresh if we exist in db, ie id != null*/
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
        /*if id is null we a creating a new course*/
        if (this.getId() == null)
        {
            ret = this.saveWithoutId();
        }
        /*if we have an id set, we are updating*/
        else
        {
            ret = this.saveWithId();
        }
        return ret;
    }

    /**
     * save method if we don't have id set
     * @return true if no error
     */
    private boolean saveWithoutId()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;

        String query = "INSERT INTO Courses (title, department, number, section) ";
        query += "VALUES (\"" + this.getTitle() + "\",\"" + this.getDepartment();
        query += "\",\"" + this.getNumber() + "\",\"" + this.getSection() + "\")";
        ret = conn.updateQuery(query);
        /*if we failed to update, discontinue*/
        if (!(ret))
        {
            return ret;
        }
        query = "SELECT max(id) FROM Courses";
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();
        /*if result is empty so is Courses*/
        if (result.isEmpty())
        {
            return false;
        }
        ret = this.setId((Integer) result.get(0).get(0));
        return ret;
    }

    /**
     * save method if we have id set
     * @return true if no error
     */
    private boolean saveWithId()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;

        String query = "SELECT id FROM Courses WHERE id = " + this.getId();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        /*if for some reason id does not exist in db we insert*/
        if (result.isEmpty())
        {
            query = "INSERT INTO Courses (id, title, department, number, section) "; 
            query += "VALUES (\"" + this.getId() + "\",\"";
            query += this.getTitle() + "\",\"" + this.getDepartment();
            query += "\",\"" + this.getNumber() + "\",\"";
            query += this.getSection() + "\")";

            ret = conn.updateQuery(query);
        }
        /*if id does exist we update*/
        else
        {
            query = "UPDATE Courses SET ";
            query += "title = \"";
            query += this.getTitle();
            query += "\"," + "department = \"";
            query += this.getDepartment() + "\",";
            query += "number = \"" + this.getNumber();
            query += "\"," + "section = \"";
            query += this.getSection() + "\" ";
            query += "WHERE id = \"" + this.getId() + "\"";

            ret = conn.updateQuery(query);
        }
        conn.close();
        return ret;
    }

    /**
     * toString()
     * @return a string created from Course class
     */
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

    /**
     * matches a teacher's id and a course id int the table teaches
     * @param teacher the new teacher for the class
     * @return true if set and no errors
     */
    private boolean setTeacher(Teacher teacher)
    {
        boolean ret = false;
        /*db table has two columns that can't be set to null...*/
        if (teacher != null && this.getId() != null)
        {
            String query = "INSERT INTO teaches (teacher, course) ";
            query += "VALUES (\"" + teacher.getId();
            query += "\",\"" + this.getId() + "\")";
            StorageConnection conn = new StorageConnection();
            ret = conn.updateQuery(query);
            conn.close();
        }

        return ret;
    }

    /**
     * Validates that given string can be used as an id
     * @param string string to be validated
     * @return true if string follows specifications for id
     */
    public static boolean validateId(String string)
    {
        boolean ret = true;
        try
        {
            Integer tmp = new Integer(string);
            /* Validate the input value */
            if (tmp.intValue() < 1)
            {
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException nfe)
        {
            ret = false;

            Logger.getLogger(
                    Course.class.getName()).log(Level.SEVERE,
                    string + " is not a valid section ");
        }
        return ret;
    }

    /**
     * Validates that given string can be used as a title
     * @param string string to be validated
     * @return true if string follows specifications for title
     */
    public static boolean validateTitle(String string)
    {
        boolean ret = true;


        /* Validate input */
        if (string == null ||
                string.length() < kTITLEMINLEN ||
                string.length() > kTITLEMAXLEN)
        {
            ret = false;
            Logger.getLogger(
                    Course.class.getName()).log(Level.SEVERE,
                    string + " is not a valid title");
        }

        return ret;
    }

    /**
     * Validates that given string can be used as a department
     * @param string string to be validated
     * @return true if string follows specifications for department
     */
    public static boolean validateDepartment(String string)
    {
        boolean ret = true;

        /* validate data */
        if (string == null ||
                string.length() < kDEPARTMENTMINLEN ||
                string.length() > kDEPARTMENTMAXLEN)
        {
            ret = false;
            Logger.getLogger(
                    Course.class.getName()).log(Level.SEVERE,
                    string + " is not a valid department");
        }

        return ret;
    }

    /**
     * Validates that given string can be used as a number
     * @param string string to be validated
     * @return true if string follows specifications for number
     */
    public static boolean validateNumber(String string)
    {
        boolean ret = true;
        try
        {
            Integer tmp = new Integer(string);
        }
        catch (NumberFormatException nfe)
        {
            ret = false;
            Logger.getLogger(
                    Course.class.getName()).log(Level.SEVERE,
                    string + " is not a valid number");
        }
        return ret;
    }

    /**
     * Validates that given string can be used as a section
     * @param string string to be validated
     * @return true if string follows specifications for section
     */
    public static boolean validateSection(String string)
    {
        boolean ret = true;
        try
        {
            Integer tmp = new Integer(string);
        }
        catch (NumberFormatException nfe)
        {
            ret = false;

            Logger.getLogger(
                    Course.class.getName()).log(Level.SEVERE,
                    string + " is not a valid section ");
        }
        return ret;
    }
}
