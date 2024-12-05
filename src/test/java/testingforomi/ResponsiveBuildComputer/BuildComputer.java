package testingforomi.ResponsiveBuildComputer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testingforomi.Base;

public class BuildComputer extends Base {

	By ItemLocator = By.xpath("//div[@data-productid='16']");
	By ProcessorLocator = By.id("product_attribute_16_5_4");
	By RAMLocator = By.id("product_attribute_16_6_5");
	By HDDLocator = By.id("product_attribute_16_3_6_19");
	By OSLocator = By.id("product_attribute_16_4_7_21");
	By SoftwareLocator = By.id("product_attribute_16_8_8_23");
	By QuantityLocator = By.id("addtocart_16_EnteredQuantity");
	By AddToCarLocator = By.id("add-to-cart-button-16");
	By ConfirmationMessageLocator = By.xpath("//div[@id='bar-notification']//p[@class='content']\n" + "");

	public BuildComputer(WebDriver driver) {
		super(driver);// TODO Auto-generated constructor stub
	}

	public String BuildComputerMethod() {
		click(ItemLocator);
		Select SelectProcessor = new Select(FindElement(ProcessorLocator));
		SelectProcessor.selectByIndex(1);
		Select SelectRam = new Select(FindElement(RAMLocator));
		SelectRam.selectByIndex(2);
		click(RAMLocator);
		click(HDDLocator);
		click(OSLocator);
		click(SoftwareLocator);
		FindElement(QuantityLocator).clear();
		Type("2", QuantityLocator);
		click(AddToCarLocator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationMessageLocator));
		return FindElement(ConfirmationMessageLocator).getText();
	}
}
