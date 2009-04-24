package GooGrade;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String whereIsDb = "jdbc:sqlite://home/vgerdin/blugoo.db";
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
    public ArrayList<Array> query(String in)
    {
        Statement stat;
        ArrayList<Array> ret = null;
        try
        {
            stat = this.conn.createStatement();
            ResultSet rs = stat.executeQuery(in);

            for (int idx = 0; rs.next(); idx++)
            {
                ret.add(rs.getArray(idx));
            }

            rs.close();
            stat.close();

        }
        catch (SQLException ex)
        {
            // TODO: Don't really know what this does...
            Logger.getLogger(StorageConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
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
            Logger.getLogger(StorageConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConn()
    {
        return this.conn;
    }
}
