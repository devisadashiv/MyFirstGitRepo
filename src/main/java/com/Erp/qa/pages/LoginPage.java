package com.Erp.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Erp.qa.BaseClass.TestBase;

public class LoginPage extends TestBase
{

	//PageObject Repository
	
	
	@FindBy(name="username")
	WebElement UserEdit;
	
	@FindBy(name="password")
	WebElement paswordEdit;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@alt,'free crm logo')]")
	WebElement imglogo;
	
	
	//Intialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateloginPageTitle()
	{
	   return driver.getTitle()	;
	}
	
	public boolean validateCrmLogoImage()
	{
		return imglogo.isDisplayed();
	}
	
	public HomePage login(String un,String pw) 
	{
		UserEdit.sendKeys(un);
		paswordEdit.sendKeys(pw);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginBtn.click();
	
		
		return new HomePage();
		
	}
	
}

