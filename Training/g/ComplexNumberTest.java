/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

    public void testGetReal()
    {
        System.out.println("getReal");
        ComplexNumber instance = cn1;
        double expResult = 6;
        double result = instance.getReal();
        assertEquals(expResult, result);
    }
}
