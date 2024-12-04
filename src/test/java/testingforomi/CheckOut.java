package testingforomi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		click(LinkShoppingCarLocator);
		click(TermsCheckLocator);
		click(CheckOutButtonLocator);
		click(GuestButtonLocator);
	}
}
