package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.LoginPageUI;

public class LoginPageObject extends BasePageFactory {

	private WebDriver driver;
	public Object clickToLoginButton;

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath="//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessfullErrorMessage;
	
	@FindBy(xpath="//a[@class='ico-register']")
	private WebElement registerLink;
	
	// Page Object/ Action
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getErrorMessageAtEmailTextbox() {
	waitForElementVisible(driver,emailErrorMessage);
	return getElementText(driver, emailErrorMessage);

	}

	public void inputToEmailTexttbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, unsuccessfullErrorMessage);
		return getElementText(driver, unsuccessfullErrorMessage);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);

	}
	
	
}