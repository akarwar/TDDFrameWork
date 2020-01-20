package com.learnautomationutility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Helper {
	
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
			
			try 
			{
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source =ts.getScreenshotAs(OutputType.FILE);
			String screenshotPath=System.getProperty("user,dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime()+" .png";
			
				FileUtils.copyFile(source, new File("./Screenshots/FreeCRM_"+ getCurrentDateTime() +".png"));
				
				System.out.println("Screenshot captured");
				
			} catch (IOException e) 
			{
				
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
	
	public static String getCurrentDateTime()
	{
		DateFormat customeFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customeFormat.format(currentDate);
	}
		
		
	}



