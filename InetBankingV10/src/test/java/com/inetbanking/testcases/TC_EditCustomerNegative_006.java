package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_EditCustomerNegative_006 extends BaseClass{
	
	
	// Invalid data
	
	@Test
	public void EditCustomerNeg() throws InterruptedException, IOException
	{
	  LoginPage lp= new LoginPage(driver);
	     lp.setUserName(username);
	     lp.setPassword(password);
	     lp.clickSubmit();
	     logger.info("Logged in");
	     
		EditCustomerPage editcust = new EditCustomerPage(driver);	
	     
	     logger.info("Enter custid for invalid ");
			editcust.clickEdit();
			Thread.sleep(3000);
			editcust.entercustidtoediti();
	        logger.info("Invalid customer ID entered");
			
			
			editcust.clicksubmittoedit();
			Thread.sleep(3000);
			
			if(isAlertPresent()==true) 
			{
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				Assert.assertTrue(true);
				logger.info("Test case for invalid data passed");
				Thread.sleep(3000);	
				System.out.println("pass");
			}
			else
			{
				captureScreen(driver, "EditCustomerInvalid");
				Assert.assertTrue(false);
				logger.info("test case for invalid data failed");
				System.out.println("fail");
			}
			
		
		}

		private boolean isAlertPresent() {
			try
			{
				driver.switchTo().alert();
				return true;
			}
			catch (NoAlertPresentException e)
			{
				
			return false;
			}
		}
}


