package com.Flipkart.Electonics.Mobile;

import org.testng.annotations.Test;

import com.Flipkart.init.Common;
import com.Flipkart.init.SeleniumInit;

import junit.framework.Assert;

public class MobilePhonesIndex extends SeleniumInit
{
	
	@Test
	public void mobile() throws InterruptedException
	{
		int fail=0;
		int step = 1;

		Common.log("Step " + step++ + ": Open the" + TestURL);
		
		Thread.sleep(2000);

		Common.log("Verify the 'X' button is available");
		if(mobilePhonesVerification.showloginXbutton())
		{
			Common.log("Result is Pass:" + mobilePhonesVerification.loginX.getText() + " button is shown");
			
			System.out.println("This Statement is from MobilePhonesIndex..................................................................");
		}
		else
		{
			Common.log("Result is Fail:" + mobilePhonesVerification.loginX.getText() + " button is not shown");
			fail++;
		}
		
		Common.log("Step " + step++ + ": Click on 'X' button");
		mobilePhonesIndexPage.clickonloginXbutton();
		
		Thread.sleep(3000);
		
		Common.log("Verify the 'Electronics' button is available");
		if(mobilePhonesVerification.showElectronicsMenu())
		{
			Common.log("Result is Pass:" + mobilePhonesVerification.ElectronicsMenu.getText() + " button is shown");
		}
		else
		{
			Common.log("Result is Fail:" + mobilePhonesVerification.ElectronicsMenu.getText() + " button is not shown");
			fail++;
			
		}
		
		Common.log("Step " + step++ + ": Hower on 'Electronics' button");
		mobilePhonesIndexPage.clickOnElectronicsMenu();
		
		Thread.sleep(5000);
		
		Common.log("Step " + step++ + ": Click and select on mobile brands");
		mobilePhonesIndexPage.clickOnMobileBrandNameItem();
		
		Common.log("Step " + step++ + ": Click and drag the price slider");
		mobilePhonesIndexPage.clickOnPriceslider();
		
		Thread.sleep(2000);
		Common.log("Step " + step++ + ": Click on '4 GB' check box");
		mobilePhonesVerification=mobilePhonesIndexPage.clickon4GBcategory();
	
		Thread.sleep(2000);
		Common.log("Step " + step++ + ": Click on ''Product Item link");
		mobilePhonesIndexPage.clickonProduct();
		
		Common.log("Step " + step++ + ": Click on ''Add to Cart' link");
		mobilePhonesIndexPage.clickonAddtoCartButton();

		
		
		
		if(fail>0)
		{
			Assert.assertTrue(false);			
		}
		
	}

}
