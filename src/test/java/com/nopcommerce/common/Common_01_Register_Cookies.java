package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookies extends BaseTest {
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName;

	public static String emailAddress, password;
	public static Set<Cookie> loggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create new User for all Classes Test")
	public void Register(String browserName) {

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

		log.info("Register - Step 08: Verify Register successful Message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

		log.info("Register - Step 09: Click To Logout Link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Pre-condition - Step 10: Navigate To Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 11: Enter to emailAddress Textbox with value is '"+emailAddress+"");
		loginPage.inputToEmailTexttbox(emailAddress);
		
		log.info("Pre-condition - Step 12: Enter to Password Textbox with value is '"+password+"");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 13: Click To Login Button");
		homePage = loginPage.clickToLoginButton();


		loggedCookies = homePage.getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookies at Common Class:" + cookie);

		}
	}

	@AfterTest
	public void afterClass() {
		driver.quit();

	}

}
