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

    private Student student;
    private Assignment assignment;
    private float grade;

    /**
     * Constructor for Grade class
     * @param crse the course this grade is from
     * @param ass teh assignment this grade is from
     * @param aThis the student is grade is for
     */
    public Grade(Assignment ass, Student aThis)
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
    public Assignment getAssignment()
    {
        return assignment;
    }

    /**
     * getStudent returns the student this grade is for
     * @return the Student ID
     */
    public Student getStudent()
    {
        return student;
    }

    /**
     * set student changes the Student id number
     * @return true if change is sucessful
     */
    public boolean setStudent(Student pstudent)
    {
        student = pstudent;
        return true;
    }

    /**
     * set Assignment changes the id number of the assignment
     * @return true if set is sucessful
     */
    public boolean setAssignment(Assignment assignmentNo)
    {
        assignment = assignmentNo;
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
                "FROM Grades WHERE assignment =" + assignment.getId();
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
                    student = (Student) result.get(0);
                    grade = (Float) result.get(1);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                            "SQL error occurred when trying to fetch " +
                            "Assignment" +
                            " with id = " + this.assignment.getId(), ex);
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if(object instanceof Grade)
        {
            if(((Grade) object).getGrade() == this.getGrade())
            {
                return true;
            }
        }
        return false;
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
                grade = new Grade((Assignment) result.get(index).get(0),
                        (Student) result.get(index).get(1));
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
    public static void addGrade(Student sStudent, Assignment sAssignment,
            float sGrade)
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
                "VALUES (" + tid + sStudent.getId() + sAssignment.getId() + ")";
        conn = new StorageConnection();
        conn.query(query);
        conn.close();

        temp.gradeStudent(sGrade);
    }

    public static void deleteGrade(Student sStudent, Assignment sAssignment)
    {
        String query = "DELETE FROM Grades WHERE accountId = " + sStudent.getId() +
                "assignId = " + sAssignment.getId();
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
    }
    
    /**
     * save, stores current instance in database
     * if id already exists, update
     * else, insert
     * @return true if successfull, else false
     */
    public boolean save()
    {
        boolean ret = false;
        /*if id is null we a creating a new course*/
        /*if(this.getId() == null)
        {
            ret = this.saveWithoutId();
        }*/
        /*if we have an id set, we are updating*/
        //else
        //{
            ret = this.saveWithId();
        //}
        return ret;
    }
    
    /**
     * save method if we don't have id set
     * @return true if no error
     */
    /*private boolean saveWithoutId()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;
        
        String query = "INSERT INTO Courses (title, department, number, section) " 
                    + "VALUES (\"" + this.getTitle() + "\",\"" + this.getDepartment() 
                    + "\",\"" + this.getNumber() + "\",\"" + this.getSection() + "\")";
        ret = conn.updateQuery(query);
        /*if we failed to update, discontinue//
        if(!(ret))
        {
            return ret;
        }
        query = "SELECT max(id) FROM Courses";
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();
        //if result is empty so is Courses//
        if(result.isEmpty())
        {
            return false;
        }
        ret = this.setId((Integer)result.get(0).get(0));
        return ret;
    }*/
    /**
     * save method if we have id set
     * @return true if no error
     */    
    private boolean saveWithId()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;
        
        String query = "SELECT assignId FROM Grades WHERE id = " 
                + this.getAssignment();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        /*if for some reason id does not exist in db we insert*/
        if(result.isEmpty())
        {
            query = "INSERT INTO Grades (assignId, grade, accountId) "
                + "VALUES (\"" + ((Integer) this.getAssignment().getId()) + "\", \"" 
                + this.getGrade() 
                + "\",\"" + ((Integer) this.getStudent().getId()) + "\")";
            ret = conn.updateQuery(query);
        }
        /*if id does exist we update*/
        else
        {
            query = "UPDATE Grades SET " 
                + "assignId = \"" + ((Integer)this.getAssignment().getId()) + "\","
                + "grade = \"" + this.getGrade() + "\","
                + "accountId = \"" + ((Integer) this.getStudent().getId()) + "\"";
            ret = conn.updateQuery(query);
        }
        conn.close();
        return ret;
    }
}
