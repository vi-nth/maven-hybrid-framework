package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAboutUsPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserSearchTermPageObject;
import pageUIs.navigation.FooterContainerPageUI;

public class FooterContainerPageObject extends BasePage {
	WebDriver driver;

	public FooterContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	
	public UserAboutUsPageObject openUserAboutUsPage() {
		waitForElementClickable(driver, FooterContainerPageUI.ABOUT_US);
		clickToElement(driver, FooterContainerPageUI.ABOUT_US);
		return PageGeneratorManager.getUserAboutUsPage(driver);
		
	}
	
	public UserSearchTermPageObject openUserSearchTermPage() {
		waitForElementClickable(driver, FooterContainerPageUI.SEARCH_TERM);
		clickToElement(driver, FooterContainerPageUI.SEARCH_TERM);
		return PageGeneratorManager.getUserSearchTermPage(driver);
	}
	
	public UserMyAccountPageObject openUserMyAccountPage() {
		waitForElementClickable(driver, FooterContainerPageUI.MY_ACCOUNT);
		clickToElement(driver, FooterContainerPageUI.MY_ACCOUNT);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}
}
