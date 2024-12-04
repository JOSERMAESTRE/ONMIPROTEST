package testingforomi;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;

public class ResponsiveMenuPageTest {
	private WebDriver driver;
	private ResponsiveMenuPage ResponsiveMenuPage;

	@BeforeClass
	public void beforeClass() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone XR"));
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver(options);
		ResponsiveMenuPage = new ResponsiveMenuPage(driver);
		driver.manage().window().setSize(new Dimension(375, 812));
		ResponsiveMenuPage.visit("https://demowebshop.tricentis.com/");
	}

	@Test
	public void MenuBurgerTesting() {
		assertEquals("Desktops", ResponsiveMenuPage.InteractMenu());
	}

	@AfterClass
	public void afterClass() {
	}

}
