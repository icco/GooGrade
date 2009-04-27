package GooGrade;

/**
 *
 * @author nwelch
 */
public class Grade {

    public Grade(Course crse, Assignment ass, Student aThis)
    {
    }
    
    public Grade()
    {
        
    }

    public Float getGrade()
    {
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
    
    @Override
    public String toString()
    {
        return this.getGrade().toString();
    }

}
