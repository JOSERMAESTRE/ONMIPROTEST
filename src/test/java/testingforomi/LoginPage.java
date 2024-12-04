package testingforomi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base {
	By UsernameLocator = By.id("Email");
	By PasswordLocator = By.id("Password");
	By RemembermeLocator = By.id("RememberMe");
	By ErrorMessageLocator = By.cssSelector("div.validation-summary-errors");
	By LogInButtonLocator = By.xpath("//input[value='search']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void Login_In(String Username, String Password) {
		Type(Username, UsernameLocator);
		Type(Password, PasswordLocator);
		click(RemembermeLocator);
		click(LogInButtonLocator);
	}

	public boolean IsErrorMessageDisplayed() {
		try {
			WebElement errorMessage = FindElement(ErrorMessageLocator);
			return errorMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	

}
