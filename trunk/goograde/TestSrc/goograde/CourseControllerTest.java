/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goograde;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import junit.framework.TestCase;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.servletunit.ServletUnitClient;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.InvocationContext;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import java.io.File;
//import com.meterware.httpunit.WebResponse;
import java.io.IOException;
//import javax.servlet.ServletException;
import junit.framework.TestCase;
import org.xml.sax.SAXException;
import java.io.FileInputStream;


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
        System.out.println("HTTPUnit: CourseController doPost & doGet driver");
        int aryLoc = -1;
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);

        //WebResponse resp = null;
        WebLink link = null;
        WebForm form = null;
        WebLink linkArray[] = null;
        try
        {
            ServletRunner sr = new ServletRunner(
                    new File("WEB-INF/web.xml"));
            sr.registerServlet("GooGrade/teacher/course",
                CourseController.class.getName() );
            ServletUnitClient sc = sr.newClient();
            
            WebRequest req = new PostMethodWebRequest(  //was GetMethodWebRequest
                "http://localhost:8080/GooGrade/teacher/course");
            
             //WebConversation wc = new WebConversation();
        
            sc.putCookie("userid", "1");
            req.setParameter("newCourseTitle", "Intro to Sleep");
            req.setParameter("newCourseDepartment", "SLP");
            req.setParameter("newCourseNumber", "101");
            req.setParameter("newCourseSection", "04");
            req.setParameter("action", "add");
            
            
                    
            InvocationContext ic = sc.newInvocation( req );
            CourseController ss = (CourseController) ic.getServlet();
            assertNull( "A session already exists", 
                    ic.getRequest().getSession( false ) );
            
            

            ss.doGet( ic.getRequest(), ic.getResponse() );
            assertNotNull( "Session was not created", 
                    ic.getRequest().getSession( false ) );
            assertEquals("Intro to Sleep", 
                    ic.getRequest().getSession()
                    .getAttribute( "newCourseTitle"));

        }
        catch (IOException ex)
        {
            fail("IOException: " + ex);
        }
        catch (SAXException ex)
        {
            fail("SAXException: " + ex);
        }
        catch(javax.servlet.ServletException ex)
        {
            
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
    

   