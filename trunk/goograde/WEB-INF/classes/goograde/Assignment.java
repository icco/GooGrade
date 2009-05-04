package goograde;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class keeps information about Assignments
 *
 * @author bluGoo
 * @version 0.42
 */
public class Assignment implements java.io.Serializable
{

    /**
     * The database id of the Assignment
     */
    private Integer id;
    /** 
     * The due date of the Assignment 
     */
    private Date dueDate;
    /**
     * The name of the Assignment 
     */
    private String name;
    /**
     * The maximum possible score of the Assignment 
     */
    private Integer total;
    /**
     * The type of the Assignment; can be Test, Quiz, Homework, Participation,
     * or Other
     */
    private String type;
    /**
     * The average for all graded assignments for this assignment
     */
    private Float average;
    /**
     * The maximum for all graded assignments for this assignment
     */
    private Float max;
    /**
     * The minimum for all graded assignments for this assignment
     */
    private Float min;
    private ArrayList<Grade> grades; // a list of student grades on this 
    //  assignment

    private int courseId;

    /**
     * Constructors
     */
    /**
     * Standard constructor, should not be used, kept for now
     */
    public Assignment()
    {
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     */
    public Assignment(Integer id)
    {
        this.id = id;
        this.fetch();
    }

    public static void deleteAssignment(String Rid)
    {
        String query = "DELETE FROM Assignments WHERE id = " + Rid;
        StorageConnection conn = new StorageConnection();
        conn.updateQuery(query);
        conn.close();

        /*query = "DELETE FROM Grades WHERE assignId = " + Rid;
        conn = new StorageConnection();
        conn.updateQuery(query);
        conn.close(); */


    }

    /**
     * Gets a Date object for the due date of the assignment
     * @return the date the assignment is due
     */
    public Date getDueDate()
    {
        return dueDate;
    }

    /**
     * Gets a String for the name of the assignment.
     * @return the name of the assignment.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the total points for the Assignment.
     * @return this Assignment's total points.
     */
    public Integer getTotal()
    {
        return total;
    }

    /**
     * Gets the ID of the course this assignment belongs to
     * @return
     */
    public Integer getCourseId()
    {
        return courseId;
    }

    /**
     * Gets the type of Assignment.
     * @return a String of the type Assignment.
     */
    public String getType()
    {
        return type;
    }

    /**
     * Gets the average points of Assignment.
     * @return this Assignment's average points.
     */
    public Float getAvg()
    {
        return average;
    }

    /**
     * Gets the max point out of all graded assignment of this Assignment.
     * @return this Assignment's max points.
     */
    public Float getMax()
    {
        return max;
    }

    /**
     * Gets the min point out of all graded assignment of this Assignment.
     * @return this Assignment's min points.
     */
    public Float getMin()
    {
        return min;
    }

    public int getId()
    {
        return id;
    }

    /**
     * getGrades returns a list of grades for this assignment
     * @return the list of grades
     */
    public ArrayList<Grade> getGrades()
    {
        return grades;
    }

    /**
     * Sets the dueDate of the Assignment.
     * @param pdueDate the date the Assignment is due.
     * @return true if set, false if failure.
     */
    public boolean setDueDate(Date pdueDate)
    {
        if(pdueDate != null)
        {
            dueDate = pdueDate;
        }
        return true;
    }

    /**
     * Sets the namne of the Assignment.
     * @param pname the name of the Assignment.
     * @return true if set, false if failure.
     */
    public boolean setName(String pname)
    {
        if(pname != null)
        {
            name = pname;
        }

        return true;
    }

    /**
     * Sets the total points of the Assignment.
     * @param ptotal the total points of the Assignment.
     * @return true if set, false if failure.
     */
    public boolean setTotal(Integer ptotal)
    {
        if(ptotal > 0)
        {
            total = ptotal;
        }
        return true;
    }

    /**
     * Sets the type of the Assignment.
     * @param ptype the type the Assignment is.
     * @return true if set, false if failure.
     */
    public boolean setType(String ptype)
    {
        if(ptype != null)
        {
            type = ptype;
        }

        return true;
    }

    /**
     * Sets the average points of the Assignment
     * @param paverage the average points of the graded assignment for this 
     * Assignment
     * @return true if set, false if failure.
     */
    public boolean setAvg(Float paverage)
    {
        //TODO, ACTUALLY calculate the average from all grades submitted
        if(paverage > 0)
        {
            average = paverage;
        }
        return true;
    }

    /**
     * Sets the max points of the Assignment
     * @param pmax the max points of the graded assignment for this Assignment
     * @return true if set, false if failure.
     */
    public boolean setMax(Float pmax)
    {
        //TODO. calculate the maximum score out of all the grades
        if(pmax > 0)
        {
            max = pmax;
        }
     
        return true;
    }

    /**
     * Sets the min points of the Assignment
     * @param pmin the min points of the graded assignment for this Assignment
     * @return true if set, false if failure.
     */
    public boolean setMin(Float pmin)
    {
        //TODO, calculate the minimum score out of all teh grades
        if(pmin > 0)
        {
            min = pmin;
        }
      
        return true;
    }

    /**
     * Sets the Course ID for this Assignment
     */
    public boolean setCourseId(int pcourse)
    {
        if(pcourse > 0)
        {
            courseId = pcourse;
        }
        
        return true;
    }

    /**
     * Saves a new grade for a partucular student into the database
     * @param aStudent the student being graded.
     * @return true if save was successful
     */
    public boolean setAGrade(Student aStudent, float newGrade)
    {

        /*making sure to avoid nulls */
        if (grades == null)
        {
            grades = new ArrayList<Grade>();
        }

        /*adds the new grade */
        grades.add(new Grade(aStudent.getId(), id));
        grades.get(grades.indexOf(aStudent.getId())).gradeStudent(newGrade);

        return true;
    }

    public boolean setId(int newId)
    {
        if (newId > 0)
        {
            id = newId;
        }
        else
        {
            return false;
        }
        return true;
    }

    /**
     * Searches the database table Assignments according
     * to this.id and sets all instance variables from there
     * @return true if found in database, else false
     * @todo improve StorageConnection.query return handling
     * @todo write it
     */
    public boolean fetch()
    {
        /*Get the database at row ID */
        String query = "SELECT id, aTotal, aName, " +
                "aDueDate, aType, aAverage, aMax, " +
                "aMin FROM Assignments WHERE id =" + id;
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
                    total = (Integer) result.get(1);
                    name = (String) result.get(2);

                    String dateFormatString = "MM-dd-yy";
                    SimpleDateFormat format = new SimpleDateFormat(dateFormatString);
                    Date newDate = format.parse((String) result.get(3));
                    dueDate = newDate;
                    type = (String) result.get(4);
                    average = new Float((Double) result.get(5));
                    max = new Float((Double) result.get(6));
                    min = new Float((Double) result.get(7));
                }
                catch (Exception ex)
                {
                    Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                            "SQL error occurred when trying to fetch " +
                            "Assignment" +
                            " with id = " + this.id.toString(), ex);
                }
            }

            /*Now fetch the grades from the grade table */
            query = "SELECT accountId, grade, assignId " +
                    "FROM Grades WHERE assignId =" + id;
            conn = new StorageConnection();
            ArrayList<ArrayList<Object>> result2 = conn.query(query);
            conn.close();

            /* No results from the query means an unsuccessful fetch */
            if (result2.size() < 1)
            {
                //return false;
            }
            else
            {
                try
                {
                    /*put the grades into the grade table */
                    grades = new ArrayList<Grade>();
                    int count;
                    for (count = 0; count < result2.size(); count++)
                    {
                        grades.add(new Grade((Integer) result2.get(count).get(2),
                                (Integer) result2.get(count).get(0)));
                        grades.get(count).gradeStudent((Float) result2.get(count).get(1));
                    }

                }
                catch (Exception ex)
                {
                    /*table insert failed */
                    Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                            "SQL error occurred when trying to fetch Grades" +
                            " with id = " + this.id.toString(), ex);
                }
            }
        }
        else
        {
            return false;
        }
        return true;

    }

    public static ArrayList<Assignment> allAssignments()
    {

        ArrayList<Assignment> assgns = new ArrayList<Assignment>();
        String query = "SELECT id FROM Assignments";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();

        /*for all in result, add to returned course list*/
        for (int index = 0; index < result.size(); index++)
        {
            Assignment assignment = null;
            try
            {
                assignment = new Assignment((Integer) result.get(index).get(0));
            }
            catch (Exception ex)
            {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                        "Error msg TBD", ex);
            }
            /*avoid null pointer exceptions and fetch is successful*/
            if (assignment != null && assignment.fetch())
            {
                assgns.add(assignment);
            }
        }

        return assgns;

    }

    public static void addAssignment(String type, Date dueDate, String name,
            Integer total)
    {
        /*String query = "SELECT count (*) FROM Assignments";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close(); */
        //TODO: fix database indexing issue. Deleting an item 
        //and adding it confiuses the index

        //int tid = (Integer) result.get(0).get(0) + 1;

        Assignment temp = new Assignment();
        /*query = "INSERT INTO Assignments (id) " +
                "VALUES (" + tid + ")";
        conn = new StorageConnection();
        conn.query(query);
        conn.close(); */

        temp.setType(type);
        temp.setDueDate(dueDate);
        temp.setName(name);
        temp.setTotal(total);
        temp.save();
    }

    private static void modifyAssignment(String type, float max, float min,
            float average, Date dueDate, String name, Integer total, int pid)
    {

        Assignment temp = new Assignment(pid);

        if (type != null)
        {
            temp.setType(type);
        }
        if (max >= 0)
        {
            temp.setMax(max);
        }
        if (min >= 0)
        {
            temp.setMin(min);
        }
        if (average >= 0)
        {
            temp.setAvg(average);
        }
        if (dueDate != null)
        {
            temp.setDueDate(dueDate);
        }
        if (name != null)
        {
            temp.setName(name);
        }
        if (total != null)
        {
            temp.setTotal(total);
        }
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
        if (this.getId() == 0)
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

        String query = "INSERT INTO Assignments (id, type, max, min, " +
                "average, dueDate, name, total" + "VALUES (\"" + this.getId() + "\",\"" + this.getType() + "\",\"" + this.getMax() + "\",\"" + this.getMin() + "\"" + this.getAvg() + "\"" + this.getDueDate() + "\"" + this.getName() + "\"" + this.getTotal() + "\")";
        ret = conn.updateQuery(query);
        /*if we failed to update, discontinue*/
        if (!(ret))
        {
            return ret;
        }
        query = "SELECT max(id) FROM Assignments";
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
            query = "INSERT INTO Assignments (id, type, max, min, " +
                    "average, dueDate, name, total" + "VALUES (\"" 
                    + this.getId() + "\",\""
                    + this.getType() + "\",\"" 
                    + this.getMax() + "\",\"" 
                    + this.getMin() + "\", \"" 
                    + this.getAvg() + "\", \"" 
                    + this.getDueDate() + "\", \""
                    + this.getName() + "\", \"" 
                    + this.getTotal() + "\")";
            ret = conn.updateQuery(query);
        }
        /*if id does exist we update*/
        else
        {
            query = "UPDATE Courses SET " 
                    + "id = "+ this.getId() + "\", \"" 
                    + "type =" + this.getType() + "\", \""
                    + "max = " + this.getMax() + "\", \"" 
                    + "min" + this.getMin() + "\" , \"" 
                    + "average = " + this.getAvg() + "\" , \"" 
                    + "dueDate = " + this.getDueDate() + "\" , \"" 
                    + "name = " + this.getName() + "\", \"" 
                    + "total = " + this.getTotal() + "\"";
            ret = conn.updateQuery(query);
        }
        conn.close();
        return ret;
    }
}

