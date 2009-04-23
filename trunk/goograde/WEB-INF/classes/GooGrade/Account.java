package GooGrade;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;

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
    private String jdbcConnectionString;
    private String jdbcDriver;
    private Connection conn;

    /**
     * standard constructor, should never be used
     */
    public Account (){
    }
    
    /**
     * Minimal constructor for db connection
     * @param jdbcDriver driver to db
     * @param jdbcConnectionString path to db
     */
    public Account (String jdbcDriver, String jdbcConnectionString){
        this.setJdbcDriver("jdbcDriver");
        this.setJdbcConnectionString("jdbcConnectionString");
    }
    
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
     * gets the db connection string for this instance.
     * @return this instances connection string
     */
    public String getJdbcConnectionString()
    {
        return jdbcConnectionString;
    }

    public void setJdbcConnectionString(String jdbcConnectionString)
    {
        this.jdbcConnectionString = jdbcConnectionString;
    }
    /**
     * gets the db connection holder for this instance.
     * @return this instances connection holder
     */
    public Connection getConn()
    {
        return conn;
    }

    /**
     * sets the db connection holder for this instance
     * @param conn the db connection holder for this instance
     * @return true if set, false if error.
     */
    public boolean setConn(Connection conn)
    {
        this.conn = conn;
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
     * gets the db connection driver string for this instance.
     * @return this instances connection driver string
     */
    public String getJdbcDriver()
    {
        return jdbcDriver;
    }

    /**
     * sets the jdbcDriver for this instance
     * @param jdbcDringer the db driver string for this instance
     * @return true if set, false if error.
     */
    public boolean setJdbcDriver(String jdbcDriver)
    {
        this.jdbcDriver = jdbcDriver;
        return true;
    }
}

