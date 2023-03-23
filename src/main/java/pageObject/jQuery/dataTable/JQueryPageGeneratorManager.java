package pageObject.jQuery.dataTable;

import org.openqa.selenium.WebDriver;

public class JQueryPageGeneratorManager {

		public static JQueryHomePageObject getJQueryHomePage(WebDriver driver) {
			return new JQueryHomePageObject(driver);
			
			
		}
	

}
