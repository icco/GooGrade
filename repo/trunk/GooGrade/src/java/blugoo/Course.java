package blugoo;

import java.util.*;
import java.lang.*;

import java.sql.*;

/**
 * This class keeps information about Courses. It's a JavaBean since
 * it implements java.io.Serializable. It too uses StorageConnection
 * to store and get things out of the storage system.
 *
 * @author bluGoo
 * @version 0.42
 */
public class Course implements java.io.Serializable
{
    /** The Course's title */
    private String courseTitle;
    
    /** The Course's section */
    private Integer courseSection;
    
    /** The Course's number */
    private Integer courseNumber;
    
    /** An array of Students who are enrolled in the Course */
    private ArrayList<Student> students;
    
    /** An instance of Teacher Assistant who is associated with the Course */
    private TeacherAssistant assistant;

    /** An instance of Teacher who is teaching the Course*/
    private Teacher teacher;

    /** The set of grade boundaries for this class*/
    private GradingRules scale;

	/**
	 * setGradingRules saves a new Grading Rules over the old.
	 * @param newScale the new grading rules to save
	 * @return true if no errors 
	 */
	public boolean setGradingRules(GradingRules newScale)
	{
		return false;
	}
	
	/**
	 * setTitle saves a new Couse title over the old.
	 * @param newTitle the new title to save
	 * @return true if no errors 
	 */
	public boolean setCourseTitle(String newTitle)
	{
		return false;
	}

	/**
	 * setSection saves a new section number over the old one
	 * @param newSection is the number of the new section to save
	 * @return true if no errors occurred
	 */
	public boolean setCourseSection(short newSection)
	{
		return false;
	}

	/** 
	 * setNumber replaces the course number with a new one
	 * @param newNumber is the new course number to save
	 * @return true if no errors occurred. 
	 */
	public boolean setCourseNumber(int newNumber)
	{
		return false;
	}


	/**
	 * setTeacher sets the Teacher attribute for this course
	 * @param t the Teacher to be assigned to this course
	 * @return true if no error have occured
	 */
	public boolean setTeacher(Teacher t)
	{
		return false;
	}

	/**
	 * setTeacherAssistant sets the TeacherAssistant attribute for this course
	 * @param ta the TeacherAssistant to be assigned to this course
	 * @return true if no error have occured
	 */
	public boolean setTeacherAssistant(TeacherAssistant ta)
	{
		return false;
	}
	
	/**
	 * getTeacher gets the Teacher attribute from this course
	 * @return teacher of this course
	 */
	public Teacher getTeacher()
	{
		return teacher;
	}
	
	/**
	 * getTeacherAssistant gets the TeacherAssistant attribute from this course
	 * @return assistant of this course
	 */
	public TeacherAssistant getTeacherAssistant()
	{
		return assistant; 
	}

	/**
	 * getCourseNumber gets the courseNumber
	 * @return the courseNumber
	 */
	public Integer getCourseNumber()
	{
		return courseNumber; 
	}
	
	/**
	 * getCourseSection gets the courseSection
	 * @return the courseSection
	 */
	public Integer getCourseSection()
	{
		return courseSection; 
	}

	/**
	 * getCourseTitle gets the courseTitle
	 * @return the courseTitle
	 */
	public String getCourseTitle()
	{
		return courseTitle; 
	}
	
	/**
	 * getGradingRules gets the scale attribute for this course 
	 * @return the scale attribute for this course
	 */
	public GradingRules getGradingRules()
	{
		return scale; 
	}

	/**
	 * getStudents gets the students attribute for this course 
	 * @return the students attribute for this course
	 */
	public ArrayList<Student> getStudents()
	{
		return students; 
	}

    /**
	 * addStudent adds a new student to this course.
	 * @param permission the permission of the user who calls this function
	 * @param student the student that is to be added to the course
	 * @return true if no errors were enountered
	 */
	public boolean addStudent(Permissions permission, Student student)
	{
		return false;
	}
    
    /**
	 * removeStudent removes a particular student from the course.
	 * @param permission the permission of the user who calls this function
	 * @param student the student to be removed from this course
	 * @return true if no errors were encountered in removal.
	 */
	public boolean removeStudent(Permissions permission, Student student)
	{
		return false;
	}

	/**
	 * addTA assignes a new TeacherAssistant to this course.
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be assigned to this course
	 * @return true if no errors have occured
	 */
	public boolean addTA(Permissions permission, TeacherAssistant ta)
	{
		return false;
	}

	/**
	 * removeTA removes a TeacherAssistant from this course
	 * @param permission the permission of the user who calls this function
	 * @param ta the TeacherAssistant to be removed to this course
	 * @return true if no errors have occured
	 */
	public boolean removeTA(Permissions permission, TeacherAssistant ta)
	{
		return false;
	}
}
