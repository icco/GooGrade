package goograde;

import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class EmailAddressTest extends TestCase {
    
    public EmailAddressTest(String testName) {
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
     * Test of valid method, of class EmailAddress.
     */
    /* public void testValid()
    {
        System.out.println("valid");
        String in = "";
        EmailAddress instance = null;
        boolean expResult = false;
        boolean result = instance.valid(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of toString method, of class EmailAddress.
     */
    public void testToString()
    {
        System.out.println("toString");
        EmailAddress instance = new EmailAddress("mahAddy");
        String expResult = "mahAddy";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
