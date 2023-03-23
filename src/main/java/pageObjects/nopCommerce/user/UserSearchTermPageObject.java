package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class UserSearchTermPageObject extends FooterContainerPageObject {
	WebDriver driver;
	public UserSearchTermPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
