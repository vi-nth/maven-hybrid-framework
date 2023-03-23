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
import pageObject.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid2 extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.sleepInSecond(2);

		homePage.openPagingByPageNumber("15");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("15"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.sleepInSecond(2);

		homePage.enterToHeaderTextboxByLabel("Females", "15999");
		homePage.sleepInSecond(2);
		homePage.enterToHeaderTextboxByLabel("Males", "407124");
		homePage.sleepInSecond(2);
		homePage.enterToHeaderTextboxByLabel("Total", "12599691");
		homePage.sleepInSecond(2);

		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.sleepInSecond(2);
		homePage.enterToHeaderTextboxByLabel("Females", "764956");
		homePage.sleepInSecond(2);
		homePage.enterToHeaderTextboxByLabel("Males", "802948");
		homePage.sleepInSecond(2);
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(2);

	}

	// @Test
	public void Table_03_Enter_To_Header() {
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();

//		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);

	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(5);

		homePage.enterToTextboxAtRowByColumnNameAtRowNumber("Album", "2", "Michael 97");
		homePage.enterToTextboxAtRowByColumnNameAtRowNumber("Artist", "4", "Michael Jackson");
		homePage.enterToTextboxAtRowByColumnNameAtRowNumber("Year", "3", "1997");
		homePage.enterToTextboxAtRowByColumnNameAtRowNumber("Price", "1", "150");

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "5", "Japan");
		homePage.sleepInSecond(2);

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Korea");
		homePage.sleepInSecond(2);

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "US");
		homePage.sleepInSecond(2);

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Hong Kong");
		homePage.sleepInSecond(2);

		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");
		
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
		
		homePage.clickToButtonByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		
		homePage.clickToButtonByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		
		homePage.clickToButtonByRowNumber("3", "Move Up");
		homePage.sleepInSecond(2);
		
		homePage.clickToButtonByRowNumber("5", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToButtonByRowNumber("4", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToButtonByRowNumber("3", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToButtonByRowNumber("2", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToButtonByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		

	}

	@AfterClass
	public void afterClass() {
	}

}
