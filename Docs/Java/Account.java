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
	 */
	boolean isPassword(String passwd)
	{
		return false;
	}

	/**
	 * Takes new password, hashes it, and saves to database.
	 */
	boolean setPassword(String newpass)
	{
		return true;
	}
}
