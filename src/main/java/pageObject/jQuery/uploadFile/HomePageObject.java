package pageObject.jQuery.uploadFile;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver,HomePageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(5);
		}
	
	}

	public boolean isFileLinkUploadLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver,HomePageUI.FILE_NAME_UPLOADED, fileName);
	}

	public boolean isFileImageUploadLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
		return isImageLoaded(driver,HomePageUI.FILE_NAME_UPLOADED, fileName);
	}

	



}
