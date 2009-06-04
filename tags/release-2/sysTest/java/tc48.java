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
		selenium.click("//input[@value='Add New Assignment']");
		assertTrue(selenium.isTextPresent(""));
		assertTrue(selenium.isTextPresent(""));
		assertTrue(selenium.isTextPresent(""));
		selenium.select("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[4]/select", "label=Quiz");
		selenium.type("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[1]/input", "MOO");
		selenium.type("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[3]/input", "234");
		selenium.click("//input[@value='Add']");
		assertTrue(selenium.isTextPresent("MOO"));
		selenium.click("//div[@id='side']/div/div[5]/h1/a/span");
	}
}
