package goograde;

//import java.lang;
//import java.io.*;
import java.util.ArrayList;
//import java.sql.Array;
//import java.sql.ResultSet;
//import java.sql.SQLException;


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
    /** Permission for managing announcements */
    private boolean manageAnnouncement;
    /** Permission for managing Users */
    private boolean manageUser;
    /*the ID of the account that these permissions belong to */
    private int accountID;

    /** Constructor for a NEW Permissions class. By default all permissions 
     * are turned off, assuming Teacher Assistant mode.
     */
    public Permissions()
    {
        manageUser = false;
        manageAnnouncement = false;
        manageRoster = false;
        manageGrade = false;
        manageMetric = false;
        manageCourse = false;
        viewOwnGrade = false;
        uploadFile = false;
        sendEmail = false;

        //make ID the next integer in the database here T0D0
        String query = "INSERT INTO Permissions (manageUser, "
                + "manageAnnouncement, manageRoster, manageGrade, manageMetric"
                + "manageCourse, viewOwnGrade, uploadFile, sendEmail) "
                + "VALUES(" + manageUser + ", " + manageAnnouncement + ", "
                + manageRoster + ", " + manageGrade + ", " + manageMetric + ", "
                + manageCourse + ", " + viewOwnGrade + ", " + uploadFile + ", "
                + sendEmail + ")";
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close(); 
    }

    /**
     * Constructor for a NEW Permissions class. By default all permissions are 
     * turned off, assuming Teacher Assistant mode, unless isTeacher or 
     * isStudent is true
     * @param isStudent determines whether set Student type permissions.
     * @param isTeacher determines whether to set Teacher type permissions.
     * @throws java.lang.Exception if isStudent and isTeacher are both true.
     */
    public Permissions(boolean isStudent, boolean isTeacher) throws Exception
    {
        this();

        /*Check for error */
        if (isStudent && isTeacher)
        {
            /*Trying to set two contradictory permissions */
            throw new Exception("Account cannot be Student and Teacher");
        }
        /*Based on type of account created, different permissions are set. */
        if (isStudent)
        {
            /*student permissions */
            viewOwnGrade = true;
            uploadFile = true;
        }
        /*set teacher permissions */
        else if (isTeacher)
        {
            /*teacher permissions */
            manageUser = true;
            manageAnnouncement = true;
            manageRoster = true;
            manageGrade = true;
            manageMetric = true;
            manageCourse = true;
            uploadFile = true;
            sendEmail = true;
        }
    }

    /**
     * Constuctor for a PREVIOUSLY EXISTING set of permissions
     * @param id is the ID of the Account that these permissions belong to
     */
    public Permissions(int id)
    {
        /*loads permissions from the database */
        String query = "SELECT manageUser, manageAnnouncement, manageRoster, "
                + "manageGrade, manageMetric, manageCourse, uploadFile, "
                + "sendEmail FROM Permissions WHERE accountID =" + id;
        StorageConnection conn = new StorageConnection();
        ArrayList<Object> result =  conn.query(query).get(0);
        conn.close();

    /*set variables from results from the database.  */
    //i dont know how to get the items out of the array
    manageUser = (Boolean) result.get(0);
    manageAnnouncement = (Boolean) result.get(1);
    manageRoster = (Boolean) result.get(2);
    manageGrade = (Boolean) result.get(3);
    manageMetric = (Boolean) result.get(4);
    manageCourse = (Boolean) result.get(5);
    uploadFile = (Boolean) result.get(6);
    sendEmail = (Boolean) result.get(7);
    

    }

    /**
     * changeVerify is a permission checker to make sure the system has 
     * permission to edit permissions. 
     * @param manageUserPermit
     * @return false if no problems are encountered. 
     * @throws java.lang.IllegalAccessException
     */
    private boolean changeVerify(boolean manageUserPermit) throws
            IllegalAccessException
    {
        /*System needs manage User permission */
        if (!manageUserPermit)
        {
            //throw error
            throw new IllegalAccessException("Permission Denied");
        }
        return false;
    }

    /** To check if the user has the sendEmail permission
     * @return true if yes, false if no
     */
    public boolean isSendEmail()
    {
        return sendEmail;
    }

    /** To check if the user has the uploadFile permission
     * @return true if yes, false if no
     */
    public boolean isUploadFile()
    {
        return uploadFile;
    }

    /** To check if the user has the viewOwnGrade permission
     * @return true if yes, false if no
     */
    public boolean isViewOwnGrade()
    {
        return viewOwnGrade;
    }

    /** To check if the user has the manageCourse permission
     * @return true if yes, false if no
     */
    public boolean isManageCourse()
    {
        return manageCourse;
    }

    /** To check if the user has the manageMetric permission
     * @return true if yes, false if no
     */
    public boolean isManageMetric()
    {
        return manageMetric;
    }

    /** To check if the user has the manageGrade permission
     * @return true if yes, false if no
     */
    public boolean isManageGrade()
    {
        return manageGrade;
    }

    /** To check if the user has the manageRoster permission
     * @return true if yes, false if no
     */
    public boolean isManageRoster()
    {
        return manageRoster;
    }

    /** To check if the user has the manageAnnouncement permission
     * @return true if yes, false if no
     */
    public boolean isManageAnnouncement()
    {
        return manageAnnouncement;
    }

    /** To check if the user has the manageUser permission
     * @return true if yes, false if no
     */
    public boolean isManageUser()
    {
        return manageUser;
    }

    /**Changes (sets) the sendEmail permission
     * @param desiredChange A boolean value to which sendEmail is to be set to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setSendEmail(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            sendEmail = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET sendEmail ="
                + sendEmail + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the uploadFile permission
     * @param desiredChange A boolean value to which uploadFile is to be set to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setUploadFile(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            uploadFile = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET uploadFile ="
                + uploadFile + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the viewOwnGrade permission
     * @param desiredChange A boolean value to which viewOwnGrade is to be set 
     * to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setViewOwnGrade(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            viewOwnGrade = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET viewOwnGrade ="
                + viewOwnGrade + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the manageCourse permission
     * @param desiredChange A boolean value to which manageCourse is to be set
     * to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setManageCourse(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageCourse = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET manageCourse ="
                + manageCourse + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the manageMetric permission
     * @param desiredChange A boolean value to which manageMetric is to be 
     * set to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setManageMetric(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageMetric = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET manageMetric ="
                + manageMetric + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the manageGrade permission
     * @param desiredChange A boolean value to which manageGrade is to be 
     * set to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setManageGrade(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageGrade = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET manageGrade ="
                + manageGrade + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the manageRoster permission
     * @param desiredChange A boolean value to which manageRoster is to be 
     * set to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setManageRoster(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageRoster = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET manageRoster ="
                + manageRoster + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the manageAnnouncement permission
     * @param desiredChange A boolean value to which manageAnnouncement is to 
     * be set to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setManageAnnouncement(boolean desiredChange,
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageAnnouncement = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */

            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET manageAnnouncement ="
                + manageAnnouncement + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }

    /**Changes (sets) the manageUser permission
     * @param desiredChange A boolean value to which manageUser is to be
     * set to.
     * @param manageUserPermit A value from an Account's isManageUser() to see
     * if the account has permision to change permission. If this method is 
     * called by the system rather than a user, pass in true. 
     * @return true if set is succesful, false if not
     */
    public boolean setManageUser(boolean desiredChange, 
            boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageUser = desiredChange;

        }
        catch (IllegalAccessException accountError)
        {
            /*changeVerify reported insufficient permissions. */
            return false;
        }

        /*now updating the database with changes */
        String query = "UPDATE Permissions SET manageUser ="
                + manageUser + "WHERE accountID = " + accountID;
        StorageConnection conn = new StorageConnection();
        conn.query(query);
        conn.close();

        return true;
    }
}
