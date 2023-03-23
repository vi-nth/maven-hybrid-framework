package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.UserPostSearchPageUI;

public class UserPostSearchPO extends BasePage{
	WebDriver driver;

	protected UserPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundDisplayed() {
		return isElementDisplayed(driver, UserPostSearchPageUI.RESULT_SEARCH_MESSAGE_HOMEPAGE);
	}

}
