package GooGradeTest;

import goograde.*;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class StudentTest extends TestCase {
    
    public StudentTest(String testName) {
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
     * Test of getGrade method, of class Student.
     */
    public void testGetGrade()
    {
        System.out.println("getGrade");
        assertEquals(null, null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } 


    /**
     * Test of getEnrolled method, of class Student.
     */
    public void testGetEnrolled()
    {
        System.out.println("getEnrolled");
        Student instance = new Student();
        ArrayList<Course> expResult = null;
        ArrayList<Course> result = instance.getEnrolled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnrolled method, of class Student.
     */
    public void testSetEnrolled()
    {
        System.out.println("setEnrolled");
        ArrayList<Course> enrolled = null;
        Student instance = new Student();
        instance.setEnrolled(enrolled);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
