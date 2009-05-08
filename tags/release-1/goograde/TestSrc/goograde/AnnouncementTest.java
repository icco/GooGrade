package goograde;

import java.util.Date;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class AnnouncementTest extends TestCase {
    
    public AnnouncementTest(String testName) {
        super(testName);
    }

    /**
     * Test of getBody method, of class Announcement.
     */
    public void testGetBody()
    {
        System.out.println("getBody");
        Announcement instance = new Announcement();
        String expResult = new String("Announcement!");
        String result = instance.getBody();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Announcement.
     */
    public void testGetDate()
    {
        System.out.println("getDate");
        Announcement instance = new Announcement();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Announcement.
     */
    public void testGetTitle()
    {
        System.out.println("getTitle");
        Announcement instance = new Announcement();
        String expResult = new String("Title!");
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBody method, of class Announcement.
     */
    public void testSetBody()
    {
        System.out.println("setBody");
        Announcement instance = new Announcement();
        boolean expResult = true;
        boolean result = instance.setBody("gnuBody");
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class Announcement.
     */
    public void testSetDate()
    {
        System.out.println("setDate");
        Announcement instance = new Announcement();
        boolean expResult = false;
        boolean result = instance.setDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Announcement.
     */
    public void testSetTitle()
    {
        System.out.println("setTitle");
        Announcement instance = new Announcement();
        boolean expResult = true;
        boolean result = instance.setTitle("gnuTitle");
        assertEquals(expResult, result);
    }

}
