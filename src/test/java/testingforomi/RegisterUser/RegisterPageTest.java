package testingforomi.RegisterUser;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RegisterPageTest {
	private WebDriver driver;
	private RegisterPage RegisterPage;

	@BeforeClass
	public void beforeClass() {
		RegisterPage = new RegisterPage(driver);
		driver = RegisterPage.WebDriverConnetor();
		driver.manage().window().maximize();
		RegisterPage.visit("https://demowebshop.tricentis.com/register");
	}

	@Test
	public void TestRegister() {
		String[] Datainfo = { "Male", "Rafael", "Diaz", "jose.aja@hotmail.com", "123456", "123456" };
		RegisterPage.RegisterUser(Datainfo);
		assertFalse("El mensaje de error se mostró.", RegisterPage.isErrorMessageDisplayed());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
