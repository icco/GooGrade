package goograde;

import goograde.*;
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
     * Test of allTeacherAssistants method, of class TeacherAssistant.
     */
    public void testAllTeacherAssistants()
    {
        System.out.println("allTeacherAssistants");
        ArrayList<TeacherAssistant> expResult = null;
        ArrayList<TeacherAssistant> result = TeacherAssistant.allTeacherAssistants();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCourse method, of class TeacherAssistant.
     */
    public void testEditCourse()
    {
        System.out.println("editCourse");
        Course course = null;
        TeacherAssistant instance = new TeacherAssistant();
        Course expResult = null;
        Course result = instance.editCourse(course);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCourse method, of class TeacherAssistant.
     */
    public void testCreateCourse()
    {
        System.out.println("createCourse");
        TeacherAssistant instance = new TeacherAssistant();
        Course expResult = null;
        Course result = instance.createCourse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCourse method, of class TeacherAssistant.
     */
    public void testRemoveCourse()
    {
        System.out.println("removeCourse");
        Course course = null;
        TeacherAssistant instance = new TeacherAssistant();
        boolean expResult = false;
        boolean result = instance.removeCourse(course);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gradeStudent method, of class TeacherAssistant.
     */
    public void testGradeStudent()
    {
        System.out.println("gradeStudent");
        Student who = null;
        TeacherAssistant instance = new TeacherAssistant();
        boolean expResult = false;
        boolean result = instance.gradeStudent(who);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTeacherAssistant method, of class TeacherAssistant.
     */
    public void testIsTeacherAssistant()
    {
        System.out.println("isTeacherAssistant");
        TeacherAssistant instance = new TeacherAssistant();
        boolean expResult = false;
        boolean result = instance.isTeacherAssistant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
