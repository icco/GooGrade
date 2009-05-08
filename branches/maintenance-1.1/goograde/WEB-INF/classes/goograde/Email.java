package goograde;

import java.util.ArrayList;



/**
 * The class stores information about Emails. These emails will not be stored 
 * in the database. This is purely a way to create a wrapper for validation and 
 * sending of emails.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Email
{

    /** The title of the Email */
    private String emailTitle;
    /** The files to be attached to the Email */
    private ArrayList<File> emailAttachment;
    /** An array of email addresses to which the Email will be sent */
    private ArrayList<EmailAddress> emailRecipients;
    /** The body of the Email */
    private String emailBody;

    /** 
     * Constructor for Email class.
     * @param title email title
     * @param attachments email attachments
     * @param to receiver of email
     * @param body message of email
     */
    public Email(String title, ArrayList<File> attachments,
            ArrayList<EmailAddress> to, String body)
    {
        this.emailTitle = title;
        this.emailAttachment = attachments;
        this.emailRecipients = to;
        this.emailBody = body;
    }
    
    /**
     * Get the email title
     * @return email title
     */
    public String getEmailTitle()
    {
        return this.emailTitle;
    }
    
    /**
     * Get the email body
     * @return email body
     */
    public String getEmailBody()
    {
        return this.emailBody;
    }
}
