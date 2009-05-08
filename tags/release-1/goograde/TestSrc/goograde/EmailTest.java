package goograde;

import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class EmailTest extends TestCase {
    
    public EmailTest(String testName) {
        super(testName);
    }

    /**
     * Test of getEmailTitle method, of class Email.
     */
    public void testGetEmailTitle()
    {
        System.out.println("getEmailTitle");
        Email instance = new Email("Title", null, null, "Body");
        String expResult = "Title";
        String result = instance.getEmailTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailBody method, of class Email.
     */
    public void testGetEmailBody()
    {
        System.out.println("getEmailBody");
        Email instance = new Email("Title", null, null, "Body");
        String expResult = "Body";
        String result = instance.getEmailBody();
        assertEquals(expResult, result);
    }

}
