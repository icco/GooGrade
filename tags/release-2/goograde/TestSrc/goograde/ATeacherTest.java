package goograde;

import java.util.ArrayList;
import junit.framework.TestCase;

public class ATeacherTest extends TestCase {
    
    public ATeacherTest(String testName) {
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
    
    public void testAllTeachers()
    {
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();
        int result = Teacher.allTeachers().size();
        int expResult = 0;
        
        System.out.println("allTeachers");
        out = conn.query("SELECT * FROM teachers");
        conn.close();
        expResult = out.size();
        assertEquals(result, expResult);
    }
    
    /**
     * Test of method getCourses in class Teacher
     */
    public void testGetCourses()
    {
        System.out.println("getCourses");
        Teacher testTeacher = null;
        try
        {
            testTeacher = new Teacher(1);
        }
        catch (Exception ex)
        {
            fail("Invalid id" + ex);
        }
        ArrayList<Course> testCourseList = testTeacher.getCourses();
        String query = new String("SELECT COUNT(*) FROM teaches WHERE teacher = 1");
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> queryResult = conn.query(query);
        conn.close();
        Integer result = testCourseList.size();
        ArrayList<Object> resultSet = queryResult.get(0);
        Integer expResult = new Integer((Integer) resultSet.get(0));
        assertEquals(result, expResult);
    }

    /**
     * Test of isTeacher method, of class Teacher.
     */
    public void testIsTeacher()
    {
        System.out.println("isTeacher");
        Teacher instance = new Teacher();
        boolean expResult = true;
        boolean result = instance.isTeacher();
        assertEquals(expResult, result);
    }

}
