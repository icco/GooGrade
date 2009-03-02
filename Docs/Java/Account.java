/**
 * This is a class that keeps all of the information of a User.
 */

import java.lang.*;

/**
 * Description
 *
 * @author
 * @version
 */
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
    
    /** Type of User; can be Teacher, Teacher Assistant, or Student */
    private short userType;
    
    /** An array of Courses that the User is involved in */
    private Course courses[];
    
    /** Permissions for performing actions */
    private Permissions permission;
    
    /** An array of files that the User owns */
    private File files[];

}
