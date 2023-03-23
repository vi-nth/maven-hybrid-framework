package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.navigation.SidebarAccountPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserMyProductReviewPageObject extends SidebarAccountPageObject {
	private WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
