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
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest("http://localhost:8080/GooGrade/");
        WebResponse resp = null;
        WebLink link = null;
        WebForm form = null;
        WebLink linkArray[] = null;
        try
        {
            resp = wc.getResponse(req);         // Main page
            link = resp.getLinkWith("teacher"); // Highlight teacher's page
            req = link.getRequest();
            resp = wc.getResponse(req);         // Follow link
            form = resp.getForms()[0];          // Access form to select nwelch
            req = form.getRequest();
            form.setParameter("who", "1");      // Set it to nwelch (id 1)
            assertEquals("1", form.getParameterValue("who"));
            resp = wc.getResponse(req);         // Follow submit button's link
            req = link.getRequest();

            linkArray = resp.getLinks(); // Get all links from teacher's opening page
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
            req = linkArray[aryLoc].getRequest();
            resp = wc.getResponse(req);         // Follow link to manage 357 accounts
            // System.out.println(new String(resp.getTitle()));
            String expResult = "[CSC-357-1] - Manage Accounts";
            String result = resp.getTitle();
            assertEquals(expResult, result);
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
}
