package goograde;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class AGradeTest extends TestCase {
    
    public AGradeTest(String testName) {
        super(testName);
    }

    /**
     * Test of gradeStudent method, of class Grade.
     */
    public void testGradeStudent()
    {
        System.out.println("gradeStudent");
        float theGrade = 0.5F;
        Grade instance = null;
        try
        {
            instance = new Grade(1,1);
        }
        catch (Exception ex)
        {
            fail("Invalid student ID " + ex);
        }
        boolean expResult = true;
        boolean result = instance.gradeStudent(theGrade);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrade method, of class Grade.
     */
    public void testGetGrade()
    {
        System.out.println("getGrade");
        Grade instance = new Grade();
        instance.gradeStudent(3.14F);
        Float expResult = 3.14F;
        Float result = instance.getGrade();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssignment method, of class Grade.
     */
    public void testGetAssignment()
    {
        System.out.println("getAssignment");
        Grade instance;
        Assignment expResult = null;
        Assignment result = null;
        try
        {
            instance = new Grade(1, 1);
            expResult = new Assignment(1);
            result = instance.getAssignment();
        }
        catch (Exception ex)
        {
            fail("Got an error thrown" + ex);
        }
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudent method, of class Grade.
     */
    public void testGetStudent()
    {
        System.out.println("getStudent");
        Grade instance = new Grade();
        Student expResult = null;
        Student result = instance.getStudent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStudent method, of class Grade.
     */
    public void testSetStudent()
    {
        System.out.println("setStudent");
        Student pstudent = null;
        Grade instance = new Grade();
        boolean expResult = true;
        boolean result = instance.setStudent(pstudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAssignment method, of class Grade.
     */
    public void testSetAssignment()
    {
        System.out.println("setAssignment");
        Assignment assignmentNo = null;
        Grade instance = new Grade();
        boolean expResult = true;
        boolean result = instance.setAssignment(assignmentNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Grade.
     */
    public void testToString()
    {
        System.out.println("toString");
        Grade instance = new Grade();
        instance.gradeStudent(3.14F);
        String expResult = "3.14";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of fetch method, of class Grade.
     */
    public void testFetch()
    {
        System.out.println("fetch");
        Grade instance = null;
        try
        {
            instance = new Grade(2, 3);
        } 
        catch (Exception ex)
        {
            fail("Invalid student ID" + ex);
        }
        boolean expResult = true;
        boolean result = instance.fetch();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Grade.
     */
    public void testEquals()
    {
        System.out.println("equals");
        Grade instance = null;
        Grade test = null;
        boolean expResult = true;
        boolean result = false;
        try
        {
            instance = new Grade(1, 1);
            test = new Grade(1,1);
            result = instance.equals(test);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AGradeTest.class.getName()).log(Level.WARNING, null, ex);
        }
        assertEquals(expResult, result);

    }

    /**
     * Test of allGrades method, of class Grade.
     */
    public void testAllGrades()
    {
        System.out.println("allGrades");
        Integer expResult = new Integer(55);
        Integer result = null;
        try
        {
            result = Grade.allGrades().size();
        }
        catch (Exception ex)
        {
            Logger.getLogger(AGradeTest.class.getName()).log(Level.WARNING, null, ex);
        }
		
        assertEquals(expResult, result);
    }

    /**
     * Test of addGrade method, of class Grade.
     */
    public void testAddGrade()
    {
        System.out.println("addGrade");
        Student sStudent = null;
        try
        {
            sStudent = new Student(3);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AGradeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assignment sAssignment = new Assignment(1);
        float sGrade = 100.0F;
        boolean result = Grade.addGrade(sStudent, sAssignment, sGrade);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteGrade method, of class Grade.
     */
    public void testDeleteGrade()
    {
        System.out.println("deleteGrade");
        Student sStudent = null;
        try
        {
            sStudent = new Student(3);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AGradeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assignment sAssignment = new Assignment(1);
        boolean result = Grade.deleteGrade(sStudent, sAssignment);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class Grade.
     */
    public void testSave()
    {
        System.out.println("save");
        Grade instance = null;
        try
        {
            instance = new Grade(2, 3);
        }
        catch (Exception ex)
        {
            Logger.getLogger(AGradeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.gradeStudent(3.14F);
        boolean expResult = true;
        boolean result = instance.save();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of gradeStudent method, of class Grade.
     */
    public void testVGMagic()
    {
        System.out.println("Magic!!!");
        Grade instance = null;
        Grade instance2 = null;
        try
        {
            instance = new Grade(2,3);
            instance2 = new Grade(3,3);
        }
        catch (Exception ex)
        {
            fail("Invalid student ID " + ex);
        }
        float expResult1 = 3.14F;
        float result1 = instance.getGrade();
        assertEquals(expResult1, result1);
        float expResult2 = 0F;
        float result2 = instance2.getGrade();
        assertEquals(expResult2, result2);
    }
    
    /**
     * Test for predictGrade method in class Grade
     */
    public void testPredictGrade()
    {
        System.out.println("predictGrade");
        ArrayList<Grade> result = null;

        try
        {
            //Test 1, a course with no assignments
            result = Grade.predictGrades(new Course(4), new Student(3), 0.50F);
            assertEquals(null, result);
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
        
        try
        {
            //Test 2, goal is unachievable
            result = Grade.predictGrades(new Course(5), new Student(3), 0.90F);
            assertEquals(null, result);
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
        
        try
        {
            //Test 3, goal is achievable
            result = Grade.predictGrades(new Course(5), new Student(3), 0.80F);
            if(result == null)
            {
                fail("returned null when shouldn't");
            }
            else
            {
                assertEquals(8F, result.get(0).getGrade());
                assertEquals(5F, result.get(1).getGrade());
            }
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
        
        try
        {
            //Test 4, boundary testing
            result = Grade.predictGrades(new Course(5), new Student(3), 0.83F);
            if(result == null)
            {
                fail("returned null when shouldn't");
            }
            else
            {
                assertEquals(10F, result.get(0).getGrade());
                assertEquals(5F, result.get(1).getGrade());
            }
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
        
        try
        {
            //Test 5, boundary testing
            result = Grade.predictGrades(new Course(5), new Student(3), 0.84F);
            if(result == null)
            {
                fail("returned null when shouldn't");
            }
            else
            {
                assertEquals(10F, result.get(0).getGrade());
                assertEquals(5F, result.get(1).getGrade());
            }
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
        
        try
        {
            //Test 6, boundary testing
            result = Grade.predictGrades(new Course(5), new Student(3), 0.85F);
            assertEquals(null, result);
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
    }
    
    /**
     * Test for isGraded method in class Grade
     */
    public void testIsGraded()
    {
        System.out.println("isGraded");
        
        Grade instance = null;
        boolean expResult;
        boolean result;
        
        try
        {
            instance = new Grade(8, 3);
            expResult = true;
            result = instance.isGraded();
            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
        try
        {

            instance = new Grade(10, 3);
            expResult = false;
            result = instance.isGraded();
            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
    }
    
    /**
     * Test for setGraded method in class Grade
     */
    public void testSetGraded()
    {
        System.out.println("setGraded");
        
        Grade instance = null;
        boolean expResult;
        boolean result;
        try
        {
            instance = new Grade(8, 3);
            expResult = false;
            result = instance.setGraded(null);
            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
        try
        {

            instance = new Grade(8, 3);
            expResult = true;
            result = instance.setGraded(false);
            assertEquals(expResult, result);
            assertEquals(new Boolean(false), instance.isGraded());
            
            result = instance.setGraded(true);
            assertEquals(expResult, result);
            assertEquals(new Boolean(true), instance.isGraded());
        }
        catch (Exception ex)
        {
            fail("Bad test data");
        }
    }
            
    /**
     * Test for updateGrade method in class Grade
     */
    public void testUpdateGrade()
    {
        System.out.println("updateGrade");
        Grade instance = null;
        boolean result = false;
        boolean expResult = true;

        try {
            instance = new Grade(10, 3);
        } catch (Exception ex) {
            fail("Bad Test Data");
        }
        finally
        {
            if(instance != null)
            {
                result = instance.updateGrade(5F);
                assertEquals(expResult, result);
            }
            else
            {
                fail("Null");
            }
        }
    }
    
    public void testGetGrades() throws Exception
    {
        System.out.println("getGrades");
        Grade instance = null;
        ArrayList<Grade> result = null;
        
        try {
            instance = new Grade(10, 3);
        } catch (Exception ex) {
            fail("Bad Test Data");
        }
        finally
        {
            if(instance != null)
            {
                result = instance.getGrades(new Course(1), new Student(2),0);
                assertEquals(3, result.size());
            }
            else
            {
                fail("Null");
            }
        }
        
    }
}
