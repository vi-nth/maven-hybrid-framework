package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
	WebDriver driver;

	protected UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isPostInforDisplayedWithPostTitle(String postTile) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE_AT_HOME_PAGE, postTile );
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE_AT_HOME_PAGE, postTile);
	}


	public boolean isPostInforDisplayedWithPostBody(String postTile, String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POSTED_BODY_AT_HOME_PAGE,postTile,postBody);
		return isElementDisplayed(driver, UserPostDetailPageUI.POSTED_BODY_AT_HOME_PAGE,postTile,postBody);
	}

	public boolean isPostInforDisplayedWithAuthorName(String postTile, String authorName) {
		waitForElementVisible(driver, UserPostDetailPageUI.POSTED_AUHOR,postTile,authorName);
		return isElementDisplayed(driver, UserPostDetailPageUI.POSTED_AUHOR,postTile,authorName);
	}

	public boolean isPostInforDisplayedWithCurrentDay(String postTile, String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.POSTED_TIME_AT_HOME_PAGE,postTile,currentDay);
		return isElementDisplayed(driver, UserPostDetailPageUI.POSTED_TIME_AT_HOME_PAGE,postTile,currentDay);
	}


	public boolean isNothingFoundDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


	
}
