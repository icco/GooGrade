package goograde;

import java.util.ArrayList;

/**
 * The GradingRules class determines how the Total Grade
 * is computed from mutiple Assignment Grades. 
 *
 * @author nwelch
 * @version 2.42
 */
public class GradingRules implements java.io.Serializable
{

    /**
     * ID used to find things in database
     */
    private Integer id;
    /**
     * The lowest percentage a student can have to obtain an A in the course.
     */
    private Integer aFloor;
    /**
     * The lowest percentage a student can have to obtain an B in the course.
     */
    private Integer bFloor;
    /**
     * The lowest percentage a student can have to obtain an C in the course.
     */
    private Integer cFloor;
    /**
     * The lowest percentage a student can have to obtain an D in the course.
     */
    private Integer dFloor;

    /**
     * Standard constructor, should not be used, kept for now
     */
    public GradingRules()
    {
    }

    /**
     * ID constructor, standard constructor with id parameter.
     * All variables, other than id, are still null and retrieved from
     * database with fetch();
     * @param id identification Integer used to fetch data from db
     */
    public GradingRules(Integer id)
    {
        this.id = id;
        this.fetch();
    }

    /**
     * Sets a the lowest percentage one can have to have a grade.
     * @param letter The Grade (A,B,C,D) you wish to change
     * @param grade The Percentage you wish to set the floor to.
     * @return false if fail, true if set.
     */
    public boolean setCurve(Character letter, Integer grade)
    {
        boolean ret = false;
        /*sets curve based on which letter grade was input */
        switch (Character.toUpperCase(letter))
        {
            case 'A':
                ret = this.setA(grade);
                break;
            case 'B':
                ret = this.setB(grade);
                break;
            case 'C':
                ret = this.setC(grade);
                break;
            case 'D':
                ret = this.setD(grade);
                break;
            default:
                ret = false;
        }
        
        return ret;
    }

    /**
     * Gets a the lowest percentage one can have to have a grade.
     * @param letter The Grade (A,B,C,D) you wish to get
     * @return the floor for that percentage or null
     */
    public Integer getCurve(Character letter)
    {
        Integer ret = 0;

        /* set return value to curve related to letter received */
        switch (Character.toUpperCase(letter))
        {
            case 'A':
                ret = this.getA();
                break;
            case 'B':
                ret = this.getB();
                break;
            case 'C':
                ret = this.getC();
                break;
            case 'D':
                ret = this.getD();
                break;
            default:
                ret = null;
        }

        return ret;
    }

    /**
     * Searches the database table GradingRules according
     * to this.id and sets all instance variables from there
     * @return true if found in database, else false
     */
    public boolean fetch()
    {
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = null;
        String query = new String();
        boolean ret = false;
        int indx = 0;

        /* A present ID requires one type of query */
        if (this.getId() != null)
        {
            query = "SELECT id, aFloor, bFloor, cFloor, dFloor";
            query += " FROM GradingRules";
            query += " WHERE id = " + this.getId().toString();

            result = conn.query(query);
            conn.close();

            indx = 0;
            ArrayList<Object> rs = result.get(indx);
            ret = this.setId((Integer) rs.get(indx++));
            ret = this.setA((Integer) rs.get(indx++));
            ret = this.setB((Integer) rs.get(indx++));
            ret = this.setC((Integer) rs.get(indx++));
            ret = this.setD((Integer) rs.get(indx++));

        }

        return ret;
    }

    /**
     * save will insert or update the db
     * @return true if successfully saved in db
     */
    public boolean save()
    {
        boolean ret = false;
        StorageConnection conn = new StorageConnection();

        /* Update if the id exists */
        if (this.getId() != null)
        {
            String query = "UPDATE GradingRules SET " 
                    + "aFloor = \"" + this.getA().toString() + "\"," 
                    + "bFloor = \"" + this.getB().toString() + "\"," 
                    + "cFloor = \"" + this.getC().toString() + "\"," 
                    + "dFloor = \"" + this.getD().toString() + "\" " 
                    + "WHERE id = \"" + this.getId() + "\"";
            ret = conn.updateQuery(query);
        }
        /* If nothing exists, insert a new GradingRule into the db */
        else if (this.getA() != null
                && this.getB() != null
                && this.getC() != null
                && this.getD() != null)
        {
            String query = "INSERT into GradingRules (aFloor, bFloor, cFloor, dFloor)";
            query += " VALUES(\"" + this.getA() + "\",\"";
            query += this.getB() + "\",\"";
            query += this.getC() + "\",\"";
            query += this.getD() + "\")";
            ret = conn.updateQuery(query);

            // Update the instance with the new ID
            this.fetch();
        }

        conn.close();


        return ret;
    }

    /**
     * returns a list of the current boundaries as floats
     * in the order a,b,c,d
     * @return an ArrayList with the 4 boundaries a to d
     */
    public ArrayList<Integer> getRules()
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        ret.add(this.getA());
        ret.add(this.getB());
        ret.add(this.getC());
        ret.add(this.getD());

        return ret;
    }

    /**
     * Get lower boundary for an A
     * @return aFloor
     */
    public Integer getA()
    {
        return this.aFloor;
    }

    /**
     * Get lower boundary for an B
     * @return bFloor
     * @author vgerdin
     */
    public Integer getB()
    {
        return this.bFloor;
    }

    /**
     * Get lower boundary for an C
     * @return cFloor
     * @author vgerdin
     */
    public Integer getC()
    {
        return this.cFloor;
    }

    /**
     * Get lower boundary for an D
     * @return dFloor
     * @author vgerdin
     */
    public Integer getD()
    {
        return this.dFloor;
    }

    /**
     * Set lower boundary for an A
     * @param floor lower boundary
     * @return true if no errors, false otherwise
     * @author vgerdin
     */
    public boolean setA(Integer floor)
    {
        boolean ret = false;
        /* Set value to a non-null Integer */
        if (floor != null)
        {
            this.aFloor = floor;
            ret = true;
        }
        return ret;
    }

    /**
     * Set lower boundary for a B
     * @param floor lower boundary
     * @return true if no errors, false otherwise
     * @author vgerdin
     */
    public boolean setB(Integer floor)
    {
        boolean ret = false;
        
        /* Set value to a non-null Integer */
        if (floor != null)
        {
            this.bFloor = floor;
            ret = true;
        }
        
        return ret;
    }

    /**
     * Set lower boundary for a C
     * @param floor lower boundary
     * @return true if no errors, false otherwise
     * @author vgerdin
     */
    public boolean setC(Integer floor)
    {
        boolean ret = false;
        
        /* Set value to a non-null Integer */
        if (floor != null)
        {
            this.cFloor = floor;
            ret = true;
        }
        
        return ret;
    }

    /**
     * Set lower boundary for a D
     * @param floor lower boundary
     * @return true if no errors, false otherwise
     * @author vgerdin
     */
    public boolean setD(Integer floor)
    {
        boolean ret = false;
        
        /* Set new value to a non-null Integer */
        if (floor != null)
        {
            this.dFloor = floor;
            ret = true;
        }
        
        return ret;
    }

    /**
     * Get's the id of this GradingRules object.
     * @return id Integer
     */
    public Integer getId()
    {
        return this.id;
    }

    /**
     * Set's the id of this GradingRules object.
     * @param in Integer id to be set
     * @return true if set, false otherwise
     * @author nwelch
     */
    public boolean setId(Integer in)
    {
        boolean ret = false;

        /*ensure action not done on null value */
        if (in != null)
        {
            this.id = new Integer(in);
            ret = true;
        }

        return ret;
    }
}

