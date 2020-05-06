package com.Flipkart.init;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Flipkart.Electonics.Mobile.MobilePhonesIndexPage;
import com.Flipkart.Electonics.Mobile.MobilePhonesVerification;
import com.Flipkart.Utility.FlipkartReporter;




public class SeleniumInit
{
	public WebDriver driver;
	public static String TestURL;
	public static String Testpath;
	public static String filepath ;
	public static String Testbrowser;
	public static String osName = "";
	public static String browserVersion = "";
	public static String seleniumHub; // Selenium hub IP
	public static String seleniumHubPort; // Selenium hub port
	public static String currentTest; 
	DesiredCapabilities capability = null;		
	ChromeOptions chromeOptions;

	
	public MobilePhonesIndexPage mobilePhonesIndexPage;
	public MobilePhonesVerification mobilePhonesVerification;
	public Common common;
	public FlipkartReporter flipkartReporter;
	
	
		
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration() throws IOException 
	{
		TestURL=Common.getConfigValue("config.properties","URL");
		
	}

	@BeforeMethod(alwaysRun = true)
	public void BrowserSetup() throws IOException, MessagingException, EmailException
	{
		URL remote_grid = new URL("http://192.168.0.104:4444/wd/hub");
		DesiredCapabilities capability=null;	
		Testbrowser=Common.getConfigValue("config.properties", "Browser");
		
		if(Testbrowser.equalsIgnoreCase("gecko"))
		{
		
		    driver= new FirefoxDriver();
		}	
		else if (Testbrowser.contains("chrome") || Testbrowser.equalsIgnoreCase("chrome"))
		{
			
			/*capability = DesiredCapabilities.chrome();
			File driverpath = new File("Resource/chromedriver.exe");
			String path1 = driverpath.getAbsolutePath();
			System.setProperty("webdriver.chrome.driver",path1);
			final ChromeOptions chromeOptions = new ChromeOptions();
			capability.setBrowserName("chrome");
			capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			capability.setJavascriptEnabled(true);
			capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			capability.setCapability("disable-popup-blocking", true);
			osName = capability.getPlatform().name();
			capability = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver",
					"E:\\chromedriver.exe");
			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();
			driver = new RemoteWebDriver(remote_grid, capability);
			//driver= new ChromeDriver(capability);
*/			
// test			
			
		}
		driver.get(TestURL);
		driver.manage().window().maximize();
		//driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		mobilePhonesIndexPage = new MobilePhonesIndexPage(driver);
		mobilePhonesVerification = new MobilePhonesVerification(driver);
		common=new Common(driver);
		flipkartReporter = new FlipkartReporter();
		
		chromeOptions=new ChromeOptions();
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void postConfig(ITestResult TestResult) throws IOException {
			
		if (TestResult.getStatus() == ITestResult.FAILURE) 
		{
			try
			{
				filepath = common.takeScreenshot(TestResult.getName());
				Reporter.setCurrentTestResult(TestResult);
				Reporter.log("<a href=\"" + filepath + "\">" +filepath + "</a>");
				//sendMail();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}



		}
		//driver.close();
		//driver.quit();
		

	}
	//@AfterClass(alwaysRun = true)
	/*public void sendMail() throws MessagingException, EmailException, FileNotFoundException
	{
		String username="jaykishan.kiwiqa@gmail.com";
		String password="J@ckdave199110";
		String from_Email="jaykishan.kiwiqa@gmail.com";
		String to_Email="jaykishan.kiwiqa@gmail.com";
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(true);
		email.setFrom(from_Email);
		email.setSubject("This is a test mail ... :-)");
		email.setHtmlMsg(Common.email());
		email.addTo(to_Email);
		email.send();
		
		
	}*/
	
	
	
	
	
	
	
	

}
