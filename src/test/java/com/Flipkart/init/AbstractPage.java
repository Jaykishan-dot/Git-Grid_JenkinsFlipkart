package com.Flipkart.init;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public abstract class AbstractPage extends SeleniumInit
{
	
	public int DRIVER_WAIT = 15;
	
	public AbstractPage(WebDriver driver) 
	{
		System.out.println("This Statement is from Abstract Class");
		this.driver=driver;
		ElementLocatorFactory finder =new AjaxElementLocatorFactory(driver,DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		
	}

}
