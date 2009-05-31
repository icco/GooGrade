package goograde;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains the static methods used to produce any type of Metric.
 * Charts will be created using the Google Charts API.
 * For more infomation, see http://code.google.com/apis/chart/
 * 
 * @author pphu
 * @version 0.2
 */

public final class Metrics
{
    //Base URL for accessing Google Chart API
    private static String baseURL = "http://chart.apis.google.com/chart?cht=bvs&chs=";
     /**
     * Using Google Charts API, a bar graph representing each possible letter grade
     * will be producded where the floor percent values taken from what the teacher has set
     * @param course the Course to get the distribution
     * @param graphWidth the desired width of the bar graph
     * @param graphHeight the desired height of the bar graph
     * @param barWidth the desired width of the bars
     * @return a String representing the link to the Google image
     */
    public static String gradeDistroBars( Course course, int graphWidth, 
                                          int graphHeight, int barWidth)
    {
        int index = 4; // the number of grades including 0 totals to 5
        String toReturn = "";
        ArrayList<Integer> distro = gradeDistroInts(course);
        
        //adds the baseURL of Google api
        toReturn += baseURL;
        
        //Adds the graph dimensions as width x height
        toReturn += graphWidth + "x" + graphHeight;
        
        //Adds each value in the order of F, D, C, B and then A
        toReturn += "&chd=t:" + distro.get(index--) + "," + distro.get(index--) 
                    + "," + distro.get(index--) + "," + distro.get(index--) 
                    + "," + distro.get(index--);
        
        //Adds the color Black (000000) and then sets the range of the values [0, 100]
        toReturn += "&chco=000000&chbh=50&chds=0,100";
        
        return toReturn;
                
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
        int index = 4; // the number of grades including 0 totals to 5
        String toReturn = "";
        ArrayList<Integer> distro = assignmentGradeDistroInts(ass);
        
        //adds the baseURL of Google api
        toReturn += baseURL;
        
        //Adds the graph dimensions as width x height
        toReturn += graphWidth + "x" + graphHeight;
        
        //Adds each value in the order of F, D, C, B and then A
        toReturn += "&chd=t:" + distro.get(index--) + "," + distro.get(index--) 
                    + "," + distro.get(index--) + "," + distro.get(index--) 
                    + "," + distro.get(index--);
        
        //Adds the color Black (000000) and then sets the range of the values [0, 100]
        toReturn += "&chco=000000&chbh=50&chds=0,100";
        
        
        return toReturn;
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
        ArrayList<Student> students = course.getRoster();
        Integer[] distro = {0, 0, 0, 0, 0};
        rules.add(-1); //adds F to the list, which is a floor of -1 to count for 0's
        ArrayList<Integer> toReturn;
        
        /*
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
        }*/
        /*
         * Checks to see the grade is greater than the floor of the letter grade
         * */
        for(Student stu: students)
        {
            float currentGrade = stu.getCurrentGrade(course);
            for(int i = 0; i < distro.length; i++)
            {
                if(currentGrade > (float)rules.get(i))
                {
                    distro[i]++;
                }
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
        ArrayList<Integer> rules = new ArrayList<Integer>();
        rules.add(90);//Adding A floor
        rules.add(80);//Adding B floor
        rules.add(70);//Adding C floor
        rules.add(60);//Adding D floor
        rules.add(0);//Adding F floor
        
        /*
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
        }*/
        /*
         * Checks to see the grade is greater than the floor of the letter grade
         * */
        for( Grade grade : grades)
        {
            float currentGrade = grade.getGrade();
            for(int i = 0; i < distro.length; i++)
            {
                if(currentGrade > (float)rules.get(i))
                {
                    distro[i]++;
                }
            }
        }
        
        toReturn = new ArrayList<Integer>( Arrays.asList( distro) );
        
        return toReturn;
        
    }
}
