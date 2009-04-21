package blugoo;

import java.util.*;
import java.lang.*;

/**
 * A model for email addresses since they need to be validated and such.
 *
 * @author bluGoo
 * @version 0.42
 */
public class EmailAddress 
{
	private String address;

	/**
	 * Basically a wrapper for validation.
	 * @param in Email adress to validate
	 * @return boolean if is a valid email address or not.
	 */
	boolean valid(String in)
	{
		return false;
	}

	/**
	 * Obtain a string form of the Email Address. 
	 * @return a String of this EmailAddress
	 */
	public String toString()
	{
		return address;
	}
}
