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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BuildComputer {
	
	private WebDriver driver;
	private Base Base;
	By ItemLocator = By.xpath("//div[@data-productid='16']");
	By ProcessorLocator = By.id("product_attribute_16_5_4");
	By RAMLocator = By.id("product_attribute_16_6_5");
	By HDDLocator = By.id("product_attribute_16_3_6_19");
	By OSLocator = By.id("product_attribute_16_4_7_21");
	By SoftwareLocator = By.id("product_attribute_16_8_8_23");
	By QuantityLocator = By.id("addtocart_16_EnteredQuantity");
	By AddToCarLocator = By.id("add-to-cart-button-16");
	By ConfirmationMessageLocator = By.xpath("//div[@id='bar-notification']//p[@class='content']\n"
			+ "");

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
		Base.click(ItemLocator);
		Select SelectProcessor = new Select(Base.FindElement(ProcessorLocator));
		SelectProcessor.selectByIndex(1);
		Select SelectRam = new Select(Base.FindElement(RAMLocator));
		SelectRam.selectByIndex(2);
		Base.click(RAMLocator);
		Base.click(HDDLocator);
		Base.click(OSLocator);
		Base.click(SoftwareLocator);
		Base.FindElement(QuantityLocator).clear();
		Base.Type("2", QuantityLocator);
		Base.click(AddToCarLocator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationMessageLocator));
		assertEquals("The product has been added to your shopping cart", Base.FindElement(ConfirmationMessageLocator).getText());
       //System.out.println(Base.FindElement(ConfirmationMessageLocator).getText());
	}

	@AfterClass
	public void afterClass() {
	}


}
