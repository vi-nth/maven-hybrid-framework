package pageUIs.wordpress.admin;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON ="xpath=//h1[contains(text(),'Posts')]/following-sibling::a[text()='Add New']";
	public static final String SEARCH_TEXTBOX="CSS=input#post-search-input";
	public static final String SEARCH_POSTS_BUTTON="CSS=input#search-submit";
	public static final String TABLE_INDEX_BY_HEADER_NAME="xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX="xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String POST_TITLE_IN_GRID="xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";
	
	public static final String POST_TITLE_CHECKBOX="xpath=//table[contains(@class,'table-view-list posts')]/tbody//label[contains(text(),'%s')]/following-sibling::input[@type='checkbox']";
	public static final String SELECT_MOVE_TO_TRASH_IN_DROPDOWN="CSS=select#bulk-action-selector-top";
	public static final String APPLY_BUTTON="xpath=//input[@id='doaction']";
	public static final String CONFIRMED_DELETE_MESSAGE="xpath=//div[@id='message']/p[contains(text(),'1 post moved to the Trash. ')]";
	public static final String ADMIN_RESULT_SEARCH_MESSAGE="xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/td[text()='No posts found.']";
	
	
	
	

}
