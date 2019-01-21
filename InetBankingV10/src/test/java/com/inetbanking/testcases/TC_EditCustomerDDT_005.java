package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_EditCustomerDDT_005 extends BaseClass{
	
	EditCustomerPage editcust= new EditCustomerPage (driver);
	@Test
	public void login() throws IOException, InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("logged in");
		
		//EditCustomerPage editcust= new EditCustomerPage (driver);
		logger.info("Edit custmer details by entering the cust id");
		editcust.clickEdit();
		Thread.sleep(3000);
		
		//editcust.entercustidtoedit();
		
	
	}
	
	@Test(dataProvider="EditData") //same name of dataprovider and data rovider is teh parameter
	public void EditDDT(String custid) throws InterruptedException  // this takes username and pass from data provider method
, IOException
	{
		System.out.println("entere EditDDD");
		Thread.sleep(3000);
		System.out.println(custid);
		editcust.entercustidtoeditD(custid);
		Thread.sleep(3000);
		

		editcust.clicksubmittoedit();
		Thread.sleep(3000);
		
		
		editcust.clickEditadd();
		Thread.sleep(3000);
		
		editcust.clicksub();
		Thread.sleep(3000);
		
		
		boolean re2= driver.getPageSource().contains("Customer details updated Successfully!!!");
		boolean re3= driver.getPageSource().contains("CABADA");
		if(re2 && re3)
		{
			Assert.assertTrue(true);
			logger.info("test case pass");
			System.out.println("test case pass");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("test case fail");
			System.out.println("test case fail");
		}

		
		
		
	}
	
	@DataProvider(name="EditData")
	public String [][] getdata() throws IOException
	{
		//System.out.println("entered");
		
    	String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/EditData.xlsx";
    	int rownum=XLUtils.getRowCount(path, "Sheet1")	;//row coun;t
    	//System.out.println(rownum);
    	int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
    	String d[][]= new String[rownum][colcount];
    //	System.out.println(colcount);
    	for(int i=1;i<rownum;i++)
    	{
    		for(int j=0;j<colcount;j++)
    		{
    	d[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
    	System.out.print(d[i][j]);
    		}
    	}
    	
    	return d;
	}
	
}
