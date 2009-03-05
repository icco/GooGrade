import java.lang.*;
import java.util.*;

/**
 * An announcement for a course.
 * @author bluGoo
 * @version 0.42
 */
public class Announcement implements Storage
{
	private String body;
	private String title;
	private Date posted;

	/**
	 * Posts an announcement.
	 * @param title The title
	 * @param post The post body
	 */
	boolean post(String title, String post)
	{
		return false;
	}
}
