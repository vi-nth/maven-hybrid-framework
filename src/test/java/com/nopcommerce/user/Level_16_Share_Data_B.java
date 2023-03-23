package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_16_Share_Data_B extends BaseTest {
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;


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

		log.info("Pre-condition - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Pre-condition - Step 02: Enter to FirstName Textbox with value is '"+firstName+"");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Pre-condition - Step 03: Enter to LastName Textbox with value is '"+lastName+"");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre-condition - Step 04: Enter to EmailAddress Textbox with value is '"+emailAddress+"");
		registerPage.inputToEmailTextbox(emailAddress);
		System.out.println(emailAddress);
		
		log.info("Pre-condition - Step 05: Enter to Password Textbox with value is '"+password+"");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 06: Enter to Confirm Password Textbox with value is '"+password+"");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Pre-condition - Step 07: Click To Register Button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 08: Verify Register successful Message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
		
		log.info("Pre-condition - Step 09: Click To Logout Link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Pre-condition - Step 10: Navigate To Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 11: Enter to emailAddress Textbox with value is '"+emailAddress+"");
		loginPage.inputToEmailTexttbox(emailAddress);
		
		log.info("Pre-condition - Step 12: Enter to Password Textbox with value is '"+password+"");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 13: Click To Login Button");
		homePage = loginPage.clickToLoginButton();

		
	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Relative_Product_Name() {

	}

	@Test
	public void Search_03_Absolute_Product_Name() {

	}

	@Test
	public void Search_04_Parent_Catergory() {

	}

	@Test
	public void Search_05_Incorrect_Manufacturer() {

	}

	@Test
	public void Search_05_Correct_Manufacturer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
