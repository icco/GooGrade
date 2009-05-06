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
     * 
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

        String query = "INSERT INTO Permissions (manageUser, manageAnnouncement,"
                +"manageRoster, manageGrade, manageMetric, manageCourse, " 
                + "uploadFile, sendEmail, viewOwnGrade) "
                + "VALUES(\"" 
                 + manageUser + "\", \""+ manageAnnouncement + "\", \"" 
                 + manageRoster +"\", \"" + manageGrade + "\", \"" 
                 + manageMetric +"\", \"" + manageCourse + "\", \"" + uploadFile 
                 +"\", \"" + sendEmail +"\", \"" + viewOwnGrade +"\")";
        StorageConnection conn = new StorageConnection();
        conn.updateQuery(query);
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
            viewOwnGrade = false;
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
                + "sendEmail, viewOwnGrade FROM Permissions WHERE accountID ="
                + id;
        StorageConnection conn = new StorageConnection();
        ArrayList<Object> result =  conn.query(query).get(0);
        conn.close();

        int indx = 0;    
        /*set variables from results from the database.  */
        //i dont know how to get the items out of the array
        manageUser = (Boolean) result.get(indx++);
        manageAnnouncement = (Boolean) result.get(indx++);
        manageRoster = (Boolean) result.get(indx++);
        manageGrade = (Boolean) result.get(indx++);
        manageMetric = (Boolean) result.get(indx++);
        manageCourse = (Boolean) result.get(indx++);
        uploadFile = (Boolean) result.get(indx++);
        sendEmail = (Boolean) result.get(indx++);
        viewOwnGrade = (Boolean) result.get(indx++);
    

    }
    
    //public Permissions(Account)

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

        return true;
    }
    
    private Integer getId()
    {
        return accountID;
    }
    
    private boolean setId(Integer newId)
    {
        accountID = newId;
        return true;
    }
    
    /**
     * save, stores current instance in database
     * if id already exists, update
     * else, insert
     * @return true if successfull, else false
     */
    public boolean save()
    {
        boolean ret = false;
        /*if id is null we a creating a new course*/
        if (this.getId() == null)
        {
            ret = this.saveWithoutId();
        }
        /*if we have an id set, we are updating*/
        else
        {
            ret = this.saveWithId();
        }
        return ret;
    }

    /**
     * save method if we don't have id set
     * @return true if no error
     */
    private boolean saveWithoutId()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;

        String query = "INSERT INTO Permissions (manageUser, manageAnnouncement,"
                + "manageRoster, manageGrade, manageMetric, manageCourse,"
                + "uploadFile, sendEmail, viewOwnGrade)";
        query += "VALUES (\"" + this.isManageUser() + "\",\""
                + this.isManageAnnouncement() + "\",\""
                + this.isManageRoster() + "\",\""
                + this.isManageGrade() + "\",\""
                + this.isManageMetric() + "\",\""
                + this.isManageCourse() + "\",\""
                + this.isUploadFile() + "\",\""
                + this.isSendEmail() + "\",\""
                + this.isViewOwnGrade() + "\")";
        ret = conn.updateQuery(query);
        /*if we failed to update, discontinue*/
        if (!(ret))
        {
            return ret;
        }
        query = "SELECT max(accountID) FROM Permissions";
        ArrayList<ArrayList<Object>> result = conn.query(query);
        conn.close();
        /*if result is empty so is Courses*/
        if (result.isEmpty())
        {
            return false;
        }
        ret = this.setId((Integer) result.get(0).get(0));
        return ret;
    }

    /**
     * save method if we have id set
     * @return true if no error
     */
    private boolean saveWithId()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;

        String query = "SELECT id FROM Permissions WHERE id = " + this.getId();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        /*if for some reason id does not exist in db we insert*/
        if (result.isEmpty())
        {
            query = "INSERT INTO Permissions (manageUser, manageAnnouncement,"
                + "manageRoster, manageGrade, manageMetric, manageCourse,"
                + "uploadFile, sendEmail, viewOwnGrade)";
            query += "VALUES (\"" + this.isManageUser() + "\",\""
                + this.isManageAnnouncement() + "\",\""
                + this.isManageRoster() + "\",\""
                + this.isManageGrade() + "\",\""
                + this.isManageMetric() + "\",\""
                + this.isManageCourse() + "\",\""
                + this.isUploadFile() + "\",\""
                + this.isSendEmail() + "\",\""
                + this.isViewOwnGrade() + "\")";

            ret = conn.updateQuery(query);
        }
        /*if id does exist we update*/
        else
        {
            query = "UPDATE Permissions";
            query += "SET \"" 
                + "manageUser = "+ this.isManageUser() + "\",\""
                + "manageAnnouncement = "+ this.isManageAnnouncement() + "\",\""
                + "manageRoster = " + this.isManageRoster() + "\",\""
                + "manageGrade = "+ this.isManageGrade() + "\",\""
                + "manageMetric = " + this.isManageMetric() + "\",\""
                + "manageCourse = " + this.isManageCourse() + "\",\""
                + "uploadFile = "+ this.isUploadFile() + "\",\""
                + "sendEmail = "+ this.isSendEmail() + "\",\""
                + "viewOwnGrade" + this.isViewOwnGrade() + "\",\"";

            ret = conn.updateQuery(query);
        }
        conn.close();
        return ret;
    }
}
