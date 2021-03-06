package goograde;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Grade holds a specific grade for bewteen an assignment and student. The Grade
 * represents what that student received for that particular assignment. 
 * 
 * @author kblizard 
 * @author nwelch
 * @author vgerdin
 * @version 2.42
 */
public class Grade implements Comparable<Grade>
{

    private Student student;
    private Assignment assignment;
    private Float grade;
    private Boolean graded;

    /**
     * Constructor for Grade class depending on a given assignment and student
     * @param ass the assignment this grade is from
     * @param aThis the student is grade is for
     * @author vgerdin
     */
    public Grade(Assignment ass, Student aThis)
    {
        this.setStudent(aThis);
        this.setAssignment(ass);
        
        //if no data is stored we set a 0
        if (!this.fetch())
        {
            this.gradeStudent(0);
            this.setGraded(false);
        }
        else
        {
            this.setGraded(true);
        }
    }

    /**
     * Constructor receiving ids for assignments and students
     * @param ass id for assignment
     * @param aThis id for student?
     * @throws java.lang.Exception because it can
     * @author bluGoo
     */
    public Grade(int ass, int aThis) throws Exception
    {
        this.student = new Student(aThis);
        this.assignment = new Assignment(ass);

        //if no data is stored we set a 0
        if (!this.fetch())
        {
            this.gradeStudent(0);
            this.setGraded(false);
        }
        else
        {
            this.setGraded(true);
        }
    }

    /**
     * Empty Constructor for Grade. Not to be used, other than for unit tests.
     * @author vgerdin
     */
    public Grade()
    {
        this.student = null;
        this.assignment = null;
        this.grade = null;
        this.setGraded(false);
    }

    /**
     * Constructor for Grade when the assignment, student and the grade itself 
     * is already known
     * @param stud The Student this grade belongs to
     * @param aFloat the grade this student receives
     * @param ass the assignment this grade is from.
     * @author vgerdin
     */
    public Grade(Student stud, Float aFloat, Assignment ass)
    {
        this.student = stud;
        this.assignment = ass;
        this.grade = aFloat;
        this.setGraded(true);
    }

    /**
     * gradeStudent gives a grade to a specific student.
     * @param theGrade the grade the student will receive
     * @return true if grading is successful
     * @author kblizard
     */
    public boolean gradeStudent(float theGrade)
    {
        this.grade = theGrade;

        return true;
    }

    /**
     * getGrade retrieves the grade for this student and assignment
     * @return the grade received
     * @author kblizard
     */
    public Float getGrade()
    {
        return this.grade;
    }

    /**
     * getAssignment returns the assignment this grade belonged to
     * @return the Assignment ID
     * @author kblizard
     */
    public Assignment getAssignment()
    {
        return this.assignment;
    }

    /**
     * getStudent returns the student this grade is for
     * @return the Student ID
     * @author kblizard
     */
    public Student getStudent()
    {
        return student;
    }

    /**
     * set student changes the Student id number
     * @param pstudent the Student to save the id number for
     * @return true if change is sucessful
     * @author nwelch
     */
    public boolean setStudent(Student pstudent)
    {
        student = pstudent;
        return true;
    }

    /**
     * set Assignment changes the id number of the assignment
     * @param assignmentNo assignment number
     * @return true if set is sucessful
     * @author bluGoo
     */
    public boolean setAssignment(Assignment assignmentNo)
    {
        assignment = assignmentNo;
        return true;
    }

    /**
     * toString returns the grade in the form of a string
     * @return the String version of the grade. 
     * @author kblizard
     */
    @Override
    public String toString()
    {
        return this.getGrade().toString();
    }

    /**
     * fetch grade data from the database
     * @return true if successful, false otherwise
     * @author vgerdin
     */
    public boolean fetch()
    {
        boolean ret = false;
        /*Get the database at row ID */
        String query = "SELECT grade FROM Grades ";
        query += "WHERE assignId =" + this.getAssignment().getId();
        query += " AND accountId =" + this.getStudent().getId();

        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);

