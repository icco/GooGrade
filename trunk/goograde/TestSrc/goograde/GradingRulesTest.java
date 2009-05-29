package goograde;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author nwelch
 */
public class GradingRulesTest extends TestCase
{

    public GradingRulesTest(String testName)
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
     * Test of setCurve method, of class GradingRules.
     */
    public void testSetCurve()
    {
        System.out.println("setCurve");
        Character letter = new Character('A');
        Integer grade = new Integer(90);
        GradingRules instance = new GradingRules();
        boolean expResult = false;
        boolean result = instance.setCurve(letter, grade);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurve method, of class GradingRules.
     */
    public void testGetCurve()
    {
        System.out.println("getCurve");
    }

    /**
     * Test of fetch method, of class GradingRules.
     */
    public void testFetch()
    {
        System.out.println("fetch");
        GradingRules instance = new GradingRules();
        instance.setId(1);
        instance.fetch();
        ArrayList result = new ArrayList();
        result.add(instance.getA());
        result.add(instance.getB());
        result.add(instance.getC());
        result.add(instance.getD());
        assertEquals(instance.getRules(), result);
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
    }

    /**
     * Test of getRules method, of class GradingRules.
     */
    public void testGetRules()
    {
        System.out.println("getRules");
        GradingRules instance = new GradingRules(1);
        ArrayList result = new ArrayList();
        result.add(instance.getA());
        result.add(instance.getB());
        result.add(instance.getC());
        result.add(instance.getD());
        assertEquals(instance.getRules(), result);
    }

    /**
     * Test of getA method, of class GradingRules.
     */
    public void testGetA()
    {
        System.out.println("getA");
        GradingRules instance = new GradingRules(5);
        Integer expResult = 90;
        Integer result = instance.getA();
        assertEquals(expResult, result);
    }

    /**
     * Test of getB method, of class GradingRules.
     */
    public void testGetB()
    {
        System.out.println("getB");
        GradingRules instance = new GradingRules(5);
        Integer expResult = 80;
        Integer result = instance.getB();
        assertEquals(expResult, result);
    }

    /**
     * Test of getC method, of class GradingRules.
     */
    public void testGetC()
    {
        System.out.println("getC");
        GradingRules instance = new GradingRules(5);
        Integer expResult = 70;
        Integer result = instance.getC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getD method, of class GradingRules.
     */
    public void testGetD()
    {
        System.out.println("getD");
        GradingRules instance = new GradingRules(5);
        Integer expResult = 60;
        Integer result = instance.getD();
        assertEquals(expResult, result);
    }

    /**
     * Test of setA method, of class GradingRules.
     */
    public void testSetA()
    {
        System.out.println("setA");
        GradingRules instance = new GradingRules(4);

        Integer floor = null;
        boolean expResult = false;
        boolean result = instance.setA(floor);
        assertEquals(expResult, result);

        floor = 85;
        expResult = true;
        result = instance.setA(floor);
        assertEquals(expResult, result);

        assertEquals(floor, instance.getA());
    }

    /**
     * Test of setB method, of class GradingRules.
     */
    public void testSetB()
    {
        System.out.println("setB");
        GradingRules instance = new GradingRules(4);

        Integer floor = null;
        boolean expResult = false;
        boolean result = instance.setB(floor);
        assertEquals(expResult, result);

        floor = 75;
        expResult = true;
        result = instance.setB(floor);
        assertEquals(expResult, result);

        assertEquals(floor, instance.getB());
    }

    /**
     * Test of setC method, of class GradingRules.
     */
    public void testSetC()
    {
        System.out.println("setC");
        GradingRules instance = new GradingRules(4);

        Integer floor = null;
        boolean expResult = false;
        boolean result = instance.setC(floor);
        assertEquals(expResult, result);

        floor = 65;
        expResult = true;
        result = instance.setC(floor);
        assertEquals(expResult, result);

        assertEquals(floor, instance.getC());
    }

    /**
     * Test of setD method, of class GradingRules.
     */
    public void testSetD()
    {
        System.out.println("setD");
        GradingRules instance = new GradingRules(4);

        Integer floor = null;
        boolean expResult = false;
        boolean result = instance.setD(floor);
        assertEquals(expResult, result);

        floor = 55;
        expResult = true;
        result = instance.setD(floor);
        assertEquals(expResult, result);

        assertEquals(floor, instance.getD());
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
    }
}
