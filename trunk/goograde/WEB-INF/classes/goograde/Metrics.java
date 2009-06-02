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
    private static String letters[] = { "A (", "B (", "C (", "D (", "F ("};

    /**
     * To satisfy Checkstyle
     */
    private Metrics()
    {
    }

    /**
     * Using Google Charts API, pie representing each possible letter grade
     * will be producded where the floor percent values taken from what 
     * the teacher has set
     * @param course the Course to get the distribution
     * @param graphWidth the desired width of the pie chart
     * @param graphHeight the desired height of the pie chart
     * @return a String representing the link to the Google image
     */
    public static String gradeDistroPie(Course course, int graphWidth,
            int graphHeight)
    {
        int length, length2;
        String toReturn = "";
        String toReturn2 = "";
        ArrayList<Integer> distro = gradeDistroInts(course);

        //adds the baseURL of Google api
        toReturn += baseURL;

        //Adds that it is going to be a pie chart
        toReturn += "cht=p";

        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;

        toReturn += "&chd=t:";
        
        toReturn2 += "&chl=";
        
        length = toReturn.length();
        length2 = toReturn2.length();
        
        
        //Adds each value in the order of F, D, C, B and then A
        for (int index = 0; index < distro.size(); index++)
        {
            //Adds only if there is a student that falls inside this letter
            if (distro.get(index) != 0)
            {
                //Adds the | needed and not at the beginning
                if(toReturn2.length() > length2)
                {
                    toReturn2 += "|";
                }
                
                //Adds the | needed and not at the beginning
                if(toReturn.length() > length)
                {
                    toReturn += ",";
                }
                toReturn += distro.get(index);
                toReturn2 += letters[index] + "" + distro.get(index) + ")";
            }
        }

        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=50&chds=0,100";
        toReturn += toReturn2 + "&chco=0044FF&chf=bg,s,65432100";
        toReturn += "&chtt=Current+Grade+Distribution";

        return toReturn;

    }

    /**
     * Using Google Charts API, pie representing each possible letter grade
     * will be producded where the floor percent values taken from what the
     * teacher has set
     * @param course the Course to get the distribution
     * @param graphWidth the desired width of the pie chart
     * @param graphHeight the desired height of the pie chart
     * @return a String representing the link to the Google image
     */
    public static String gradeCourseCurvePie(Course course, int graphWidth,
            int graphHeight)
    {
        int length, length2; // the number of grades including 0 totals to 5

        String toReturn = "";
        String toReturn2 = "";
        GradingRules gradingRules = new GradingRules(course.getGradingRulesId());
        ArrayList<Integer> rules = new ArrayList();
        rules = gradingRules.getRules();
        rules.add(-1);
        final int aFloor = 100;
        //adds the baseURL of Google api
        toReturn += baseURL;

        //Adds that it is going to be a pie chart
        toReturn += "cht=p";

        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;
        
        toReturn += "&chd=t:";

        //Adds each value in the order of F, D, C, B and then A
        toReturn2 += "&chl=";


        length = toReturn.length();
        length2 = toReturn2.length();
        

        //Adds each value in the order of F, D, C, B and then A
        for (int index = 0; index < rules.size(); index++)
        {
            //Adds only if there is a student that falls inside this letter
            if (rules.get(index) != 0)
            {
                //Adds the | needed and not at the beginning
                if(toReturn2.length() > length2)
                {
                    toReturn2 += "|";
                }
                
                //Adds the | needed and not at the beginning
                if(toReturn.length() > length)
                {
                    toReturn += ",";
                }
                if(index == 4)
                {
                    toReturn += rules.get(index - 1) - rules.get(index);
                    toReturn2 += "F";
                }
                else if(index > 0)
                {
                    toReturn += rules.get(index - 1) - rules.get(index);
                    toReturn2 += letters[index];
                    toReturn2 += rules.get(index) + "%%2B)";
                }
                else
                {
                    toReturn += aFloor - rules.get(index);
                    toReturn2 += letters[index];
                    toReturn2 += rules.get(index) + "%%2B)";
                }
                
            }
        }

        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=10&chds=0,100";
        toReturn += toReturn2 + "&chco=0044FF&chf=bg,s,65432100";
        toReturn += "&chtt=Current+Grade+Curve";

        return toReturn;

    }

    /**
     * Using Google Charts API, a bar graph representing each possible letter 
     * grade will be producded where the floor percent values taken from what 
     * the teacher has set
     * @param course the Course to get the distribution
     * @param graphWidth the desired width of the bar graph
     * @param graphHeight the desired height of the bar graph
     * @param barWidth the desired width of the bars
     * @return a String representing the link to the Google image
     */
    public static String gradeDistroBars(Course course, int graphWidth,
            int graphHeight, int barWidth)
    {

        String toReturn = "";
        String toReturn2 = "";
        ArrayList<Integer> distro = gradeDistroInts(course);
        
        int length, length2;

        //adds the baseURL of Google api
        toReturn += baseURL;

        //Adds that it is going to be a bar veritcal stacked graph
        toReturn += "cht=bvs";

        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;
        
        toReturn += "&chd=t:";
        
        toReturn2 += "&chl=";
        
        length = toReturn.length();
        length2 = toReturn2.length();
        
        
        //Adds each value in the order of F, D, C, B and then A
        for (int index = 0; index < distro.size(); index++)
        {
            //Adds only if there is a student that falls inside this letter
            if (distro.get(index) != 0)
            {
                //Adds the | needed and not at the beginning
                if(toReturn2.length() > length2)
                {
                    toReturn2 += "|";
                }
                
                //Adds the | needed and not at the beginning
                if(toReturn.length() > length)
                {
                    toReturn += ",";
                }
                toReturn += distro.get(index);
                toReturn2 += letters[index] + "" + distro.get(index) + ")";
            }
        }

        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=50&chds=0,100";
        toReturn += toReturn2 + "&chco=0044FF&chf=bg,s,65432100";
        toReturn += "&chtt=Current+Grade+Distribution";

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
    public static String assignmentGradeDistroBars(Assignment ass, int graphWidth,
            int graphHeight, int barWidth)
    {
        int length, length2; // the number of grades including 0 totals to 5

        String toReturn = "";
        String toReturn2 = "";
        ArrayList<Integer> distro = assignmentGradeDistroInts(ass);
        ArrayList<Integer> rules = new ArrayList();

        //adds the baseURL of Google api
        toReturn += baseURL;

        //Adds that it is going to be a bar veritcal stacked graph
        toReturn += "cht=bvs";

        //Adds the graph dimensions as width x height
        toReturn += "&chs=" + graphWidth + "x" + graphHeight;
        
        toReturn += "&chd=t:";

        toReturn2 += "&chl=";
        
        length = toReturn.length();
        length2 = toReturn2.length();
        
        
        //Adds each value in the order of F, D, C, B and then A
        for (int index = 0; index < distro.size(); index++)
        {
            //Adds only if there is a student that falls inside this letter
            if (distro.get(index) != 0)
            {
                //Adds the | needed and not at the beginning
                if(toReturn2.length() > length2)
                {
                    toReturn2 += "|";
                }
                
                //Adds the | needed and not at the beginning
                if(toReturn.length() > length)
                {
                    toReturn += ",";
                }
                toReturn += distro.get(index);
                toReturn2 += letters[index] + "" + distro.get(index) + ")";
            }
        }

        //Adds the range of the values [0 , 100]
        toReturn += "&chbh=50&chds=0,100";
        toReturn += toReturn2 + "&chco=0044FF&chf=bg,s,65432100";
        toReturn += "&chtt=Current+Grade+Distribution";

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
        Integer[] distro =
        {
            0, 0, 0, 0, 0
        };
        rules.add(-1); //adds F to the list, which is a floor of -1 to count for 0's

        ArrayList<Integer> toReturn = null;

        /*
         * Checks to see the grade is greater than the floor of the letter grade
         */
        if (!rules.isEmpty())
        {

            //For every Student it will add a tally to the correct letter
            for (Student stu : students)
            {
                float currentGrade = 0;
                currentGrade += stu.getCurrentGrade(course);


                //Checks if the currentGrade grade is in a letter range defined 
                //by gradingRules
                for (int index = 0; index < distro.length; index++)
                {
                    //if greater than or eqal to the grade rule
                    if (currentGrade >= (float) rules.get(index))
                    {
                        distro[index]++;
                        index = distro.length;
                    }
                }
            }


            toReturn = new ArrayList<Integer>(Arrays.asList(distro));
        }

        return toReturn;

    }

    /**
     * Produces an ArrayList of the distribution of grades in the Assignment.
     * Letter grade is in the order of A, B, C, D.   
     * @param assignment the assignment to get the distribution from
     * @return the int value of how many students are receiving what A, B, C, and D 
     */
    private static ArrayList<Integer> assignmentGradeDistroInts(Assignment assignment)
    {
        ArrayList<Grade> grades = assignment.getGrades();
        Integer[] distro =
        {
            0, 0, 0, 0, 0
        };
        ArrayList<Integer> toReturn;
        ArrayList<Integer> rules = new ArrayList<Integer>();
        final int aFloor = 90;
        final int bFloor = 80;
        final int cFloor = 70;
        final int dFloor = 60;
        final int fFloor = 0;

        rules.add(aFloor); //Adding A floor

        rules.add(bFloor); //Adding B floor

        rules.add(cFloor); //Adding C floor

        rules.add(dFloor); //Adding D floor

        rules.add(fFloor); //Adding F floor

        /*
         * Checks to see the grade is greater than the floor of the letter grade
         * */
        for (Grade grade : grades)
        {
            float currentGrade = grade.getGrade();
            for (int index = 0; index < distro.length; index++)
            {
                if (currentGrade > (float) rules.get(index))
                {
                    distro[index]++;
                }
            }
        }

        toReturn = new ArrayList<Integer>(Arrays.asList(distro));

        return toReturn;

    }
}
