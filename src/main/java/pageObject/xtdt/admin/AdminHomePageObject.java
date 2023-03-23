package pageObject.xtdt.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminHomePageObject extends BasePage{
	WebDriver driver;

	protected AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
}
