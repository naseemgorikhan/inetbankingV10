package com.inetbanking.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomerValid extends BaseClass{
	
	@Test
	public void DeleteCustomerValid() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Logged in");
		
		DeleteCustomer delcust= new DeleteCustomer(driver);
delcust.clickDelete();
		
		delcust.clickentercustIdValid();
		Thread.sleep(3000);
		logger.info("ID entered");
		
		delcust.clicksubmitdel();
		logger.info("Delete button hit");
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			System.out.println("yes");
			//String t1= driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			
			if(isAlertPresent()==true)
			{
				//String t2= driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
			}
				//delcust.clickDelete();
				
				delcust.clickentercustIdValid();
				Thread.sleep(3000);
				logger.info("ID entered");
				
				delcust.clicksubmitdel();
				logger.info("Delete button hit for same ");
				Thread.sleep(3000);
				
				if(isAlertPresent()==true)
				{
					//String u2= driver.switchTo().alert().getText();
					driver.switchTo().alert().accept();
					
					if(isAlertPresent()==true)
					{
						String u3= driver.switchTo().alert().getText();
						driver.switchTo().alert().accept();
						
					if(u3.equals("Customer does not exist!!"))
					{
						logger.info("Test case passed");
						
					}
					else
					{
						logger.info("test case failed");
					}	
				}
				
				}	
				
			}	
			
		}	
	
		
		
	

	private boolean isAlertPresent() {
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
