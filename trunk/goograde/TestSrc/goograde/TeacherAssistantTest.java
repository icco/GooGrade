package goograde;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class TeacherAssistantTest extends TestCase {
    
    public TeacherAssistantTest(String testName) {
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
     * Test of method equals with class TeacherAssistant
     */
    public void testEquals()
    {
        try
        {
            TeacherAssistant ta1 = new TeacherAssistant(2);
            TeacherAssistant ta2 = new TeacherAssistant(4);
            boolean result1 = ta1.equals(ta1);
            boolean result2 = ta2.equals(ta1);
            assertEquals(true, result1);
            assertEquals(false, result2);
        }
        catch (Exception ex)
        {
            System.out.println("Invalid id found in test case testEquals" + ex);
        }
    }

    /**
     * Test of allTeacherAssistants method, of class TeacherAssistant.
     */
    public void testAllTeacherAssistants()
    {
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();
        int result = TeacherAssistant.allTeacherAssistants().size();
        int expResult = 0;
        
        System.out.println("allTeacherAssistants");
        out = conn.query("SELECT * FROM tas");
        conn.close();
        expResult = out.size();
        assertEquals(result, expResult);
    }

    /**
     * Test of isTeacherAssistant method, of class TeacherAssistant.
     */
    public void testIsTeacherAssistant()
    {
        System.out.println("isTeacherAssistant");
        TeacherAssistant instance = new TeacherAssistant();
        boolean expResult = true;
        boolean result = instance.isTeacherAssistant();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of method getCourses in class TeacherAssistant
     */
    public void testGetCourses()
    {
        System.out.println("getCourses");
        TeacherAssistant testTA = null;
        try
        {
            testTA = new TeacherAssistant(2);
        }
        catch (Exception ex)
        {
            fail("Invalid id" + ex);
        }
        ArrayList<Course> testCourseList = testTA.getCourses();
        String query = new String("SELECT COUNT(*) FROM assists WHERE ta = 2");
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> queryResult = conn.query(query);
        conn.close();
        Integer result = testCourseList.size();
        ArrayList<Object> resultSet = queryResult.get(0);
        Integer expResult = new Integer((Integer) resultSet.get(0));
        assertEquals(result, expResult);
    }

}
