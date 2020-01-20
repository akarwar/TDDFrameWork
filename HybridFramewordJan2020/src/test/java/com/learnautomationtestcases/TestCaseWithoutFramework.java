package com.learnautomationtestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
	
	@Test
	public void test1()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahsan\\Documents\\Drivers\\chrome 79\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.crmpro.com/index.html");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).sendKeys("ahsankarwar");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.quit();
		
	
	}

}
