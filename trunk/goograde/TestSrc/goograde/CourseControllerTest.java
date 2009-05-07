/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package goograde;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import junit.framework.TestCase;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.servletunit.ServletUnitClient;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.InvocationContext;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
//import com.meterware.httpunit.WebResponse;
import java.io.IOException;
//import javax.servlet.ServletException;
import junit.framework.TestCase;
//import org.xml.sax.SAXException;
import com.meterware.httpunit.cookies.Cookie;


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
    public void testDoPost()
    {
        System.out.println("HTTPUnit: AccountController doPost & doGet driver");
        int aryLoc = -1;
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        
        //Cookie cook = new Cookie();
        ServletRunner sr = new ServletRunner();
        sr.registerServlet("GooGrade/teacher/course",
                CourseController.class.getName() );
        
        //WebConversation wc = new WebConversation();
        ServletUnitClient sc = sr.newClient();
        WebRequest req = new GetMethodWebRequest(
                "http://localhost:8080/GooGrade/teacher/course");
        
        //WebResponse resp = null;
        WebLink link = null;
        WebForm form = null;
        WebLink linkArray[] = null;
        try
        {
            req.setParameter("newCourseTitle", "Intro to Sleep");
            req.setParameter("newCourseDepartment", "SLP");
            req.setParameter("newCourseNumber", "101");
            req.setParameter("newCourseSection", "04");
            req.setParameter("id", "1");
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

            //resp = sc.getResponse(req);         // Main page
            //link = resp.getLinkWith("teacher"); // Highlight teacher's page
            //req = link.getRequest();
            //resp = sc.getResponse(req);         // Follow link
            //form = resp.getForms()[0];          // Access form to select nwelch
            //req = form.getRequest();
            //form.setParameter("who", "1");      // Set it to nwelch (id 1)
            //assertEquals("1", form.getParameterValue("who"));
            //resp = sc.getResponse(req);         // Follow submit button's link
            //req = link.getRequest();

            //linkArray = resp.getLinks(); // Get all links from teacher's opening page
            /* Store the index of the link in the array referring to 357-1 accts */
            for (int index = 0; index < linkArray.length; index++)
            {
                /* pull the matching location out */
                if (new String("/GooGrade/teacher/accounts?id=1")
                        .equals(linkArray[index].getURLString()))
                {
                    aryLoc = index;
                }
            }
            // System.out.println(linkArray[aryLoc].getURLString());
            //req = linkArray[aryLoc].getRequest();
            //resp = sc.getResponse(req);         // Follow link to manage 357 accounts
            // System.out.println(new String(resp.getTitle()));
            //String expResult = "[CSC-357-1] - Manage Accounts";
            //String result = resp.getTitle();
            //assertEquals(expResult, result);
        }
        catch (IOException ex)
        {
            fail("IOException: " + ex);
        }
        /*catch (SAXException ex)
        {
            fail("SAXException: " + ex);
        }*/
        catch(javax.servlet.ServletException ex)
        {
            
        }
    }

    /**
     * Test of doGet method, of class CourseController.
     */
    public void testDoGet()
    {
        System.out.println("doGet");
        HttpServletRequest req = null;
        HttpServletResponse resp = null;
        CourseController instance = new CourseController();
        instance.doGet(req, resp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
