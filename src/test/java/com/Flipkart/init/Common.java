package com.Flipkart.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Common {
	public static final String filepath = null;

	public Common(WebDriver driver) 
	{
		super();
		this.driver = driver;
	}

	public WebDriver driver;
	static String filePath;
	static File screenShotUrl;
	String ScreenPath;
	static String destination;
	static File scrFile;
	static ITestResult TestResult;

	public static void log(String result) {
		if (result.contains("Pass")) {
			Reporter.log("<b><Font color='green'>" + result + "<font><br><b>");

		} else if (result.contains("Fail")) {
			Reporter.log("<b><Font color='RED'>" + result + "<font><br><b>");
		} else if (result.contains("Step")) {
			Reporter.log("<b><Font color='BLUE'>" + result + "<font><br><b>");
		} else {
			Reporter.log("<u><Font color='Black'>" + result + "<font><br></u>");
		}
	}
	

	public String takeScreenshot(String name) throws IOException
	{
		String dirPath= "D:\\Automation\\Flipkart\\FlipKartReport";
		String newDirName ="AnotherScreenshot";
		boolean isCreated;
		File oneMoreDirectory = new File(dirPath+File.separator+newDirName);
		String destination =oneMoreDirectory.getAbsolutePath()+"\\";
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		isCreated = oneMoreDirectory.mkdir();
		if (isCreated) 
		{
            System.out.printf("\n3. Successfully created new directory, path:%s",
                    oneMoreDirectory.getCanonicalPath());
        } 
		else
		{ //Directory may already exist
            System.out.println("\n3. Unable to create directory or directory is available ");
        }
		
		
		screenShotUrl= new File(destination+name+".png");
		FileHandler.copy(scrFile,screenShotUrl);
		filePath = screenShotUrl.toString();	
		//Reporter.log("Screenshot value is: "+destination);
		return filePath;
		
		
	}
	
	public static String getConfigValue(String filename ,String value) throws IOException
	{
		String result="";
		File file = new File(filename);
		FileInputStream fip = null;
		
		fip=new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fip);
		result = prop.getProperty(value);
		System.out.println("This is from common confing method" + result);
		return result;
		
	}
	
	@SuppressWarnings("resource")
	public static String email() throws FileNotFoundException {
		
		String content = new Scanner(new File("D:\\Automation\\Flipkart\\FlipKartReport\\test-output\\emailable-report-new.html")).useDelimiter("\\Z").next();
		System.out.println(content);
		return content;
	}
	

}
