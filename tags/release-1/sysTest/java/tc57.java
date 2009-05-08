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
		selenium.click("TB_closeWindowButton");
		selenium.click("//div[@id='content']/div/div[5]/table/tbody/tr[3]/td[7]/input");
		selenium.click("TB_closeWindowButton");
		selenium.click("//div[@id='content']/div/div[5]/table/tbody/tr[3]/td[8]/form/input[4]");
		selenium.click("//div[@id='side']/div/div[5]/h1/a/span");
	}
}
