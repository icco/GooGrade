import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class keeps information about Courses
 *
 * @author bluGoo
 * @version 0.42
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

	@Override
	public ArrayList<Object> buildArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> buildArray(Comparator condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Object in) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Object> selectFrom(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
