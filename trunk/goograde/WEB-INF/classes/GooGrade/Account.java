package GooGrade;

import java.util.ArrayList;


/**
 * This is a class that keeps all of the information of a user. A user is 
 * a synomnym for an Account. This will have lots of get and set methods 
 * that will handle getting and saving Accounts to the Storage system.
 *
 * @author bluGoo
 * @version 0.42
 */
public abstract class Account implements java.io.Serializable
{

    /**
     * Username for logging in
     */
    private String userName;
    /**
     * Full name of the Account owner
     */
    private String fullName;
    /**
     * Email address of the Account owner
     */
    private EmailAddress emailAddress;
    /**
     * Password for logging in. This will not be 
     * stored in plain text due to privacy concerns. 
     */
    private Password password;
    /**
     * Permissions for performing actions
     */
    private Permissions permission;
    /**
     * Files owned by account
     */
    private ArrayList<File> files;
    /**
     * ID used to find things in database
     */
    private Integer id;

    
    /**
     * Constructors
     */
    
    /**
     * Standard constructor, should not be used, kept for now
     */
    public Account()
    {
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     */
    public Account(Integer id)
    {
        this.id = id;
    }
    
    
    /**
     * Commonly used constructor. I should just be able to do this with an id tho.
     * @param id
     * @param username
     * @param name
     * @param email
     */
    public Account(Integer id, String username, String name, String email)
    {
        
    }
    // Begin the Functions!
    /**
     * get the accounts user name.
     * @return a string with the user name of the current account
     */
    String getUserName()
    {
        return this.userName;
    }

    /**
     * get the accounts full name.
     * @return a string with the full name of the current account
     */
    String getFullName()
    {
        return this.fullName;
    }

    /**
     * gets the EmailAddress of this account.
     * @return this user's email address 
     */
    public EmailAddress getEmailAddress()
    {
        return this.emailAddress;
    }

    /**
     * Takes new password, hashes it, and saves to database.
     * @param newPass the new password to be saved
     * @return true if set, false if failure.
     * @TODO Passwords are not implemented for release 1.
     */
    boolean setPassword(String newPass)
    {
        return false;
    }

    /**
     * set the Account's user name.
     * @param newUserName the new name to be stored
     * @return true if set, false if error.
     */
    boolean setUserName(String newUserName)
    {
        this.userName = newUserName;
        return true;
    }

    /**
     * set the Account's full name.
     * @param newFullName the new name to be stored
     * @return true if set, false if error.
     */
    boolean setFullName(String newFullName)
    {
        this.fullName = newFullName;
        return true;
    }

    /**
     * sets the EmailAddress of this Account.
     * @param newAddress the new email address to be stored
     * @return true if set, false if error.
     */
    boolean setEmailAddress(EmailAddress newAddress)
    {
        this.emailAddress = newAddress;
        return true;
    }

    /**
     * Checks the provided password to see if they match.
     * @param passwd the password entered by the user that will be compared with the stored value. 
     * @return true if the hashed passwd matches the password in the database, false otherwise. 
     */
    boolean isPassword(String passwd)
    {
        return false;
    }

    /**
     * gets the list of files submitted by this account.
     * @return this user's files 
     */
    public ArrayList<File> getFiles()
    {
        return files;
    }

    /**
     * sets the list of files for this account
     * @param files a list of files owned by this account
     * @return true if set, false if error.
     */
    public boolean setFiles(ArrayList<File> files)
    {
        this.files = files;
        return true;
    }

    /**
     * gets the id for this account.
     * @return this account's id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * sets the id for this instance
     * @param id the id used in the db for the account
     * @return true if set, false if error.
     */
    public boolean setId(Integer id)
    {
        this.id = id;
        return true;
    }
    
    /**
     * Searches the database table Accounts according
     * to this.id and sets all instance variables from there
     * @return true if found in database, else false
     * @todo improve StorageConnection.query return handling
     * @todo write it
     */
    public boolean fetch()
    {
        return false;
    }
}

