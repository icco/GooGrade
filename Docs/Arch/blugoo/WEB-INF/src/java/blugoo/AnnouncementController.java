
package blugoo;

import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * An announcement for a course. Quite a simple class for saving 
 * and storing Announcements. There should be a method in Course to 
 * obtain an array of these associated with said Course.
 * @author bluGoo
 * @version 0.42
 */
public class AnnouncementController
{
	private String body;
	private String title;
	private Date posted;

	/**
	 * Posts an announcement. This will call the functions needed 
	 * to save to the database.
	 * @param title The title
	 * @param post The post body
	 */
	boolean post(String title, String post)
	{
		return false;
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
}

