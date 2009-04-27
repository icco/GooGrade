/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GooGrade;

/**
 *
 * @author nwelch
 */
class Grade {

    public Grade(Course crse, Assignment ass, Student aThis)
    {
    }

    public Float getGrade()
    {
        //throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @Override
    public String toString()
    {
        return this.getGrade().toString();
    }

}
