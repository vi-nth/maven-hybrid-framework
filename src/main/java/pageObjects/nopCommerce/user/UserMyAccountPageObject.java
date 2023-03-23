package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class UserMyAccountPageObject extends FooterContainerPageObject {
	WebDriver driver;
	public UserMyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
