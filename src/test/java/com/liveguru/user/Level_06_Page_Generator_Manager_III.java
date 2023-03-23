package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyDashboardPageObject myDashboardPage;
	private String firstName, lastName, email, password, confirmPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Automation";
		lastName = "FC";
		email = "afc" + generateFakeNumber() + "@gmail.us";
		password = "123456";
		confirmPassword = "123456";

	}

	@Test
	public void User_01_Register_To_System() {
		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.clickOnAccountMenu();
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);

		myDashboardPage = registerPage.clickToRegisterButton();
		
		myDashboardPage.clickOnAccountMenu();

		homePage = myDashboardPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login_To_System() {
		homePage.clickOnAccountMenu();
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToLoginEmailTextbox(email);
		loginPage.inputToLoginPasswordTextbox(password);
		
		myDashboardPage = loginPage.clickOnLoginButton();
		
		Assert.assertTrue(myDashboardPage.isMyDashboardDisplayed());

	}

	@AfterClass
	public void afterClass() {
	}

	public int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
