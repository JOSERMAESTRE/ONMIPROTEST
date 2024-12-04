package testingforomi;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ResponsiveMenuPage {
	private WebDriver driver;
	private Base Base;
	By BurgerMenuLocator = By.id("mob-menu-button");
	By ButtonLocator1 = By.xpath("//ul[@class='mob-top-menu show']//span[@class='expand']");
	By ButtonLocator2 = By.xpath("//ul[@class='mob-top-menu show']//ul[@class='sublist firstLevel']//li//a");
	By ComfirmationMessage = By.xpath("//div[@class='page-title']//h1");

	@BeforeClass
	public void beforeClass() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone XR"));

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver(options);

		Base = new Base(driver);
		driver.manage().window().setSize(new Dimension(375, 812));
		Base.visit("https://demowebshop.tricentis.com/");
	}

	@Test
	public void MenuBurgerTesting() throws InterruptedException {
		Base.click(BurgerMenuLocator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonLocator1));
		Base.click(ButtonLocator1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonLocator2));
		Base.click(ButtonLocator2);
		assertEquals("Desktops", Base.FindElement(ComfirmationMessage).getText());

	}

	@AfterClass
	public void afterClass() {
	}

}
