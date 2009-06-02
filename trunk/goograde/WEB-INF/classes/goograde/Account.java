package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a class that keeps all of the information of a user. A user is 
 * a synomnym for an Account. This will have lots of get and set methods 
 * that will handle getting and saving Accounts to the Storage system.
 *
 * @author mduder
 * @version 2.42
 */
public class Account implements java.io.Serializable
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
    private String emailAddress;
    /**
     * ID used to find things in database
     */
    private Integer id;

    /**
     * Constructors
     */
    
    /**
     * Default constructor instantiats an empty Account object.
     * 
     * @author mduder
     */
    public Account()
    {
        this.id = null;
        this.userName = new String();
        this.fullName = new String();
        this.emailAddress = new String();
    }
    
    /**
     * Constructor for generating an Account with user input.
     * 
     * @param newUser  the user name an account holder uses to access GooGrade
     * @param newFull      the full name of an account holder
     * @param newEmail     the email address of an account holder
     * @author mduder
     */
    public Account(String newUser, String newFull, String newEmail)
    {
        this.id = null;
        this.userName = newUser;
        this.fullName = newFull;
        this.emailAddress = newEmail;
    }

    /**
     * System constructor which receives an ID and fetches the other info.
     * 
     * @param newID identification Integer used to fetch data from db
     * @throws Exception an invalid id passed in is erroneous
     * @author mduder
     */
    public Account(Integer newID) throws Exception
    {
        this.id = newID;
        boolean validIdent = this.fetch();
        
        /* An invalid ID must throw an error */
        if (!validIdent)
        {
            throw new Exception("Invalid identification");
        }
    }

    /**
     * Standard system constructor where all information is already known.
     * 
     * @param newID        unique identification number for each account
     * @param newUser  the user name an account holder uses to access GooGrade
     * @param newFull      the full name of an account holder
     * @param newEmail     the email address of an account holder
     * @author mduder
     */
    public Account(Integer newID, String newUser, String newFull, String newEmail)
    {
        this.id = newID;
        this.userName = newUser;
        this.fullName = newFull;
        this.emailAddress = newEmail;
    }

    /**
     * Retrieve the account's user name.
     * 
     * @return a string with the user name of the current account
     * @author mduder
     */
    public String getUserName()
    {
        return this.userName;
    }

    /**
     * Retrieve the account's full name.
     * 
     * @return a string with the full name of the current account
     * @author mduder
     */
    public String getFullName()
    {
        return this.fullName;
    }

    /**
     * Retrieve the account's EmailAddress of this account.
     * 
     * @return this user's email address 
     * @author mduder
     */
    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    /**
     * Sets the Account's user name.
     * 
     * @param newUserName the new name to be stored
     * @return true if set, false if error.
     * @author muder
     */
    public boolean setUserName(String newUserName)
    {
        boolean ret = false;
        
        /* Check for unique name before setting */
        if (Account.isUserNameUnique(newUserName))
        {
            this.userName = newUserName;
            ret = true;
        }
        return ret;
    }

    /**
     * Sets the Account's full name.
     * 
     * @param newFullName the new name to be stored
     * @return true if set, false if error.
     * @author mduder
     */
    public boolean setFullName(String newFullName)
    {
        this.fullName = newFullName;
        return true;
    }

    /**
     * Sets the Account's EmailAddress.
     * 
     * @param newAddress the new email address to be stored
     * @return true if set, false if error.
     * @author mduder
     */
    public boolean setEmailAddress(String newAddress)
    {
        this.emailAddress = newAddress;
        return true;
    }

    /**
     * Retrieve the account's id for this account.
     * 
     * @return this account's id
     * @author mduder
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * Sets the Account's id.
     * 
     * @param newID the id used in the db for the account
     * @return true if set, false if error.
     * @author mduder
     */
    public boolean setId(Integer newID)
    {
        this.id = newID;
        return true;
    }

    /**
     * Searches the database table Account according
     * to this.id and sets all instance variables from there
     * 
     * @return true if found in database, else false
     * @author mduder
     */
    public boolean fetch()
    { 
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;
        String query = new String();
        boolean ret = false;
        int index = 0, initial = 0;
        
        /* A present ID requires one type of query */
        if (this.getId() != null)
        {
            query = "SELECT id, username, name, email"
                    + " FROM Accounts WHERE id = " + this.getId().toString();
            result = conn.query(query);
            conn.close();
        }
        /* Otherwise, a present username requires a different query type */
        else if (this.getUserName() != null)
        {
            query = "SELECT id, username, name, email"
                    + " FROM Accounts WHERE username = \"" + this.getUserName() + "\"";
            result = conn.query(query);
            conn.close();
        }
        
        /* No results from the query means an unsuccessful fetch */
        if(result != null && result.size() >= 1)
        {
            try
            {
                ArrayList<Object> rs = result.get(initial);
                this.setId((Integer) rs.get(index++));
                this.setUserName(new String((String) rs.get(index++)));
                this.setFullName((String) rs.get(index++));
                this.setEmailAddress((String) rs.get(index++));
                ret = true;
            }
            catch (Exception ex)
            {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                        "SQL error occurred when trying to fetch Account"
                        + " with id = " + this.getId().toString(), ex);
            }
        }
        return ret;
    }

    /**
     * Resets all variables according to current database information
     * 
     * @return true if successful, else false
     * @author mduder
     */
    public boolean refresh()
    {
        /* Account validity is checked before a fetch */
        return (this.getId() != null) && this.fetch(); 
    }

    /**
     * Stores current instance in database and either updates it if
     * the id already exists, otherwise it inserts
     * 
     * @return true if successfull, else false
     * @author mduder
     */
    public boolean save()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;
        
        /* Update if the id exists */
        if (this.getId() != null)
        {
            String query = "UPDATE Accounts SET "
                    + "username = \"" + this.getUserName() + "\","
                    + "name = \"" + this.getFullName() + "\","
                    + "email = \"" + this.getEmailAddress().toString() + "\","
                    + "WHERE id = \"" + this.getId() + "\"";
            ret = conn.updateQuery(query);
        }
        else
        {
            String query = "INSERT into Accounts (username, name, email)";
            query += " VALUES(\"" + this.getUserName() + "\",\"";
            query += this.getFullName() + "\",\"";
            query += this.getEmailAddress().toString() + "\")";
            ret = conn.updateQuery(query);
        }
        
        conn.close();
        
        return ret;
    }

    /**
     * Standard toString method for displaying a class
     * 
     * @return a concatenated string of the object's variables
     * @author mduder
     */
    @Override
    public String toString()
    {
        String ret = new String();
        ret += this.getId() + ", ";
        ret += this.getUserName() + ", ";
        ret += this.getFullName() + ", ";
        ret += this.getEmailAddress();


        return ret;
    }

    /**
     * Returns an array of all of the accounts.
     * 
     * @return and arraylist of all the accounts.
     * @author mduder
     */
    public static ArrayList<Account> allAccounts()
    {
        ArrayList<Account> ret = new ArrayList<Account>();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();
        int index = 0;

        try
        {
            out = conn.query("select id, username, name, email from accounts");
            /* Each row in the query result creates and populates a new Account obj */
            for (ArrayList<Object> row : out)
            {
                ret.add(new Account((Integer) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++),
                        (String) row.get(index++)));
                index = 0;
            }
            conn.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Account.class.getName())
                    .log(Level.SEVERE, "Error in Account", ex);
        }

        return ret;
    }

    /**
     * Tells whether an accounter is a Teacher or Not.
     * 
     * @return true if account is a Treacher, false if it isn't
     * @author mduder
     */
    public boolean isTeacher()
    {
        boolean ret = false;
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;
        String query = "SELECT id FROM Teachers WHERE id = \""
                + id + "\"";
        
        
        result = conn.query(query);
        conn.close();
        
        /* If there is a result, then this account is Teacher */
        if(result.size() > 0)
        {
            ret = true;
        }
        
        return ret;
    }
    
    /**
     * Tells whether an accounter is a Student or Not.
     * 
     * @return true if account is a Student, false if it isn't
     * @author mduder
     */
    public boolean isStudent()
    {
        boolean ret = false;
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;
        String query = "SELECT id FROM Students WHERE id = \""
                + id + "\"";
        
        
        result = conn.query(query);
        conn.close();
        
        /* If there is a result, then this account is Student */
        if(result.size() > 0)
        {
            ret = true;
        }
        
        return ret;
    }

    /**
     * An account is deleted from the database
     * 
     * @return a boolean representing the success of the delete call
     * @author mduder
     */
    public boolean delete()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;
        
        /* If an ID is present, form one type of query to delete */
        if (this.getId() != null)
        {
            String query = "DELETE from Accounts ";
            query += "WHERE id = " + this.getId();
            ret = conn.updateQuery(query);
        }
        /* Otherwise, if a valid user name is present, use a different query */
        else if (this.getUserName() != null)
        {
            String query = new String("DELETE from Accounts WHERE username = \""
                    + this.getUserName() + "\"");
            ret = conn.updateQuery(query);
        }
        
        return ret;
    }
    
    /**
     * This checks the database to make sure the queried username is unique.
     * 
     * @param userNameIn the name to verify if is unique
     * @return true if unique, false if not.
     * @author nwelch
     */
    public static boolean isUserNameUnique(String userNameIn)
    {
        boolean ret = true;
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;
        String query = "SELECT id FROM Accounts WHERE username = \""
                + userNameIn + "\"";
        
        result = conn.query(query);
        conn.close();
        
        /* No results from the query means the name is unique */
        if(result.size() < 1)
        {
            ret = true;
        }
        
        return ret;
    }
    
    /**
     * Standard issue equals method
     * 
     * @param testAct the Account object to be compared with
     * @return true if equal, false otherwise
     * @author mduder
     */
    public boolean equals(Account testAct)
    {
        boolean ret = true;
        /* Equals implemented via variable string comparison */
        if (!(this.toString().equals(testAct.toString())))
        {
            ret = false;
        }
        return ret;
    }
    
    /**
     * Overriding the equals method
     * 
     * @param in the object to compare to
     * @return a boolean
     * @author mduder
     */
    @Override
    public boolean equals(Object in)
    {
        boolean ret = false;
        
        /*ensuring an operation is not performed on a wrong object */
        if(in instanceof Account)
        {
            ret = this.equals((Account)in);            
        }
        
        return ret;
    }

    /**
     * A hash code generator.
     * 
     * @return a hash of the Object
     * @author nwelch
     */
    @Override
    public int hashCode()
    {
        return this.toString().hashCode();
    }
}

