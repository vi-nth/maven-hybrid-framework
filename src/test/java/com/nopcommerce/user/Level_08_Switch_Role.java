package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.Admin.AdminDashboardPageObject;
import pageObject.nopCommerce.Admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInforPageObject userCustomerInforPage;

	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	

		userEmailAddress = "andinh123456@gmail.us";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();

		// Login as User Role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		// HomePage --> Customer Infor
		userCustomerInforPage = userHomePage.openMyAccountLink();
		
		// Customer Infor --> CLick Logout --> HomePage
		userHomePage = userCustomerInforPage.clickToLogoutatUser(driver);
		
		// User Home Page --> Open Admin Page --> Login Page (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		// Login as Admin Role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);

		Assert.assertTrue(adminDashboardPage.isMyDashboardDisplayed());
		
		// Dashboard Page --> Click Logout --> Login Page (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutatAdmin(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login Page (Admin) -->Open Portal Url --> User Home Page
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		// HomePage --> Login Page (User)
		userLoginPage = userHomePage.openLoginPage();
		
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
	}

	public int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
