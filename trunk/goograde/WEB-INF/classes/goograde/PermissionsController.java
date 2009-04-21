package goograde;

import java.lang.*;
import java.io.*;
import java.util.*;

/**
 * This class keeps the permissions controller.
 *
 * @author bluGoo
 * @version 0.42
 */
public class PermissionsController
{
    /**
     * VerifyPermission determines if an account has the permission required to perform another method. 
     * @param inquirer indicates the specific permission that is being inquired about.
     * @return permission is true if the account has permission to perform the inquired action.    
     */
    public boolean VerifyPermission(int inquirer)
    {
	    return true; 
    }


    /** 
 * AddPermission grants a new permission to a user. It does nothing to permissions already granted.  
     * @param permission to determine which permission is to be granted
     */
    public void  AddPermission( int permission)
    {
    }

    /** 
 * Remove Permission prevents a user from using a specific permission. It does nothing to permissions previoulsy not granted. 
     * @param permission to determine which permission to be removed
     */
    public void RemovePermission( int permission)
    {
    }
}
