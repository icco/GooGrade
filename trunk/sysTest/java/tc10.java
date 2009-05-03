package com.example.tests;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class NewTest extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://change-this-to-the-site-you-are-testing/", "*chrome");
	}
	public void testNew() throws Exception {
		selenium.open("/GooGrade/");
		selenium.click("link=Student's Page");
		selenium.waitForPageToLoad("30000");
		selenium.click("who");
		selenium.click("//input[@type='submit']");
		selenium.waitForPageToLoad("30000");
		assertNotEquals("Your Courses", selenium.getText("//div[@id='content']/div/div[5]/h3"));
	}
}
