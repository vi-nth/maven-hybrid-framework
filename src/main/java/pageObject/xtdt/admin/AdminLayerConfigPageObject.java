package pageObject.xtdt.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminLayerConfigPageObject extends BasePage{
	WebDriver driver;

	protected AdminLayerConfigPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
