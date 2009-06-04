package com.example.tests;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class NewTest extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://change-this-to-the-site-you-are-testing/", "*chrome");
	}
	public void testNew() throws Exception {
		selenium.open("/GooGrade/");
		selenium.click("link=Teacher's Page");
		selenium.click("who");
		selenium.click("//input[@type='submit']");
		selenium.click("link=CPE 308-1");
		selenium.click("link=Manage Assignments");
		verifyTrue(selenium.isTextPresent("JSP Sample"));
		selenium.click("//div[@id='data']/table/tbody/tr[3]/td[6]/form/input[4]");
		verifyFalse(selenium.isTextPresent("JSP Sample"));
		verifyEquals("Test Not Finished", selenium.getTitle());
	}
}
