/**
 * The class stores information about Emails.
 *
 * @author bluGoo
 * @version 0.42
 */

import java.lang.*;
import java.util.*;

public class Email
{
    /** The title of the Email */
    private String emailTitle;
    
    /** The pathname of a file to be attached to the Email */
    private String emailAttachment;
    
    /** An array of email addresses to which the Email will be sent */
    private ArrayList<String> emailRecipients;
    
    /** The body of the Email */
    private String emailBody;


    /** 
     * Constructor for Email class.
     */
    public Email()
    {
    }
}
