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
        System.out.println("doPost & doGet");
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest
                ("http://localhost:8080/GooGrade2.0/teacher/accounts?id=3");

        try
        {
            wc.putCookie("userid", "1");
            WebResponse resp = wc.getResponse(req);
            WebLink link = null;
            WebForm form = null;
            resp = wc.getResponse(req);             // Page to be tested loads
            
            assertEquals("[CPE-309-1] - Manage Accounts", resp.getTitle());
            form = resp.getForms()[0];              //edit first course
            form.setParameter("action", "edit");
            form.setParameter("newUserName", "jhendrix");
            form.setParameter("newEmailAddr", "jhendrix@website.com");
            form.setParameter("newFullName", "Jimmy Hendrix");
            form.submit();
            wc.getCurrentPage();                    //refresh 
            form = resp.getForms()[1];              //delete first course
            form.setParameter("action", "delete");
            //form.setParameter("AssgnId", "1");
            form.submit();
            form = resp.getForms()[10];             //add new course
            form.setParameter("newUserName", "jpage");
            form.setParameter("newEmailAddr", "jpage@website.com");
            form.setParameter("newFullName", "Jimmy Page");
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
}
