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

public class BuildComputerTest {

	private WebDriver driver;
	private BuildComputer BuildComputer;

	@BeforeClass
	public void beforeClass() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone XR"));

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver(options);

		BuildComputer = new BuildComputer(driver);
		driver.manage().window().setSize(new Dimension(375, 812));
		BuildComputer.visit("https://demowebshop.tricentis.com/");
	}

	@Test
	public void MenuBurgerTesting() throws InterruptedException {
		assertEquals("The product has been added to your shopping cart", BuildComputer.BuildComputerMethod());
	}

	@AfterClass
	public void afterClass() {
	}

}
