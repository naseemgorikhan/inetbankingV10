package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
//import com.inetbanking.pageObjects.*;

public class TC_EditCustomer_004 extends BaseClass{
	

	@Test
	public void EditCustomer() throws IOException, InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("logged in");
		
		//Edit 
		
	
		EditCustomerPage editcust= new EditCustomerPage (driver);
		logger.info("Edit custmer details by entering the cust id");
		editcust.clickEdit();
		Thread.sleep(3000);
		editcust.entercustidtoedit();
        logger.info("valid customer ID entered");
		
		
		editcust.clicksubmittoedit();
		Thread.sleep(3000);
		
		editcust.clickEditadd();
		Thread.sleep(3000);
		
		editcust.clicksub();
		Thread.sleep(3000);
		
		boolean re2= driver.getPageSource().contains("Customer details updated Successfully!!!");
		//boolean re3= driver.getPageSource().contains("USA");
		if(re2)
		{
			Assert.assertTrue(true);
			logger.info("test case pass for valid custid");
			
			
		}
		else
		{
			captureScreen(driver, "EditCustomer");
			Assert.assertTrue(false);
			logger.info("test case fail");
			System.out.println("test case fail");
		}

	}
	

}
