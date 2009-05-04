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
		selenium.click("link=Manage Accounts");
		selenium.click("//input[@value='Add Student']");
		selenium.type("//form[@id='Form']/table/tbody/tr/td[1]/input", "mshinoda");
		selenium.type("//form[@id='Form']/table/tbody/tr/td[2]/input", "moo@hotmail.com");
		selenium.type("//form[@id='Form']/table/tbody/tr/td[3]/input", "Cthulhu");
		selenium.click("//input[@value='Add']");
		assertTrue(selenium.isTextPresent("Cthulhu"));
		assertEquals("ManageAccounts", selenium.getTitle());
		selenium.click("//div[@id='side']/div/div[5]/h1/a/span");
	}
}
