package com.inetbanking.testcases;
import com.inetbanking.pageObjects.*;

import junit.framework.Assert;

import java.io.IOException;

import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass{
	
	
	
	@Test
	public void loginTest() throws IOException
	{
	//	driver.get(baseURL);
		
	//	logger.info("URL opened");
		
		
		//create object for login page to call the methods from the login page
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username entered");
		
		lp.setPassword(password);
		logger.info("Password enetered");
		lp.clickSubmit();
		logger.info("click on submit");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			logger.info("login test pass");
			Assert.assertTrue(true);
			System.out.println("pass");
		}
		else
		{
			captureScreen(driver, "loginTest");
			logger.info("Login test failed");
			Assert.assertTrue(false);
			
		
		}
	}
	
  

}
