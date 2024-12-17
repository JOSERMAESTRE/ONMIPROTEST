package testingforomi.Shopping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testingforomi.Base;

public class CheckOut extends Base {
	By LinkShoppingCarLocator = By.id("topcartlink");
	By TermsCheckLocator = By.id("termsofservice");
	By CheckOutButtonLocator = By.id("checkout");
	By GuestButtonLocator = By.xpath("//input[@value='Checkout as Guest']");

	public CheckOut(WebDriver driver) {
		super(driver);// TODO Auto-generated constructor stub
	}

	public void CheckingOut() {
		System.out.println(FindElement(LinkShoppingCarLocator).getText());
		WebDriverWait Wait =   new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement linkShoppincar = Wait.until(ExpectedConditions.visibilityOfElementLocated(LinkShoppingCarLocator));
		click(linkShoppincar);
		//click(LinkShoppingCarLocator);
		click(TermsCheckLocator);
		click(CheckOutButtonLocator);
		click(GuestButtonLocator);
	}
}
