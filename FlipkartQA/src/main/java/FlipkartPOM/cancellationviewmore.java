package FlipkartPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cancellationviewmore {
	
	@FindBy (xpath = ("//span[text()='View More']"))
	private WebElement viewmore;
	
	
	// constructor
	public cancellationviewmore(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	// methods
	
	public void clickviewmore() {
		viewmore.click();
	}
}
