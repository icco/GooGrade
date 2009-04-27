package GooGrade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.BasicRowProcessor;

/**
 * Alright this is how you do Database connections. If you 
 * want to run updates on the database, I suggest you deal 
 * with that yourself. This just kinda works with other stuff.
 * 
 * @author nwelch
 */
public class StorageConnection
{

    /** Where is the database held? */
    private String whereIsDb = "jdbc:sqlite://tmp/goograde.db";
    /** What Driver are we using for a storage connection? */
    private String whatIsDb = "org.sqlite.JDBC";
    /** Where the connection is held */
    private Connection conn;

    /**
     * Create one of these to do querys to the database.
     */
    public StorageConnection()
    {
        try
        {
            Class.forName(whatIsDb).newInstance();
            this.conn = DriverManager.getConnection(whereIsDb);
            this.conn.setAutoCommit(true);
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }

    /**
     * Run a select query in the database.
     * 
     * @param in Query to be run.
     * @return results of the query.
     */
    public ArrayList<ArrayList<Object>> query(String in)
    {
        Statement stat;
        BasicRowProcessor rowProc = new BasicRowProcessor();
        ArrayList<ArrayList<Object>> ret = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> toAdd = null;
        
        try
        {
           
            stat = this.conn.createStatement();
            ResultSet rs = stat.executeQuery(in);
                        
            for (int idx = 0; rs.next(); idx++)
            {
                toAdd = new ArrayList<Object>(Arrays.asList(rowProc.toArray(rs)));
                ret.add(toAdd);
            }

            rs.close();
            stat.close();

        }
        catch (SQLException ex)
        {
            Logger.getLogger(StorageConnection.class.getName()).log(Level.SEVERE,
                    "An Error has occured while running a query. " + 
                    "If you see this error, tell nwelch.",
                    ex);
        }
        finally
        {
            Logger.getLogger(StorageConnection.class.getName()).log(Level.WARNING,
                    "Query Returned: " + ret.toString());
        }
           
        return ret;
    }
    
    /**
     * This is the method you use to update the database. 
     * @param in A query string containing an insert, update, or delete statement.
     * @return A boolean specifying if the database was able to execute the statement.
     */
    public boolean updateQuery(String in)
    {
        return false;
    }
    
    public void close()
    {
        try
        {
            this.getConn().close();
        }
        catch (SQLException ex)
        {
            // TODO: Don't really know what this does...
            Logger.getLogger(StorageConnection.class.getName()).log(Level.SEVERE, 
                    "An Error has occured while closing the connection. " +
                    "If you see this error, tell nwelch.", 
                    ex);
        }
    }

    public Connection getConn()
    {
        return this.conn;
    }
}
