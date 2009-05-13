package goograde;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author mduder
 */
public class AccountTest extends TestCase {
    
    public AccountTest(String testName) {
        super(testName);
    }            

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getUserName method, of class Account.
     */
    public void testGetUserName()
    {
        System.out.println("getUserName");
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        String expResult = "testGuy";
        String result = testAct.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullName method, of class Account.
     */
    public void testGetFullName()
    {
        System.out.println("getFullName");
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        String expResult = "Test Guy";
        String result = testAct.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailAddress method, of class Account.
     */
    public void testGetEmailAddress()
    {
        System.out.println("getEmailAddress");
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        String expResult = "test@guy";
        assertEquals(expResult, testAct.getEmailAddress().toString());
    }

    /**
     * Test of setPassword method, of class Account.
     */
    public void testSetPassword()
    {
        System.out.println("setPassword");
        Password newPass = new Password("123456");
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = true;
        boolean result = testAct.setPassword(newPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class Account.
     */
    public void testSetUserName()
    {
        System.out.println("setUserName");
        String newUserName = "newGuy";
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = true;
        boolean result = testAct.setUserName(newUserName);
        assertEquals(expResult, result);
    }

    /**
     * Test of setFullName method, of class Account.
     */
    public void testSetFullName()
    {
        System.out.println("setFullName");
        String newFullName = "New Guy";
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = true;
        boolean result = testAct.setFullName(newFullName);
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmailAddress method, of class Account.
     */
    public void testSetEmailAddress()
    {
        System.out.println("setEmailAddress");
        EmailAddress newAddress = new EmailAddress(new String("new@guy"));
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = true;
        boolean result = testAct.setEmailAddress(newAddress);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPassword method, of class Account.
     */
    public void testIsPassword()
    {
        System.out.println("isPassword");
        String passwd = "123456";
        Account testAct = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = true;
        boolean result = testAct.isPassword(passwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Account.
     */
    public void testGetId()
    {
        System.out.println("getId");
        Account instance = new Account(42, "testGuy", "Test Guy", "test@guy");
        Integer expResult = 42;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Account.
     */
    public void testSetId()
    {
        System.out.println("setId");
        Integer newID = 27;
        Account instance = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = true;
        boolean result = instance.setId(newID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPermissions method, of class Account.
     */
    public void testGetPermissions()
    {
        System.out.println("getPermissions");
        Account instance = new Account(42, "testGuy", "Test Guy", "test@guy");
        Permissions expResult = null;
        Permissions result = instance.getPermissions();
        assertEquals(expResult, result);
    }

    /**
     * Test of fetch method, of class Account.  Assumes test db entry #1 is Nat.
     */
    public void testFetch() throws Exception
    {
        System.out.println("fetch");
        Account instance1 = new Account(1);
        String expResult = new String("nwelch");
        assertEquals(expResult, instance1.getUserName());
    }

    /**
     * Test of refresh method, of class Account.
     */
    public void testRefresh() throws Exception
    {
        System.out.println("refresh");
        Account instance = new Account(1);
        boolean result = instance.refresh();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of save and delete methods, of class Account.
     */
    public void testSaveAndDelete()
    {
        System.out.println("save and delete");
        Account instance = new Account("jUnit", "JAY EWENIT", "jay@unit");
        boolean expResult = true;
        boolean result = instance.save();
        assertEquals(expResult, result);
        
        result = instance.delete();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Account.
     */
    public void testToString()
    {
        System.out.println("toString");
        Account instance = new Account(42, "testGuy", "Test Guy", "test@guy");
        String expResult = "42, testGuy, Test Guy, test@guy";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of allAccounts method, of class Account.
     * NOTE: jUnit doesn't use Account class equals method in assertEquals
     * for some reason, so I am calling Account equals for each and 
     * asserting the results.
     */
    public void testAllAccounts()
    {
        System.out.println("allAccounts");
        ArrayList<Account> actList = new ArrayList<Account>();
        boolean accountState = true, result = false;
        int index = 1;
        
        while (accountState)
        {
            Account newAct = new Account();
            newAct.setId(index++);
            accountState = newAct.fetch();
            if (accountState)
            {
                actList.add(newAct);
            }
        }
        
        for (index = 0; index < actList.size(); index++)
        {
            result = Account.allAccounts().get(index).equals(actList.get(index));
            if (!result)
                fail();
        }
    }

    /**
     * Test of isTeacher method, of class Account.
     */
    public void testIsTeacher()
    {
        System.out.println("isTeacher");
        Account instance = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = false;
        boolean result = instance.isTeacher();
        assertEquals(expResult, result);
    }

    /**
     * Test of isTeacherAssistant method, of class Account.
     */
    public void testIsTeacherAssistant()
    {
        System.out.println("isTeacherAssistant");
        Account instance = new Account(42, "testGuy", "Test Guy", "test@guy");
        boolean expResult = false;
        boolean result = instance.isTeacherAssistant();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method in class Account
     */
    public void testEquals()
    {
        System.out.println("equals");
        Account instance1 = new Account(42, "testGuy", "Test Guy", "test@guy");
        Account instance2 = new Account(42, "testGuy", "Test Guy", "test@guy");
        Account instance3 = new Account(41, "newGuy", "New Guy", "new@guy");
        boolean result1 = instance1.equals(instance2);
        boolean result2 = instance1.equals(instance3);
        assertEquals(true, result1);
        assertEquals(false, result2);
    }
}
