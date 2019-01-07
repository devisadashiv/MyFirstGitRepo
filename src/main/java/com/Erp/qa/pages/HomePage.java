package com.Erp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Erp.qa.BaseClass.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(), 'User: Naveen K')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//a[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[text()='Tasks']")
	WebElement taskLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifycorrctUserLabel() {

		return userNameLabel.isDisplayed();
	}

	public ContactsPage contactslink() {
		contactsLink.click();

		return new ContactsPage();
	}

	public DealsPage dealspageLink() {
		dealsLink.click();

		return new DealsPage();
	}

	public TaskPage taskspageLink() {
		taskLink.click();

		return new TaskPage();
	}

}
