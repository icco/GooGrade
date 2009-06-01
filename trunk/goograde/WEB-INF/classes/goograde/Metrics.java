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
    private static String baseURL = "http://chart.apis.google.com/chart?";

     /**
     * Using Google Charts API, pie representing each possible letter grade
     * will be producded where the floor percent values taken from what the teacher has set
     * @param course the Course to get the distribution
     * @param graphWidth the desired width of the pie chart
     * @param graphHeight the desired height of the pie chart
     * @param barWidth the desired width of the bars
     * @return a String representing the link to the Google image
     */
    public static String gradeDistroPie( Course course, int graphWidth, 
                                          int graphHeight, int barWidth)
    {
        int index = 0; // the number of grades including 0 totals to 5
        String toReturn = "";
        ArrayList<Integer> distro = gradeDistroInts(course);
        
        //adds the baseURL of Google api
        toReturn += baseURL;
        
        //Adds that it is going to be a pie chart
        toReturn += "cht=p";
        
        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;
        
        //Adds each value in the order of F, D, C, B and then A
        toReturn += "&chd=t:" + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index);
        
        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=50&chds=0,100";
        
        index = 0;
        
        //Adds the labels for each respective section
        toReturn += "&chl=A (" + distro.get(index++) + ")";
        toReturn += "|B (" + distro.get(index++) + ")";
        toReturn += "|C (" + distro.get(index++) + ")"; 
        toReturn += "|D (" + distro.get(index++) + ")";
        toReturn += "|F (" + distro.get(index) + ")";
        
        return toReturn;
        
    }
    
    
    
     /**
     * Using Google Charts API, pie representing each possible letter grade
     * will be producded where the floor percent values taken from what the teacher has set
     * @param course the Course to get the distribution
     * @param graphWidth the desired width of the pie chart
     * @param graphHeight the desired height of the pie chart
     * @param barWidth the desired width of the bars
     * @return a String representing the link to the Google image
     */
    public static String gradeCourseCurvePie( Course course, int graphWidth, 
                                          int graphHeight, int barWidth)
    {
        int index = 0; // the number of grades including 0 totals to 5
        String toReturn = "";
        ArrayList<Integer> distro = gradeDistroInts(course);
        
        //adds the baseURL of Google api
        toReturn += baseURL;
        
        //Adds that it is going to be a pie chart
        toReturn += "cht=p";
        
        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;
        
        //Adds each value in the order of F, D, C, B and then A
        toReturn += "&chd=t:" + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index);
        
        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=50&chds=0,100";
        
        index = 0;
        
        //Adds the labels for each respective section
        toReturn += "&chl=A (" + distro.get(index++) + ")";
        toReturn += "|B (" + distro.get(index++) + ")";
        toReturn += "|C (" + distro.get(index++) + ")"; 
        toReturn += "|D (" + distro.get(index++) + ")";
        toReturn += "|F (" + distro.get(index) + ")";
        
        return toReturn;
        
    }
    
    
    
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
        int index = 0; // the number of grades including 0 totals to 5
        String toReturn = "";
        ArrayList<Integer> distro = gradeDistroInts(course);
        
        //adds the baseURL of Google api
        toReturn += baseURL;
        
        //Adds that it is going to be a bar veritcal stacked graph
        toReturn += "cht=bvs";
        
        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;
        
        //Adds each value in the order of F, D, C, B and then A
        toReturn += "&chd=t:" + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index);
        
        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=50&chds=0,100";
        
        index = 0;
        
        //Adds the labels for each respective section
        toReturn += "&chl=A (" + distro.get(index++) + ")";
        toReturn += "|B (" + distro.get(index++) + ")";
        toReturn += "|C (" + distro.get(index++) + ")"; 
        toReturn += "|D (" + distro.get(index++) + ")";
        toReturn += "|F (" + distro.get(index) + ")";
        
        return toReturn;
                
    }

    /**
     * Using Google Charts API, a bar graph representing each possible letter grade
     * will be producded where the floor percent values are A = 90%, B = 80%, C = 70% , 
     * D = 60%  and F = anything less than 60%
     * @param ass the Assignment to get the distribution
     * @param graphWidth the desired width of the bar graph
     * @param graphHeight the desired height of the bar graph
     * @param barWidth the desired width of the bars
     * @return a String representing the link to the Google image
     */
    public static String assignmentGradeDistroBars( Assignment ass, int graphWidth, 
                                                    int graphHeight, int barWidth)
    {
        int index = 0; // the number of grades including 0 totals to 5
        String toReturn = "";
        ArrayList<Integer> distro = assignmentGradeDistroInts(ass);
        ArrayList<Integer> rules = new ArrayList();
        
        //adds the baseURL of Google api
        toReturn += baseURL;
        
        //Adds that it is going to be a bar veritcal stacked graph
        toReturn += "cht=bvs";
        
        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;
        
        //Adds each value in the order of F, D, C, B and then A
        toReturn += "&chd=t:" + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index++);
        toReturn += "," + distro.get(index);
        
        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=50&chds=0,100";
        
        index = 0;
        
        //Adds the labels for each respective section
        toReturn += "&chl=A (" + distro.get(index++) + ")";
        toReturn += "|B (" + distro.get(index++) + ")";
        toReturn += "|C (" + distro.get(index++) + ")"; 
        toReturn += "|D (" + distro.get(index++) + ")";
        toReturn += "|F (" + distro.get(index) + ")";
        
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
        GradingRules gradingRules = new GradingRules(course.getGradingRulesId());
        ArrayList<Integer> rules = new ArrayList();
        rules = gradingRules.getRules();
        ArrayList<Student> students = course.getRoster();
        Integer[] distro = {0, 0, 0, 0, 0};
        rules.add(-1); //adds F to the list, which is a floor of -1 to count for 0's
        ArrayList<Integer> toReturn = null;
        
        /*
         * Checks to see the grade is greater than the floor of the letter grade
         */
        if(!rules.isEmpty())
        {
            for(Student stu : students)
            {
                float currentGrade = 0;
                currentGrade += stu.getCurrentGrade(course);
                for(int i = 0; i < distro.length; i++)
                {
                    if(currentGrade >= (float)rules.get(i))
                    {
                        System.out.println("Rule " + rules.get(i) + "    currentGrade " + currentGrade);
                        distro[i]++;
                        i = distro.length;
                    }
                }
            }
        
        
            toReturn = new ArrayList<Integer>( Arrays.asList( distro) );
        }
        
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
