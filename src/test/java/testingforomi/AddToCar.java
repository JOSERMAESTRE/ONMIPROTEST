package testingforomi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCar extends Base {
	By SearchBoxLocator = By.id("small-searchterms");
	By SearchButtonLocator = By.xpath("//input[@value='Search']");
	By ItemLocator = By.xpath("//div[@class='item-box']");
	By AddToCarButton = By.xpath("//input[@value='Add to cart']");

	public AddToCar(WebDriver driver) {
		super(driver);// TODO Auto-generated constructor stub
	}

	public void AddtoCart() throws InterruptedException {
		Type("laptop", SearchBoxLocator);
		click(SearchButtonLocator);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (IsDisplayed(ItemLocator)) {
			click(AddToCarButton);
			Thread.sleep(1000);
		} else {
			System.out.print("no se observa el elemento");
		}
	}
}
