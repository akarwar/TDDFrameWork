package com.learnautomationtestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.learnautomationpages.BaseClass;
import com.learnautomationpages.LoginPage;

public class LoginTestCRM extends BaseClass {

	@Test
	public void LoginApp(ITestResult result) {
		
		logger=report.createTest("Login to CRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Success");
		
	}
	
	
	

}
