package goograde;

/**
 * The GradingRules class determines how the Total Grade is computed from mutiple Assignment Grades. 
 *
 * @author Blugoo
 * @version 0.42
 */
public class GradingRules implements java.io.Serializable
{

    /**
     * ID used to find things in database
     */
    private Integer id;
    /**
     * The lowest percentage a student can have to obtain an A in the course.
     */
    private Integer aFloor;
    /**
     * The lowest percentage a student can have to obtain an B in the course.
     */
    private Integer bFloor;
    /**
     * The lowest percentage a student can have to obtain an C in the course.
     */
    private Integer cFloor;
    /**
     * The lowest percentage a student can have to obtain an D in the course.
     */
    private Integer dFloor;

    
    /**
     * Constructors
     */
    
    /**
     * Standard constructor, should not be used, kept for now
     */
    public GradingRules()
    {
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     */
    public GradingRules(Integer id)
    {
        this.id = id;
    }
    
    
    /**
     * Sets a the lowest percentage one can have to have a grade.
     * @param letter The Grade (A,B,C,D) you wish to change
     * @param grade The Percentage you wish to set the floor to.
     * @return false if fail, true if set.
     */
    boolean setCurve(Character letter, Integer grade)
    {
        return false;
    }

    /**
     * Gets a the lowest percentage one can have to have a grade.
     * @param letter The Grade (A,B,C,D) you wish to get
     * @return false if fail, true if set.
     */
    Integer getCurve(Character letter)
    {
        return null;
    }
    
    /**
     * Searches the database table GradingRules according
     * to this.id and sets all instance variables from there
     * @return true if found in database, else false
     * @todo improve StorageConnection.query return handling
     * @todo write it
     */
    public boolean fetch()
    {
        return false;
    }
}
