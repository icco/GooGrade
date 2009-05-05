/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goograde;

import java.util.Date;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class FileTest extends TestCase {
    
    public FileTest(String testName) {
        super(testName);
    }

    /**
     * Test of getOwner method, of class File.
     */
    public void testGetOwner()
    {
        System.out.println("getOwner");
        File instance = new File(null, "tehOwner", "tehFileName");
        String expResult = "tehOwner";
        String result = instance.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCreationDate method, of class File.
     */
    public void testGetCreationDate()
    {
        System.out.println("getCreationDate");
        File instance = new File(null, "tehOwner", "tehFileName");
        Date expResult = null;
        Date result = instance.getCreationDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileName method, of class File.
     */
    public void testGetFileName()
    {
        System.out.println("getFileName");
        File instance = new File(null, "tehOwner", "tehFileName");
        String expResult = "tehFileName";
        String result = instance.getFileName();
        assertEquals(expResult, result);
    }

}
