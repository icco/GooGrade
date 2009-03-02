/**
 * This is a class that keeps all of the information of a user.
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
	/** Description */
	private String userName;
    
    /** Description */
	private String fullName;
    
    /** Description */
	private String emailAddress;
    
    /** Description */
    private String password;
    
    /** Description */
    private short userType;
    
    /** Description */
    private Course courses;
    
    /** Description */
    private Permissions permission;
    
    /** Description */
    private File files[];

}
