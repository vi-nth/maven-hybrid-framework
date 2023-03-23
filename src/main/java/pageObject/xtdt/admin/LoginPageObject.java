package pageObject.xtdt.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	protected LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
