package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.UserHomePageUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	protected UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTile(String postTile) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_AT_HOME_PAGE, postTile);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_AT_HOME_PAGE, postTile);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTile, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POSTED_BODY_AT_HOME_PAGE, postTile, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POSTED_BODY_AT_HOME_PAGE, postTile, postBody);
	}

	public boolean isPostInforDisplayedWithAuthorName(String postTile, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POSTED_AUHOR, postTile, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POSTED_AUHOR, postTile, authorName);
	}

	public boolean isPostInforDisplayedWithCurrentDay(String postTile, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POSTED_TIME_AT_HOME_PAGE, postTile, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POSTED_TIME_AT_HOME_PAGE, postTile, currentDay);
	}

	public UserPostDetailPO clickOnPostTitle(String postTile) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_AT_HOME_PAGE, postTile);
		clickToElement(driver, UserHomePageUI.POST_TITLE_AT_HOME_PAGE, postTile);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public  boolean isPostInforUndisplayedWithPostTile(String editPostTile) {
		 return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_AT_HOME_PAGE, editPostTile);
	}

	public void enterToSearchBox(String editPostTile) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX_AT_HOMEPAGE, editPostTile);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX_AT_HOMEPAGE, editPostTile);
		sleepInSecond(2);

	}

	public UserPostSearchPO clickOnSearchButtonAtHomePage() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON_HOMEPAGE);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON_HOMEPAGE);
		return PageGeneratorManager.getUserPostSearchPage(driver);
	}
}