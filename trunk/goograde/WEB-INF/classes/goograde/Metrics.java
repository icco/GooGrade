package goograde;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * This class contains the static methods used to produce any type of Metric.
 * Charts will be created using the Google Charts API.
 * 
 * @author pphu
 * @version 0.1
 */

public final class Metrics
{
     /**
     * Using Google Charts API, a bar graph representing each possible letter grade
     * will be producded where the floor percent values taken from what the teacher has set
     * @param course the Course to get the distribution
     * @param graphWidth the desired width of the bar graph
     * @param graphHieght the desired height of the bar graph
     * @param barWidth the desired width of the bars
     * @return a String representing the link to the Google image
     */
    public static String gradeDistroBars( Course course, int graphWidth, 
                                          int graphHeight, int barWidth)
    {
        ArrayList<Integer> distro = gradeDistroInts(course);
        
        return "http://chart.apis.google.com/chart?cht=bvs&chs=" + graphWidth +
                "x" + graphHeight + "&chd=t:" + distro.get(4) + "," +
                distro.get(3) + "," + distro.get(2) + "," +
                distro.get(1) + "," + distro.get(0) + 
                "&chco=000000&chbh=50&chds=0,100";
    }

    /**
     * Using Google Charts API, a bar graph representing each possible letter grade
     * will be producded where the floor percent values are A = 90%, B = 80%, C = 70% , 
     * D = 60%  and F = anything less than 60%
     * @param ass the Assignment to get the distribution
     * @param graphWidth the desired width of the bar graph
     * @param graphHieght the desired height of the bar graph
     * @param barWidth the desired width of the bars
     * @return a String representing the link to the Google image
     */
    public static String assignmentGradeDistroBars( Assignment ass, int graphWidth, 
                                                    int graphHeight, int barWidth)
    {
        ArrayList<Integer> distro = assignmentGradeDistroInts(ass);
        
        return "http://chart.apis.google.com/chart?cht=bvs&chs=" + graphWidth +
                "x" + graphHeight + "&chd=t:" + distro.get(4) + "," +
                distro.get(3) + "," + distro.get(2) + "," +
                distro.get(1) + "," + distro.get(0) + 
                "&chco=000000&chbh=50&chds=0,100";
    }
    
    /**
     * Produces an ArrayList of the distribution of grades in the course.
     * Letter grade is in the order of A, B, C, D.   
     * @param course the course to get the distribution from
     * @return the int value of how many students are receiving what A, B, C, and D 
     */
    private static ArrayList<Integer> gradeDistroInts(Course course)
    {
        GradingRules gradingRules = new GradingRules();
        ArrayList<Integer> rules;
        rules = gradingRules.getRules();
        ArrayList<Student> students = Student.allStudents();
        Integer[] distro = {0, 0, 0, 0, 0};
        ArrayList<Integer> toReturn;
        /*
         * Checks to see the grade is greater than the floor of the letter grade
         * */
        for( Student stu : students)
        {
            float currentGrade = stu.getCurrentGrade(course);
            if(currentGrade > rules.get(0)) //is greater than A's floor
            {
                distro[0]++;
            }
            else if(currentGrade > rules.get(1)) //is greater than B's floor
            {
                distro[1]++;
            }
            else if(currentGrade > rules.get(2)) //is greater than C's floor
            {
                distro[2]++;
            }
            else if(currentGrade > rules.get(3)) //is greater than D's floor
            {
                distro[3]++;
            }
            else // is F :(
            {
                distro[4]++;
            }
        }
        toReturn = new ArrayList<Integer>( Arrays.asList( distro) );
        
        return toReturn;
        
    }
    
     /**
     * Produces an ArrayList of the distribution of grades in the Assignment.
     * Letter grade is in the order of A, B, C, D.   
     * @param course the course to get the distribution from
     * @return the int value of how many students are receiving what A, B, C, and D 
     */
    private static ArrayList<Integer> assignmentGradeDistroInts(Assignment assignment)
    {
        ArrayList<Grade> grades = assignment.getGrades();
        Integer[] distro = {0, 0, 0, 0, 0};
        ArrayList<Integer> toReturn;
        
        for( Grade grade : grades)
        {
            float currentGrade = grade.getGrade();
            if(currentGrade >= 90.0) //is greater than A's floor
            {
                distro[0]++;
            }
            else if(currentGrade >= 80.0) //is greater than B's floor
            {
                distro[1]++;
            }
            else if(currentGrade >= 70.0) //is greater than C's floor
            {
                distro[2]++;
            }
            else if(currentGrade >= 60.0) //is greater than D's floor
            {
                distro[3]++;
            }
            else // is F :(
            {
                distro[4]++;
            }
        }
        toReturn = new ArrayList<Integer>( Arrays.asList( distro) );
        
        return toReturn;
        
    }
}
