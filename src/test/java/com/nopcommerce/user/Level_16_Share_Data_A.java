package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	private String emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		emailAddress = Common_01_Register.emailAddress;
		password = Common_01_Register.password;

		log.info("Login - Step 01: Navigate To Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to emailAddress Textbox with value is '" + emailAddress + "");
		loginPage.inputToEmailTexttbox(emailAddress);

		log.info("Login - Step 03: Enter to Password Textbox with value is '" + password + "");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04: Click To Login Button");
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
		//driver.quit();

	}

}
