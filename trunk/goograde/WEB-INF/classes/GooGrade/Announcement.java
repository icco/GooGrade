package GooGrade;

import java.lang.*;
import java.util.*;

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
    public boolean setBody()
    {
        return false;
    }

    /**
     * Sets the date of the Announcement.
     * @return false if error. True if successful
     */
    public Date setDate()
    {
        return this.posted;
    }

    /**
     * sets the title of the announcement.
     * @return false if error. True if successful
     */
    public String setTitle()
    {
        return this.title;
    }
}

