package com.Erp.qa.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Erp.qa.BaseClass.TestBase;
import com.Erp.qa.Utility.TestUtil;
import com.Erp.qa.pages.ContactsPage;
import com.Erp.qa.pages.HomePage;
import com.Erp.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;

	HomePage hmpage;
	
	ContactsPage contPage;
	
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp()
	{
		intializtion();
		loginpage=new LoginPage();
		testUtil=new TestUtil();
		hmpage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	

	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String hmpageTitle=hmpage.verifyHomePageTitle();
		
		Assert.assertEquals(hmpageTitle,"CRMPRO","Home Page Title is Not Correct");
		
	}
	
	@Test(priority=2)
	public void verifyUserCorrectLabelTest()
	{
		testUtil.swithToFrame();
		Assert.assertTrue(hmpage.verifycorrctUserLabel());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.swithToFrame();
		contPage=hmpage.contactslink();
		
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
