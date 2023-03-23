package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.FooterContainerPageObject;

public class UserAboutUsPageObject extends FooterContainerPageObject {
	WebDriver driver;
	
	public UserAboutUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	
}
