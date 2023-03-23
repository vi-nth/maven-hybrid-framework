package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage{
	WebDriver driver;

	protected AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterInPostTitle(String postTile) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADMIN_POST_TITLE);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADMIN_POST_TITLE, postTile);
		
	}

	public void enterInPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.ADMIN_POST_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.ADMIN_POST_BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADMIN_POST_BODY);
		sendkeyToElement(driver,  AdminPostAddNewPageUI.ADMIN_POST_BODY, postBody);
		
	}

	public void clickOnPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		
	}

	public void clickOnPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		
	}

	public boolean isPostPublishedDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

	public void enterInEditPostBody(String editPostBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.ADMIN_POST_BODY);
		clickToElement(driver, AdminPostAddNewPageUI.ADMIN_POST_BODY);
		
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADMIN_POST_BODY);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.ADMIN_POST_BODY);
		sendkeyToElement(driver,  AdminPostAddNewPageUI.ADMIN_POST_BODY, editPostBody);
		
	}

	public void clickOnUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.UPDATE_BUTTON);
	}

}
