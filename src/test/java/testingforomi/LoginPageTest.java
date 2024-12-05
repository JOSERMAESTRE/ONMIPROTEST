package testingforomi;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class LoginPageTest {
	private WebDriver driver;
	private LoginPage LoginPage;

	@BeforeClass
	public void beforeClass() {
		LoginPage = new LoginPage(driver);
		driver = LoginPage.WebDriverConnetor();
		driver.manage().window().maximize();
		LoginPage.visit("https://demowebshop.tricentis.com/login");
	}

	@Test
	public void TestLogin() {
		LoginPage.Login_In("Masterjr@gmail.com", "123456");
		assertFalse("El mensaje de error se mostró.", LoginPage.IsErrorMessageDisplayed());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
