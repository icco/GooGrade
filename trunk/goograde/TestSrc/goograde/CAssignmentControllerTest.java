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
 *CAssignmentControllerTest
 * @author kblizard
 */
public class CAssignmentControllerTest extends TestCase {
    
    public CAssignmentControllerTest(String testName) {
        super(testName);
    }

    /**
     * Test of doPost and doGet methods, of class AccountController.
     */
    public void testDoPostAndGet() throws IOException
    {
        
        System.out.println("doPost & doGet");
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest
                ("http://localhost:8080/GooGrade2.0/teacher/assignment?id=1");

        try
        {
            wc.putCookie("userid", "1");
            WebResponse resp = wc.getResponse(req);
            WebLink link = null;
            WebForm form = null;
            resp = wc.getResponse(req);             // Page to be tested loads
            
            assertEquals("[CSC-357-1] - Manage Assignments", resp.getTitle());
            form = resp.getForms()[0];              //edit first course
            form.setParameter("action", "edit");
            form.setParameter("newAssgnDate", "05-30-09");
            form.setParameter("newAssgnTitle", "Take a Nap");
            form.setParameter("newAssgnTotal", "100");
            form.submit();
            wc.getCurrentPage();                    //refresh 
            form = resp.getForms()[1];              //delete first course
            form.setParameter("action", "delete");
            form.setParameter("AssgnId", "1");
            form.submit();
            form = resp.getForms()[6];             //add new course
            form.setParameter("action", "add");
            form.setParameter("newAssgnDate", "05-30-09");
            form.setParameter("newAssgnTitle", "Take a Nap");
            form.setParameter("newAssgnTotal", "100");
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
