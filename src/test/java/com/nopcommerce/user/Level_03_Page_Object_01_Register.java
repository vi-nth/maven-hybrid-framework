package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, confirmPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		homePage = new UserHomePageObject(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		firstName="Automation";
		lastName="FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.us";
		password="123456";
		confirmPassword="123456";

	}

	@Test
	public void Register_01_Emty_Data() {

		System.out.println("Home Page - Step 01: Click to Register Button");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Register Page - STEP 2: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Home Page - Step 01: Click to Register Button");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Register Page - STEP 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@123@gmail.us");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		System.out.println("Register Page - STEP 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - STEP 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
		
	}

	@Test
	public void Register_03_Success() {
		System.out.println("Home Page - Step 01: Click to Register Button");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Register Page - STEP 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		System.out.println("Register Page - STEP 3: Click to Register Button");
		registerPage.clickToRegisterButton();
	
		System.out.println("Register Page - STEP 4: Verify success messsage displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register Page - STEP 5: Click to Logout Button");
		registerPage.clickToLogoutLink();
	
	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Home Page - Step 01: Click to Register Button");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
;		
		System.out.println("Register Page - STEP 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		System.out.println("Register Page - STEP 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - STEP 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Then_6_Characters() {
		System.out.println("Home Page - Step 01: Click to Register Button");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Register Page - STEP 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
	
		System.out.println("Register Page - STEP 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - STEP 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Home Page - Step 01: Click to Register Button");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Register Page - STEP 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123444");

		System.out.println("Register Page - STEP 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - STEP 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
	}

	public int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
