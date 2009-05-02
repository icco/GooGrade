package goograde;

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
     * The type of the Assignment; can be Test, Quiz, Homework, Participation, or Other
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

    /**
     * Sets the dueDate of the Assignment.
     * @param pdueDate the date the Assignment is due.
     * @return true if set, false if failure.
     */
    public boolean setDueDate(Date pdueDate)
    {
        dueDate = pdueDate;
        /*now updating the database with changes */
        String query = "UPDATE Assignments SET dueDate =" +
                dueDate + "WHERE id = " + id;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
        return true;
    }

    /**
     * Sets the namne of the Assignment.
     * @param pname the name of the Assignment.
     * @return true if set, false if failure.
     */
    public boolean setName(String pname)
    {
        name = pname;
        /*now updating the database with changes */
        String query = "UPDATE Assignments SET dueDate =" +
                dueDate + "WHERE id = " + id;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**
     * Sets the total points of the Assignment.
     * @param ptotal the total points of the Assignment.
     * @return true if set, false if failure.
     */
    public boolean setTotal(Integer ptotal)
    {
        total = ptotal;
        /*now updating the database with changes */
        String query = "UPDATE Assignments SET dueDate =" +
                dueDate + "WHERE id = " + id;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
        return true;
    }

    /**
     * Sets the type of the Assignment.
     * @param ptype the type the Assignment is.
     * @return true if set, false if failure.
     */
    public boolean setType(String ptype)
    {
        type = ptype;
        /*now updating the database with changes */
        String query = "UPDATE Assignments SET dueDate =" +
                dueDate + "WHERE id = " + id;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
        return true;
    }

    /**
     * Sets the average points of the Assignment
     * @param paverage the average points of the graded assignment for this Assignment
     * @return true if set, false if failure.
     */
    public boolean setAvg(Float paverage)
    {
        average = paverage;
        /*now updating the database with changes */
        String query = "UPDATE Assignments SET dueDate =" +
                dueDate + "WHERE id = " + id;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
        return true;
    }

    /**
     * Sets the max points of the Assignment
     * @param pmax the max points of the graded assignment for this Assignment
     * @return true if set, false if failure.
     */
    public boolean setMax(Float pmax)
    {
        max = pmax;
        /*now updating the database with changes */
        String query = "UPDATE Assignments SET dueDate =" +
                dueDate + "WHERE id = " + id;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
        return true;
    }

    /**
     * Sets the min points of the Assignment
     * @param pmin the min points of the graded assignment for this Assignment
     * @return true if set, false if failure.
     */
    public boolean setMin(Float pmin)
    {
        min = pmin;
        /*now updating the database with changes */
        String query = "UPDATE Assignments SET dueDate =" +
                dueDate + "WHERE id = " + id;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();
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
        ArrayList<Object> result = conn.query(query).get(0);
        conn.close();
        
        /* No results from the query means an unsuccessful fetch */
        if(result.size() < 1)
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
                dueDate = (Date) result.get(3);
                type = (String) result.get(4);
                average = (Float) result.get(5);
                max = (Float) result.get(6);
                min = (Float) result.get(7);
            }
            catch (Exception ex)
            {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                        "SQL error occurred when trying to fetch Assignment"
                        + " with id = " + this.id.toString(), ex);
            }
        }

        return true;
    }
}

