package pageUIs.jQuery.dataTable;

public class JQueryHomePageUI {
	public static final String COLUMN_NAME ="XPATH=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String DATA_DISPLAYED ="XPATH=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String EDIT_OR_REMOVE="xpath=//td[@data-key='females' and text()='%s']/preceding-sibling::td/button[contains(@class,'%s')]";
	public static final String PAGE_NUMBER = "XPATH=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_NUMBER_DISPLAYED = "XPATH=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	
	public static final String LOAD_BUTTON ="css=button#btnLoad";
	public static final String COLUMN_INDEX ="xpath=//thead/tr//td[text()='%s']//preceding-sibling::td";
	public static final String TEXTBOX_AT_ROW_AND_COLUMN_NAME ="XPATH=//tbody//tr[%s]//td[%s]/input";
	public static final String SELECT_VALUE_AT_DROPDOWN ="xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String POSTER_CHECKBOX="XPATH=//tbody/tr[%s]/td[%s]/input";
	public static final String ACTION_BUTTON="XPATH=//tbody/tr[%s]//button[@title='%s']";
	public static final String FOOTER_BUTTON ="xpath=//button[@title='%s']";
	
	
}
