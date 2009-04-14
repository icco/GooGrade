package blugoo;

import java.lang.*;
import java.util.*;


/**
 * The GradingRulesController class is the GradingRules controller. 
 *
 * @author Blugoo
 * @version 0.42
 */
public class GradingRulesController
{
	/**
	* Renders the Pie Charts
	*/
    public void renderPieCharts()
    {
        
    }
	
	/**
	* Sets a the lowest percentage one can have to have a grade.
	* @param letter The Grade (A,B,C,D) you wish to change
	* @param amount The amount you wish to increment the floor.
	* @return false if fail, true if set.
	*/
    public boolean addPercentage( Character letter, Integer amount)
    {
        return false;
    }
	
	/**
	* Sets a the lowest percentage one can have to have a grade.
	* @param letter The Grade (A,B,C,D) you wish to change
	* @param amount The amount you wish to decrement the floor.
	* @return false if fail, true if set.
	*/
    public boolean subtractPercentage( Character letter, Integer amount)
    {
        return false;
    }

	/**
	* Sets a the lowest percentage one can have to have a grade.
	* @param letter The Grade (A,B,C,D) you wish to change
	* @param grade The Percentage you wish to set the floor to.
	* @return false if fail, true if set.
	*/
    public boolean setPercentage( Character letter, Integer grade)
    {
        return false;
    }
}
