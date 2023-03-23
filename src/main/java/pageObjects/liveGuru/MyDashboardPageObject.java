package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage{
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickOnAccountMenu() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_MENU);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_MENU);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isMyDashboardDisplayed() {
		waitForAllElementVisible(driver, MyDashboardPageUI.MY_DASHBOARD_TEXT);
		return isElementDisplayed(driver, MyDashboardPageUI.MY_DASHBOARD_TEXT);
	}
}
