/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goograde;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import java.io.IOException;
import junit.framework.TestCase;
import org.xml.sax.SAXException;


/**
 *
 * @author kblizard
 */
public class CourseControllerTest extends TestCase 
    {
    
    public CourseControllerTest(String testName) 
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
     * Test of doPost method, of class CourseController.
     */
    public void testDoPost() throws SAXException
    {
       System.out.println("doPost & doGet: Teacher");
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest
                ("http://localhost:8080/GooGrade2.0/teacher/course");

        try
        {
            wc.putCookie("userid", "1");
            WebResponse resp = wc.getResponse(req);
            WebLink link = null;
            WebForm form = null;
            resp = wc.getResponse(req);             // Page to be tested loads
            
            assertEquals("Manage Courses", resp.getTitle());
            form = resp.getForms()[0];              //edit first course
            form.setParameter("action", "edit");
            form.setParameter("title", "SLEEPING");
            form.setParameter("department", "SLE");
            form.setParameter("number", "101");
            form.setParameter("section", "04");
            form.submit();
            wc.getCurrentPage();                    //refresh 
            form = resp.getForms()[1];              //delete first course
            form.setParameter("action", "delete");
            form.setParameter("courseRef", "1");
            form.submit();
            form = resp.getForms()[10];             //add new course
            form.setParameter("action", "add");
            form.setParameter("newCourseTitle", "Napping");
            form.setParameter("newCourseDepartment", "NAP");
            form.setParameter("newCourseNumber", "102");
            form.setParameter("newCourseSection", "05");
            form.submit();
        }
        catch (IOException ex)
        {
            fail("IOException: " + ex);
        } 
        catch (SAXException ex)
        {
            fail("SAXException: " + ex);
        } 
    }

    /**
     * Test of doGet method, of class CourseController.
     */
    /*public void testDoGet()
    {
        testDoPost();
    } */
}
    

   