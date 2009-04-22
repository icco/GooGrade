package GooGrade;

import java.io.*;
import java.util.*;

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
     * Gets the String of the owner for this File.
     * @return this File's owner.
     */
    public String getOwner()
    {
        return new String();
    }

    /**
     * Gets the Date of the creationDate for this File.
     * @return this File's creation date and time.
     */
    public Date getCreationDate()
    {
        return new Date();
    }

    /**
     * Gets the String of the filename for this File.
     * @return this File's name.
     */
    public String getFileName()
    {
        return new String();
    }

    /** 
     * Constructor for File class.
     */
    public File(String owner, Date creationDate, String fileName)
    {
    }
}
