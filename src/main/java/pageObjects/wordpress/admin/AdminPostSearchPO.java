package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	protected AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickOnAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);

	}

	public void enterInSearchTextbox(String postTile) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTile);

	}

	public void clickOnSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);

	}

	public boolean isTableInforDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_INDEX_BY_HEADER_NAME, headerID) + 1;

		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,
				String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,
				String.valueOf(headerIndex), cellValue);
	}

	public AdminPostAddNewPO clickOnPostTitleDetailLink(String postTile) {
		waitForElementClickable(driver, AdminPostSearchPageUI.POST_TITLE_IN_GRID, postTile);
		clickToElement(driver, AdminPostSearchPageUI.POST_TITLE_IN_GRID,postTile );
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
		
	}

	public void checkOnPostDetailCheckbox(String editPostTile) {
		waitForElementClickable(driver, AdminPostSearchPageUI.POST_TITLE_CHECKBOX, editPostTile);
		clickToElement(driver,AdminPostSearchPageUI.POST_TITLE_CHECKBOX, editPostTile);
		
	}

	public void selectMoveToTraskItem(String dropdownItem) {
		waitForElementClickable(driver, AdminPostSearchPageUI.SELECT_MOVE_TO_TRASH_IN_DROPDOWN);
		selectItemInDefautlDropDown(driver, AdminPostSearchPageUI.SELECT_MOVE_TO_TRASH_IN_DROPDOWN, dropdownItem);
		
	}

	public void clickOnApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		
	}

	public void isPostMovedToTheTrashDisplayed() {
		waitForElementVisible(driver, AdminPostSearchPageUI.CONFIRMED_DELETE_MESSAGE);
		isElementDisplayed(driver, AdminPostSearchPageUI.CONFIRMED_DELETE_MESSAGE);
		
	}

	public void isNoPostsFoundMessageDisplayed() {
		waitForElementVisible(driver, AdminPostSearchPageUI.ADMIN_RESULT_SEARCH_MESSAGE);
		isElementDisplayed(driver, AdminPostSearchPageUI.ADMIN_RESULT_SEARCH_MESSAGE);
		
	}

	



}
