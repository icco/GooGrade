package blugoo;

import java.lang.*;
import java.io.*;
import java.util.*;

/**
 * This class keeps information about permissions for each action.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Permissions implements java.io.Serializable
{
    /** Permission for sending emails */
    private boolean sendEmail;
    
    /** Permission for uploading files */
    private boolean uploadFile;
    
    /** Permission for viewing personal grades */
    private boolean viewOwnGrade;
    
    /** Permission for managing Courses */
    private boolean manageCourse;
    
    /** Permission for managing metrics */
    private boolean manageMetric;
    
    /** Permission for managing grades */
    private boolean manageGrade;
    
    /** Permission for managing the roster */
    private boolean manageRoster;
    
    /** Permission for managing Assignments */
    private boolean manageAnnouncement;
    
    /** Permission for managing Users */
    private boolean manageUser;

    /** Constructor for Permissions class
     */
    public Permissions()
    {
    }
}
