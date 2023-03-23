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

public class Level_17_Custom_Close_Driver extends BaseTest {
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

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

		log.info("Register - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Enter to FirstName Textbox with value is '" + firstName + "");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Register - Step 03: Enter to LastName Textbox with value is '" + lastName + "");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 04: Enter to EmailAddress Textbox with value is '" + emailAddress + "");
		registerPage.inputToEmailTextbox(emailAddress);
		System.out.println(emailAddress);

		log.info("Register - Step 05: Enter to Password Textbox with value is '" + password + "");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - Step 06: Enter to Confirm Password Textbox with value is '" + password + "");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 07: Click To Register Button");
		registerPage.clickToRegisterButton();

		driver = null;

		log.info("Register - Step 08: Verify Register successful Message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		log.info("Register - Step 09: Click To Logout Link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Login - Step 10: Navigate To Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 11: Enter to emailAddress Textbox with value is '" + emailAddress + "");
		loginPage.inputToEmailTexttbox(emailAddress);

		log.info("Login - Step 12: Enter to Password Textbox with value is '" + password + "");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 13: Click To Login Button");
		homePage = loginPage.clickToLoginButton();

	}

	@Test
	public void Search_01_Name() {

	}

	@Test
	public void Searh_02_Address() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

}
