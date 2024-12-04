package testingforomi;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedSearch extends Base {

	By ResponseLocator = By.xpath("//div[@class='search-results']//strong[@class='result']");
	By SearchBarLocator = By.id("small-searchterms");
	By SearchButtonLocator = By.xpath("//input[@value='Search']");
	By AdvancedLocator = By.id("As");
	By CategoryLocator = By.id("Cid");
	By SubCategoryLocator = By.id("Isc");
	By ManofacturerLocator = By.id("Mid");
	By PriceFromLocator = By.id("Pf");
	By PriceToLocator = By.id("Pt");
	By ProductdescriptionLocator = By.id("Sid");
	By AdSearchButtonLocator = By.xpath("//input[@class='button-1 search-button' and @value='Search'] ");

	public AdvancedSearch(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	public void AdvancedSearchMethod(String search, String lowprice, String topPrice) {
		Type(search, SearchBarLocator);
		click(SearchButtonLocator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdvancedLocator));
		click(AdvancedLocator);
		Select SelectCategory = new Select(FindElement(CategoryLocator));
		SelectCategory.selectByIndex(2);
		click(SubCategoryLocator);
		Select SelectManofacturer = new Select(FindElement(ManofacturerLocator));
		SelectManofacturer.selectByIndex(0);
		Type(lowprice, PriceFromLocator);
		Type(topPrice, PriceToLocator);
		click(ProductdescriptionLocator);
		click(AdSearchButtonLocator);

	}

	public boolean IsErrorMessageDisplayed() {
		try {
			WebElement errorMessage = FindElement(ResponseLocator);
			return errorMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
