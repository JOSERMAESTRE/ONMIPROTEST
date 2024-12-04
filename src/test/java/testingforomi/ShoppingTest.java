package testingforomi;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ShoppingTest {
	private WebDriver driver;
	private Base Base;
	private AddToCar AddToCar;
	private CheckOut CheckOut;
	private Information Information;
	By ComfirmationOrderMessage = By.xpath("//div[@class='title']");

	@BeforeClass
	public void beforeClass() {
		Base = new Base(driver);
		driver = Base.WebDriverConnetor();
		driver.manage().window().maximize();
		Base.visit("https://demowebshop.tricentis.com/");

		AddToCar = new AddToCar(driver);
		CheckOut = new CheckOut(driver);
		Information = new Information(driver);

	}

	@Test
	public void ShopTest() throws InterruptedException {
		AddToCar.AddtoCart();
		CheckOut.CheckingOut();
		Information.Billingaddress();
		assertEquals("Your order has been successfully processed!",
				Base.FindElement(ComfirmationOrderMessage).getText());
	}

	@AfterClass
	public void afterClass() {
	}

}
