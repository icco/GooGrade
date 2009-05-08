package goograde;

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

/**
 *
 * @author mduder
 */
public class AccountControllerTest extends TestCase
{

    public AccountControllerTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of doPost and doGet methods, of class AccountController.
     */
    public void testDoPostAndGet()
    {


        System.out.println("HTTPUnit: AccountController doPost & doGet driver");
        int aryLoc = -1;
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        
        ServletRunner sr = new ServletRunner();
        sr.registerServlet("GooGrade/teacher/accounts",
                AccountController.class.getName() );
        
        //WebConversation wc = new WebConversation();
        ServletUnitClient sc = sr.newClient();
        WebRequest req = new GetMethodWebRequest(
                "http://localhost:8080/GooGrade/teacher/accounts");
        
        //WebResponse resp = null;
        WebLink link = null;
        WebForm form = null;
        WebLink linkArray[] = null;
        try
        {
            req.setParameter("type", "student");
            req.setParameter("newUserName", "bbunny");
            req.setParameter("newFullName", "Bugs Bunny");
            req.setParameter("newEmailAddr", "bbunny@calpoly.edu");
            req.setParameter("id", "1");
            req.setParameter("action", "add");
            
            InvocationContext ic = sc.newInvocation( req );
            AccountController ss = (AccountController) ic.getServlet();
            assertNull( "A session already exists", 
                    ic.getRequest().getSession( false ) );
         

            ss.doGet( ic.getRequest(), ic.getResponse());
            assertNotNull( "Session was not created", 
                    ic.getRequest().getSession( false ));
            assertEquals("student", 
                    ic.getRequest().getSession().getAttribute( "type" ) );

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
                if (new String("/GooGrade/teacher/accounts?id=1").equals(linkArray[index].getURLString()))
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
}
