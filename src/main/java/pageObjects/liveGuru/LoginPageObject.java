package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;
import pageUIs.liveGuru.RegisterPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToLoginEmailTextbox(String email) {
		waitForAllElementVisible(driver, LoginPageUI.LOGIN_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.LOGIN_EMAIL_TEXTBOX, email);
		
	}

	public void inputToLoginPasswordTextbox(String password) {
		waitForAllElementVisible(driver, LoginPageUI.LOGIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.LOGIN_PASSWORD_TEXTBOX, password);
		
	}

	public MyDashboardPageObject clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}
}
