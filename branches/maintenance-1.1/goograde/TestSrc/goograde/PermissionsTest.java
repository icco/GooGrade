package goograde;

import junit.framework.TestCase;

/**
 *
 * @author kblizard
 */
public class PermissionsTest extends TestCase
{

    public PermissionsTest(String testName)
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
     * Test of isSendEmail method, of class Permissions.
     */
    public void testIsSendEmail()
    {
        System.out.println("isSendEmail");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isSendEmail();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isSendEmail();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isUploadFile method, of class Permissions.
     */
    public void testIsUploadFile()
    {
        System.out.println("isUploadFile");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isUploadFile();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isUploadFile();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isViewOwnGrade method, of class Permissions.
     */
    public void testIsViewOwnGrade()
    {
        System.out.println("isViewOwnGrade");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isViewOwnGrade();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isViewOwnGrade();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of isManageCourse method, of class Permissions.
     */
    public void testIsManageCourse()
    {
        System.out.println("isManageCourse");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isManageCourse();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isManageCourse();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isManageMetric method, of class Permissions.
     */
    public void testIsManageMetric()
    {
        System.out.println("isManageMetric");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isManageMetric();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isManageMetric();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isManageGrade method, of class Permissions.
     */
    public void testIsManageGrade()
    {
        System.out.println("isManageGrade");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isManageGrade();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isManageGrade();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isManageRoster method, of class Permissions.
     */
    public void testIsManageRoster()
    {
        System.out.println("isManageRoster");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isManageRoster();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isManageRoster();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isManageAccouncement method, of class Permissions.
     */
    public void testIsManageAnnouncement()
    {
        System.out.println("isManageAccouncement");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isManageAnnouncement();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isManageAnnouncement();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isManageUser method, of class Permissions.
     */
    public void testIsManageUser()
    {
        System.out.println("isManageUser");
        Permissions instance = new Permissions();
        boolean expResult = false;
        boolean result = instance.isManageUser();
        assertEquals(expResult, result);
        try
        {
            Permissions teacherInstance = new Permissions(false, true);
            result = teacherInstance.isManageUser();
        }
        catch (Exception error)
        {
            fail("Constructor fail");
        }
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of setSendEmail method, of class Permissions.
     */
    public void testSetSendEmail()
    {
        System.out.println("setSendEmail");
        boolean pSendEmail = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        
        boolean result = instance.setSendEmail(pSendEmail, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isSendEmail());

        manageUserPermit = false;
        expResult = false;
        result = instance.setSendEmail(pSendEmail, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isSendEmail());

        manageUserPermit = true;
        pSendEmail = true;
        result = instance.setSendEmail(pSendEmail, manageUserPermit);
        assertEquals(true, instance.isSendEmail());

    }

    /**
     * Test of setUploadFile method, of class Permissions.
     */
    public void testSetUploadFile()
    {
        System.out.println("setUploadFile");
        boolean pUploadFile = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setUploadFile(pUploadFile, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isUploadFile());

        manageUserPermit = false;
        expResult = false;
        result = instance.setUploadFile(pUploadFile, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isUploadFile());

        manageUserPermit = true;
        result = instance.setUploadFile(pUploadFile, manageUserPermit);
        assertEquals(false, instance.isUploadFile());
    }

    /**
     * Test of setViewOwnGrade method, of class Permissions.
     */
    public void testSetViewOwnGrade()
    {
        System.out.println("setViewOwnGrade");
        boolean pViewOwnGrade = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setViewOwnGrade(pViewOwnGrade, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isViewOwnGrade());

        manageUserPermit = false;
        expResult = false;
        result = instance.setViewOwnGrade(pViewOwnGrade, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isViewOwnGrade());

        manageUserPermit = true;
        result = instance.setViewOwnGrade(pViewOwnGrade, manageUserPermit);
        assertEquals(false, instance.isViewOwnGrade());
    }

    /**
     * Test of setManageCourse method, of class Permissions.
     */
    public void testSetManageCourse()
    {
        System.out.println("setManageCourse");
        boolean pManageCourse = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setManageCourse(pManageCourse, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageCourse());

        manageUserPermit = false;
        expResult = false;
        result = instance.setManageCourse(pManageCourse, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageCourse());

        manageUserPermit = true;
        result = instance.setManageCourse(pManageCourse, manageUserPermit);
        assertEquals(false, instance.isManageCourse());
    }

    /**
     * Test of setManageMetric method, of class Permissions.
     */
    public void testSetManageMetric()
    {
        System.out.println("setManageMetric");
        boolean pManageMetric = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setManageMetric(pManageMetric, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageMetric());

        manageUserPermit = false;
        expResult = false;
        result = instance.setManageMetric(pManageMetric, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageMetric());

        manageUserPermit = true;
        result = instance.setManageMetric(pManageMetric, manageUserPermit);
        assertEquals(false, instance.isManageMetric());
    }

    /**
     * Test of setManageGrade method, of class Permissions.
     */
    public void testSetManageGrade()
    {
        System.out.println("setManageGrade");
        boolean pManageGrade = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setManageGrade(pManageGrade, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageGrade());

        manageUserPermit = false;
        expResult = false;
        result = instance.setManageGrade(pManageGrade, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageGrade());

        manageUserPermit = true;
        result = instance.setManageGrade(pManageGrade, manageUserPermit);
        assertEquals(false, instance.isManageGrade());
    }

    /**
     * Test of setManageRoster method, of class Permissions.
     */
    public void testSetManageRoster()
    {
        System.out.println("setManageRoster");
        boolean pManageRoster = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setManageRoster(pManageRoster, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageRoster());

        manageUserPermit = false;
        expResult = false;
        result = instance.setManageRoster(pManageRoster, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageRoster());

        manageUserPermit = true;
        result = instance.setManageRoster(pManageRoster, manageUserPermit);
        assertEquals(false, instance.isManageRoster());
    }

    /**
     * Test of setManageAnnouncement method, of class Permissions.
     */
    public void testSetManageAnnouncement()
    {
        System.out.println("setManageAnnouncement");
        boolean pManageAnnouncement = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setManageAnnouncement(pManageAnnouncement, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageAnnouncement());

        manageUserPermit = false;
        expResult = false;
        result = instance.setManageAnnouncement(pManageAnnouncement, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageAnnouncement());

        manageUserPermit = true;
        result = instance.setManageAnnouncement(pManageAnnouncement, manageUserPermit);
        assertEquals(false, instance.isManageAnnouncement());
    }

    /**
     * Test of setManageUser method, of class Permissions.
     */
    public void testSetManageUser()
    {
        System.out.println("setManageUser");
        boolean pManageUser = false;
        boolean manageUserPermit = true;
        Permissions instance = new Permissions();
        boolean expResult = true;
        boolean result = instance.setManageUser(pManageUser, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageUser());

        manageUserPermit = false;
        expResult = false;
        result = instance.setManageUser(pManageUser, manageUserPermit);
        assertEquals(expResult, result);
        assertEquals(false, instance.isManageUser());

        manageUserPermit = true;
        result = instance.setManageUser(pManageUser, manageUserPermit);
        assertEquals(false, instance.isManageUser());
    }

    public void testConstructor()
    {
        System.out.println("Constructor test");
        boolean isStudent = false;
        boolean isTeacher = false;
        Permissions instance;

        try
        {
            instance = new Permissions();
            assertEquals(false, instance.isManageUser());

            instance = new Permissions(isStudent, isTeacher);
            assertEquals(false, instance.isManageUser());

            isStudent = true;
            instance = new Permissions(isStudent, isTeacher);
            assertEquals(false, instance.isManageUser());
            assertEquals(true, instance.isViewOwnGrade());

            isStudent = false;
            isTeacher = true;
            instance = new Permissions(isStudent, isTeacher);
            assertEquals(false, instance.isViewOwnGrade());
            assertEquals(true, instance.isManageUser());

        }
        catch (Exception error)
        {
            fail("Constructor failed");
        }

        try
        {
            isStudent = true;
            isTeacher = true;
            instance = new Permissions(isStudent, isTeacher);
            fail("Exception not thrown");
        }
        catch (Exception Error)
        {
            System.out.println(Error);
        }

    }
}
