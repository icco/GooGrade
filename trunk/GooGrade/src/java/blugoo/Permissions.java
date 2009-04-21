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
    /** Permission for managing announcements */
    private boolean manageAnnouncement;
    /** Permission for managing Users */
    private boolean manageUser;

    /** Constructor for Permissions class
     */
    public Permissions()
    {
    }

    private boolean changeVerify(boolean manageUserPermit)
    {
        if (!manageUserPermit)
        {
            //throw error
            return true;
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
    public boolean isManageAccouncement()
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
        return false;
    }

    /**Changes (sets) the uploadFile permission
     * @param pUploadFile A boolean value to which uploadFile is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setUploadFile(boolean pUploadFile, boolean manageUserPermit)
    {
        return false;
    }

    /**Changes (sets) the viewOwnGrade permission
     * @param pViewOwnGrade A boolean value to which viewOwnGrade is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setViewOwnGrade(boolean pViewOwnGrade, boolean manageUserPermit)
    {
        return false;
    }

    /**Changes (sets) the manageCourse permission
     * @param pManageCourse A boolean value to which manageCourse is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageCourse(boolean pManageCourse, boolean manageUserPermit)
    {
        return false;
    }

    /**Changes (sets) the manageMetric permission
     * @param pManageMetric A boolean value to which manageMetric is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageMetric(boolean pManageMetric, boolean manageUserPermit)
    {
        return false;
    }

    /**Changes (sets) the manageGrade permission
     * @param pManageGrade A boolean value to which manageGrade is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageGrade(boolean pManageGrade, boolean manageUserPermit)
    {
        return false;
    }

    /**Changes (sets) the manageRoster permission
     * @param pManageRoster A boolean value to which manageRoster is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageRoster(boolean pManageRoster, boolean manageUserPermit)
    {
        return false;
    }

    /**Changes (sets) the manageAnnouncement permission
     * @param pManageAnnouncement A boolean value to which manageAnnouncement is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageAnnouncement(boolean pManageAnnouncement, boolean manageUserPermit)
    {
        return false;
    }

    /**Changes (sets) the manageUser permission
     * @param pManageUser A boolean value to which manageUser is set to.
     * @return true if set is succesful, false if not
     */
    public boolean setManageUser(boolean pManageUser, boolean manageUserPermit)
    {
        return false;
    }
}