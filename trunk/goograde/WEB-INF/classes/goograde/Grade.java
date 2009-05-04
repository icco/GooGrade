package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Grade holds a specific grade for bewteen an assignment and student.  
 * 
 * @author kblizard 
 * @author nwelch
 */
public class Grade
{

    private int student;
    private int assignment;
    private float grade;

    /**
     * Constructor for Grade class
     * @param crse the course this grade is from
     * @param ass teh assignment this grade is from
     * @param aThis the student is grade is for
     */
    public Grade(int ass, int aThis)
    {
        this.student = aThis;
        this.assignment = ass;
    }

    /**
     * Empty Constructor for Grade. Not to be used.
     */
    public Grade()
    {
    }

    /**
     * gradeStudent gives a grade to a specific student.
     * @param theGrade the grade the student will receive
     * @return true if grading is successful
     */
    public boolean gradeStudent(float theGrade)
    {
        this.grade = theGrade;

        return true;
    }

    /**
     * getGrade retrieves the grade for this student and assignment
     * @return the grade received
     */
    public Float getGrade()
    {
        return grade;
    }

    /**
     * getAssignment returns the assignment this grade belonged to
     * @return the Assignment ID
     */
    public int getAssgnment()
    {
        return assignment;
    }

    /**
     * getStudent returns the student this grade is for
     * @return the Student ID
     */
    public int getStudent()
    {
        return student;
    }

    /**
     * set student changes the Student id number
     * @return true if change is sucessful
     */
    public boolean setStudent(int pstudent)
    {
        String query = "UPDATE Grades SET accountId = " + pstudent +
                " WHERE assignId = " + assignment;
        StorageConnection conn = new StorageConnection();
        conn.updateQuery(query);
        conn.close();
        return true;
    }

    /**
     * set Assignment changes the id number of the assignment
     * @return true if set is sucessful
     */
    public boolean setAssignment(int assignmentNo)
    {
        String query = "UPDATE Grades SET accountId = " + assignmentNo +
                " WHERE assignId = " + student;
        StorageConnection conn = new StorageConnection();
        conn.updateQuery(query);
        conn.close();
        return true;
    }

    /**
     * toString returns the grade in the form of a string
     * @return the String version of the grade. 
     */
    @Override
    public String toString()
    {
        return this.getGrade().toString();
    }

    public boolean fetch()
    {
        /*Get the database at row ID */
        String query = "SELECT accountId, grade" +
                "FROM Grades WHERE assignment =" + assignment;
        StorageConnection conn = new StorageConnection();
        if (conn.query(query).size() > 0)
        {

            ArrayList<Object> result = conn.query(query).get(0);
            conn.close();
            /* No results from the query means an unsuccessful fetch */
            if (result.size() < 1)
            {
                return false;
            }
            else
            {
                try
                {
                    //set varaibles to values loaded from database,
                    student = (Integer) result.get(0);
                    grade = (Float) result.get(1);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                            "SQL error occurred when trying to fetch " +
                            "Assignment" +
                            " with id = " + this.assignment, ex);
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }

    public static ArrayList<Grade> allGrades()
    {
        ArrayList<Grade> assgns = new ArrayList<Grade>();
        String query = "SELECT assignId, accountId FROM Grades";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();

        /*for all in result, add to returned course list*/
        for (int index = 0; index < result.size(); index++)
        {
            Grade grade = null;
            try
            {
                grade = new Grade((Integer) result.get(index).get(0),
                        (Integer) result.get(index).get(1));
            }
            catch (Exception ex)
            {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                        "Error msg TBD", ex);
            }
            /*avoid null pointer exceptions and fetch is successful*/
            if (grade != null && grade.fetch())
            {
                assgns.add(grade);
            }
        }

        return assgns;

    }

    
    /* NO! */
    public static void addGrade(int sStudent, int sAssignment, float sGrade)
    {
        String query = "SELECT count (*) FROM Grades";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();
        //TODO: fix database indexing issue. Deleting an item 
        //and adding it confiuses the index

        int tid = (Integer) result.get(0).get(0) + 1;

        Grade temp = new Grade(sAssignment, sStudent);
        query = "INSERT INTO Grades (id, accountId, assignId) " +
                "VALUES (" + tid + sStudent + sAssignment + ")";
        conn = new StorageConnection();
        conn.query(query);
        conn.close();

        temp.gradeStudent(sGrade);
    }

    public static void deleteGrade(int sStudent, int sAssignment)
    {
        String query = "DELETE FROM Grades WHERE accountId = " + sStudent +
                "assignId = " + sAssignment;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
    }
}
