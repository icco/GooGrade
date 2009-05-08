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
		selenium.click("TB_closeWindowButton");
		selenium.click("//input[@value='Add New Assignment']");
		selenium.type("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[1]/input", "JSP Sample  	10  	Thu Apr 16 00:00:00 PDT 2009  	Othe");
		selenium.select("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[4]/select", "label=Other");
		selenium.type("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[1]/input", "JSP Sample  	10  	Thu Apr 16 00:00:00 PDT 2009");
		selenium.type("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[3]/input", "10");
		selenium.type("//div[@id='TB_ajaxContent']/form/table/tbody/tr/td[1]/input", "JSP Sample");
		selenium.click("dp1241428414430");
		selenium.click("link=16");
		selenium.click("//input[@value='Add']");
		selenium.click("//div[@id='side']/div/div[5]/h1/a/span");
	}
}
