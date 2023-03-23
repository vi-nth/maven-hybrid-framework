package pageObject.xtdt.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static PublicMapPageObject getPublicMapPage(WebDriver driver) {
		return new PublicMapPageObject(driver);
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
		
	}
	
	public static AdminLayerConfigPageObject getAdminLayerConfigPage(WebDriver driver) {
		return new AdminLayerConfigPageObject(driver);
		
	}
	
	public static AdminLayerManagePageObject getAdminLayerManagePage(WebDriver driver) {
		return new AdminLayerManagePageObject(driver);
		
	}
	
	public static AdminDetailLayerManagePageObject getAdminDetailLayerManagePage(WebDriver driver) {
		return new AdminDetailLayerManagePageObject(driver);
		
	}

}
