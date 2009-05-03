/*
 * Assignment Test for Assignment class
 * @author kblizard
 * @version 0.42
 */
package goograde;

import java.util.ArrayList;
import java.util.Date;
import junit.framework.TestCase;


/**
 * AssignmentTest is a Junit test for the Assignment class
 * @author kblizard
 */
public class AssignmentTest extends TestCase
{

    public AssignmentTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of getDueDate method, of class Assignment.
     */
    public void testGetDueDate()
    {
        System.out.println("getDueDate");
        Assignment instance = new Assignment();
        Date expResult = new Date();
        instance.setDueDate(expResult);
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Assignment.
     */
    public void testGetName()
    {
        System.out.println("getName");
        Assignment instance = new Assignment();
        instance.setName("Mike Shinoda");
        String expResult = "Mike Shinoda";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class Assignment.
     */
    public void testGetTotal()
    {
        System.out.println("getTotal");
        Assignment instance = new Assignment();
        instance.setTotal(100);
        Integer expResult = 100;
        Integer result = instance.getTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Assignment.
     */
    public void testGetType()
    {
        System.out.println("getType");
        Assignment instance = new Assignment();
        String expResult = "Final";
        instance.setType("Final");
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvg method, of class Assignment.
     */
    public void testGetAvg()
    {
        System.out.println("getAvg");
        Assignment instance = new Assignment();
        Float expResult = 52.4F;
        instance.setAvg(52.4F);
        Float result = instance.getAvg();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMax method, of class Assignment.
     */
    public void testGetMax()
    {
        System.out.println("getMax");
        Assignment instance = new Assignment();
        Float expResult = 98.8F;
        instance.setMax(98.8F);
        Float result = instance.getMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class Assignment.
     */
    public void testGetMin()
    {
        System.out.println("getMin");
        Assignment instance = new Assignment();
        Float expResult = 42.0F;
        instance.setMin(42.0F);
        Float result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Assignment.
     */
    public void testGetId()
    {
        System.out.println("getId");
        Assignment instance = new Assignment(11);
        int expResult = 11;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrades method, of class Assignment.
     */
    public void testGetGrades()
    {
        System.out.println("getGrades");
        Assignment instance = new Assignment();
        ArrayList<Grade> expResult = new ArrayList<Grade>();
        instance.setAGrade(new Student(), 20.4F);
        expResult.add(new Grade());
        expResult.get(0).gradeStudent(20.4F);
        ArrayList<Grade> result = instance.getGrades();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDueDate method, of class Assignment.
     */
    public void testSetDueDate()
    {
        System.out.println("setDueDate");
        Date pdueDate = new Date();
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setDueDate(pdueDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Assignment.
     */
    public void testSetName()
    {
        System.out.println("setName");
        String pname = "Mike Shinoda";
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setName(pname);
        assertEquals(expResult, result);
    }

    /**
     * Test of setTotal method, of class Assignment.
     */
    public void testSetTotal()
    {
        System.out.println("setTotal");
        Integer ptotal = 42;
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setTotal(ptotal);
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Assignment.
     */
    public void testSetType()
    {
        System.out.println("setType");
        String ptype = "Final";
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setType(ptype);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvg method, of class Assignment.
     */
    public void testSetAvg()
    {
        System.out.println("setAvg");
        Float paverage = 42.2F;
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setAvg(paverage);
        assertEquals(expResult, result);
    }

    /**
     * Test of setMax method, of class Assignment.
     */
    public void testSetMax()
    {
        System.out.println("setMax");
        Float pmax = 99.9F;
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setMax(pmax);
        assertEquals(expResult, result);
    }

    /**
     * Test of setMin method, of class Assignment.
     */
    public void testSetMin()
    {
        System.out.println("setMin");
        Float pmin = 2.11F;
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setMin(pmin);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAGrade method, of class Assignment.
     */
    public void testSetAGrade()
    {
        System.out.println("setAGrade");
        Student aStudent = new Student();
        float newGrade = 40.0F;
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.setAGrade(aStudent, newGrade);
        assertEquals(expResult, result);
    }

    /**
     * Test of fetch method, of class Assignment.
     */
    public void testFetch()
    {
        System.out.println("fetch");
        Assignment instance = new Assignment();
        boolean expResult = true;
        boolean result = instance.fetch();
        assertEquals(expResult, result);
    }
}
