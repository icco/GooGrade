package blugoo;

import java.lang.*;
import java.util.*;


/**
 * The GradingRules class determines how the Total Grade is computed from mutiple Assignment Grades. 
 *
 * @author Blugoo
 * @version 0.42
 */
public class GradingRulesController
{
	/**
	 * The lowest percentage a student can have to obtain an A in the course.
	 */
	private Integer aFloor;
	/**
	 * The lowest percentage a student can have to obtain an B in the course.
	 */
	private Integer bFloor;
	/**
	 * The lowest percentage a student can have to obtain an C in the course.
	 */
	private Integer cFloor;
	/**
	 * The lowest percentage a student can have to obtain an D in the course.
	 */
	private Integer dFloor;

	/**
	 * Sets a the lowest percentage one can have to have a grade.
	 * @param letter The Grade (A,B,C,D) you wish to change
	 * @param grade The Percentage you wish to set the floor to.
	 * @return false if fail, true if set.
	 */
	boolean setCurve(Character letter, Integer grade)
	{
		return false;
	}

	/**
	 * Gets a the lowest percentage one can have to have a grade.
	 * @param letter The Grade (A,B,C,D) you wish to get
	 * @return false if fail, true if set.
	 */
	Integer getCurve(Character letter)
	{
		return null;
	}

}
