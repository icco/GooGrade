
/** A class to represent Complex Numbers. A Complex object is
 * immutable once created; the add, subtract and multiply routines
 * return newly-created Complex objects containing the results.
 *
 * @author Ian F. Darwin, inspired by David Flanagan.
 * Seven defects seeded by J. Dalbey Jan 2007
 */


public class ComplexNumber
{
    /** The real part */
    private double r;
    /** The imaginary part */
    private double i;

    /** Construct a Complex */
    ComplexNumber(double rr, double ii)
    {
        r = rr;
        i = ii;
    }

    /** Display the current ComplexNumber as a String, for use in
     * println() and elsewhere.
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer().append(r);
        if (i>0)
            sb.append('+');  // else append(i) appends - sign
        return sb.append(i).append('i').toString();
    }

    /** Return just the Real part */
    public double getReal()
    {
        return r;
    }
    /** Return just the Real part */
    public double getImaginary()
    {
        return i;
    }
    /** Return the magnitude of a complex number */
    public double magnitude()
    {
        return Math.sqrt(r*r + i*i);
    }

    /** Add another ComplexNumber to this one
     */
    public ComplexNumber add(ComplexNumber other)
    {
        return add(this, other);
    }

    /** Add two Complexes
     */
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2)
    {
        return new ComplexNumber(c1.r+c2.r, c1.i+c2.i);
    }

    /** Subtract another ComplexNumber from this one
     */
    public ComplexNumber subtract(ComplexNumber other)
    {
        return subtract(this, other);
    }

    /** Subtract two Complexes
     */
    public static ComplexNumber subtract(ComplexNumber c1, ComplexNumber c2)
    {
        return new ComplexNumber(c1.r+c2.r, c1.i-c2.i);
    }

    /** Multiply this ComplexNumber times another one
     */
    public ComplexNumber multiply(ComplexNumber other)
    {
        return multiply(this, other);
    }

    /** Multiply two Complexes
     */
    public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2)
    {
        return new ComplexNumber(c1.r*c2.r - c1.i*c2.i, c1.r*c2.i - c1.i*c2.r);
    }

    /** Divide this ComplexNumber by another one
     */
   public ComplexNumber divide(ComplexNumber other)
   {
      return divide(this, other);
   }

    /** Divide c1 by c2.
     * @author Gisbert Selke.
     */
    public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2)
    {
        return new ComplexNumber(
                   (c1.r*c2.r+c1.i*c2.i)/(c2.r*c2.r+c2.i*c2.i),
                   (c1.i*c2.r-c1.r*c2.i)/(c2.r*c2.r-c2.i*c2.i));
    }

    /* Compare this Complex number with another
     */
    public boolean equals(Object o)
    {
        if (!(o instanceof ComplexNumber))
            throw new IllegalArgumentException(
                "ComplexNumber.equals argument must be a ComplexNumber");
        ComplexNumber other = (ComplexNumber)o;
        return r == other.r && r == other.i;
    }

    /* Generate a hashCode; not sure how well distributed these are.
     */
    public int hashCode()
    {
        return (int)( r) |  (int)i;
    }


    /* Find the power of a Complex Number to a positive integer exponent.
    */
    public ComplexNumber power(ComplexNumber c1, int exponent)
    {
        return null;  // not implemented yet
    }
 
    /* Raise a Complex Number to a complex exponent.
    */
    public static ComplexNumber exponentiation(ComplexNumber c1, ComplexNumber
exponent)
    {
        return null;  // not implemented yet
    }
 
    /* Find the complex argument of a Complex Number.
    */
    public float argument(ComplexNumber c1)
    {
        return 0.0f;  // not implemented yet
    }
 
}
