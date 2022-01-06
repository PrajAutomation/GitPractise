package appShoping;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateAccount_PO;
import pageObjects.SignUpUser_PO;
import resources.BaseInitializer;

public class RegisterUser extends BaseInitializer{
	
	WebDriver driver;
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void registerUser() {
		driver.get(prop.getProperty("url"));
		SignUpUser_PO spo = new SignUpUser_PO(driver);
		spo.getSignUpBtn().click();
		spo.getUserName().sendKeys("Prasann");
		spo.getUserEmailSignUp().sendKeys("xyz@gmail.com");
		spo.getSignUpSubmitBtn().click();
		CreateAccount_PO cpo = new CreateAccount_PO(driver);
		String actualHeader = cpo.getHeaderTxt().getText();
		System.out.println(actualHeader);
		Assert.assertTrue(actualHeader.equals("ENTER ACCOU INFORMATION"), "Test Case failed");
		
	}

	@AfterTest
	public void tearDown() {
		
		System.out.println("Inside closing browser");
		//New Changes
		driver.close();
	}
}
