package goograde;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author nwelch
 */
public class GradingRulesTest extends TestCase {
    
    public GradingRulesTest(String testName) {
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
     * Test of setCurve method, of class GradingRules.
     */
    public void testSetCurve()
    {
        System.out.println("setCurve");
        Character letter = null;
        Integer grade = null;
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.setCurve(letter, grade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurve method, of class GradingRules.
     */
    public void testGetCurve()
    {
        System.out.println("getCurve");
        Character letter = null;
        GradingRules instance = new GradingRules();
        Integer expResult = null;
        Integer result = instance.getCurve(letter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetch method, of class GradingRules.
     */
    public void testFetch()
    {
        System.out.println("fetch");
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.fetch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class GradingRules.
     */
    public void testSave()
    {
        System.out.println("save");
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRules method, of class GradingRules.
     */
    public void testGetRules()
    {
        System.out.println("getRules");
        GradingRules instance = new GradingRules();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getRules();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getA method, of class GradingRules.
     */
    public void testGetA()
    {
        System.out.println("getA");
        GradingRules instance = new GradingRules();
        Integer expResult = null;
        Integer result = instance.getA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getB method, of class GradingRules.
     */
    public void testGetB()
    {
        System.out.println("getB");
        GradingRules instance = new GradingRules();
        Integer expResult = null;
        Integer result = instance.getB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getC method, of class GradingRules.
     */
    public void testGetC()
    {
        System.out.println("getC");
        GradingRules instance = new GradingRules();
        Integer expResult = null;
        Integer result = instance.getC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getD method, of class GradingRules.
     */
    public void testGetD()
    {
        System.out.println("getD");
        GradingRules instance = new GradingRules();
        Integer expResult = null;
        Integer result = instance.getD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setA method, of class GradingRules.
     */
    public void testSetA()
    {
        System.out.println("setA");
        Integer floor = null;
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.setA(floor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setB method, of class GradingRules.
     */
    public void testSetB()
    {
        System.out.println("setB");
        Integer floor = null;
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.setB(floor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setC method, of class GradingRules.
     */
    public void testSetC()
    {
        System.out.println("setC");
        Integer floor = null;
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.setC(floor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setD method, of class GradingRules.
     */
    public void testSetD()
    {
        System.out.println("setD");
        Integer floor = null;
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.setD(floor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class GradingRules.
     */
    public void testGetId()
    {
        System.out.println("getId");
        GradingRules instance = new GradingRules();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
