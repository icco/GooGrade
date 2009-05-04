package com.example.tests;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class NewTest extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://localhost:8080/", "*chrome");
	}
	public void testNew() throws Exception {
		selenium.open("/GooGrade/");
		selenium.click("link=Teacher's Page");
		selenium.click("who");
		selenium.click("//input[@type='submit']");
		selenium.click("link=CPE 308-1");
		selenium.click("link=Manage Assignments");
		selenium.click("//input[@value='Add New Assignment']");
		selenium.click("TB_closeWindowButton");
		selenium.click("//div[@id='data']/table/tbody/tr[3]/td[5]/input");
		selenium.click("TB_closeWindowButton");
		selenium.click("//div[@id='data']/table/tbody/tr[3]/td[6]/form/input[4]");
		selenium.click("//div[@id='side']/div/div[5]/h1/a/span");
	}
}
