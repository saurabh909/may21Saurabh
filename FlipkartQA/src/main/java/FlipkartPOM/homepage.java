package FlipkartPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	
	@FindBy (xpath = ("//button[@class='_2KpZ6l _2doB4z']"))
	private WebElement popupclose;
	
	
	@FindBy (xpath = ("//a[text()='Cancellation & Returns']"))
	private WebElement cancellation;
	
	
	
	// constructor
	public homepage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	// methods
	
	public void closepopup() 
	{
		popupclose.click();
	}
	
	public void clickcancel() 
	{
		cancellation.click();
	}
}
