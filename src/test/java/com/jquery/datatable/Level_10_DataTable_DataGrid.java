package com.jquery.datatable;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.JQueryHomePageObject;
import pageObject.jQuery.dataTable.JQueryPageGeneratorManager;
import pageObject.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	JQueryHomePageObject jQueryHomePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		jQueryHomePage = JQueryPageGeneratorManager.getJQueryHomePage(driver);
	}

	// @Test
	public void Table_01_Enter_To_Header_Name() {
		jQueryHomePage.enterToTextboxByColumnName("Females", "384187");
		jQueryHomePage.sleepInSecond(2);
		Assert.assertTrue(jQueryHomePage.verifyDataDisplayed("384187", "Afghanistan", "407124", "791312"));
		jQueryHomePage.refreshCurrentPage(driver);

		jQueryHomePage.enterToTextboxByColumnName("Country", "AFRICA");
		jQueryHomePage.sleepInSecond(2);
		Assert.assertTrue(jQueryHomePage.verifyDataDisplayed("12253515", "AFRICA", "12599691", "24853148"));
		jQueryHomePage.refreshCurrentPage(driver);

		jQueryHomePage.enterToTextboxByColumnName("Total", "687522");
		jQueryHomePage.sleepInSecond(2);
		Assert.assertTrue(jQueryHomePage.verifyDataDisplayed("338282", "Argentina", "349238", "687522"));
		jQueryHomePage.refreshCurrentPage(driver);

	}

	// @Test
	public void Table_02_Edit_Or_Delete() {
		jQueryHomePage.clickToActionButtonByFemale("384187", "remove");
		jQueryHomePage.sleepInSecond(2);

		jQueryHomePage.clickToActionButtonByFemale("12253515", "remove");
		jQueryHomePage.sleepInSecond(2);

		jQueryHomePage.clickToActionButtonByFemale("338282", "remove");
		jQueryHomePage.sleepInSecond(2);

		jQueryHomePage.refreshCurrentPage(driver);

		jQueryHomePage.clickToActionButtonByFemale("15999", "edit");
		jQueryHomePage.sleepInSecond(2);
		jQueryHomePage.refreshCurrentPage(driver);

		jQueryHomePage.clickToActionButtonByFemale("276880", "edit");
		jQueryHomePage.sleepInSecond(2);

	}

	// @Test
	public void Table_03_Paging() {
		jQueryHomePage.clickToPageNumber("10");
		Assert.assertTrue(jQueryHomePage.verifyPageNumberDisplayed("10"));
		jQueryHomePage.clickToPageNumber("5");
		Assert.assertTrue(jQueryHomePage.verifyPageNumberDisplayed("5"));
		jQueryHomePage.clickToPageNumber("20");
		Assert.assertTrue(jQueryHomePage.verifyPageNumberDisplayed("20"));

	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		jQueryHomePage.clickToLoadButton();
		jQueryHomePage.sleepInSecond(2);

		jQueryHomePage.enterToTextboxAtRowAndColumnName("Album", "2", "Hello");
		jQueryHomePage.enterToTextboxAtRowAndColumnName("Artist", "4", "Adele");
		jQueryHomePage.enterToTextboxAtRowAndColumnName("Year", "5", "2022");
		jQueryHomePage.enterToTextboxAtRowAndColumnName("Price", "3", "180.5");

		jQueryHomePage.selectCountryValueAtRowAndColumnName("Origin", "1", "Japan");
		jQueryHomePage.selectCountryValueAtRowAndColumnName("Origin", "2", "Korea");
		jQueryHomePage.selectCountryValueAtRowAndColumnName("Origin", "3", "US");
		jQueryHomePage.selectCountryValueAtRowAndColumnName("Origin", "5", "Hong Kong");

		jQueryHomePage.checkToCheckboxAtRowAndColumnName("With Poster?", "3");
		jQueryHomePage.checkToCheckboxAtRowAndColumnName("With Poster?", "5");

		jQueryHomePage.uncheckToCheckboxAtRowAndColumnName("With Poster?", "1");
		jQueryHomePage.uncheckToCheckboxAtRowAndColumnName("With Poster?", "4");

		jQueryHomePage.clickToActionButtonByRowNumber("2", "Insert Row Above");
		jQueryHomePage.clickToActionButtonByRowNumber("1", "Move Down");
		jQueryHomePage.clickToActionButtonByRowNumber("3", "Move Up");

		jQueryHomePage.clickToActionButtonByRowNumber("5", "Remove Current Row");
		jQueryHomePage.clickToActionButtonByRowNumber("5", "Remove Current Row");
		jQueryHomePage.clickToActionButtonByRowNumber("3", "Remove Current Row");
		jQueryHomePage.clickToActionButtonByRowNumber("2", "Remove Current Row");
		jQueryHomePage.clickToActionButtonByRowNumber("1", "Remove Current Row");

		jQueryHomePage.clickToFooterButtonName("Append Row");
		jQueryHomePage.enterToTextboxAtRowAndColumnName("Album", "2", "I am the best");
		jQueryHomePage.enterToTextboxAtRowAndColumnName("Artist", "2", "2NE1");
		jQueryHomePage.enterToTextboxAtRowAndColumnName("Year", "2", "1111");
		jQueryHomePage.enterToTextboxAtRowAndColumnName("Price", "2", "2222");
		jQueryHomePage.clickToFooterButtonName("Remove Last Row");

	}

	@AfterClass
	public void afterClass() {
	}

}
