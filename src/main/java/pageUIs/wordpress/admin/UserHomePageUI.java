package pageUIs.wordpress.admin;

public class UserHomePageUI {
	public static final String POST_TITLE_AT_HOME_PAGE ="XPATH=//article//a[text()='%s']";
	public static final String POSTED_TIME_AT_HOME_PAGE="XPATH=//article//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POSTED_BODY_AT_HOME_PAGE="XPATH=//article//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String POSTED_AUHOR="XPATH=//article//a[text()='%s']/parent::h2/following-sibling::div//a[text()='%s']";

	public static final String SEARCH_TEXTBOX_AT_HOMEPAGE="xpath=//input[@id='wp-block-search__input-1']";
	public static final String SEARCH_BUTTON_HOMEPAGE="XPATH=//button[@class='wp-block-search__button  ']";
}
