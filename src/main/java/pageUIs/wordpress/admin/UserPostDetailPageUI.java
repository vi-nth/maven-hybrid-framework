package pageUIs.wordpress.admin;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_AT_HOME_PAGE ="XPATH=//article//h1[text()='%s']";
	public static final String POSTED_TIME_AT_HOME_PAGE="XPATH=//article//h1[text()='%s']/following-sibling::div//time[text()='%s']";
	public static final String POSTED_BODY_AT_HOME_PAGE="xpath=//article//h1[text()='%s']/parent::header/following-sibling::div/p[text()='%s']";
	public static final String POSTED_AUHOR="XPATH=//article//h1[text()='%s']/parent::header//a[text()='%s']";

}
