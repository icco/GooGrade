package goograde;

import java.util.Date;


/**
 * An Announcement for a Course. Quite a simple class for saving 
 * and storing Announcements. There should be a method in Course to 
 * obtain an array of these associated with said Course.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Announcement implements java.io.Serializable
{

    private String body;
    private String title;
    private Date posted;

    /**
     * Default constructor; can't write test cases without one.
     */
    public Announcement()
    {
        body = new String("Announcement!");
        title = new String("Title!");
        posted = null;
    }
    
    /**
     * Returns the body, aka the content, of an Announcement.
     * @return the content of the post in a single string.
     */
    public String getBody()
    {
        return this.body;
    }

    /**
     * Returns when this Announcement was posted.
     * @return the date this was posted.
     */
    public Date getDate()
    {
        return this.posted;
    }

    /**
     * Returns the title of this Announcement.
     * @return a string containing the title.
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Sets the body of the Announcement.
     * @return false if error. True if successful
     */
    public boolean setBody(String newBody)
    {
        this.body = newBody;
        return true;
    }

    /**
     * Sets the date of the Announcement.
     * @return false if error. True if successful
     */
    public boolean setDate()
    {
        return false;
    }

    /**
     * sets the title of the announcement.
     * @return false if error. True if successful
     */
    public boolean setTitle(String newTitle)
    {
        this.title = newTitle;
        return true;
    }
}

