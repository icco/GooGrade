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
		selenium.click("//div[@id='data']/table/tbody/tr[3]/td[5]/input");
		selenium.type("//input[@name='newAssgnTitle' and @value='JSP Sample']", "Mooses");
		verifyEquals("10", selenium.getValue("//input[@name='newAssgnTotal' and @value='10']"));
		selenium.click("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[5]/input");
		verifyTrue(selenium.isTextPresent("Mooses"));
		selenium.click("//div[@id='side']/div/div[5]/h1/a/span");
	}
}
