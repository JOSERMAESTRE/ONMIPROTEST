package testingforomi.RegisterUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testingforomi.Base;

public class RegisterPage extends Base {
	By GenderLocator = By.id("gender-male");
	By FirstNameLocator = By.id("FirstName");
	By LastNameLocator = By.id("LastName");
	By EmailLocator = By.id("Email");
	By PasswordLocator = By.id("Password");
	By ConfirmPasswordLocator = By.id("ConfirmPassword");
	By RegisterButtonLocator = By.id("register-button");
	By ErrorMessageLocator = By.cssSelector("div.validation-summary-errors");

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void RegisterUser(String[] Data) {
		if (Data[0].equals("Male")) {
			click(GenderLocator);
		}
		Type(Data[1], FirstNameLocator);
		Type(Data[2], LastNameLocator);
		Type(Data[3], EmailLocator);
		Type(Data[4], PasswordLocator);
		Type(Data[5], ConfirmPasswordLocator);
		click(RegisterButtonLocator);
	}

	public boolean isErrorMessageDisplayed() {
		try {
			WebElement errorMessagea = FindElement(ErrorMessageLocator);
			return errorMessagea.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
