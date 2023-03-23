package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.navigation.SidebarAccountPageObject;
import pageUIs.navigation.BasePageUI;
import pageUIs.nopCommerce.user.CustomerInforPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserCustomerInforPageObject extends SidebarAccountPageObject{
	private WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	


	




}
