package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;
import com.nopcommerce.data.UserData.MyAccount;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import utilities.DataHelper;
import pageObjects.nopCommerce.user.UserAddressPageObject;

public class Level_20_Manage_Data3 extends BaseTest {
	private WebDriver driver;
	private DataHelper dataFaker;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;


	private String emailAddress;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataFaker = DataHelper.getDataHelper();

		emailAddress = UserData.Register.EMAIL_ADDRESS+generateFakeNumber()+"@gmail.us";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
		
		log.info("Register - Step 02: Enter to FirstName Textbox with value is '"+UserData.Register.FIRST_NAME+"");
		registerPage.inputToTextboxByID(driver,"FirstName",UserData.Register.FIRST_NAME);
		
		log.info("Register - Step 03: Enter to LastName Textbox with value is '"+UserData.Register.LAST_NAME+"");
		registerPage.inputToTextboxByID(driver,"LastName",UserData.Register.LAST_NAME);
		
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", UserData.Register.DATE);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", UserData.Register.MONTH);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", UserData.Register.YEAR);
		
		log.info("Register - Step 04: Enter to EmailAddress Textbox with value is '"+emailAddress+"");
		registerPage.inputToTextboxByID(driver,"Email",emailAddress);
		System.out.println(emailAddress);
		
		registerPage.clickToCheckBoxByLabel(driver, "Newsletter");
		

		log.info("Register - Step 05: Enter to Password Textbox with value is '"+UserData.Register.PASSWORD+"");
		registerPage.inputToTextboxByID(driver,"Password",UserData.Register.PASSWORD);
		

		log.info("Register - Step 06: Enter to Confirm Password Textbox with value is '"+UserData.Register.PASSWORD+"");
		registerPage.inputToTextboxByID(driver,"ConfirmPassword",UserData.Register.PASSWORD);
		

		log.info("Register - Step 07: Click To Register Button");
		registerPage.clickToButtonByText(driver, "Register");
		

		log.info("Register - Step 08: Verify Register successful Message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	
	}
	
	@Test
	public void User_02_Login() {
		log.info("Register - Step 09: Click To Logout Link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Login - Step 01: Navigate To Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to emailAddress Textbox with value is '"+emailAddress+"");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login - Step 03: Enter to Password Textbox with value is '"+UserData.Register.PASSWORD+"");
		loginPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);
		
		log.info("Login - Step 04: Click To Login Button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' Link is Displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: Navigate To 'My Account' Page");
		customerInforPage = homePage.openMyAccountLink();
		
		log.info("Login - Step 07: Verify 'Customer Infor Page' is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
	}
	
	@Test
	public void User_03_My_Account() {
		log.info("Login - Step 01: Navigate To 'My Account' Page");
		customerInforPage = homePage.openMyAccountLink();
		
		log.info("Login - Step 02: Verify 'Customer Infor Page' is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		log.info("Login - Step 03: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxByAttributeValueByID(driver,"FirstName"), UserData.Register.FIRST_NAME);
		
		log.info("Login - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxByAttributeValueByID(driver,"LastName"), UserData.Register.LAST_NAME);
		
		log.info("Login - Step 05: Verify 'Email Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxByAttributeValueByID(driver,"Email"), emailAddress);
		
		
		
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver();
	}



}
