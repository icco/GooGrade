import junit.framework.*;

// A demonstration of JUnit testing
public class ComplexNumberTest extends TestCase
{
	ComplexNumber cn1, cn2;
	
	public ComplexNumberTest (String name)
	{
		super (name);
	}
	
    // Create variables to used in each test case
	protected void setUp()
	{
		cn1 = new ComplexNumber(6, 8);
		cn2 = new ComplexNumber(1, 3);
	}

	
}
		
