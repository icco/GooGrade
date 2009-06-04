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
public class CGradingRulesControllerTest extends TestCase 
    {
    
    public CGradingRulesControllerTest(String testName) 
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
     * Test of doPost and doGet methods, of class GradingRulesController.
     */
    public void testDoPostAndGet() throws IOException
    {
        
        System.out.println("doPost & doGet");
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest
                ("http://localhost:8080/GooGrade2.0/teacher/rules?id=1");

        try
        {
            wc.putCookie("userid", "1");
            WebResponse resp = wc.getResponse(req);
            WebLink link = null;
            WebForm form = null;
            resp = wc.getResponse(req);             // Page to be tested loads
            
            assertEquals("Manage Grading Curve", resp.getTitle());
            form = resp.getForms()[0];              //edit first course
            form.setParameter("aVal", "85");
            form.setParameter("bVal", "75");
            form.setParameter("cVal", "65");
            form.setParameter("dVal", "50");
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
