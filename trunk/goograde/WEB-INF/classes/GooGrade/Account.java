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
     * @param newID identification Integer used to fetch data from db
     */
    public Account(Integer newID)
    {
        this.id = newID;
    }
    
    
    /**
     * Commonly used constructor. I should just be able to do this with an id tho.
     * @param newID        unique identification number for each account
     * @param newUser  the user name an account holder uses to access GooGrade
     * @param newFull      the full name of an account holder
     * @param newEmail     the email address of an account holder
     */
    public Account(Integer newID, String newUser, String newFull, String newEmail)
    {
        this.id = newID;
        this.userName = newUser;
        this.fullName = newFull;
        this.emailAddress = new EmailAddress(newEmail);
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
     * @todo Passwords are not implemented for release 1.
     */
    boolean setPassword(String newPass)
    {
        return true;
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
     * @param passwd the password entered by the user. 
     * @return true if the hashed passwd matches the password in the database,
     *         false otherwise. 
     */
    boolean isPassword(String passwd)
    {
        return false;
    }

    /**
     * gets the list of files submitted by this account.
     * @return this user's files 
     * @todo NOT IMPLEMENTING FOR RELEASE 1
     */
    public ArrayList<File> getFiles()
    {
        return files;
    }

    /**
     * sets the list of files for this account
     * @param newFiles a list of files owned by this account
     * @return true if set, false if error.
     * @todo NOT IMPLEMENTING FOR RELEASE 1
     */
    public boolean setFiles(ArrayList<File> newFiles)
    {
        this.files = newFiles;
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
     * @param newID the id used in the db for the account
     * @return true if set, false if error.
     */
    public boolean setId(Integer newID)
    {
        this.id = newID;
        return true;
    }
    
    /**
     * returns the permission for an account
     * @return the permission
     */
    public Permissions getPermissions()
    {
        return this.permission;
    }
    
    /**
     * Searches the database table Account according
     * to this.id and sets all instance variables from there
     * @return true if found in database, else false
     */
    public boolean fetch()
    { /*
        String query = "SELECT username, name, email, password"
                + " FROM Account WHERE id = " + this.getId().toString();
        StorageConnection conn = new StorageConnection();
        ArrayList<Array> result = conn.query(query);
        conn.close();
        
        /* No results from the query means an unsuccessful fetch *
        if(result.size() < 1)
        {
            return false;
        }
        try
        {
            ResultSet rs = result.get(0).getResultSet();
            this.setUserName(rs.getString("username"));
            this.setFullName(rs.getString("name"));
            this.setEmailAddress(new EmailAddress(rs.getString("email")));
            this.setPassword(rs.getString("password"));
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, 
                    "SQL error occurred when trying to fetch Account"
                    + "with id = " + this.getId().toString(), ex);
        } */
        return true;
    }
    
    /**
     * Resets all variables according to current database information
     * @return true if successful, else false
     */
    public boolean refresh()
    {
        /* Account validity is checked before a fetch */
        if(this.getId() != null)
        {
            return this.fetch();
        }
        return false;
    }
    
    /**
     * save, stores current instance in database
     * if id already exists, update
     * else, insert
     * @return true if successfull, else false
     * @todo implement the functionality requried for this
     */
    public boolean save()
    {
        return true;
    }
    
    public String toString()
    {
        String ret = new String();
        ret += this.getUserName() + ", ";
        ret += this.getFullName();

        return ret;
    }
}

