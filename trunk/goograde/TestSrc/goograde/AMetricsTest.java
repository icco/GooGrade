/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goograde;

import junit.framework.TestCase;

/**
 *
 * @author kblizard
 */
public class AMetricsTest extends TestCase 
    {
    
    public AMetricsTest(String testName) 
    {
        super(testName);
    }            

    @Override
    protected void setUp() throws Exception 
    {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception 
    {
        super.tearDown();
    }

    /**
     * Test of gradeDistroPie method, of class Metrics.
     * 
     */
    public void testGradeDistroPie()
    {
        System.out.println("gradeDistroPie");
        Course course = new Course(1);
        int graphWidth = 100;
        int graphHeight = 100;
        int barWidth = 100;
        String expResult = "http://chart.apis.google.com/chart?cht=p&chs=" +
                "100x100&chd=t:1,1,1&chbh=50&chds=0,100&chl=A (1)|C (1)|F " +
                "(1)&chco=0044FF&chf=bg,s,65432100&chtt=" +
                "Current+Grade+Distribution";
        String result = Metrics.gradeDistroPie(course, graphWidth, graphHeight);
        assertEquals(expResult, result);
    }

    /**
     * Test of gradeCourseCurvePie method, of class Metrics.
     */
    public void testGradeCourseCurvePie()
    {
        System.out.println("gradeCourseCurvePie");
        Course course = new Course(1);
        int graphWidth = 100;
        int graphHeight = 100;
        int barWidth = 10;
        String expResult = "http://chart.apis.google.com/chart?cht=p&chs=" +
                "100x100&chd=t:10,10,10,10,61&chbh=10&chds=0,100&chl=" +
                "A (90%%2B)|B (80%%2B)|C (70%%2B)|D (60%%2B)|F&chco=" +
                "0044FF&chf=bg,s,65432100&chtt=Current+Grade+Curve";
        String result = Metrics.gradeCourseCurvePie(course, graphWidth,
                graphHeight);
        assertEquals(expResult, result);
    }

    /**
     * Test of gradeDistroBars method, of class Metrics.
     */
    public void testGradeDistroBars()
    {
        System.out.println("gradeDistroBars");
        Course course = new Course(1);
        int graphWidth = 100;
        int graphHeight = 100;
        int barWidth = 10;
        String expResult = "http://chart.apis.google.com/chart?cht=bvs&chs=" +
                "100x1001,1,1&chbh=50&chds=0,100&chl=A (1)|C (1)|F " +
                "(1)&chco=0044FF&chf=bg,s,65432100";
        String result = Metrics.gradeDistroBars(course, graphWidth, graphHeight,
                barWidth);
        assertEquals(expResult, result);

    }

    /**
     * Test of assignmentGradeDistroBars method, of class Metrics.
     */
    public void testAssignmentGradeDistroBars()
    {
        System.out.println("assignmentGradeDistroBars");
        Assignment ass = new Assignment(1);
        int graphWidth = 100;
        int graphHeight = 100;
        int barWidth = 10;
        String expResult = "http://chart.apis.google.com/chart?cht=bvs&chs=" +
                "100x100&chbh=50&chds=0,100&chl=&chco=0044FF&chf=bg,s,65432100";
        String result = Metrics.assignmentGradeDistroBars(ass, graphWidth,
                graphHeight, barWidth);
        assertEquals(expResult, result);
    }

}
