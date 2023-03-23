package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.Admin.AdminDashboardPageObject;
import pageObject.nopCommerce.Admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAboutUsPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserSearchTermPageObject;
import pageObjects.wordpress.admin.UserHomePO;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUserMyProductRviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardLoginPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static UserAboutUsPageObject getUserAboutUsPage(WebDriver driver) {
		return new UserAboutUsPageObject(driver);
		
	}
	public static UserSearchTermPageObject getUserSearchTermPage(WebDriver driver) {
		return new UserSearchTermPageObject(driver);
		
	}
	public static UserMyAccountPageObject getUserMyAccountPage(WebDriver driver) {
		return new UserMyAccountPageObject(driver);
		
	}

	public static UserHomePO getEndUserSite(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
