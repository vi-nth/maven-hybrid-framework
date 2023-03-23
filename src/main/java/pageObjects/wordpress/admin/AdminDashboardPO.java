package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage{
	WebDriver driver;

	protected AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickOnPostsLink() {
	waitForElementClickable(driver, AdminDashboardPageUI.ADMIN_POSTS_LINK);
	clickToElement(driver, AdminDashboardPageUI.ADMIN_POSTS_LINK);
	return PageGeneratorManager.getAdminPostSearchPage(driver);
		
	}
	
	

}
