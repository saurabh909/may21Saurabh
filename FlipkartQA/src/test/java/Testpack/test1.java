package Testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import FlipkartPOM.cancellationviewmore;
import FlipkartPOM.homepage;

public class test1 {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Saurabh Zend\\Desktop\\selinum\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.flipkart.com/");
	
	homepage home = new homepage(driver);
	home.closepopup();
	   
	Thread.sleep(2000);
	home.clickcancel();
	
	Thread.sleep(2000);
	
	cancellationviewmore view = new cancellationviewmore(driver);
	Thread.sleep(2000);
	view.clickviewmore();
	
	driver.close();
	

}
}