package GooGradeTest;

import goograde.*;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class TeacherTest extends TestCase {
    
    public TeacherTest(String testName) {
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
     * Test of allTeachers method, of class Teacher.
     */
    public void testAllTeachers()
    {
        System.out.println("allTeachers");
        ArrayList<Teacher> expResult = null;
        ArrayList<Teacher> result = Teacher.allTeachers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourses method, of class Teacher.
     */
    public void testGetCourses()
    {
        System.out.println("getCourses");
        Teacher instance = new Teacher();
        ArrayList<Course> expResult = null;
        ArrayList<Course> result = instance.getCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCourse method, of class Teacher.
     */
    public void testCreateCourse()
    {
        System.out.println("createCourse");
        Teacher instance = new Teacher();
        Course expResult = null;
        Course result = instance.createCourse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCourse method, of class Teacher.
     */
    public void testEditCourse()
    {
        System.out.println("editCourse");
        Course course = null;
        Teacher instance = new Teacher();
        Course expResult = null;
        Course result = instance.editCourse(course);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCourse method, of class Teacher.
     */
    public void testRemoveCourse()
    {
        System.out.println("removeCourse");
        Course course = null;
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.removeCourse(course);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAnnouncement method, of class Teacher.
     */
    public void testCreateAnnouncement()
    {
        System.out.println("createAnnouncement");
        Course which = null;
        Teacher instance = new Teacher();
        Announcement expResult = null;
        Announcement result = instance.createAnnouncement(which);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gradeStudent method, of class Teacher.
     */
    public void testGradeStudent()
    {
        System.out.println("gradeStudent");
        Student who = null;
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.gradeStudent(who);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class Teacher.
     */
    public void testCreateUser()
    {
        System.out.println("createUser");
        Teacher instance = new Teacher();
        Account expResult = null;
        Account result = instance.createUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class Teacher.
     */
    public void testRemoveUser()
    {
        System.out.println("removeUser");
        Account user = null;
        Teacher instance = new Teacher();
        Account expResult = null;
        Account result = instance.removeUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editUser method, of class Teacher.
     */
    public void testEditUser()
    {
        System.out.println("editUser");
        Teacher instance = new Teacher();
        Account expResult = null;
        Account result = instance.editUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAssignment method, of class Teacher.
     */
    public void testCreateAssignment()
    {
        System.out.println("createAssignment");
        Teacher instance = new Teacher();
        Assignment expResult = null;
        Assignment result = instance.createAssignment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAssignment method, of class Teacher.
     */
    public void testEditAssignment()
    {
        System.out.println("editAssignment");
        Teacher instance = new Teacher();
        Assignment expResult = null;
        Assignment result = instance.editAssignment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAssignment method, of class Teacher.
     */
    public void testDeleteAssignment()
    {
        System.out.println("deleteAssignment");
        Teacher instance = new Teacher();
        Assignment expResult = null;
        Assignment result = instance.deleteAssignment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adjustCurve method, of class Teacher.
     */
    public void testAdjustCurve()
    {
        System.out.println("adjustCurve");
        Teacher instance = new Teacher();
        GradingRules expResult = null;
        GradingRules result = instance.adjustCurve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeAttendance method, of class Teacher.
     */
    public void testTakeAttendance()
    {
        System.out.println("takeAttendance");
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.takeAttendance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Teacher.
     */
    public void testToString()
    {
        System.out.println("toString");
        Teacher instance = new Teacher();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTeacher method, of class Teacher.
     */
    public void testIsTeacher()
    {
        System.out.println("isTeacher");
        Teacher instance = new Teacher();
        boolean expResult = false;
        boolean result = instance.isTeacher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
