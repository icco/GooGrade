package GooGradeTest;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

//So we can actually test everything...
import GooGrade.*;

/**
 *
 * @author nwelch
 */
public class StorageConnectionTest {

    public StorageConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of query method, of class StorageConnection.
     */
    @Test
    public void testQuery()
    {
        System.out.println("query");
        String in = "select * from Courses";
        StorageConnection instance = new StorageConnection();
        ArrayList<ArrayList<Object>> expResult = null;
        ArrayList<ArrayList<Object>> result = instance.query(in);
        assertEquals(expResult, result);
        /// @TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class StorageConnection.
     */
    @Test
    public void testClose()
    {
        System.out.println("close");
        StorageConnection instance = new StorageConnection();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConn method, of class StorageConnection.
     */
    @Test
    public void testGetConn()
    {
        System.out.println("getConn");
        StorageConnection instance = new StorageConnection();
        Connection expResult = null;
        Connection result = instance.getConn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}