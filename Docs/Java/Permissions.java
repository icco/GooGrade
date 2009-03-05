/**
 * This class keeps information about permissions for each action.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Permissions
{
    /** Permission for sending emails */
    private boolean sendEmail;
    
    /** Permission for uploading files */
    private boolean uploadFile;
    
    /** Permission for viewing personal grades */
    private boolean viewOwnGrade;
    
    /** Permission for managing Courses */
    private boolean manageCourse;
    
    /** Permission for managing metrics */
    private boolean manageMetric;
    
    /** Permission for managing grades */
    private boolean manageGrade;
    
    /** Permission for managing the roster */
    private boolean manageRoster;
    
    /** Permission for managing Assignments */
    private boolean manageAnnouncement;
    
    /** Permission for managing Users */
    private boolean manageUser;

    /** Constructor for Permissions class
     */
    public Permissions()
    {
    }

    /* This class probably needs an enum */
    /**
     * VerifyPermission determines if an account has the permission required to perform another method. 
     * @param inquirer indicates the specific permission that is being inquired about.
     * @return permission is true if the account has permission to perform the inquired action.    
     */
    public boolean VerifyPermission(int inquirer)
    {
	    return permission. 
    }

}
