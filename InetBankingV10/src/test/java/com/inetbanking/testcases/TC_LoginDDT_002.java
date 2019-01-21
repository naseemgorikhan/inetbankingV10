package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")  //same name of dataprovider and data rovider is teh parameter
	public void loginDDT(String user, String pwd) throws InterruptedException  // this takes username and pass from data provider method
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		logger.info("click on submit");
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)  //test case fail
		{
			driver.switchTo().alert().accept();//close alert box
			driver.switchTo().defaultContent();//focus on page
			Assert.assertTrue(false);
			logger.info("login failed");
			Thread.sleep(3000);
			
		}
		else  // test case pass
		{
			Assert.assertTrue(true);
			logger.info("login pass");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
		}
			
	}
	
	public boolean isAlertPresent()
	{
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
	
	//this is adta provider method to read data from excel
	@DataProvider(name="LoginData")
    public  String [][] getData() throws IOException
    {
    	String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
    	int rownum=XLUtils.getRowCount(path, "Sheet1")	;//row coun;t
    	
    	int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
    	
    	String logindata [][]= new String [rownum][colcount];
    	
    	for(int i=1; i<rownum; i++)	//i=1 because ignore header row from excel file
    	{
    		for(int j=0;j<colcount;j++)
    		{
    			logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);  //i= rownmum and j= col whch is i=1 j=0
    		}
    	}
    	  return logindata;
    			
    }
}
