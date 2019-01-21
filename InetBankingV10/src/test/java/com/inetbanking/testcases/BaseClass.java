package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig(); //object to call methods in readconfig
	
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password =readconfig.getPassword();
	public static WebDriver driver;
	
	
	public static Logger logger;  // adding logger class object 
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse n\\chromedriver_win32/chromedriver.exe");

		 logger = logger.getLogger("Inetbanking");  //adding logger
		  PropertyConfigurator.configure("log4j (2).properties");//adding logger
		  
		if(br.equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");
	
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		
		
		
	  driver= new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"//Drivers//geckodriver.exe");

			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			 driver= new FirefoxDriver();
		}
		
		
		else if(br.equals("IE"))
			
			{
			System.out.println("IEEEEE");
				//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"//Drivers//geckodriver.exe");

				System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
				 driver= new InternetExplorerDriver();
			}
	
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	 
	  
	  
	}
	
	@AfterClass
    void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/" + tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshots taken");
		
		
	}
	
	//method to generate a random string of characters keep this method in baseclass to be used by other test cases
		public static String randomestring()
		{
			String generatestring = RandomStringUtils.randomAlphabetic(8);
			return generatestring;
		}
}
