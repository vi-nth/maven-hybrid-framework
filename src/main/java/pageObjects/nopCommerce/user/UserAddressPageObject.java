package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import pageObjects.navigation.SidebarAccountPageObject;

public class UserAddressPageObject extends SidebarAccountPageObject {
	private WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
