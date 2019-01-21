package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomerNegativeNull extends BaseClass{
	
	@Test
	public void DeleteCustomerNegativeNull() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Logged in");
		
		DeleteCustomer delcust= new DeleteCustomer(driver);
		
delcust.clickDelete();
		
		delcust.clickentercustIdNull();
		Thread.sleep(3000);
		logger.info("Null entered");
		
		delcust.clicksubmitdel();
		logger.info("Delete button hit");
		Thread.sleep(3000);
		
		if(isPresentAlert()==true)
		{
			String g=driver.switchTo().alert().getText();
			System.out.println(g);
			driver.switchTo().alert().accept();
			if(isPresentAlert()==true)
					{
				String g1=driver.switchTo().alert().getText();
				System.out.println(g1);
				driver.switchTo().alert().accept();
				if(g1.equals("Please fill all fields"))
				{
				  logger.info("Test case passed");
				}
				else
				{
					captureScreen(driver, "DeleteCustomerNull");
					logger.info("Test case failed");
				}
					}
          
		
		}
	}

	private boolean isPresentAlert() {
		// TODO Auto-generated method stub
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
