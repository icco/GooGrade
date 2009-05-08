package goograde;

/**
 * A model for email addresses since they need to be validated and such.
 *
 * @author bluGoo
 * @version 0.42
 */
public class EmailAddress
{

    private String address;

    /**
     * Default constructor
     * @param newAddr
     */
    EmailAddress(String newAddr)
    {
        this.address = newAddr;
    }

    /**
     * Basically a wrapper for validation.
     * @param in Email adress to validate
     * @return boolean if is a valid email address or not.
     * @todo Not implemented in release 1
     */
    boolean valid(String in)
    {
        return true;
    }

    /**
     * Obtain a string form of the Email Address. 
     * @return a String of this EmailAddress
     */
    @Override
    public String toString()
    {
        return address;
    }
}
