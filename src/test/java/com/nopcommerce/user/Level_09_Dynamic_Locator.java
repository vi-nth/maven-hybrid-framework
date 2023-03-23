package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;

	private String emailAddress, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.us";
		password = "123456";
	}

	@Test
	public void User_01_Register_And_Login() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		System.out.println(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTexttbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		customerInforPage = homePage.openMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_02_Dynamic_Page() {

		addressPage = customerInforPage.openAddressPage();

		myProductReviewPage = addressPage.openMyProductReviewPage();

		rewardPointPage = myProductReviewPage.openRewardPointPage();

		addressPage = rewardPointPage.openAddressPage();

		rewardPointPage = addressPage.openRewardPointPage();

		myProductReviewPage = rewardPointPage.openMyProductReviewPage();


	}
	
	@Test
	public void User_03_Dynamic_Page_II() {
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountPageName(driver, "Reward points");

		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountPageName(driver, "Addresses");

		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountPageName(driver, "Reward points");

		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountPageName(driver, "My product reviews");

		customerInforPage = (UserCustomerInforPageObject) myProductReviewPage.openPagesAtMyAccountPageName(driver, "Customer info");
		
	}

	@Test
	public void User_03_Dynamic_Page_III() {
		customerInforPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage=PageGeneratorManager.getUserMyProductRviewPage(driver);
		
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage=PageGeneratorManager.getUserAddressPage(driver);
	
		
	}

	@AfterClass
	public void afterClass() {
	}



}
