package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//All other elements on new customer add page
		@FindBy(xpath="//a[contains(text(),'New Customer')]")
		@CacheLookup
		WebElement lnknewCust;
		
		
		@FindBy(xpath="//input[@name='name']")
		@CacheLookup
		WebElement txtCustName;
		
		
		@FindBy(name="rad1")
		@CacheLookup
		WebElement rdGender;
		
		
		@FindBy(name="dob")
		@CacheLookup
		WebElement txtdob;	
		
		@FindBy(name="addr")
		@CacheLookup
		WebElement txtAdd;
		
		
		@FindBy(name="city")
		@CacheLookup
		WebElement txtCity;
		

		@FindBy(name="state")
		@CacheLookup
		WebElement txtState;
		

		@FindBy(name="pinno")
		@CacheLookup
		WebElement txtpinno;
		
		

		@FindBy(name="telephoneno")
		@CacheLookup
		WebElement txtTel;
		
		

		@FindBy(name="emailid")
		@CacheLookup
		WebElement txtemail;
		
		
		@FindBy(xpath="//input[@name='password']")
		@CacheLookup
		WebElement txtPass;
		
		
		@FindBy(xpath="//input[@value='Submit']")
		@CacheLookup
		WebElement btnSubmit;
		
   public void clickAddCustomer()
   {
	   lnknewCust.click();
   }
   
   public void custName(String cname)
   {
	   txtCustName.sendKeys(cname);
   }

   
   public void custgender(String cgender)
   {
	   rdGender.click();
   }
   
   public void custdob(String mm, String dd, String yy)
   {
	   String h= mm+ "-" + dd+"-" +yy;
	   txtdob.sendKeys(h);
	   System.out.println(h);
	   //txtdob.sendKeys(mm");
	  // txtdob.sendKeys(dd);
	  // txtdob.sendKeys(yy);
   }
   
   public void custadd(String cadd)
   {
	   txtAdd.sendKeys(cadd);
   }
   
   public void custcity(String ccity)
   {
	   txtCity.sendKeys(ccity);
   }
   
   public void custstate(String cstate)
   {
	   txtState.sendKeys(cstate);
   }
   
   public void custpinno(String cpin)
   {
	   txtpinno.sendKeys(String.valueOf(cpin));//convert to string
   }
   
   public void custtel(String ctel)
   {
	   txtTel.sendKeys(ctel);
   }
   
   public void custemail(String cemail)
   {
	   txtemail.sendKeys(cemail);
   }
   
   public void custpass(String cpass)
   {
	   txtPass.sendKeys(cpass);
   }
   
   public void clicknewcust()
   {
	   btnSubmit.click();
   }
   
}
