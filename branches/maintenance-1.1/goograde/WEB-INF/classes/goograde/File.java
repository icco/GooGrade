package goograde;

import java.util.Date;


/**
 * This class keeps information about Files.
 *
 * @author bluGoo
 * @version 0.42
 */
public class File implements java.io.Serializable
{

    /** The time and date the File was created or uploaded */
    private Date creationDate;
    /** The owner of the File */
    private String owner;
    /** The name of the File */
    private String fileName;

    /**
     * We need a constructor
     * @param newDate the date
     * @param newOwner the name of the new owner
     * @param newFileName the name of the filename that references the file.
     */
    public File(Date newDate, String newOwner, String newFileName)
    {
        this.creationDate = newDate;
        this.owner = newOwner;
        this.fileName = newFileName;
    }
    /**
     * Gets the String of the owner for this File.
     * @return this File's owner.
     */
    public String getOwner()
    {
        return this.owner;
    }

    /**
     * Gets the Date of the creationDate for this File.
     * @return this File's creation date and time.
     */
    public Date getCreationDate()
    {
        return this.creationDate;
    }

    /**
     * Gets the String of the filename for this File.
     * @return this File's name.
     */
    public String getFileName()
    {
        return this.fileName;
    }
}
