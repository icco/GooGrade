package GooGrade;

import java.util.*;
import java.lang.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Does all of the work on the Assignment, it is the controller. 
 * We haven't really speced out what this is going to do yet.
 *
 * @author bluGoo
 * @version 0.42
 */
public class AssignmentController extends HttpServlet
{

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }

    /**
     * More of a concept than anything.
     */
    public void buildMetrics()
    {
        return;
    }

    /**
     * Give a student a grade for this assignment.
     * @return false if fail, true if pass
     */
    public boolean gradeStudent(Student stu)
    {
        return false;
    }
}

