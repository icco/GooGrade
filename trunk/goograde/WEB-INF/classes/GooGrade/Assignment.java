package GooGrade;

import java.util.*;
import java.lang.*;

/**
 * This class keeps information about Assignments
 *
 * @author bluGoo
 * @version 0.42
 */
public class Assignment implements java.io.Serializable
{
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
	* Gets a Date object for the due date of the assignment
	* @return the date the assignment is due
	*/ 
	public Date getDueDate()
	{
		return new Date();
	}
	
	/**
	* Gets a String for the name of the assignment.
	* @return the name of the assignment.
	*/ 
	public String getName()
	{
		return new String();
	}

	
	/**
	* Gets the total points for the Assignment.
	* @return this Assignment's total points.
	*/ 
	public Integer getTotal()
	{
		return 0;
	}

	/**
	* Gets the type of Assignment.
	* @return a String of the type Assignment.
	*/ 
	public String getType()
	{
		return new String();
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
	* Sets the dueDate of the Assignment.
	* @param dueDate the date the Assignment is due.
	* @return true if set, false if failure.
	*/ 
	public boolean setDueDate(Date dueDate)
	{
		return false;
	}

	/**
	* Sets the namne of the Assignment.
	* @param name the name of the Assignment.
	* @return true if set, false if failure.
	*/ 
	public boolean setName(String name)
	{
		return false;
	}

	/**
	* Sets the total points of the Assignment.
	* @param total the total points of the Assignment.
	* @return true if set, false if failure.
	*/ 
	public boolean setTotal(Integer total)
	{
		return false;
	}


	/**
	* Sets the type of the Assignment.
	* @param type the type the Assignment is.
	* @return true if set, false if failure.
	*/ 
	public boolean setType(String type)
	{
		return false;
	}

	/**
	* Sets the average points of the Assignment
	* @param average the average points of the graded assignment for this Assignment
	* @return true if set, false if failure.
	*/ 
	public boolean setAvg(Float average)
	{
		return false;
	}

	/**
	* Sets the max points of the Assignment
	* @param max the max points of the graded assignment for this Assignment
	* @return true if set, false if failure.
	*/ 
	public boolean setMax(Float max)
	{
		return false;
	}
	
	/**
	* Sets the min points of the Assignment
	* @param min the min points of the graded assignment for this Assignment
	* @return true if set, false if failure.
	*/ 
	public boolean setMin(Float min)
	{
		return false;
	}
}

