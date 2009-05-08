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
		selenium.click("link=CPE 309-1");
		selenium.click("//div[@id='accordion']/div[2]/div/ul/li[3]/a");
		selenium.click("//input[@value='Add Student']");
		selenium.type("//form[@id='Form']/table/tbody/tr/td[1]/input", "vgerdin");
		selenium.type("//form[@id='Form']/table/tbody/tr/td[2]/input", "vgerdin@calpoly.edu");
		selenium.type("//form[@id='Form']/table/tbody/tr/td[3]/input", "Viktor Gerdin");
		selenium.click("//input[@value='Add']");
		selenium.click("//div[@id='side']/div/div[5]/h1/a/span");
		selenium.waitForPageToLoad("30000");
		assertEquals("TEST FAIL - no prompt", selenium.getTitle());
	}
}
