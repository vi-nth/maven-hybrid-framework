package com.jquery.upload;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import pageObject.jQuery.uploadFile.HomePageObject;
import pageObject.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_File extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;

	String csharpFileName = "CSharp.png";
	String javaFileName = "java.png";
	String pythonFileName = "Python.png";
	String rubyFileName = "Ruby.png";
	String[] multipleFileNames = { csharpFileName, javaFileName, pythonFileName, rubyFileName };

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Upload_01_Single_File() {
		homePage.uploadMultipleFiles(driver, javaFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadLoadedByName(javaFileName));

		Assert.assertTrue(homePage.isFileImageUploadLoadedByName(javaFileName));

	}

	@Test
	public void Upload_02_Multiple_File() {
		homePage.refreshCurrentPage(driver);
		
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadLoadedByName(rubyFileName));

		Assert.assertTrue(homePage.isFileImageUploadLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadLoadedByName(rubyFileName));

	}

	@AfterClass
	public void afterClass() {
	}

}
