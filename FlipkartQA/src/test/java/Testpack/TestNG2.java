package Testpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import FlipkartPOM.cancellationviewmore;
import FlipkartPOM.homepage;
import setup.Base;
import utils.Utility;

public class TestNG2 extends Base{
	  private WebDriver driver;
	  private homepage hpage;
	  private cancellationviewmore vmore;
	  private SoftAssert soft;
	  int testId;
	  static ExtentTest test;
	  static ExtentHtmlReporter reporter;
	  
	  @Parameters ("browser")
	  @BeforeTest
	        public void launchBrowser(String browserName) {
		  
		  reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
	 		ExtentReports extend = new ExtentReports();
	 		extend.attachReporter(reporter);
			
			if(browserName.equals("Chrome")) {
				
				driver = openChromeBrowser();
			}
			
                if(browserName.equals("Firefox")) {
				
				driver = openFirefoxBrowser();
			}
				
				driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      
	  }
	  
	  @BeforeClass // make pom objects
	  
	  public void createpomobjects() 
	  {
		  hpage = new homepage(driver);
		  vmore = new cancellationviewmore(driver);
		  System.out.println("Before class");
	  }
	
	  
	  @BeforeMethod  
	  
	  public void launchurl() 
	  {
		  driver.get("https://www.flipkart.com/");
		  
		  hpage.closepopup();
		  hpage.clickcancel();
		  
		  System.out.println("Before Method");
		  soft = new SoftAssert();
	  }
	  
	  @Test 
	  
	  public void verifyviewmore() throws IOException 
	  {
		  testId = 2001;
		  
		  vmore.clickviewmore();
		  
		  String url = driver.getCurrentUrl();
		  System.out.print(url);
		  String title = driver.getTitle();
		  System.out.print(title);
		  
		  soft.assertEquals(url, "https://www.flipkart.com/helpcentre?catalog=55c9c6edb000002e002c1701&view=CATALOG");
		  soft.assertEquals(title, "Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
	      soft.assertAll();
	      
	      Utility.capture(driver, testId);
	  }
	  
	  @AfterMethod
	     public void logoutFromApplication() {
		 System.out.println("after method");
		 System.out.println("Logout");
	
	     }
	  
	  @AfterClass  // clean pom objects
	  
	       public void cleanpomobjects() 
	      {
		  hpage = null;
		  vmore = null;
		  System.out.println("after class");	
	       }
	  
	  @AfterTest
           public void closedBrowser() 
	       {
    	      System.out.println("After class");
    	      driver.close();
    	      driver = null ;
    	      System.gc();  // garbage collector - delete unused objects 
            }
	  }
