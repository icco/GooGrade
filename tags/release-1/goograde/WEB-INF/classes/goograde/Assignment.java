package goograde;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class keeps information about Assignments
 *
 * @author bluGoo, vgerdin//I deserve this for all the bugs
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
    private int courseId;

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
     * an assignment is deleted
     * @param rId assignment id to delete
     */
    public static void deleteAssignment(String rId)
    {
        String query = "DELETE FROM Assignments WHERE id = " + rId;
        StorageConnection conn = new StorageConnection();
        conn.updateQuery(query);
        conn.close();
    }

    /**
     * Gets a Date object for the due date of the assignment
     * @return the date the assignment is due
     */
    public Date getDueDate()
    {
        return this.dueDate;
    }

    /**
     * Gets a String for the name of the assignment.
     * @return the name of the assignment.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the total points for the Assignment.
     * @return this Assignment's total points.
     */
    public Integer getTotal()
    {
        return this.total;
    }

    /**
     * Gets the ID of the course this assignment belongs to
     * @return this course's ID
     */
    public Integer getCourseId()
    {
        return this.courseId;
    }

    /**
     * @return a course for this assignment.
     */
    public Course getCourse()
    {
        return new Course(this.getCourseId());
    }

    /**
     * Gets the type of Assignment.
     * @return a String of the type Assignment.
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Gets the average points of Assignment.
     * @return this Assignment's average points.
     */
    public Float getAvg()
    {
        return this.average;
    }

    /**
     * Gets the max point out of all graded assignment of this Assignment.
     * @return this Assignment's max points.
     */
    public Float getMax()
    {
        return this.max;
    }

    /**
     * Gets the min point out of all graded assignment of this Assignment.
     * @return this Assignment's min points.
     */
    public Float getMin()
    {
        return this.min;
    }

    /**
     * Get this Assignment's ID
     * @return the Assignment's ID
     */
    public Integer getId()
    {
        return this.id;
    }

    /**
     * getGrades returns a list of grades for this assignment
     * @return the list of grades
     */
    public ArrayList<Grade> getGrades()
    {
        /*Now fetch the grades from the grade table */
        String query = "SELECT accountId, grade, assignId ";
        query += "FROM Grades WHERE assignId =" + this.getId();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result2 = conn.query(query);
        conn.close();
        ArrayList<Grade> grades = null;

        try
        {
            grades = new ArrayList<Grade>();

            /* Add a grade for each result */
            for (int count = 0; count < result2.size(); count++)
            {
                int index = 0;
                grades.add(new Grade(
                        new Student((Integer) result2.get(count).get(index++)),
                        new Float((Double) result2.get(count).get(index++)),
                        new Assignment((Integer) result2.get(count).get(index))));
            }

        }
        catch (Exception ex)
        {
            String msg = "SQL error occurred when trying to fetch Grades ";
            msg += "with assignId = " + this.id.toString();
            /*table insert failed */
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                    msg, ex);
        }


        return grades;

    }

    /**
     * Sets the dueDate of the Assignment.
     * @param pdueDate the date the Assignment is due.
     * @return true if set, false if failure.
     */
    public boolean setDueDate(Date pdueDate)
    {
        /* Only good data will be set */
        if (pdueDate != null)
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
        /* Only good data will be set */
        if (pname != null)
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
        /* Only good data will be set */
        if (ptotal > 0)
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
        /* Only good data will be set */
        if (ptype != null)
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
        if (paverage >= 0)
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
        if (pmax >= 0)
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
        if (pmin >= 0)
        {
            min = pmin;
        }

        return true;
    }

    /**
     * Sets the Course ID for this Assignment
     * @param pcourse the id to set
     * @return true if id set, false otherwise
     */
    public boolean setCourseId(int pcourse)
    {
        /* Only good data will be set */
        if (pcourse > 0)
        {
            courseId = pcourse;
        }

        return true;
    }

    /**
     * Saves a new grade for a partucular student into the database
     * @param aStudent the student being graded.
     * @param newGrade the new grade to set
     * @return true if save was successful
     */
    public boolean setAGrade(Student aStudent, float newGrade)
    {
        boolean ret = false;
        boolean pass = false;
        ArrayList<Grade> grades = this.getGrades();
        Grade toSet = new Grade(this, aStudent);
        String query = "";
        
        /*making sure to avoid nulls */
        if (grades == null)
        {
            grades = new ArrayList<Grade>();
        }
        //check for maches in the entire list
        for(int indx = 0; indx<grades.size(); indx++)
        {
            //if grade is in there
            if(toSet.equals(grades.get(indx)))
            {
                
                query = "UPDATE Grades SET grade = " + newGrade;
                query += " WHERE assignId = " + this.getId();
                query += " AND accountId = " + aStudent.getId();
                pass = true;
                
            }
        }
        //if we already set the query
        if(!pass)
        {
            query = "INSERT INTO Grades (accountId, grade, assignId) ";
            query += "VALUES (" + aStudent.getId() + "," + newGrade;
            query += "," + this.getId() + ")";
            
        }
        
        StorageConnection conn = new StorageConnection();
        ret = conn.updateQuery(query);
        conn.close();
        
        return ret;
    }

    /**
     * set the assignment ID
     * @param newId new id to set
     * @return true if successful, false otherwise
     */
    public boolean setId(int newId)
    {
        boolean ret = true;
        /* Only good data will be set */
        if (newId > 0)
        {
            id = newId;
        }
        else
        {
            ret = false;
        }
        return ret;
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
        String query = "SELECT id, aTotal, aName, ";
        query += "aDueDate, aType, aAverage, aMax, ";
        query += "aMin, courseId FROM Assignments WHERE id = ";
        query += this.getId();
        boolean ret = false;
        StorageConnection conn = new StorageConnection();

        /* Process positive results from the database query */
        if (conn.query(query).size() > 0)
        {
            ArrayList<Object> result = conn.query(query).get(0);
            conn.close();

            /* No results from the query means an unsuccessful fetch */
            if (result.size() > 0)
            {
                int indx = 1;
                try
                {
                    //set varaibles to values loaded from database
                    total = (Integer) result.get(indx++);
                    name = (String) result.get(indx++);

                    String dateFormatString = "EEE MMM dd HH:mm:ss zzz yyyy";
                    SimpleDateFormat format = new SimpleDateFormat(dateFormatString);
                    Date newDate = format.parse((String) result.get(indx++));
                    dueDate = newDate;
                    this.setType((String) result.get(indx++));
                    average = new Float((Double) result.get(indx++));
                    max = new Float((Double) result.get(indx++));
                    min = new Float((Double) result.get(indx++));
                    this.setCourseId((Integer) result.get(indx++));
                    ret = true;
                }
                catch (Exception ex)
                {
                    String msg = "SQL error occurred when trying to fetch ";
                    msg += "Assignment with id = " + this.id.toString();
                    Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                             msg, ex);
                }
            }
        }

        return ret;
    }

    /**
     * return all assignments, yo
     * @return all assignments, yo
     */
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

    /**
     * add an assignment, yo
     * @param courseId the id to add
     * @param type the type to add
     * @param dueDate the date to add
     * @param name the name to add
     * @param total the total to add
     */
    public static void addAssignment(int courseId, String type, Date dueDate,
            String name, Integer total)
    {
        /*String query = "SELECT count (*) FROM Assignments";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close(); */
        //T0D0: fix database indexing issue. Deleting an item 
        //and adding it confiuses the index

        //int tid = (Integer) result.get(0).get(0) + 1;

        Assignment temp = new Assignment();
        /*query = "INSERT INTO Assignments (id) " +
        "VALUES (" + tid + ")";
        conn = new StorageConnection();
        conn.query(query);
        conn.close(); */

        temp.setCourseId(courseId);
        temp.setType(type);
        temp.setDueDate(dueDate);
        temp.setName(name);
        temp.setTotal(total);
        temp.setAvg(new Float(0F));
        temp.setMax(new Float(0F));
        temp.setMin(new Float(0F));

        temp.save();
    }

    /* <REMOVED * TO AVOID CONFUSION WITH JAVADOCS
     * This has a lot of parameters. Live with it.
     * 
     * @param type to change
     * @param max to change
     * @param min to change
     * @param average to change
     * @param dueDate to change
     * @param name to change
     * @param total to change
     * @param pid to change
     */
    /* REMOVED AS IT IS UNUSED AND FAILS STYLE, NEEDS FIXING BEFORE IMPELENTING
    private static void modifyAssignment(String type, float max, float min,
            float average, Date dueDate, String name, Integer total, int pid)
    {

        Assignment temp = new Assignment(pid);

        //Validate data
        if (type != null)
        {
            temp.setType(type);
        }
        /* Validate data
        if (max >= 0)
        {
            temp.setMax(max);
        }
        /* Validate data
        if (min >= 0)
        {
            temp.setMin(min);
        }
        /* Validate data
        if (average >= 0)
        {
            temp.setAvg(average);
        }
        /* Validate data
        if (dueDate != null)
        {
            temp.setDueDate(dueDate);
        }
        /* Validate data 
        if (name != null)
        {
            temp.setName(name);
        }
        /* Validate data 
        if (total != null)
        {
            temp.setTotal(total);
        }
    }
*/
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


        String query = "INSERT INTO Assignments (aType, aMax, aMin, ";
        query += "aAverage, aDueDate, aName, aTotal, courseId)";
        query += " VALUES (\"" + this.getType() + "\"," + this.getMax();
        query += "," + this.getMin() + "," + this.getAvg() + ",\"";
        query += this.getDueDate() + "\",\"" + this.getName() + "\",";
        query += this.getTotal() + ",\"" + this.getCourseId() + "\")";

        ret = conn.updateQuery(query);
        /*if we failed to update, discontinue*/
        if (!(ret))
        {
            return ret;
        }
        query = "SELECT max(id) FROM Assignments";
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();
        /*if result is empty so is Assignments*/
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

        String query = "SELECT id FROM Assignments WHERE id = " + this.getId();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        /*if for some reason id does not exist in db we insert*/
        if (result.isEmpty())
        {
            query = "INSERT INTO Assignments (id, aType, aMax, aMin, ";
            query += "aAverage, aDueDate, aName, aTotal, courseId";
            query += "VALUES (\"" + this.getId() + "\",\"" + this.getType();
            query += "\",\"" + this.getMax() + "\",\"" + this.getMin();
            query += "\",\"" + this.getAvg() + "\",\"" + this.getDueDate();
            query += "\",\"" + this.getName() + "\",\"" + this.getTotal();
            query += "\",\"" + this.getCourseId() + "\")";
            ret = conn.updateQuery(query);
        }
        /*if id does exist we update*/
        else
        {
            query = "UPDATE Assignments SET ";
            query += "aType = \"" + this.getType() + "\"," + "aMax = \"";
            query += this.getMax() + "\"," + "aMin = \"" + this.getMin();
            query += "\"," + "aAverage = \"" + this.getAvg() + "\",";
            query += "aDueDate = \"" + this.getDueDate() + "\"," + "aName = \"";
            query += this.getName() + "\"," + "aTotal = \"" + this.getTotal();
            query += "\" " + "WHERE id = \"" + this.getId() + "\"";
            ret = conn.updateQuery(query);
        }
        conn.close();
        return ret;
    }

    /**
     * standard toString(), returns a customized string of the assignment
     * @return Assignment in string format
     */
    @Override
    public String toString()
    {
        String ret = new String();

        ret += this.getId() + ", ";
        ret += this.getDueDate() + ", ";
        ret += this.getName() + ", ";
        ret += this.getTotal() + ", ";
        ret += this.getType() + ", ";
        ret += this.getAvg() + ", ";
        ret += this.getMin() + ", ";
        ret += this.getMax() + ", ";
        ret += this.getCourseId();

        return ret;
    }
    
    /**
     * verify one assignment is the same as another
     * @param object object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object object)
    {
        boolean ret = false;
        //object has to be an assignment
        if(object instanceof Assignment)
        {
            Assignment assObject = (Assignment) object;
            //we do not like null
            if(this.getId() != null 
                    && assObject != null 
                    && assObject.getId() != null)
            {
                ret = this.getId().equals(assObject.getId());
            }
        }
        return ret;
    }
}

