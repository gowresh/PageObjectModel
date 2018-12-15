package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	HomePage homePage;
	ContactsPage contactPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();	
		homePage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home page tite not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameInHomePageTest() {
		TestUtil.GoInsideFrame();
		String title = homePage.validateUserNameInHomePage();
		if(!title.contains("Gowresh"))
			Assert.fail();
		
	}
	
	@Test(priority=3)
	public void verifyContactsClick() {
		TestUtil.GoInsideFrame();
		contactPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		quit();
	}
	
}
