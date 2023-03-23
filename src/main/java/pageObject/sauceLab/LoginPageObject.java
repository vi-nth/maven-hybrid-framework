package pageObject.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauceLab.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	protected LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserTextbox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USER_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_TEXTBOX, userName);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public ProductPageObject clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);


	}

}
