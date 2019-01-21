package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003  extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("login completed");
		Thread.sleep(3000);
		
		//craete object to call methods from ass customer page
		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("providing cust detail");
		addcust.clickAddCustomer();
		addcust.custName("Naseem");
		addcust.custgender("Female");
		addcust.custdob("19", "12", "1999");
		Thread.sleep(4000);
		addcust.custadd("Enfield");
		addcust.custcity("Missi");
		addcust.custstate("Ontario");
		addcust.custpinno("1234");
		addcust.custtel("9089898");
	
		addcust.custpass("pass123");
		
		String emai=randomestring() + "@gmail.com";
		addcust.custemail(emai);
		System.out.println(emai);
		addcust.clicknewcust();
		logger.info("validating adding new customer");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	

}

