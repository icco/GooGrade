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
 *TeacherController Test
 * @author kblizard and mduder
 */
public class BTeacherControllerTest extends TestCase {
    
    public BTeacherControllerTest(String testName) {
        super(testName);
    }

    /**
     * Test of doPost and doGet methods, of class AccountController.
     */
    public void testDoPostAndGet() throws IOException
    {
        
        System.out.println("doPost & doGet");
        // int aryLoc = -1;
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest
                ("http://localhost:8080/GooGrade2.0/");

        // WebLink linkArray[] = null;
        try
        {
            WebResponse resp = wc.getResponse(req);
            WebLink link = null;
            WebForm form = null;
            resp = wc.getResponse(req);         // Main page
            link = resp.getLinkWith("teacher"); // Highlight teacher's page
            req  = link.getRequest();
            resp = wc.getResponse(req);         // Follow link
            form = resp.getForms()[0];          // Access form to select nwelch
            req = form.getRequest();
            form.setParameter("who", "1");      // Set it to nwelch (id 1)
            assertEquals("1", form.getParameterValue("who"));
            resp = wc.getResponse(req);         // Follow submit button's link
            req  = link.getRequest();
            
            //The teacher index appears to have dissappeared. Find out if this 
            //test is complete 
            
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
