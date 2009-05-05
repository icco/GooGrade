/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goograde;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author mduder, vgerdin
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
        StorageConnection conn = new StorageConnection();
        String query = new String("SELECT student FROM enrolled WHERE course = 1");
        ArrayList<ArrayList<Object>> queryResult = conn.query(query);
        conn.close();
        Integer expResult = queryResult.size();
        Course instance = new Course(1);
        ArrayList<Student> getResult = instance.getRoster();
        Integer result = getResult.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssignments method, of class Course.
     */
    public void testGetAssignments()
    {
        System.out.println("getAssignments");
        Course instance = new Course(4);
        ArrayList<Assignment> result = instance.getAssignments();
        String assignName = new String(result.get(0).getName());
        String expResult = new String("SRS");
        assertEquals(expResult, assignName);
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
        Course instance = new Course(1);
        ArrayList<Teacher> result = instance.getTeachers();
        String teacherName = new String(result.get(0).getUserName());
        String expResult = new String("nwelch");
        assertEquals(expResult, teacherName);
    }

    /**
     * Test of getTeacherAssistants method, of class Course.
     */
    public void testGetTeacherAssistants()
    {
        System.out.println("getTeacherAssistants");
        Course instance = new Course(1);
        ArrayList<TeacherAssistant> result = instance.getTeacherAssistants();
        String taName = new String(result.get(0).getUserName());
        String expResult = new String("pphu");
        assertEquals(expResult, taName);
    }

    /**
     * Test of getGradingRules method, of class Course.
     * @todo Implement after this feature is implemented
     */
    public void testGetGradingRules()
    {
        System.out.println("getGradingRules");
        Course instance = new Course();
        GradingRules expResult = null;
        GradingRules result = instance.getGradingRules();
        // fail("Grades are not yet implemented.");
    }

    /**
     * Test of addStudent method, of class Course.
     */
    public void testAddAndRemoveStudent()
    {
        System.out.println("addStudent");
        Permissions permission = null;
        Course instance = new Course(4);
        Student student = null;
        try
        {
            student = new Student(4);
        }
        catch (Exception ex)
        {
            fail("invalid student id" + ex);
        }
        boolean expResult = true;
        boolean result = instance.addStudent(permission, student);
        assertEquals(expResult, result);
        
        System.out.println("removeStudent");
        result = instance.removeStudent(permission, student);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTA method, of class Course.
     */
    public void testAddAndRemoveTA()
    {
        System.out.println("addTA");
        Permissions permission = null;
        Course instance = new Course(4);
        TeacherAssistant ta = null;
        try
        {
            ta = new TeacherAssistant(2);
        }
        catch (Exception ex)
        {
            fail("invalid Teacher Assistant id" + ex);
        }
        boolean expResult = true;
        boolean result = instance.addTA(permission, ta);
        assertEquals(expResult, result);
        
        System.out.println("removeTA");
        result = instance.removeTA(permission, ta);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTeacher method, of class Course.
     */
    public void testAddAndRemoveTeacher()
    {
        System.out.println("addTeacher");
        Permissions permission = null;
        Course instance = new Course(4);
        Teacher testTeacher = null;
        try
        {
            testTeacher = new Teacher(1);
        }
        catch (Exception ex)
        {
            fail("invalid Teacher id" + ex);
        }
        boolean expResult = false;
        boolean result = instance.addTeacher(permission, testTeacher);
        assertEquals(expResult, result);
        
        System.out.println("removeTeacher");
        expResult = true;
        result = instance.removeTeacher(permission, testTeacher);
        assertEquals(expResult, result);
    }

    /**
     * Test of allCourses method, of class Course.
     */
    public void testAllCourses()
    {
        System.out.println("allCourses");
        ArrayList<Course> courseList = Course.allCourses();
        int index = 0, size = 1;
        String query = new String("SELECT COUNT(*) FROM Courses");
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> queryResult = conn.query(query);
        conn.close();
        ArrayList<Object> rs = queryResult.get(0);
        Integer courseCount = new Integer((Integer) rs.get(0));
        Integer resultCount = courseList.size();
        assertEquals(courseCount, resultCount);
    }

    /**
     * Test of addCourse and deleteCourse methods, of class Course.
     */
    public void testAddCourseAndDeleteCourse()
    {
        System.out.println("addCourse");
        Permissions permission = null;
        String title = new String("jUnit Test Course");
        String department = new String("CPE");
        Integer number = new Integer(666);
        Integer section = new Integer(6);
        Teacher testTeacher = null;
        try
        {
            testTeacher = new Teacher(1);
        }
        catch (Exception ex)
        {
            fail("invalid teacher ID" + ex);
        }
        boolean expResult = true;
        ArrayList<Course> cList = Course.allCourses();
        Integer initialSize = cList.get(cList.size() - 1).getId();
        boolean result = Course.addCourse(permission, title, department, number, 
                section, testTeacher);
        assertEquals(expResult, result);
        
        System.out.println("deleteCourse");
        cList = Course.allCourses();
        Integer lastCourseId = cList.get(cList.size() - 1).getId();
        result = Course.deleteCourse(permission, lastCourseId);
        assertEquals(expResult, result);
        cList = Course.allCourses();
        Integer finalSize = cList.get(cList.size() - 1).getId();
        assertEquals(initialSize, finalSize);
    }
    
    /**
     * Test of save and delete methods in class Course
     */
    public void testSaveAndDelete()
    {
        System.out.println("save");
        String title = new String("jUnit Test Course 2");
        String department = new String("CPE");
        Integer number = new Integer(777);
        Integer section = new Integer(7);
        Course testCourse = new Course(title, department, number, section);
        testCourse.save();
        Integer testId = testCourse.getId();
        
        String query = new String("SELECT title FROM Courses WHERE id = \""
                + testId.toString() + "\"");
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> queryResult = conn.query(query);
        Integer workingSave = queryResult.size();
        Integer expResult = new Integer(1);
        assertEquals(workingSave, expResult);
        
        System.out.println("delete");
        testCourse.delete(null);
        queryResult = conn.query(query);
        conn.close();
        Integer workingDelete = queryResult.size();
        expResult = new Integer(0);
        assertEquals(workingDelete, expResult);
    }

    /**
     * Test of fetch method, of class Course.
     * Test with valid id
     */
    public void testFetch1()
    {
        System.out.println("fetch1");
        Course instance = new Course(1);
        boolean expResult = true;
        boolean result = instance.fetch();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of fetch method, of class Course.
     * Test with invalid id
     */
    public void testFetch2()
    {
        System.out.println("fetch1");
        Course instance = new Course(666);
        boolean expResult = false;
        boolean result = instance.fetch();
        assertEquals(expResult, result);
    }

    /**
     * Test of refresh method, of class Course.
     * Test with null id
     */
    public void testRefresh1()
    {
        System.out.println("refresh1");
        Course instance = new Course("Yay","Nay",123,null);
        boolean expResult = false;
        boolean result = instance.refresh();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of refresh method, of class Course.
     * Test with valid id
     */
    public void testRefresh2()
    {
        System.out.println("refresh2");
        Course instance = new Course(1);
        boolean expResult = true;
        boolean result = instance.refresh();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of refresh method, of class Course.
     * Test with invalid id
     */
    public void testRefresh3()
    {
        System.out.println("refresh3");
        Course instance = new Course(666);
        boolean expResult = false;
        boolean result = instance.refresh();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class Course.
     * Test with null id
     */
    public void testSave1()
    {
        System.out.println("save1");
        Course instance = new Course("Testing Save","TEST",101,null);
        boolean expResult = true;
        boolean result = instance.save();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of save method, of class Course.
     * Test with non-null id in database
     */
    public void testSave2()
    {
        System.out.println("save2");
        Course instance = new Course(1);
        boolean expResult = true;
        boolean result = instance.save();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of save method, of class Course.
     * Test with non-null id not in database
     */
    public void testSave3()
    {
        System.out.println("save3");
        Course instance = new Course(15);
        instance.setTitle("Testing is fun");
        instance.setDepartment("TEST");
        instance.setNumber(103);
        instance.setSection(1);
        boolean expResult = true;
        boolean result = instance.save();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumber method, of class Course.
     * Test with valid number
     */
    public void testValidateNumber1()
    {
        System.out.println("validateNumber1");
        boolean expResult = true;
        boolean result = Course.validateNumber("123");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumber method, of class Course.
     * Test with invalid number
     */
    public void testValidateNumber2()
    {
        System.out.println("validateNumber2");
        boolean expResult = false;
        boolean result = Course.validateNumber("jeh");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateSection method, of class Course.
     * Test with valid section
     */
    public void testValidateSection1()
    {
        System.out.println("validateSection1");
        boolean expResult = true;
        boolean result = Course.validateSection("01");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateSection method, of class Course.
     * Test with invalid section
     */
    public void testValidateSection2()
    {
        System.out.println("validateSection2");
        boolean expResult = false;
        boolean result = Course.validateSection("vg");
        assertEquals(expResult, result);
    }

}
