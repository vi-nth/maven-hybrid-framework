package com.xtdt.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.xtdt.admin.PageGeneratorManager;
import pageObject.xtdt.admin.PublicMapPageObject;

public class Demo_01_View_Detail_Project extends BaseTest {

	private WebDriver driver;
	private PublicMapPageObject publicMapPage;
	
	String district = "";
	String subDistrict = "Tinh Tra";
	String codeProject = "DA18140";
	String nameProject = "Du an co khi";
	String userName = "admin";
	String password = "Admin@123";
	String layerName = "Dich vu - Du lich - Thuong mai";
	int randomNumber = generateFakeNumber();
	String addNameProject = "Dich vu" +randomNumber;
	
	

	@Parameters({ "browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url );
		
	}
	
	@Test
	public void Map_01_Hover_On_District_And_Click_On_Detail_List(){
		log.info("Map - Step 01: Open browser and Public Map");
		publicMapPage = PageGeneratorManager.getPublicMapPage(driver);
		
		
		log.info("Map - Step 02: Hover on District");
		
		log.info("Map - Step 03: Verify number of 'Development projects");
		
		log.info("Map - Step 04: Click on 'Chi tiet' Button");
		
		log.info("Map - Step 05: Verify number of project on sidebar");
		
		log.info("Map - Step 06: Click on 'Chi duong' button");
		
		log.info("Map - Step 07: Enter in textbox 'Nhap diem bat dau' with value:"+ subDistrict);
		
		log.info("Map - Step 08: Click on 'Chi tiet' button ");
		
		log.info("Map - Step 09: Click on 'Vehicle' icon");
		
		log.info("Map - Step 10: Click on 'Dao chieu' icon");
		
		
		
	}
	
	@Test
	public void ViewDetailProject_02_View_Detail_Project(){
		
		log.info("View_Detail_Project - Step 01: Click on one field");
		
		log.info("View_Detail_Project - Step 02: Verify number of project on sidebar");
		
		log.info("View_Detail_Project - Step 03: Click on 1 project with name:" + codeProject);
		
		log.info("View_Detail_Project - Step 04: Verify detail info of project with codeproject 'DA18140' ");
		
		log.info("View_Detail_Project - Step 05: Click on 'image' tab ");
		
		log.info("View_Detail_Project - Step 06: Click on image to view");
		
		log.info("View_Detail_Project - Step 07: Click on 'video' tab");
		
		log.info("View_Detail_Project - Step 08: Click on video to view");
		
		log.info("View_Detail_Project - Step 09: Click on 'Vr360' tab");
		
		log.info("View_Detail_Project - Step 10: Click on VR360 to view");
		
		log.info("View_Detail_Project - Step 11: Click on 'Close' button");
		
		log.info("View_Detail_Project - Step 12: Click on 'Chu thich' button");
		
		
		
	}
	
	@Test
	public void Search_03_Search(){
		
		log.info("Search - Step 01: Click on 'Search' button");
		
		log.info("Search - Step 02: Enter in Search text box with value:" + nameProject);
		
		log.info("Search - Step 03: Click on 'Tim kiem' button");
		
		log.info("Search - Step 04: Verify results displayed");
		
		log.info("Search - Step 05: Click 'Close' Button");
		
		log.info("Search - Step 06: Select data to filter");
		
		log.info("Search - Step 07: Click on 'Tim kiem' button");
		
		log.info("Search - Step 08: Verify results displayed");
		
		
		
	}
	
	@Test
	public void Login_04_Login_Sytem(){
		log.info("Login - Step 01: Click on 'Dang nhap' button");
		
		log.info("Login - Step 02: Enter in Username with value:"+userName);
		
		log.info("Login - Step 03: Enter in password with value:"+password);
		
		log.info("Login - Step 04: Click on 'Dang nhap' button");
		
		log.info("Login - Step 05: Get Admin Home Page");
		
		
		
		
	}
	@Test
	public void LayerConfig_05_Add_Layer(){
		
		log.info("LayerConfig - Step 06: Click on 'Layer Config' button");
		
		log.info("LayerConfig - Step 07: Click on 'Add Layer' button");
		
		log.info("LayerConfig - Step 08: Enter in 'Ten Linh Vuc' textbox with value:"+layerName);
		
		log.info("LayerConfig - Step 09: Click on 'Luu' button");
		
		log.info("LayerConfig - Step 10: Click on 'Add property' button");
		
		log.info("LayerConfig - Step 11: Select data type is 'Chuoi lon'");
		
		log.info("LayerConfig - Step 12: Enter in 'Ten hien thi' textbox");
		
		log.info("LayerConfig - Step 13: Click on 'Luu' button");
		
		
		
		
	}
	
	@Test
	public void LayerManage_06_Add_Project(){
		log.info("LayerManage - Step 1: Click on 'Quan ly du an' on main menu");
		
		log.info("LayerManage - Step 2: Click on layer 'Dich vu - Du lich - Thuong mai' on sidebar");
		
		log.info("LayerManage - Step 3: Click on 'Add project' on menu");
		
		log.info("LayerManage - Step 4: Click on 'Vung nhieu cung du an theo quan huyen' on sidebar");
		
		log.info("LayerManage - Step 5: Select value 'Ba To' at Quan huyen");
		
		log.info("LayerManage - Step 6: Enter in 'Ten du an' textbox with value:"+addNameProject);
		
		log.info("LayerManage - Step 7: Click on 'Luu' button");
		
	}
		
}
