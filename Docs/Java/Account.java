/**
 * This is a class that keeps all of the information of a User.
 * @author bluGoo
 * @version 0.42
 */

import java.util.*;
import java.lang.*;

public abstract class Account implements Storage
{
	/** Username for logging in */
	private String userName;
    
    /** Full name of the Account owner */
	private String fullName;
    
    /** Email address of the Account owner */
	private EmailAddress emailAddress;
    
	/**
	 * Password for logging in. This will not be 
	 * stored in plain text due to privacy concerns. 
	 */
	private Password password;

	/** An array of Courses that the User is involved in */
	private ArrayList<Course> courses;
    
	/** Permissions for performing actions */
	private Permissions permission;

	/**
	 * get the accounts user name.
	 * @return a string with the user name of the current account
	 */
	String getUserName()
	{
		return this.userName;
	}

	/**
	 * get the accounts full name.
	 * @return a string with the full name of the current account
	 */
	String getFullName()
	{
		return this.fullName;
	}

	/**
	 * hashes the provided password and checks to see if they match.
	 * @param passwd the password entered by the user that will be compared with the stored value. 
	 * @return true if the hashed passwd matches the password in the database, false otherwise. 
	 */
	boolean isPassword(String passwd)
	{
		return false;
	}

	/**
	 * Takes new password, hashes it, and saves to database.
	 * @param newpass the new password to be saved
	 * @return none
	 */
	boolean setPassword(String newpass)
	{
		return true;
	}

	/**GetEmailAddress returns the EmailAddress of this account.
	 * @param none
	 * @return this user's email address 
	 */
	public EmailAddress getEmailAddress()
	{
		return emailAddress;
	}



}
