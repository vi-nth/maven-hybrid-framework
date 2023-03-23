package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.verifyElement.LoginPageObject;
import pageObject.facebook.verifyElement.PageGeneratorManager;


public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		

	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed() {
		verifyFalse(loginPage.isEmailTextboxConfirmationDisplayed());
		
		loginPage.inputToEmailTextbox("automationfc@gmail.us");
		sleepInSecond(2);
		verifyTrue(loginPage.isEmailTextboxConfirmationDisplayed());
		
		
		loginPage.inputToEmailTextbox("");
		sleepInSecond(2);
		//verifyFalse(loginPage.isEmailTextboxConfirmationDisplayed());
		verifyTrue(loginPage.isEmailTextboxConfirmationUndisplayed());
		
	}
	
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_Dom() {
		loginPage.clickToCloseButtonAtRegisterForm();
		loginPage.sleepInSecond(2);
		
		
		verifyTrue(loginPage.isEmailTextboxConfirmationUndisplayed());

	}

	@AfterClass
	public void afterClass() {
	}

}
