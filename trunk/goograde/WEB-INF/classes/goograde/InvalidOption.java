package goograde;

/**
 * An exception to throw if something is given the wrong thing.
 *
 * @author nwelch
 */
public class InvalidOption extends java.lang.Error
{
    /**
     * Constructor for InvalidOption class. 
     */
    public InvalidOption()
    {
        super("You have chosen to perform an invalid option.");
    }
}
