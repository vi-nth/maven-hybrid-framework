package pageObject.jQuery.dataTable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.dataTable.JQueryHomePageUI;

public class JQueryHomePageObject extends BasePage {
	WebDriver driver;

	protected JQueryHomePageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void enterToTextboxByColumnName(String columnName, String datainput) {
		waitForElementVisible(driver, JQueryHomePageUI.COLUMN_NAME, columnName);
		sendkeyToElement(driver, JQueryHomePageUI.COLUMN_NAME, datainput, columnName);
		pressKeyToElement(driver, JQueryHomePageUI.COLUMN_NAME, Keys.ENTER, columnName);

	}

	public boolean verifyDataDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, JQueryHomePageUI.DATA_DISPLAYED, female, country, male, total);
		return isElementDisplayed(driver, JQueryHomePageUI.DATA_DISPLAYED, female, country, male, total);
	
	}

	public void clickToActionButtonByFemale(String female, String actionName) {
		waitForElementClickable(driver, JQueryHomePageUI.EDIT_OR_REMOVE, female, actionName);
		clickToElement(driver, JQueryHomePageUI.EDIT_OR_REMOVE, female, actionName);
		
	}

	public void clickToPageNumber(String pageNumber) {
		waitForElementClickable(driver, JQueryHomePageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, JQueryHomePageUI.PAGE_NUMBER,pageNumber);
		
	}

	public boolean verifyPageNumberDisplayed(String pageNumber) {
		waitForElementVisible(driver, JQueryHomePageUI.PAGE_NUMBER_DISPLAYED, pageNumber);
		return isElementDisplayed(driver, JQueryHomePageUI.PAGE_NUMBER_DISPLAYED, pageNumber);
	
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, JQueryHomePageUI.LOAD_BUTTON);
		clickToElement(driver, JQueryHomePageUI.LOAD_BUTTON);
		
	}

	public void enterToTextboxAtRowAndColumnName(String columnName, String rowName, String dataInput) {
		int columnIndex = getElementSize(driver, JQueryHomePageUI.COLUMN_INDEX, columnName)+1;
		waitForElementVisible(driver, JQueryHomePageUI.TEXTBOX_AT_ROW_AND_COLUMN_NAME, rowName, String.valueOf(columnIndex));
		sendkeyToElement(driver, JQueryHomePageUI.TEXTBOX_AT_ROW_AND_COLUMN_NAME, dataInput, rowName, String.valueOf(columnIndex));
		
	}

	public void selectCountryValueAtRowAndColumnName(String columnName, String rowName, String valueSelected) {
		int columnIndex = getElementSize(driver, JQueryHomePageUI.COLUMN_INDEX, columnName)+1;
		waitForElementVisible(driver, JQueryHomePageUI.SELECT_VALUE_AT_DROPDOWN, rowName, String.valueOf(columnIndex));
		selectItemInDefautlDropDown(driver, JQueryHomePageUI.SELECT_VALUE_AT_DROPDOWN, valueSelected, rowName, String.valueOf(columnIndex));
	}

	public void checkToCheckboxAtRowAndColumnName(String columnName, String rowName) {
		int columnIndex = getElementSize(driver, JQueryHomePageUI.COLUMN_INDEX, columnName)+1;
		waitForElementClickable(driver, JQueryHomePageUI.POSTER_CHECKBOX, rowName, String.valueOf(columnIndex));
		checkToCheckboxOrRadio(driver, JQueryHomePageUI.POSTER_CHECKBOX, rowName, String.valueOf(columnIndex));
		
	}

	public void uncheckToCheckboxAtRowAndColumnName(String columnName, String rowName) {
		int columnIndex = getElementSize(driver, JQueryHomePageUI.COLUMN_INDEX, columnName)+1;
		waitForElementClickable(driver, JQueryHomePageUI.POSTER_CHECKBOX, rowName, String.valueOf(columnIndex));
		uncheckToCheckboxOrRadio(driver, JQueryHomePageUI.POSTER_CHECKBOX, rowName, String.valueOf(columnIndex));
		
	}

	public void clickToActionButtonByRowNumber(String rowName, String actionButton) {
		waitForElementClickable(driver, JQueryHomePageUI.ACTION_BUTTON,rowName, actionButton);
		clickToElement(driver, JQueryHomePageUI.ACTION_BUTTON, rowName, actionButton);
		
	}

	public void clickToFooterButtonName(String footerButtonName) {
		waitForElementClickable(driver, JQueryHomePageUI.FOOTER_BUTTON, footerButtonName);
		clickToElement(driver, JQueryHomePageUI.FOOTER_BUTTON, footerButtonName);
		
	}

	

}
