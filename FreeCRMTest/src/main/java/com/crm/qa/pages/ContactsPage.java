package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	//@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(name="title")
	//@CacheLookup
	WebElement newContactTitle;
	
	@FindBy(id="first_name")
	//@CacheLookup
	WebElement firstName;
	
	@FindBy(id="surname")
	//@CacheLookup
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	//@CacheLookup
	WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	//@CacheLookup
	WebElement saveUserBtn;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLable() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input")).click();
	}
	
	public boolean verifyContactIsSelectedByName(String name) {
		return driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input")).isSelected();
	}
	
	public void createNewContact(String title, String ftName, String ltName, String company) {
		
		Select select = new Select(newContactTitle);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(company);
		saveUserBtn.click();
	}
	
	
	
	
}
