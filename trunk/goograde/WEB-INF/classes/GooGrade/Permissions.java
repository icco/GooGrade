package GooGrade;

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
    /** Permission for managing announcements */
    private boolean manageAnnouncement;
    /** Permission for managing Users */
    private boolean manageUser;

    /** Constructor for Permissions class
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
    }

    public Permissions(boolean isStudent, boolean isTeacher) throws Exception
    {
        this();
        if (isStudent && isTeacher)
        {
            throw new Exception("Account cannot be Student and Teacher");
        }
        if (isStudent)
        {
            viewOwnGrade = true;
            uploadFile = true;
        }
        else if (isTeacher)
        {
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

    private boolean changeVerify(boolean manageUserPermit) throws
            IllegalAccessException
    {
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
     * @param pSendEmail A boolean value to which sendEmail is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setSendEmail(boolean pSendEmail, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            sendEmail = !sendEmail;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the uploadFile permission
     * @param pUploadFile A boolean value to which uploadFile is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setUploadFile(boolean pUploadFile, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            uploadFile = !uploadFile;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the viewOwnGrade permission
     * @param pViewOwnGrade A boolean value to which viewOwnGrade is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setViewOwnGrade(boolean pViewOwnGrade, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            viewOwnGrade = !viewOwnGrade;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the manageCourse permission
     * @param pManageCourse A boolean value to which manageCourse is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageCourse(boolean pManageCourse, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageCourse = !manageCourse;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the manageMetric permission
     * @param pManageMetric A boolean value to which manageMetric is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageMetric(boolean pManageMetric, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageMetric = !manageMetric;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the manageGrade permission
     * @param pManageGrade A boolean value to which manageGrade is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageGrade(boolean pManageGrade, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageGrade = !manageGrade;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the manageRoster permission
     * @param pManageRoster A boolean value to which manageRoster is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageRoster(boolean pManageRoster, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageRoster = !manageRoster;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the manageAnnouncement permission
     * @param pManageAnnouncement A boolean value to which manageAnnouncement is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageAnnouncement(boolean pManageAnnouncement, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageAnnouncement = !manageAnnouncement;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }

    /**Changes (sets) the manageUser permission
     * @param pManageUser A boolean value to which manageUser is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageUser(boolean pManageUser, boolean manageUserPermit)
    {
        try
        {
            changeVerify(manageUserPermit);
            manageUser = !manageUser;

        }
        catch (IllegalAccessException accountError)
        {
            return false;
        }
        return true;
    }
}