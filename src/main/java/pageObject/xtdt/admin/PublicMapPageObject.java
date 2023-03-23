package pageObject.xtdt.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PublicMapPageObject extends BasePage{
	WebDriver driver;

	protected PublicMapPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
