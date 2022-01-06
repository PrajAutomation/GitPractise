package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpUser_PO {

	public WebDriver driver;
	public SignUpUser_PO(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement HomeBtn;
	
	@FindBy(xpath="//a[contains(text(),' Signup / Login')]")
	WebElement SignupBtn;
	
	@FindBy(name="name")
	WebElement UserName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement userEmailSignUp;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signUpSubmitBtn;
	
	public WebElement getSignUpSubmitBtn() {
		return signUpSubmitBtn;
	}
	
	public WebElement getUserEmailSignUp() {
		return userEmailSignUp;
	}
	
	//data-qa="signup-button"
	public WebElement getUserName() {
		return UserName;
	}
	
	public WebElement getSignUpBtn() {
		return SignupBtn;
	}
	
	public WebElement getHomeBtn() {
		return HomeBtn;
	}
	
}
