
import junit.framework.*;


/**
 *
 * @author mduder
 */
public class ComplexNumberTest extends TestCase
{

    ComplexNumber cn1, cn2;

    public ComplexNumberTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        cn1 = new ComplexNumber(6, 8);
        cn2 = new ComplexNumber(1, 3);
        cn3 = new ComplexNumber(1, 1);
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of magnitude method, of class ComplexNumber.
     * @author Matthew Duder
     */
    public void testMagnitudeDefect90()
    {
        System.out.println("magnitude");
        ComplexNumber instance = cn1;
        double expResult = 10.0;
        double result = instance.magnitude();
        assertEquals(expResult, result);
    }
    
    /**
     * Test to get proper Re
     * @author Katherine Blizard
     */
    public void testGetReal()
    {
        System.out.println("getReal");
        ComplexNumber instance = cn1;
        double expResult = 6;
        double result = instance.getReal();
        assertEquals(expResult, result);
    }

    /**
     * Test to add one Complex to "this"
     * @author Viktor Gerdin
     */
    public void testAddBug3()
    {
        System.out.println("add(ComplexNumber)");
	    ComplexNumber instance = cn1;
	    String expResult = "7+11i"
        String result = cn1.add(cn1).toString();
        assertEquals(expResult,result);
    }

	/**
	 * Tests the addition of two complex numbers.
	 * @author Nat Welch
	 */
	public void testAdd()
	{
        System.out.println("add");
		ComplexNumber result = ComplexNumber.add(cn3, cn3);
        ComplexNumber expResult = new ComplexNumber(2,2);
        assertEquals(expResult, result);
	}

}
