package GooGradeTest;

import goograde.*;
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
        Account instance = new Account();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFullName method, of class Account.
     */
    public void testGetFullName()
    {
        System.out.println("getFullName");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getFullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailAddress method, of class Account.
     */
    public void testGetEmailAddress()
    {
        System.out.println("getEmailAddress");
        Account instance = new Account();
        EmailAddress expResult = null;
        EmailAddress result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Account.
     */
    public void testSetPassword()
    {
        System.out.println("setPassword");
        String newPass = "";
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.setPassword(newPass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Account.
     */
    public void testSetUserName()
    {
        System.out.println("setUserName");
        String newUserName = "";
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.setUserName(newUserName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFullName method, of class Account.
     */
    public void testSetFullName()
    {
        System.out.println("setFullName");
        String newFullName = "";
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.setFullName(newFullName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailAddress method, of class Account.
     */
    public void testSetEmailAddress()
    {
        System.out.println("setEmailAddress");
        EmailAddress newAddress = null;
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.setEmailAddress(newAddress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPassword method, of class Account.
     */
    public void testIsPassword()
    {
        System.out.println("isPassword");
        String passwd = "";
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.isPassword(passwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFiles method, of class Account.
     */
    public void testGetFiles()
    {
        System.out.println("getFiles");
        Account instance = new Account();
        ArrayList<File> expResult = null;
        ArrayList<File> result = instance.getFiles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFiles method, of class Account.
     */
    public void testSetFiles()
    {
        System.out.println("setFiles");
        ArrayList<File> newFiles = null;
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.setFiles(newFiles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Account.
     */
    public void testGetId()
    {
        System.out.println("getId");
        Account instance = new Account();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Account.
     */
    public void testSetId()
    {
        System.out.println("setId");
        Integer newID = null;
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.setId(newID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPermissions method, of class Account.
     */
    public void testGetPermissions()
    {
        System.out.println("getPermissions");
        Account instance = new Account();
        Permissions expResult = null;
        Permissions result = instance.getPermissions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetch method, of class Account.
     */
    public void testFetch()
    {
        System.out.println("fetch");
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.fetch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class Account.
     */
    public void testRefresh()
    {
        System.out.println("refresh");
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.refresh();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Account.
     */
    public void testSave()
    {
        System.out.println("save");
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Account.
     */
    public void testToString()
    {
        System.out.println("toString");
        Account instance = new Account();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allAccounts method, of class Account.
     */
    public void testAllAccounts()
    {
        System.out.println("allAccounts");
        ArrayList<Account> expResult = null;
        ArrayList<Account> result = Account.allAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTeacher method, of class Account.
     */
    public void testIsTeacher()
    {
        System.out.println("isTeacher");
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.isTeacher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTeacherAssistant method, of class Account.
     */
    public void testIsTeacherAssistant()
    {
        System.out.println("isTeacherAssistant");
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.isTeacherAssistant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
