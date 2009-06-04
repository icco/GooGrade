package goograde;

import javax.servlet.http.HttpServletRequest;
import junit.framework.TestCase;

/**
 *
 * @author nwelch
 */
public class UtilsTest extends TestCase {
    
    public UtilsTest(String testName) {
        super(testName);
    }            

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getUseridCookie method, of class Utils.
     */
    public void testGetUseridCookie()
    {
        System.out.println("getUseridCookie");
        HttpServletRequest req = null;
        Account expResult = new Account();
        Account result = Utils.getUseridCookie(req);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHTML method, of class Utils.
     */
    public void testGetHTML()
    {
        System.out.println("getHTML");
        String markdown = "# Test";
        String expResult = new String("<h1>Test</h1>");
        String result = Utils.getHTML(markdown);
        assertEquals(expResult, result);
    }

}
