/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goograde;

import goograde.Assignment;
import goograde.Course;
import goograde.GradingRules;
import goograde.Permissions;
import goograde.Student;
import goograde.Teacher;
import goograde.TeacherAssistant;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author vgerdin
 */
public class CourseTest extends TestCase {
    
    public CourseTest(String testName) {
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
     * Test of setId method, of class Course.
     */
    public void testSetId()
    {
        System.out.println("setId");
        Integer id = new Integer(14);
        Course instance = new Course(new Integer(13));
        if(!instance.setId(id))
        {
            fail("Function returns false");
        }
        Integer expResult = id;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Course.
     */
    public void testSetTitle()
    {
        System.out.println("setTitle");
        String newTitle = "HejHej";
        Course instance = new Course(new Integer(13));
        if(!instance.setTitle(newTitle))
        {
            fail("Function returns false");
        }
        String expResult = newTitle;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDepartment method, of class Course.
     */
    public void testSetDepartment()
    {
        System.out.println("setDepartment");
        String newDepartment = "VIGE";
        Course instance = new Course(new Integer(13));
        if(!instance.setDepartment(newDepartment))
        {
            fail("Function returns false");
        }
        String expResult = newDepartment;
        String result = instance.getDepartment();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class Course.
     */
    public void testSetNumber()
    {
        System.out.println("setNumber");
        Integer newNumber = new Integer(123);
        Course instance = new Course(new Integer(13));
        if(!instance.setNumber(newNumber))
        {
            fail("Function returns false");
        }
        Integer expResult = newNumber;
        Integer result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSection method, of class Course.
     */
    public void testSetSection()
    {
        System.out.println("setSection");
        Integer newSection = new Integer(3);
        Course instance = new Course(13);
        if(!instance.setSection(newSection))
        {
            fail("Function returns false");
        }
        Integer expResult = newSection;
        Integer result = instance.getSection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGradingRulesId method, of class Course.
     */
    public void testSetGradingRulesId()
    {
        System.out.println("setGradingRulesId");
        Integer newRulesId = new Integer(5);
        Course instance = new Course(new Integer(15));
        if(!instance.setGradingRulesId(newRulesId))
        {
            fail("Function returns false");
        }
        Integer expResult = newRulesId;
        Integer result = instance.getGradingRulesId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoster method, of class Course.
     */
    public void testSetRoster()
    {
        System.out.println("setRoster");
        ArrayList<Student> roster = new ArrayList<Student>();
        Course instance = new Course(new Integer(13));
        if(!instance.setRoster(roster))
        {
            fail("Function returns false");
        }
        ArrayList<Student> expResult = roster;
        ArrayList<Student> result = instance.getRoster();
        assertEquals(expResult, result);

        fail("The test is not yet implemented");
    }

    /**
     * Test of setAssignments method, of class Course.
     */
    public void testSetAssignments()
    {
        System.out.println("setAssignments");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        Course instance = new Course(new Integer(13));
        if(!instance.setAssignments(assignments))
        {
            fail("Function returns false");
        }
        ArrayList<Assignment> expResult = assignments;
        ArrayList<Assignment> result = instance.getAssignments();
        assertEquals(expResult, result);

        fail("The test is not yet implemented");
    }

    /**
     * Test of getId method, of class Course.
     */
    public void testGetId()
    {
        System.out.println("getId");
        Course instance = new Course(new Integer(13));
        Integer expResult = new Integer(13);
        if(!instance.setId(expResult))
        {
            fail("Set Function returns false");
        }
        Integer result = instance.getId();
        assertEquals(expResult.intValue(), result.intValue());
    }

    /**
     * Test of getTitle method, of class Course.
     */
    public void testGetTitle()
    {
        System.out.println("getTitle");
        Course instance = new Course(new Integer(13));
        String expResult = "HejHej";
        if(!instance.setTitle(expResult))
        {
            fail("Set Function returns false");
        }
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDepartment method, of class Course.
     */
    public void testGetDepartment()
    {
        System.out.println("getDepartment");
        Course instance = new Course(new Integer(13));
        String expResult = "VIGE";
        if(!instance.setDepartment(expResult))
        {
            fail("Set Function returns false");
        }
        String result = instance.getDepartment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class Course.
     */
    public void testGetNumber()
    {
        System.out.println("getNumber");
        Course instance = new Course(new Integer(13));
        Integer expResult = new Integer(321);
        if(!instance.setNumber(expResult))
        {
            fail("Set Function returns false");
        }
        Integer result = instance.getNumber();
        assertEquals(expResult.intValue(), result.intValue());
    }

    /**
     * Test of getSection method, of class Course.
     */
    public void testGetSection()
    {
        System.out.println("getSection");
        Course instance = new Course(new Integer(13));
        Integer expResult = new Integer(3);
        if(!instance.setSection(expResult))
        {
            fail("Set Function returns false");
        }
        Integer result = instance.getSection();
        assertEquals(expResult.intValue(), result.intValue());
    }

    /**
     * Test of getGradingRulesId method, of class Course.
     */
    public void testGetGradingRulesId()
    {
        System.out.println("getGradingRulesId");
        Course instance = new Course(new Integer(13));
        Integer expResult = new Integer(1);
        if(!instance.setGradingRulesId(expResult))
        {
            fail("Set Function returns false");
        }
        Integer result = instance.getGradingRulesId();
        assertEquals(expResult.intValue(), result.intValue());
    }

    /**
     * Test of getRoster method, of class Course.
     */
    public void testGetRoster()
    {
        System.out.println("getRoster");
        Course instance = new Course();
        ArrayList<Student> expResult = null;
        ArrayList<Student> result = instance.getRoster();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignments method, of class Course.
     */
    public void testGetAssignments()
    {
        System.out.println("getAssignments");
        Course instance = new Course();
        ArrayList<Assignment> expResult = null;
        ArrayList<Assignment> result = instance.getAssignments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class Course.
     */
    public void testGetCode()
    {
        System.out.println("getCode");
        Course instance = new Course(new Integer(13));
        String expResult = "VIGE123";
        if(!instance.setDepartment("VIGE") || !instance.setNumber(new Integer(123)))
        {
            fail("Set Function returns false");
        }
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTeachers method, of class Course.
     */
    public void testGetTeachers()
    {
        System.out.println("getTeachers");
        Course instance = new Course();
        ArrayList<Teacher> expResult = null;
        ArrayList<Teacher> result = instance.getTeachers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeacherAssistants method, of class Course.
     */
    public void testGetTeacherAssistants()
    {
        System.out.println("getTeacherAssistants");
        Course instance = new Course();
        ArrayList<TeacherAssistant> expResult = null;
        ArrayList<TeacherAssistant> result = instance.getTeacherAssistants();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGradingRules method, of class Course.
     */
    public void testGetGradingRules()
    {
        System.out.println("getGradingRules");
        Course instance = new Course();
        GradingRules expResult = null;
        GradingRules result = instance.getGradingRules();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStudent method, of class Course.
     */
    public void testAddStudent()
    {
        System.out.println("addStudent");
        Permissions permission = null;
        Student student = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.addStudent(permission, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeStudent method, of class Course.
     */
    public void testRemoveStudent()
    {
        System.out.println("removeStudent");
        Permissions permission = null;
        Student student = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.removeStudent(permission, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTA method, of class Course.
     */
    public void testAddTA()
    {
        System.out.println("addTA");
        Permissions permission = null;
        TeacherAssistant ta = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.addTA(permission, ta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTA method, of class Course.
     */
    public void testRemoveTA()
    {
        System.out.println("removeTA");
        Permissions permission = null;
        TeacherAssistant ta = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.removeTA(permission, ta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTeacher method, of class Course.
     */
    public void testAddTeacher()
    {
        System.out.println("addTeacher");
        Permissions permission = null;
        Teacher teacher = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.addTeacher(permission, teacher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTeacher method, of class Course.
     */
    public void testRemoveTeacher()
    {
        System.out.println("removeTeacher");
        Permissions permission = null;
        Teacher teacher = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.removeTeacher(permission, teacher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allCourses method, of class Course.
     */
    public void testAllCourses()
    {
        System.out.println("allCourses");
        ArrayList<Course> expResult = null;
        ArrayList<Course> result = Course.allCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCourse method, of class Course.
     */
    public void testDeleteCourse_Permissions_Integer()
    {
        System.out.println("deleteCourse");
        Permissions permission = null;
        Integer id = null;
        boolean expResult = false;
        boolean result = Course.deleteCourse(permission, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCourse method, of class Course.
     */
    public void testDeleteCourse_Permissions()
    {
        System.out.println("deleteCourse");
        Permissions permission = null;
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.delete(permission);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCourse method, of class Course.
     */
    public void testAddCourse()
    {
        System.out.println("addCourse");
        Permissions permission = null;
        String title = "";
        String department = "";
        Integer number = null;
        Integer section = null;
        boolean expResult = false;
        boolean result = Course.addCourse(permission, title, department, number, section,null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetch method, of class Course.
     */
    public void testFetch()
    {
        System.out.println("fetch");
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.fetch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class Course.
     */
    public void testRefresh()
    {
        System.out.println("refresh");
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.refresh();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Course.
     */
    public void testSave()
    {
        System.out.println("save");
        Course instance = new Course();
        boolean expResult = false;
        boolean result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
