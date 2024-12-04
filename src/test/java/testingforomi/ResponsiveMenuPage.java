package testingforomi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResponsiveMenuPage extends Base {
	By BurgerMenuLocator = By.id("mob-menu-button");
	By ButtonLocator1 = By.xpath("//ul[@class='mob-top-menu show']//span[@class='expand']");
	By ButtonLocator2 = By.xpath("//ul[@class='mob-top-menu show']//ul[@class='sublist firstLevel']//li//a");
	By ComfirmationMessage = By.xpath("//div[@class='page-title']//h1");

	public ResponsiveMenuPage(WebDriver driver) {
		super(driver);// TODO Auto-generated constructor stub
	}

	public String InteractMenu() {
		click(BurgerMenuLocator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonLocator1));
		click(ButtonLocator1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonLocator2));
		click(ButtonLocator2);
		return FindElement(ComfirmationMessage).getText();
	}
}
