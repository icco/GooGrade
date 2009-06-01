package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class keeps information about Students. It is an extension of Account. 
 *
 * @author vgerdin 
 * @version 0.42
 */
public class Student extends Account
{

    /** 
     * courses the student is enrolled in.
     */
    private ArrayList<Course> enrolled;

    /**
     * Standard constructor, should not be used, kept for now
     */
    Student()
    {
        super();
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     * @throws Exception cuz it can
     */
    public Student(Integer id) throws Exception
    {
        super(id);
        this.enrolled = this.getEnrolled();
    }

    /**
     * Non-standard constructor
     * @param newUser  the user name an account holder uses to access GooGrade
     * @param newFull      the full name of an account holder
     * @param newEmail     the email address of an account holder
     */
    public Student(String newUser, String newFull, String newEmail)
    {
        super(newUser, newFull, newEmail);
    }

    /**
     * Large constructor with all data
     * @param id identification Integer used to fetch data from db
     * @param username used to log into system
     * @param name student's real name
     * @param email student's email
     * @throws Exception cuz it can
     */
    public Student(Integer id, String username, String name, String email)
            throws Exception
    {
        super(id, username, name, email);
        this.enrolled = this.getEnrolled();
    }

    /**
     * Create a student from an account
     * 
     * @param user Account
     */
    public Student(Account user)
    {
        this.setId(user.getId());
        this.fetch();
        this.enrolled = this.getEnrolled();
    }

    /**
     * Gets the student grade in the course.
     * @return percentage the student has in the course
     * @param crse A string which maches a course name, or other identifier.
     * @param ass An assignment to get the grade for.
     */
    public Float getGrade(Course crse, Assignment ass)
    {
        Float ret = (new Grade(ass, this)).getGrade();
        return ret;
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

        return ret;
    }

    /**
     * Sets this.enrolled
     * @param nowEnrolled ArrayList of Course objects the student is enrolled in
     * @return true if successful, false otherwise
     */
    public boolean setEnrolled(ArrayList<Course> nowEnrolled)
    {
        this.enrolled = new ArrayList<Course>(nowEnrolled);
        return true;
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
        String query = new String();

        try
        {
            query = "SELECT accounts.id as id, username, name, email";
            query += " FROM students, accounts";
            query += " WHERE students.id = accounts.id";

            out = conn.query(query);

            int index = 0;
            // For each resultant row, add into ret ArrayList
            for (ArrayList<Object> row : out)
            {
                ret.add(new Student((Integer) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++)));
                index = 0;
            }

            conn.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE,
                    "Error in Student", ex);
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

    /**
     * 
     * @return a list of the grades a student has.
     * @throws Exception cuz it can
     */
    public ArrayList<Grade> getGrades() throws Exception
    {
        String query = new String();
        ArrayList<Grade> ret = new ArrayList<Grade>();
        StorageConnection conn = new StorageConnection();

        query = "SELECT accountId, assignId FROM grades "
                + "WHERE accountId = " + this.getId();

        ArrayList<ArrayList<Object>> out = conn.query(query);

        /* add a new grade for each query result */
        for (ArrayList<Object> row : out)
        {
            int index = 0;
            Grade newGrade = new Grade((Integer) row.get(index++),
                    (Integer) row.get(index++));
            ret.add(newGrade);
        }

        return ret;
    }

    /**
     * Get the grades!
     * @param crse course which needs grades gettin' from
     * @return the list of grades
     */
    public ArrayList<Grade> getGrades(Course crse)
    {
        String query = new String();
        ArrayList<Grade> ret = new ArrayList<Grade>();
        StorageConnection conn = new StorageConnection();

        query = "SELECT accountId, assignments.id FROM grades, assignments "
                + "WHERE grades.assignId = assignments.id "
                + "AND assignments.courseId = " + crse.getId()
                + " AND  accountId = " + this.getId();

        ArrayList<ArrayList<Object>> out = conn.query(query);

        /* For each query result, add a grade to the list */
        for (ArrayList<Object> row : out)
        {
            int index = 0;
            Grade newGrade = null;
            try
            {
                newGrade = new Grade((Integer) row.get(index++),
                        (Integer) row.get(index++));
                ret.add(newGrade);

            }
            catch (Exception ex)
            {
                Logger.getLogger(Student.class.getName())
                        .log(Level.SEVERE, "Grade does not exist", ex);
            }
        }

        return ret;
    }
    
    /**
     * verify one student is the same as another
     * @param  object object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object object)
    {
        boolean ret = false;
        //If the object is a Student
        if(object instanceof Student)
        {
            Student stud = (Student) object;
            //We do not like null
            if(this.getId() != null && stud.getId() != null)
            {
                ret = this.getId().equals(stud.getId());
            }
        }
        return ret;
    }

    /**
     * Generates a hashcode
     * @return the hash of the string
     */
    @Override
    public int hashCode()
    {
        return this.toString().hashCode();
    }

    /**
     * Calculate and return the student's current grade
     * @param course the course the grade covers
     * @return Float the student's current grade
     * @author vgerdin
     */
    public Float getCurrentGrade(Course course)
    {
        Float totalScore = 0F;
        Integer totalWeight = 0;
        Float currentGrade = new Float(0);
        Integer oneHundred = new Integer(100);
        ArrayList<Grade> grades = Grade.getGrades(course, this, 1);

        // No nulls boy!
        if(grades != null)
        {
            // For each grade, add, then calc percentage
            for(Grade grade : grades)
            {
                totalWeight += grade.getAssignment().getTotal();
                totalScore += grade.getGrade();
            }
            System.out.println("totalScore " + totalScore + " totalWeight " + totalWeight);
            currentGrade = totalScore / new Float(totalWeight);
            currentGrade *= oneHundred;
        }
        
        return currentGrade;
    }
}
