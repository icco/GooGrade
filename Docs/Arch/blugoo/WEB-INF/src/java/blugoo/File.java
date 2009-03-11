import java.io.*;
import java.util.*;

/**
 * This class keeps information about Files
 *
 * @author bluGoo
 * @version 0.42
 */
public class File implements Serializable
{
    /** The time and date the File was created or uploaded */
    private String creationDate;
    
    /** The owner of the File */
    private String owner;
    
    /** The name of the File */
    private String fileName;

}