package com.Flipkart.Electonics.Mobile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Flipkart.init.AbstractPage;

public class MobilePhonesIndexPage extends AbstractPage {

	public MobilePhonesIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	public WebElement loginX;

	public MobilePhonesVerification clickonloginXbutton() {
		loginX.click();
		System.out.println("This Statement is from MobilePhonesIndexpage..................................................................");
		return new MobilePhonesVerification(driver);
		

	}

	@FindBy(xpath = "//span[text()='Electronics']")
	public WebElement ElectronicsMenu;

	public MobilePhonesVerification clickOnElectronicsMenu() {
		ElectronicsMenu.click();
		return new MobilePhonesVerification(driver);
	}

	// Click on any of the mobile and navigate to mobile page

	@FindBy(xpath = ".//*[@class='_114Zhd']/li[1]/ul/li/ul/li[1]/ul/li[2]/a")
	public WebElement MobileBrandName;

	public MobilePhonesVerification clickOnMobileBrandNameItem() {
		/*
		 * MobileBrandName.remove(0); int mobileBrandNameSize=MobileBrandName.size();
		 * Random ran=new Random(); int
		 * next_mobileBrand=ran.nextInt(mobileBrandNameSize); WebElement
		 * select_MobileBrandName=MobileBrandName.get(next_mobileBrand);
		 * select_MobileBrandName.click();
		 */

		// System.out.println("Mobilebrand name is :--------------"+
		// select_MobileBrandName);
		MobileBrandName.click();
		return new MobilePhonesVerification(driver);

	}

	// WebElement slidebar=driver.findElement(By.xpath("//div[@class='gl5Kwg']"));
	// @FindBy(xpath="//div[@class='gl5Kwg']") public WebElement slidebar;
	@FindBy(xpath = "//div[@class='_3G9WVX oVjMho']/div")
	public WebElement Priceslider;

	public MobilePhonesVerification clickOnPriceslider() {

		Actions move = new Actions(driver);
		move.dragAndDropBy(Priceslider, 100, 1).release().build().perform();

		System.out.println("Slider is moviung");

		// Priceslider.click();

		return new MobilePhonesVerification(driver);

	}

	@FindBy(xpath = "//div[text()='4 GB']/../div[1]")
	public WebElement sorting4GB;

	public MobilePhonesVerification clickon4GBcategory() {
		sorting4GB.click();
		return new MobilePhonesVerification(driver);
	}
	
	String v_productPrice=".//*[@class='_1vC4OE _2rQ-NK']";
	String v_producttitle= ".//*[@class='_3wU53n']";

	@FindBy(xpath = ".//*[@class='_1vC4OE _2rQ-NK']")public List<WebElement> productPrice;
	//@FindBy(xpath = "v_producttitle")	public List<WebElement> producttitle;
	public MobilePhonesVerification clickonProduct()
	{
		
		ArrayList<String> digits = new ArrayList<String>();
		for (int i = 0; i < productPrice.size(); i++) 
		{
			digits.add( productPrice.get(i).getText().replaceAll("/[^0-9]/g", ""));
		}
		
		Collections.sort(digits,Collections.reverseOrder());
		String maxValue=Collections.max(digits);
		System.err.println("Max value is---------------"+maxValue);
		System.out.println("--------------------------------"+driver.findElements(By.xpath(".//div[@class='_1vC4OE _2rQ-NK' and contains(.,'"+maxValue+"')]")).size());
		driver.findElements(By.xpath(".//div[@class='_1vC4OE _2rQ-NK' and contains(.,'"+maxValue+"')]")).get(0).click();
						
				return new MobilePhonesVerification(driver);

	}

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	public WebElement AddtoCartButton;

	public MobilePhonesVerification clickonAddtoCartButton() throws InterruptedException {
		String MainWindow = driver.getWindowHandle();
				ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			for (String window : windowHandles) {
				if (window != MainWindow) 
				{
					driver.switchTo().window(window);

				}
			}
			
			

		
		

		return new MobilePhonesVerification(driver);
	}

}
