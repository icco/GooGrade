/**
 * This is a class that keeps all of the information of a User.
 * @author bluGoo
 * @version 0.42
 */

import java.util.*;
import java.lang.*;

public class Account implements Storage
{
	/** Username for logging in */
	private String userName;
    
    /** Full name of the Account owner */
	private String fullName;
    
    /** Email address of the Account owner */
	private String emailAddress;
    
    /** Password for logging in */
    private String password;
    
    /** An array of Courses that the User is involved in */
    private ArrayList<Course> courses;
    
    /** Permissions for performing actions */
    private Permissions permission;
}
