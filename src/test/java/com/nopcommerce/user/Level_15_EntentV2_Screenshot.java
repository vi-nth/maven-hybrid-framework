//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import pageObjects.nopCommerce.user.UserRewardPointPageObject;
//import reportConfig.ExtentManager;
//import reportConfig.ExtentTestManager;
//import pageObjects.nopCommerce.user.UserAddressPageObject;
//
//public class Level_15_EntentV2_Screenshot extends BaseTest {
//	private WebDriver driver;
//
//	private UserHomePageObject homePage;
//	private UserRegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private UserCustomerInforPageObject customerInforPage;
//
//
//	private String emailAddress, firstName, lastName, password;
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//		firstName = "Automation";
//		lastName = "FC";
//		emailAddress = "afc" + generateFakeNumber() + "@gmail.us";
//		password = "123456";
//	}
//
//	@Test
//	public void User_01_Register(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Register");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to Register Page");
//
//		registerPage = homePage.clickToRegisterLink();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to FirstName Textbox with value is '"+firstName+"");
//		registerPage.inputToFirstNameTextbox(firstName);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to LastName Textbox with value is '"+lastName+"");
//		registerPage.inputToLastNameTextbox(lastName);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to EmailAddress Textbox with value is '"+emailAddress+"");
//		registerPage.inputToEmailTextbox(emailAddress);
//		System.out.println(emailAddress);
//		
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password Textbox with value is '"+password+"");
//		registerPage.inputToPasswordTextbox(password);
//		
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password Textbox with value is '"+password+"");
//		registerPage.inputToConfirmPasswordTextbox(password);
//		
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click To Register Button");
//		registerPage.clickToRegisterButton();
//		
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify Register successful Message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
//		ExtentTestManager.endTest();
//	}
//	
//	@Test
//	public void User_02_Login(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_02_Login");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click To Logout Link");
//		homePage = registerPage.clickToLogoutLink();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate To Login Page");
//		loginPage = homePage.openLoginPage();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to emailAddress Textbox with value is '"+emailAddress+"");
//		loginPage.inputToEmailTexttbox(emailAddress);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password Textbox with value is '"+password+"");
//		loginPage.inputToPasswordTextbox(password);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click To Login Button");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' Link is Displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate To 'My Account' Page");
//		customerInforPage = homePage.openMyAccountLink();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer Infor Page' is displayed");
//		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//		ExtentTestManager.endTest();
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//		
//	}
//
//
//
//}
