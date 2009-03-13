package blugoo.controller;

import java.util.*;
import java.lang.*;

/**
 * This class does most of the work on the Account. It is the Account controller.
 * @author bluGoo
 * @version 0.42
 */
public abstract class Account 
{
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
	 * gets the EmailAddress of this account.
	 * @return this user's email address 
	 */
	public EmailAddress getEmailAddress()
	{
		return this.emailAddress;
	}
	
	/**
	 * Takes new password, hashes it, and saves to database.
	 * @param newpass the new password to be saved
	 * @return true if set, false if failure.
	 */
	boolean setPassword(String newpass)
	{
		return false;
	}
	
	/**
	 * set the Account's user name.
	 * @return true if set, false if error.
	 */
	String setUserName()
	{
		return false;
	}

	/**
	 * set the Account's full name.
	 * @return true if set, false if error.
	 */
	String setFullName()
	{
		return false;
	}

	/**
	 * sets the EmailAddress of this Account.
	 * @return true if set, false if error.
	 */
	public boolean setEmailAddress()
	{
		return false;
	}
	
	/**
	 * Checks the provided password to see if they match.
	 * @param passwd the password entered by the user that will be compared with the stored value. 
	 * @return true if the hashed passwd matches the password in the database, false otherwise. 
	 */
	boolean isPassword(String passwd)
	{
		return false;
	}
}

