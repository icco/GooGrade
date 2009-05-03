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
     * Test of gradeStudent method, of class TeacherAssistant.
     */
    public void testGradeStudent()
    {
        System.out.println("gradeStudent");
        Student who = new Student();
        TeacherAssistant instance = new TeacherAssistant();
        boolean expResult = false;
        boolean result = instance.gradeStudent(who);
        assertEquals(expResult, result);
    }

    /**
     * Test of createAssignment method, of class TeacherAssistant.
     */
    public void testCreateAssignment()
    {
        System.out.println("createAssignment");
        TeacherAssistant instance = new TeacherAssistant();
        Assignment expResult = null;
        Assignment result = instance.createAssignment();
        assertEquals(expResult, result);
    }

    /**
     * Test of editAssignment method, of class TeacherAssistant.
     */
    public void testEditAssignment()
    {
        System.out.println("editAssignment");
        TeacherAssistant instance = new TeacherAssistant();
        Assignment expResult = null;
        Assignment result = instance.editAssignment();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteAssignment method, of class TeacherAssistant.
     */
    public void testDeleteAssignment()
    {
        System.out.println("deleteAssignment");
        TeacherAssistant instance = new TeacherAssistant();
        Assignment expResult = null;
        Assignment result = instance.deleteAssignment();
        assertEquals(expResult, result);
    }

    /**
     * Test of adjustCurve method, of class TeacherAssistant.
     */
    public void testAdjustCurve()
    {
        System.out.println("adjustCurve");
        TeacherAssistant instance = new TeacherAssistant();
        GradingRules expResult = null;
        GradingRules result = instance.adjustCurve();
        assertEquals(expResult, result);
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

}
