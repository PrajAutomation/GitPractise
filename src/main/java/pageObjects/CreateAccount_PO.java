package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount_PO {

	
	////div[@class='login-form']/h2/b
	
	public WebDriver driver;
	public CreateAccount_PO(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='login-form']/h2/b")
	WebElement headerTxt;
	
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
}
