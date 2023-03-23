package pageObject.facebook.verifyElement;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.verifyElement.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	protected LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		
	}

	public boolean isEmailTextboxConfirmationDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX_CONFIRMATION);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public void clickToCloseButtonAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
		
	}

	public boolean isEmailTextboxConfirmationUndisplayed() {
		return isElementUndisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX_CONFIRMATION);
	}


}
