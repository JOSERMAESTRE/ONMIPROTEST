package testingforomi;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertFalse;

import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class AdvancedSearchTest {
	private WebDriver driver;
	private AdvancedSearch AdvancedSearch;

  @BeforeClass
  public void beforeClass() {
	  ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone XR"));
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver(options);
		AdvancedSearch = new AdvancedSearch(driver);
		driver.manage().window().setSize(new Dimension(375, 812));
		AdvancedSearch.visit("https://demowebshop.tricentis.com/");
  }
	  @Test
	  public void AdvancedSearchTesting() {
		  AdvancedSearch.AdvancedSearchMethod("computer", "800", "1200"); 
		assertFalse("No products were found that matched your criteria.", AdvancedSearch.IsErrorMessageDisplayed());
	  }

  @AfterClass
  public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		//driver.quit();
  }

}
