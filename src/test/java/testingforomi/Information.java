package testingforomi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Information extends Base {
	By FirstNameLocator = By.id("BillingNewAddress_FirstName");
	By LastNameLocator = By.id("BillingNewAddress_LastName");
	By EmailLocator = By.id("BillingNewAddress_Email");
	By CompanyLocator = By.id("BillingNewAddress_Company");
	By CountryLocator = By.id("BillingNewAddress_CountryId");
	By StateLocator = By.id("BillingNewAddress_StateProvinceId");
	By CityLocator = By.id("BillingNewAddress_City");
	By FirstAdressLocator = By.id("BillingNewAddress_Address1");
	By FirstSecondLocator = By.id("BillingNewAddress_Address2");
	By ZipCodeLocator = By.id("BillingNewAddress_ZipPostalCode");
	By PhoneLocator = By.id("BillingNewAddress_PhoneNumber");
	By FaxLocator = By.id("BillingNewAddress_FaxNumber");
	By ShippingAdreesLocator = By.id("shipping-address-select");
	By ShippingMethodLocator = By.id("shippingoption_1");
	By PaymentMethodLocator = By.id("paymentmethod_3");
	By POLocator = By.id("PurchaseOrderNumber");
	
	By ButtonLocator1 = By.xpath("//div[@id='billing-buttons-container']//input[ @title='Continue']");
	By ButtonLocator2 = By.xpath("//div[@id='shipping-buttons-container']//input[ @title='Continue']");
	By ButtonLocator3 = By.xpath(
			"//div[@id='shipping-method-buttons-container']//input[@type='button' and @value='Continue']\r\n" + "");
	By ButtonLocator4 = By.xpath(
			"//div[@id='payment-method-buttons-container']//input[@type='button' and @value='Continue']\r\n" + "");
	By ButtonLocator5 = By.xpath(
			"//div[@id='payment-info-buttons-container']//input[@type='button' and @value='Continue']\r\n" + "");
	By ButtonLocator6 = By.xpath(
			"//div[@id='confirm-order-buttons-container']//input[@type='button' and @value='Confirm']\r\n" + "");

	public Information(WebDriver driver) {
		super(driver);// TODO Auto-generated constructor stub
	}

	public void Billingaddress() {
		Type("jose", FirstNameLocator);
		Type("maestre", LastNameLocator);
		Type("josermaestre@gmail.com", EmailLocator);
		Type("master", CompanyLocator);
		Type("colombia", CountryLocator);
		Type("Other", StateLocator);
		Type("valledupar", CityLocator);
		Type("calle 7c", FirstAdressLocator);
		Type("calle 7b", FirstSecondLocator);
		Type("20005", ZipCodeLocator);
		Type("31945874", PhoneLocator);
		Type("5426", FaxLocator);
		click(ButtonLocator1);
		Select SelectAdress = new Select(FindElement(ShippingAdreesLocator));
		SelectAdress.selectByIndex(0);
		click(ButtonLocator2);
		click(ShippingMethodLocator);
		click(ButtonLocator3);
		click(PaymentMethodLocator);
		click(ButtonLocator4);
		Type("12457", POLocator);
		click(ButtonLocator5);
		click(ButtonLocator6);

	}
}
