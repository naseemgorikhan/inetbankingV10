package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {

	
	WebDriver ldriver;
	public DeleteCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath="//a[@href='DeleteCustomerInput.php']")
	@CacheLookup
	WebElement lnkDelete;
	
	@FindBy (xpath="//input[@name='cusid']")
	@CacheLookup
	WebElement txtcustid;
	
	@FindBy (xpath="//input[@value='Submit']")
	@CacheLookup
	WebElement btnsubdel;
	
	public void clickDelete()
	{
		lnkDelete.click();
	}

	public void clickentercustId()
	{
		txtcustid.sendKeys("99");
		
	}
	
	public void clickentercustIdValid()
	{
		txtcustid.sendKeys("70570");
		
	}
	
	public void clickentercustIdNull()
	{
		txtcustid.sendKeys(" ");
		
	}

	public void clicksubmitdel()
	{
		btnsubdel.click();
		
	}
}
