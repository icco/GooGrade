package goograde;

import goograde.Account;
import java.util.*;
import java.lang.*;


/**
 *   This class keeps information about Teacher Assistants. It is an extension of Account.
 *  
 *   @author bluGoo
 *   @version 0.42
 */
public class TeacherAssistant extends Account
{

	private ArrayList<Course> helps;

	/**
	 * Constructor for Teacher Assistant.
	 */
	public TeacherAssistant(Permissions granted)
	{
	}

	/**
	 * Constructor for Teacher Assistant. No permissions are passed in, a default, minimal permission set will be initiated. 
	 */
	public TeacherAssistant()
	{
	}
}

