/**
 * This class keeps information about Courses
 *
 * @author
 * @version
 */
public class Course implements Storage
{
    /** The grading rules for the Course */
    private int gradingRules;
    
    /** The Course's title */
    private String courseTitle;
    
    /** The Course's section */
    private short courseSection;
    
    /** The Course's number */
    private int courseNumber;
    
    /** An array of Students who are enrolled in the Course */
    private Student students[];
    
    /** An array of Teacher Assistants who are associated with the Course */
    private TeacherAssistant assistants[];
}
