package GooGrade;

import java.util.*;
import java.lang.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a controller for teacher. It should be noted that controllers work by
 * running doPost or something similiar, then calling a function which then calls
 * the model.
 *
 * @author bluGoo
 * @version 0.42
 */
public class TeacherController extends AccountController
{

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }

    
    /**
     * editCourse asks for information from the user and updates the Course with it
     * @return the new, edited Course
     */
    public Course editCourse(Course course)
    {
        return course;
    }

    /**
     * removeCourse marks a course for deletion. 
     * @return true if no errors occur
     */
    public boolean removeCourse(Course course)
    {
        return true;
    }

    /** 
     * createAnnouncement gathers information from the user to make a new Announcement with
     * @param which The course to add an announcement for.
     * @return the new, created Announcement.
     */
    public Announcement createAnnouncement(Course which)
    {
        return new Announcement();
    }

    /**
     * gradeStudent adjusts information in a Student specified by the user
     * @param who the Student to be graded.
     */
    public boolean gradeStudent(Student who)
    {
        return false;
    }

    /**
     * createUser creates a new Account based on the user's preferences. 
     * If a Teacher Assistant is being created, their permissions may be given. 
     * The new account will be stored in userStorage until they are given a Course, if none specified. 
     * @return the created Account
     */
    public Account createUser()
    {
        return null;
    }

    /**
     * removeUser removes a User from a Course. If the user is not on any remaining courses, the account is marked for deletion
     * @return the Account removed
     */
    public Account removeUser(Account user)
    {
        return null;
    }

    /**
     * editUser provides overhead for Teacher to edit User information
     * @return the Account that was edited
     */
    public Account editUser()
    {
        return null;
    }

    /**
     * createAssignment creates a new Assignment with the Teacher's specifications. 
     * @return the new Assignment
     */
    public Assignment createAssignment()
    {
        return null;
    }

    /**
     * editAssignment changes the information in the Assignment to fit the Teacher's preferences.
     * @return the modified Assignment
     */
    public Assignment editAssignment()
    {
        return null;
    }

    /**
     * deleteAssignment marks an Assignment for removal from the system
     * @return the Assignment deleted
     */
    public Assignment deleteAssignment()
    {
        return null;
    }

    /** 
     * adjustCruve modifies the GradingRules to a specific Course
     * @return the GradingRules that were modified
     */
    public GradingRules adjustCurve()
    {
        return null;
    }

    /**
     * takeAttendance adjusts the Participation portion of a grade for Students
     * @return true if no errors occurred
     */
    public boolean takeAttendance()
    {
        return false;
    }
}