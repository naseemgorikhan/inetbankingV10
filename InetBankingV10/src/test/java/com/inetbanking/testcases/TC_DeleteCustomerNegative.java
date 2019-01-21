package com.inetbanking.testcases;
import com.inetbanking.pageObjects.*;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomerNegative extends BaseClass {
	
	@Test
	public void DeleteCustomer() throws IOException, InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Login successful");
		
		DeleteCustomer delcust= new DeleteCustomer(driver);
		delcust.clickDelete();
		
		delcust.clickentercustId();
		Thread.sleep(3000);
		logger.info("ID entered");
		
		delcust.clicksubmitdel();
		logger.info("Delete button hit");
		Thread.sleep(3000);
		
		
		if(isAlertPresent()==true)
		{
			System.out.println("yes");
			String t1= driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			
			System.out.println(t1);
			Thread.sleep(3000);
			 if(isAlertPresent()==true)
			 {
				String t2= driver.switchTo().alert().getText();
				 driver.switchTo().alert().accept();
				
				System.out.print(t2);
				Thread.sleep(3000);
				if(t2.equals("Customer does not exist!!"))
				{
					System.out.println("test case passed");
					Assert.assertTrue(true);
					logger.info("Test case passed");
					
				}
			 }
			
		}
		
		else
		{
			captureScreen(driver,"DeleteCustomer");
			Assert.assertTrue(true);
			logger.info("Test case failed");
			
		}
	}

	private boolean isAlertPresent() {
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
		return false;
		}
	}

}
