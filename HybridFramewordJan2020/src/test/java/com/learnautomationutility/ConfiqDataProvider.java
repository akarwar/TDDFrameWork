package com.learnautomationutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfiqDataProvider {
	
	Properties pro;
	
	public ConfiqDataProvider()
	{
		File src = new File("./Confiq/Confiq.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
		} catch (FileNotFoundException e) {
		
		} catch (Exception e) {
			
			System.out.println("Not able to load confiqfile >> "+ e.getMessage());
		}
	}



	public String getDataFromConfiq(String keyToSearch)
	{
	return pro.getProperty("FirstName");	
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("qaURL");
	}

}
