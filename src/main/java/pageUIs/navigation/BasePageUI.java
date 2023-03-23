package pageUIs.navigation;

public class BasePageUI {
	public static final String CUSTOMER_INFOR_LINK = "XPath=//li[contains(@class, 'customer-info')]/a[text()='Customer info']";
	public static final String ADDRESS_LINK = "XPATH=//li[contains(@class, 'customer-addresses')]/a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "Xpath=//li[contains(@class, 'customer-reviews ')]/a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//li[contains(@class, 'reward-points')]/a[text()='Reward points']";
	
	public static final String USER_LOGOUT_LINK = "css=a[class='ico-logout']";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
	
	// Pattern Object
	public static final String OPEN_PAGES_AT_MY_ACCOUNT_AREA= "xpath=//div[contains(@class, 'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID="XPATH=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT="XPATH=//button[text()='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL="XPATH=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_DROPDOWN_BY_NAME="XPATH=//select[@name='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL="XPATH=//label[contains(text(),'%s')]/following-sibling::input";
}
