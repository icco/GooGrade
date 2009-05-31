package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class AStudentTest extends TestCase {
    
    public AStudentTest(String testName) {
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
        Student testStu = null;
        try
        {
            testStu = new Student(3);
        }
        catch (Exception ex)
        {
            fail("invalid student ID");
        }
        Assignment testAssign = new Assignment(7);
        Course testCourse = new Course(5);
        Float result = testStu.getGrade(testCourse, testAssign);
        Float expResult = new Float(17.0);
        assertEquals(expResult, result);
    } 


    /**
     * Test of getEnrolled method, of class Student.
     */
    public void testGetEnrolled()
    {
        System.out.println("getEnrolled");
        Student vgerdin = null;
        try
        {
            vgerdin = new Student(3);
        }
        catch (Exception ex)
        {
            fail("invalid student id of 3:" + ex);
        }
        ArrayList<Course> courseListResult = vgerdin.getEnrolled();
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> queryResult = conn.query("SELECT COUNT(*) "
                + "FROM enrolled WHERE student = 3");
        conn.close();
        ArrayList<Object> resultSet = queryResult.get(0);
        Integer expResult = new Integer((Integer)resultSet.get(0));
        Integer testResult = new Integer(courseListResult.size());
        assertEquals(expResult, testResult);
    }

    /**
     * Test of setEnrolled method, of class Student.
     */
    public void testSetEnrolled()
    {
        System.out.println("setEnrolled");
        ArrayList<Course> enrolled = new ArrayList<Course>();
        Student testStudent = null;
        try
        {
            testStudent = new Student(4);
        }
        catch (Exception ex)
        {
            fail("Invalid student Id of 4: " + ex);
        }
        boolean testResult = testStudent.setEnrolled(enrolled);
        boolean expResult = true;
        assertEquals(testResult, expResult);
    }

    /**
     * Test if getCurrentGrade, of class Student
     */
    
    public void testGetCurrentGrade()
    {
        System.out.println("getCurrentGrade");
        Integer result = null;
        Integer expResult = 3;
        try
        {
            //Test 1, no assignments in course
            Student student = new Student(expResult);
            result = student.getId();
            
            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Bad Test Data");
        }
    }
}
