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
 
/** @author kblizard
 */
public class CGradeControllerTest extends TestCase 
    {
    
    public CGradeControllerTest(String testName) 
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
     * Test of doPost method, of class GradeController.
     */
   public void testDoPostAndGetteacher() throws IOException
    {
        
        System.out.println("doPost & doGet: teacher");
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest
                ("http://localhost:8080/GooGrade2.0/teacher/grades?id=3");

        try
        {
            wc.putCookie("userid", "1");
            WebResponse resp = wc.getResponse(req);
            WebLink link = null;
            WebForm form = null;
            resp = wc.getResponse(req);             // Page to be tested loads
            
            assertEquals("[CPE-309-1] - Manage Grades", resp.getTitle());
            
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
     * Test of doPost method, of class GradeController.
     */
   public void testDoPostAndGetStudent() throws IOException
    {
        
        System.out.println("doPost & doGet: student");
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest
                ("http://localhost:8080/GooGrade2.0/student/grades?id=1");

        try
        {
            wc.putCookie("userid", "2");
            WebResponse resp = wc.getResponse(req);
            WebLink link = null;
            WebForm form = null;
            resp = wc.getResponse(req);             // Page to be tested loads
            
            assertEquals("[CSC-357-1] - View Grades", resp.getTitle());
            
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
