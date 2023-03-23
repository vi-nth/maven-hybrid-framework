package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{
	WebDriver driver;

	protected AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterInUsernameTextbox(String adminUsername) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_USER_NAME);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_USER_NAME, adminUsername);
		
	}

	public void enterInPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD, adminPassword);
		
	}

	public AdminDashboardPO clickOnLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
		
	}

	
}
