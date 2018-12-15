package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	HomePage homePage;
	ContactsPage contactPage;
	String sheetName = "contacts";
	
	public ContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();	
		homePage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.GoInsideFrame();
		contactPage = homePage.clickOnContactsLink();				
	}
	
	@Test(priority=1)
	public void verifyContactPageLabel() {
		Assert.assertTrue(contactPage.verifyContactsLable(),"Contacts label is missing in the page");
	}
	
	@Test(priority=2)
	public void verifyContactSelect() {
		
		String name = "User One";
		contactPage.selectContactsByName(name);
		Assert.assertTrue(contactPage.verifyContactIsSelectedByName(name));
		
	}
	
	@Test(priority=3)
	public void validateCreateNewContact() {
		homePage.clickOnNewContactLink();
		contactPage.createNewContact("Mr.", "Rocking", "Yash", "KFI");
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateMultipleNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		contactPage.createNewContact(title, firstName, lastName, company);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		quit();
	}
}
