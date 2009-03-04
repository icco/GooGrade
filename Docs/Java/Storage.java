/**
 * This will be our database connection.
 * One theory that needs to be remembered for storage is that it's 
 * best to keep database connections as abstract as possible. This
 * would work better if java implemented multiple inheritance.
 *
 * I'm not totally sure how we want to do this, but this is an idea.
 *
 * @author bluGoo
 * @version 0.42
 */
 
import java.util.*;
import java.lang.*;

interface Storage
{

	/**
	 * A function that will call a select query on a database.
	 * I could go into all of the reasons this is a bad idea, but
	 * We will probably need to do this at some point.
	 */
	ArrayList<Object> selectFrom(String query);

	/**
	 * This should connect to the Storage system and return
	 * an array of all objects of that type.
	 */
	ArrayList<Object> buildArray();

	/**
	 * This should connect to the Storage system and return
	 * an array of all objects of that type and that match
	 * the Comparator. Imagine this as the where clause in 
	 * a select statement.
	 */
	ArrayList<Object> buildArray(Comparator condition);

	/**
	 * This will save one object to the database.
	 */
	boolean save(Object in);

}
