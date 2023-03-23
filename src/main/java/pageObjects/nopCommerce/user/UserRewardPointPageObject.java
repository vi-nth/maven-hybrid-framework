package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.SidebarAccountPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserRewardPointPageObject extends SidebarAccountPageObject {
	private WebDriver driver;

	public UserRewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
