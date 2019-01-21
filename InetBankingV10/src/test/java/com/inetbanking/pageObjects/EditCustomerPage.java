package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testcases.BaseClass;

public class EditCustomerPage extends BaseClass {
	WebDriver ldriver;
	
	 public EditCustomerPage(WebDriver rdriver) {

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy (xpath="//a[contains(text(),'Edit Customer')]")	
	@CacheLookup
	WebElement lnkEditCust;
	
	@FindBy (name="cusid")	
	@CacheLookup
	WebElement txteditcustid;
	

	@FindBy (xpath="//input[@value='Submit']")	
	@CacheLookup
	WebElement btnsubmittoedit;
	
	
	@FindBy (name="sub")	
	@CacheLookup
	WebElement btnsub;
	
	
	//edit cust fields
	
	@FindBy (name="addr")	
	@CacheLookup
	WebElement txteditaddr;
	
	 public void clickEdit()
	   {
		   lnkEditCust.click();
	   }
	   
	   public void entercustidtoeditD(String i)
	   {
		   txteditcustid.sendKeys(i);
	   }
	   
	   public void entercustidtoedit()
	   {
		   txteditcustid.sendKeys("88812");
	   }
	   
	   public void entercustidtoediti()
	   {
		   txteditcustid.sendKeys("111");
	   }
	   
	   public void clicksubmittoedit()
	   {
		 btnsubmittoedit.click();
	   }
	   
	   //edit methods
	   public void clickEditadd()
	   {
		     txteditaddr.clear();
		     String newadd=randomestring();
		   txteditaddr.sendKeys(newadd);
		  
		   
	   }
	   
	   public void clicksub()
	   {
		   btnsub.click();
	   }
	
}