        /* Proceed if result is positive */
        if (result.size() > 0)
        {
            ArrayList<Object> row = result.get(0);
            conn.close();
            /* No results from the query means an unsuccessful fetch */
            if (row.size() > 0)
            {
                try
                {
                    int indx = 0;
                    //set varaibles to values loaded from database,
                    //this.setStudent(new Student((Integer) row.get(indx++)));
                    this.gradeStudent(new Float(row.get(indx++).toString()));
                    ret = true;
                } 
                catch (Exception ex)
                {
                    Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
                            "SQL error occurred when trying to fetch " 
                            + "Assignment  with id = " 
                            + this.assignment.getId(), ex);
                }
            }
        }
        return ret;
    }

    /**
     * equals verifies that one grade is the same (numerically) as another. Only
     * the value of the grade itself is compared. The student and the assignment
     * this grade is from is not entered into the equation. 
     * @param object object to compare with
     * @return true if equal, false otherwise
     * @author vgerdin
     */
    @Override
    public boolean equals(Object object)
    {
        boolean ret = false;
        /* Must be a grade to compare with */
        if (object instanceof Grade)
        {
            Grade gradeObject = (Grade) object;
            /* Compare data */
            if ((gradeObject.getStudent().equals((Object) this.getStudent())) 
                    && (gradeObject.getAssignment().equals(this.getAssignment())))
            {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * allGrades returns all of the grades in the database
     * @return an arraylsit of all the grades
     * @throws Exception Account constructor ex
     * @author bluyGoo
     */
    public static ArrayList<Grade> allGrades() throws Exception
    {
        ArrayList<Grade> assgns = new ArrayList<Grade>();
        //String query = "SELECT assignId, accountId FROM Grades";
        String query = "SELECT id FROM Assignments";
        String queryStu = "SELECT id FROM Students";
        StorageConnection conn = new StorageConnection();
        ArrayList<ArrayList<Object>> result = conn.query(query);
        ArrayList<ArrayList<Object>> resultStu = conn.query(queryStu);

        /* for all in result, add to returned course list */
        for (int index = 0; index < result.size(); index++)
        {
            Integer assid = (Integer) result.get(index).get(0);
            /* Deal with every student in the list */
            for (ArrayList<Object> stu : resultStu)
            {
                Integer stuId = (Integer) stu.get(0);
                assgns.add(new Grade(assid, stuId));
            }
        }

        /*for all in result, add to returned course list
        for (int index = 0; index < result.size(); index++)
        {
        Grade grade = null;
        try
        {
        Integer assId = (Integer)result.get(index).get(0);
        Integer accId = (Integer)result.get(index).get(1);
        //We do not like null
        if(assId != null && accId != null)
        {
        grade = new Grade(assId, accId);
        }
        }
        catch (Exception ex)
        {
        Logger.getLogger(Course.class.getName()).log(Level.SEVERE,
        "Error msg TBD", ex);
        }
        /*avoid null pointer exceptions and fetch is successful
        if (grade != null && grade.fetch())
        {
        assgns.add(grade);
        }
        }*/

        return assgns;

    }

    /**
     * static method addGrade saves new grade to the database
     * @param sStudent student whom owns it
     * @param sAssignment assignment who is owned by it
     * @param sGrade the value
     * @return true if no errors
     * @author vgerdin
     */
    public static boolean addGrade(Student sStudent, Assignment sAssignment,
            float sGrade)
    {
        boolean ret = false;
        Grade temp = new Grade(sAssignment, sStudent);
        String query = "INSERT INTO Grades (accountId, assignId, grade) ";
        query += "VALUES (" + sStudent.getId() + ",";
        query += sAssignment.getId() + "," + sGrade + ")";
        StorageConnection conn = new StorageConnection();
        ret = conn.updateQuery(query);
        conn.close();
        return ret;
    }

    /**
     * static method deleteGrade permanantly removes a grade from the database
     * @param sStudent student whom owns this grade
     * @param sAssignment assignment owned by this grade
     * @return true if no errors
     * @author vgerdin
     */
    public static boolean deleteGrade(Student sStudent, Assignment sAssignment)
    {
        boolean ret = false;
        String query = "DELETE FROM Grades WHERE accountId = " 
                + sStudent.getId() + " AND assignId = " + sAssignment.getId();
        StorageConnection conn = new StorageConnection();
        ret = conn.updateQuery(query);
        conn.close();
        return ret;
    }

    /**
     * save stores this current instance in database
     * @return true if successfull, else false
     * @author bluGoo
     */
    public boolean save()
    {
        boolean ret = false;
        /*if id is null we a creating a new course*/
        /*if(this.getId() == null)
        {
        ret = this.saveWithoutId();
        }*/
        /*if we have an id set, we are updating*/
        //else
        //{
        ret = this.saveWithId();
        //}
        return ret;
    }

    /**
     * save method if we don't have id set
     * @return true if no error
     */
    /*private boolean saveWithoutId()
    {
    StorageConnection conn = new StorageConnection();
    boolean ret = false;
    
    String query = "INSERT INTO Courses (title, department, number, section) " 
    + "VALUES (\"" + this.getTitle() + "\",\"" + this.getDepartment() 
    + "\",\"" + this.getNumber() + "\",\"" + this.getSection() + "\")";
    ret = conn.updateQuery(query);
    /*if we failed to update, discontinue//
    if(!(ret))
    {
    return ret;
    }
    query = "SELECT max(id) FROM Courses";
    ArrayList<ArrayList<Object>> result = conn.query(query);
    conn.close();
    //if result is empty so is Courses//
    if(result.isEmpty())
    {
    return false;
    }
    ret = this.setId((Integer)result.get(0).get(0));
    return ret;
    }*/
    /**
     * save method if we have id set
     * @return true if no error
     * @author bluGoo
     */
    private boolean saveWithId()
    {
        StorageConnection conn = new StorageConnection();
        boolean ret = false;

        String query = "SELECT assignId FROM Grades ";
        query += "WHERE assignId = " + this.getAssignment().getId();
        query += " AND accountId = " + this.getStudent().getId();

        ArrayList<ArrayList<Object>> result = conn.query(query);
        /*if for some reason id does not exist in db we insert*/
        if (result.isEmpty())
        {
            query = "INSERT INTO Grades (assignId, grade, accountId) " 
                    + "VALUES (\"" + ((Integer) this.getAssignment().getId()) 
                    + "\", \"" + this.getGrade() + "\",\"" 
                    + ((Integer) this.getStudent().getId()) + "\")";
            ret = conn.updateQuery(query);
        } /*if id does exist we update*/ 
        else
        {
            query = "UPDATE Grades SET grade = " + this.getGrade();
            query += " WHERE assignId = " + this.getAssignment().getId();
            query += " AND accountId = " + this.getStudent().getId();
            ret = conn.updateQuery(query);
        }
        conn.close();
        return ret;
    }

    /**
     * Compare to other objects
     * 
     * @param in grade to compare.
     * @return a negative integer, zero, or a positive integer as this object 
     * is less than, equal to, or greater than the specified object. 
     * @author bluGoo
     */
    public int compareTo(Grade in)
    {
        return this.getGrade().compareTo(in.getGrade());
    }

    /**
     * Returns a list of all grades for a student in a course
     * @param course Course object to which the assignment belongs
     * @param student Student object to which the assignment belongs
     * @param graded 1 only graded, -1 only non graded, 0 both.
     * @return ArrayList of Grades in course and object, null if not found
     * @author pphu
     */
    public static ArrayList<Grade> getGrades(Course course, 
      Student student, Integer graded)
    {
        ArrayList<Grade> toReturn = new ArrayList();
        StorageConnection conn = new StorageConnection();
        
        String query = makeQuery(graded, course, student);
        
        
       
        ArrayList<ArrayList<Object>> result = conn.query(query);
        //Set toReturn to null if there is no result
        if(result == null || result.isEmpty())
        {
            toReturn = null;
        }
        else
        {
            //Adds every assignment found into the list
            for(ArrayList<Object> ass : result)
            {
                Integer assId = (Integer) ass.get(0);
                try
                {
                    toReturn.add(new Grade(assId, student.getId()));
                } 
                catch (Exception ex)
                {
                    Logger.getLogger(Grade.class.getName()).log(Level.SEVERE,
                            null, ex);
                }

            }
        }
        
        //Checks again if there is nothing, might not be needed
        if(toReturn != null && toReturn.isEmpty())
        {
            toReturn = null;
        }
        
        conn.close();
        return toReturn;
    }
    
    private static String makeQuery(Integer graded, Course course, Student student)
    {
        String query = null;
        
        //Sees which query is to be made
        switch(graded)
        {
            case -1: //only nongraded grades
                query = "SELECT id FROM Assignments WHERE courseId = ";
                query += course.getId();
                query +=" EXCEPT SELECT assignId FROM Grades WHERE accountId";
                query += " = " + student.getId();
                
                break;
            case 0: //all assignments in the course
                query = "SELECT id FROM Assignments WHERE courseId = ";
                query += course.getId();
                break;
            case 1://only graded grades
                query = "SELECT assignId from Grades where accountId = ";
                query += student.getId();
                query += " INTERSECT SELECT id FROM Assignments";
                query += " WHERE courseId = " + course.getId();
                break;
            default:
                query = null;
                break;
        }
        return query;
    }

    /**
     * Calculate and return list of required results 
     * in order for student to recieved specified grade
     * @param course Course object in which we want to predict the grade
     * @param student Student object whos grade we want to predics
     * @param grade grade we want
     * @return a list of required results to get wished grade
     * @author vgerdin
     */
    public static ArrayList<Grade> predictGrades(Course course, 
      Student student, Float grade)
    {
        //return variable
        ArrayList<Grade> minimum = null;
        //list of all grades for that student in that course
        ArrayList<Grade> all = Grade.getGrades(course, student, 0);
        //list of the ungraded grades
        ArrayList<Grade> ungraded = new ArrayList<Grade>(); 

        //counter of total points available
        Integer totals = 0;
        //counter of total points for graded points, ie no longer available
        Integer gradedTotals = 0;
        //counter of assigned points
        Float achieved = 0F;
        //how many points needed for the wished grade
        Float needed = 0F;

        //no null pointers, ie there are no assignments
        if(all != null)
        {
            //for all assignments (grades) in the class 
            for(Grade gradeIndxI : all)
            {
                //increment total points
                totals += gradeIndxI.getAssignment().getTotal();
                //if graded, ie the assignment is graded and no longer available
                if(gradeIndxI.isGraded())
                {
                    //increment achieved points
                    achieved += gradeIndxI.getGrade();
                    //increment the number of graded totals
                    gradedTotals += gradeIndxI.getAssignment().getTotal();
                }
                //if not graded
                else
                {
                    //add the Grade to list of ungraded
                    ungraded.add(gradeIndxI);
                }
            }

            //needed points are a set of the total points 
            //minus the ones already achieved
            needed = (grade * totals) - achieved;

            //continue iff needed is less than totals left
            if(needed <= (totals - gradedTotals))
            {
                int indx = 0; //iterative index
                //continue as long as there are still points needed
                while(needed > 0F)
                {
                    Grade current = ungraded.get(indx);
                    //if an assignment is lower than
                    //its maximum (can't get more than max)
                    if(current.getGrade() < current.getAssignment().getTotal())
                    {
                        //increment grade
                        current.gradeStudent(current.getGrade() + 1F);
                        //decrement needed
                        needed = needed - 1F;
                    }
                    //increment indx and go back to beginning if out of bounds
                    indx = ((indx + 1) % ungraded.size());
                }
                //assign list of needed grade (ungraded) to return variable (minimum)
                minimum = ungraded;
            }
        }
        //if there are assignments and the grade is reachable, a list is returned
        //else null is returned
        return minimum;
    }

    /**
     * Set whether this graded is graded or not
     * @param set what to set this.graded to
     * @return true if no errors
     * @author vgerdin
     */
    public boolean setGraded(Boolean set)
    {
        boolean ret = false;
        /* Assignment graded only if input value exists */
        if(set != null)
        {
            this.graded = set;
            ret = true;
        }
        return ret;
    }

    /**
     * Check whether this grade is graded
     * @return true if graded, false otherwise
     * @author vgerdin
     */
    public Boolean isGraded()
    {
        return this.graded;
    }

    /**
     * Update a grade, a simple wrapper for gradeStudent and save
     * @param newGrade object, the new grade
     * @return true if successfull save, false if null input or failed save
     * @author vgerdin
     */
    public boolean updateGrade(Float newGrade)
    {
        boolean ret = false;
        ret = this.gradeStudent(newGrade);
        //if newGrade was added successfully
        if(ret)
        {
            ret = this.save();
        }
        return ret;
    }
    
    /**
     * get percentage, grade / ass.max
     * @return String of percentage
     */
    public String getPercentage()
    {
        Float ret = 0F;
        ret = this.getGrade() / new Float(this.getAssignment().getTotal());
        return NumberFormat.getPercentInstance().format(ret);
    }
    
    /**
     * getGraded is a getter for Boolean graded, this might
     * break some naming conventions however jsp does not
     * work with only an "isGraded"
     * @return this.graded
     */
    public Boolean getGraded()
    {
        return this.graded;
    }

}
