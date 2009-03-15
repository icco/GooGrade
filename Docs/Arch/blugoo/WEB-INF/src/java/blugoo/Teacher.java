package blugoo;

import java.util.*;
import java.lang.*;


/**
 * A Teacher is an Account type that has the most permissions. It acts as the
 * administrator of its installation. There are a lot of methods in here
 * that really should not be in here. I mean seriously. most of the create,
 * edit, and remove methods SHOULD NOT be in here. It makes me cringe everytime I think about it.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Teacher extends Account
{
    /** An array of Announcements owned by the Teacher */
    private Announcement announcements[];

    /** A list of courses owned by the Teacher */
    private ArrayList<Course> courses;

	/** Constructor for Teacher. All permissions are granted to the Teacher by  default.  
	 */
	public Teacher()
	{
	}
}
