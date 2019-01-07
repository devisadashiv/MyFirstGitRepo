package com.Erp.qa.TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.Erp.qa.BaseClass.TestBase;
import com.Erp.qa.Utility.TestUtil;
import com.Erp.qa.pages.HomePage;
import com.Erp.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	HomePage hmpage;
	

	   
	 public LoginPageTest()
	{
			super();
	}
	
	
    @BeforeMethod
	public void setup()
	{
	   intializtion();
		
	  loginpage=new LoginPage();
	}
   
	@Test(priority=1)
	public void LoginPageTitleTest() throws Exception
	{
		
		Logger log=Logger.getLogger(LoginPageTest.class);
		
		String title=loginpage.validateloginPageTitle();
		
		log.info("verify the page title");
		
		Assert.assertTrue(title.contains("Free CRM"));
		
	
	}
	
	@Test(priority=2)
	public void LoginPageCrmImageTest() throws Exception
	{
		boolean flag=loginpage.validateCrmLogoImage();
		Assert.assertTrue(flag);
		
	
		
	}
	@Test(priority=3)
	public void loginTest() throws Exception
	{
		hmpage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			try {
				TestUtil.captureScreenShot(result.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
		
	}
}
