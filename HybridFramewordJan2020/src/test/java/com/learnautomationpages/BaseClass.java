package com.learnautomationpages;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomationutility.BrowserFactory;
import com.learnautomationutility.ConfiqDataProvider;
import com.learnautomationutility.ExcelDataProvider;
import com.learnautomationutility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfiqDataProvider confiq;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		
		excel = new ExcelDataProvider();
		confiq = new ConfiqDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be started", true);
		
	}
	
	@BeforeClass
	public void setup(){
		
		Reporter.log("Trying to start Browser and Getting applicaton ready", true);
		driver = BrowserFactory.startApplication(driver,confiq.getBrowser(),confiq.getStagingURL());
		Reporter.log("Browser and application is up and running", true);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			Helper.captureScreenshot(driver, result.getName());
				
		}
		report.flush();
		Reporter.log("Test Completed >>>>>>>> Report Generated", true);
	}

}
