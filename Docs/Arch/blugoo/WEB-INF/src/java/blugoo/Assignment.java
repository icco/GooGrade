package blugoo;
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
	 * The type of the Assignment; can be Test, Quiz, Homework, Participation, or other
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

	public Date getDueDate()
	{
		return new Date();
	}

	public String getName()
	{
		return new String();
	}

	public Integer getTotal()
	{
		return 0;
	}

	public String getType()
	{
		return new String();
	}

	public Float getAvg()
	{
		return this.average;
	}

	public Float getMax()
	{
		return this.max;
	}

	public Float getMin()
	{
		return this.min;
	}

	public Date setDueDate()
	{
		return new Date();
	}

	public String setName()
	{
		return new String();
	}

	public Integer setTotal()
	{
		return 0;
	}

	public String setType()
	{
		return new String();
	}

	public Float setAvg()
	{
		return this.average;
	}

	public Float setMax()
	{
		return this.max;
	}

	public Float setMin()
	{
		return this.min;
	}
}

