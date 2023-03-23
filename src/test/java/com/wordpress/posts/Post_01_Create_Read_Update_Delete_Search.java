package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;
import pageObjects.wordpress.admin.UserHomePO;
import pageObjects.wordpress.admin.UserPostDetailPO;
import pageObjects.wordpress.admin.UserPostSearchPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	private WebDriver driver;

	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostsSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetailPage;
	private UserPostSearchPO userPostSearchPage;

	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	int randomNumber = generateFakeNumber();
	String postTile = "Live Coding Title" + randomNumber;
	String postBody = "Live Coding Body" + randomNumber;
	String editPostTile = "Edit Post Title" + randomNumber;
	String editPostBody = "Edit Post Body" + randomNumber;
	String searchPostUrl;
	String currentDay = getToday();
	String authorName = "Automation Admin";
	String adminUrl, endUserUrl;

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {

		log.info("Pre-condition - Step 01: Open browser and Admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Enter in Username Textbox with value:" + adminUsername);
		adminLoginPage.enterInUsernameTextbox(adminUsername);

		log.info("Pre-condition - Step 03: Enter in Password Textbox with value:" + adminPassword);
		adminLoginPage.enterInPasswordTextbox(adminPassword);

		log.info("Pre-condition - Step 04: Click on Login Button");
		adminDashboardPage = adminLoginPage.clickOnLoginButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click on 'Posts' menu Link");
		adminPostsSearchPage = adminDashboardPage.clickOnPostsLink();

		log.info("Create_Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostsSearchPage.getCurrentUrl(driver);

		log.info("Create_Post - Step 03: Click on 'Add New' Button");
		adminPostAddNewPage = adminPostsSearchPage.clickOnAddNewButton();

		log.info("Create_Post - Step 04: Enter in post title");
		adminPostAddNewPage.enterInPostTitle(postTile);

		log.info("Create_Post - Step 05: Enter in post body");
		adminPostAddNewPage.enterInPostBody(postBody);

		log.info("Create_Post - Step 06: Click on 'Publish' Button");
		adminPostAddNewPage.clickOnPublishButton();

		log.info("Create_Post - Step 07: Click on 'Re-Publish' Button");
		adminPostAddNewPage.clickOnPrePublishButton();

		log.info("Create_Post - Step 08: Verify 'Post Published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishedDisplayed("Post published."));
	}

	//@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' Page");
		adminPostsSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		System.out.println(searchPostUrl);

		log.info("Search_Post - Step 02: Enter in Search Textbox");
		adminPostsSearchPage.enterInSearchTextbox(postTile);

		log.info("Search_Post - Step 03: Click on 'Search Posts' Button");
		adminPostsSearchPage.clickOnSearchPostsButton();

		log.info("Search_Post - Step 04: Verify Search table contains'" + postTile + "'");
		verifyTrue(adminPostsSearchPage.isTableInforDisplayed("title", postTile));

		log.info("Search_Post - Step 05: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostsSearchPage.isTableInforDisplayed("author", authorName));

		log.info("Search_Post - Step 06: Open End User Site");
		userHomePage = adminPostsSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search_Post - Step 07: Verify Post Infor Displayed at HomePage");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTile(postTile));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTile, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithAuthorName(postTile, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithCurrentDay(postTile, currentDay));

		log.info("Search_Post - Step 08: Click on Post Title");
		userPostDetailPage = userHomePage.clickOnPostTitle(postTile);

		log.info("Search_Post - Step 09: Verify Post Infor Displayed at Post detail Page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTile));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTile, postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithAuthorName(postTile, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithCurrentDay(postTile, currentDay));

	}

	//@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin site");
		adminDashboardPage=userPostDetailPage.openAdminSite(driver, this.adminUrl);
		
		log.info("Edit_Post - Step 02: Click on 'Posts' link");
		adminPostsSearchPage=adminDashboardPage.clickOnPostsLink();
		
		log.info("Edit_Post - Step 03: Enter in Search Textbox");
		adminPostsSearchPage.enterInSearchTextbox(postTile);

		log.info("Edit_Post - Step 04: Click on 'Search Posts' Button");
		adminPostsSearchPage.clickOnSearchPostsButton();
		
		log.info("Edit_Post - Step 05: Click on Post title detail link and navigate to Edit Post Page");
		adminPostsSearchPage.clickOnPostTitleDetailLink(postTile);
		
		log.info("Edit_Post - Step 06: Enter in post title");
		adminPostAddNewPage.enterInPostTitle(editPostTile);

		log.info("Edit_Post - Step 07: Enter in post body");
		adminPostAddNewPage.enterInEditPostBody(editPostBody);

		log.info("Edit_Post - Step 08: Click on 'Update' Button");
		adminPostAddNewPage.clickOnUpdateButton();

		log.info("Edit_Post - Step 09: Verify 'Post Updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishedDisplayed("Post updated."));
		
		log.info("Edit_Post - Step 10: Open 'Search Post' Page");
		adminPostsSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		System.out.println(searchPostUrl);

		log.info("Edit_Post - Step 11: Enter in Search Textbox");
		adminPostsSearchPage.enterInSearchTextbox(editPostTile);

		log.info("Edit_Post - Step 12: Click on 'Search Posts' Button");
		adminPostsSearchPage.clickOnSearchPostsButton();

		log.info("Edit_Post - Step 13: Verify Search table contains'" + editPostTile + "'");
		verifyTrue(adminPostsSearchPage.isTableInforDisplayed("title", editPostTile));

		log.info("Edit_Post - Step 14: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostsSearchPage.isTableInforDisplayed("author", authorName));
		
		log.info("Edit_Post - Step 15: Open End User Site");
		userHomePage = adminPostsSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Edit_Post - Step 16: Verify Post Infor Displayed at HomePage");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTile(editPostTile));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTile, editPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithAuthorName(editPostTile, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithCurrentDay(editPostTile, currentDay));
		
		log.info("Edit_Post - Step 17: Click on Edit Post Title");
		userPostDetailPage = userHomePage.clickOnPostTitle(editPostTile);

		log.info("Edit_Post - Step 18: Verify Post Infor Displayed at Post detail Page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTile));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostTile, editPostBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithAuthorName(editPostTile, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithCurrentDay(editPostTile, currentDay));

	}

	
	//@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open Admin site");
		adminDashboardPage=userPostDetailPage.openAdminSite(driver, this.adminUrl);
		
		log.info("Delete_Post - Step 02: Click on 'Posts' link");
		adminPostsSearchPage=adminDashboardPage.clickOnPostsLink();
		
		log.info("Delete_Post - Step 03: Enter in Search Textbox");
		adminPostsSearchPage.enterInSearchTextbox(editPostTile);

		log.info("Delete_Post - Step 04: Click on 'Search Posts' Button");
		adminPostsSearchPage.clickOnSearchPostsButton();
		
		log.info("Delete_Post - Step 05: Select Post Detail checkbox");
		adminPostsSearchPage.checkOnPostDetailCheckbox(editPostTile);
		
		log.info("Delete_Post - Step 06: Select 'Move to Trash' item in dropdown");
		adminPostsSearchPage.selectMoveToTraskItem("Move to Trash");
		
		log.info("Delete_Post - Step 07: Click on 'Apply' button");
		adminPostsSearchPage.clickOnApplyButton();
		
		log.info("Delete_Post - Step 08: Verify '1 post moved to the trash.' message is displayed");
		adminPostsSearchPage.isPostMovedToTheTrashDisplayed();
		
		log.info("Delete_Post - Step 09: Enter in Search Textbox");
		adminPostsSearchPage.enterInSearchTextbox(editPostTile);

		log.info("Delete_Post - Step 10: Click on 'Search Posts' Button");
		adminPostsSearchPage.clickOnSearchPostsButton();
		
		log.info("Delete_Post - Step 11: Verify 'No posts found.' message is displayed");
		adminPostsSearchPage.isNoPostsFoundMessageDisplayed();

		log.info("Search_Post - Step 12: Open End User Site");
		userHomePage = adminPostsSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search_Post - Step 13: Verify Post Title Undisplayed at HomePage");
		verifyTrue(userHomePage.isPostInforUndisplayedWithPostTile(editPostTile));
		

		log.info("Search_Post - Step 14: Enter Deleted Post Title in Search box at HomePage");
		userHomePage.enterToSearchBox(editPostTile);
		
		log.info("Search_Post - Step 15: Click on Search Button");
		userPostSearchPage = userHomePage.clickOnSearchButtonAtHomePage();


		log.info("Search_Post - Step 16: Verify 'Nothing Found' message is displayed");
		verifyTrue(userPostSearchPage.isNothingFoundDisplayed());
		

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
