package goograde;

/**
 * Grade holds a specific grade for bewteen an assignment and student.  
 * @author kblizard and nwelch
 */
public class Grade 
{
    private Student student;
    private Assignment assignment;
    private Course course;
    private float grade;

    /**
     * Constructor for Grade class
     * @param crse the course this grade is from
     * @param ass teh assignment this grade is from
     * @param aThis the student is grade is for
     */
    public Grade(Course crse, Assignment ass, Student aThis)
    {
        student = aThis;
        assignment = ass;
        course = crse;
    }
    
    /**
     * Empty Constructor for Grade. Not to be used.
     */
    public Grade()
    {
        
    }

    /**
     * gradeStudent gives a grade to a specific student.
     * @param theGrade the grade the student will receive
     * @return true if grading is successful
     */
    public boolean gradeStudent(float theGrade)
    {
        grade = theGrade;
        return true;
    }
    /**
     * getGrade retrieves the grade for this student and assignment
     * @return the grade received
     */
    public Float getGrade()
    {
        return grade;
    }
    
    /**
     * getAssignment returns the assignment this grade belonged to
     * @return the Assignment
     */
    public Assignment getAssgn()
    {
        return assignment;
    }
    
    /**
     * getStudent returns the student this grade is for
     * @return the Student
     */
    public Student getStudent()
    {
        return student;
    }
    
    /**
     * getCourse returns the course this grade is from.
     * @return the Course
     */
    public Course getCourse()
    {
        return course;
    }
    
    /**
     * toString returns the grade in the form of a string
     * @return the String version of the grade. 
     */
    @Override
    public String toString()
    {
        return this.getGrade().toString();
    }

}
