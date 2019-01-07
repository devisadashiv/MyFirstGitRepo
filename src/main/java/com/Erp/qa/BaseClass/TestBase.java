package com.Erp.qa.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Erp.qa.Utility.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	
	public static Properties prop;

	
	
	
	public TestBase() {
try {
	 prop=new Properties();
	FileInputStream is
		 = new FileInputStream("C:\\Users\\Shivam\\Desktop\\DEVIPROJECTS\\com.ErpMavenProject\\src\\main\\java\\com\\Erp\\qa\\Config\\config.properties");
		prop.load(is);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 catch (IOException e) {
			e.printStackTrace();
		}
	
}
	
	
	
	
	  public static void intializtion()
	  {
		  String browsername=prop.getProperty("browser");
		 
		  if(browsername.equals("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  options.setPageLoadStrategy(PageLoadStrategy.NONE);
			  driver=new ChromeDriver();
	     }
		  else if(browsername.equals("ff"))
		  {
			  System.setProperty("webdriver.gecko.driver","C:\\SeleniumDrivers\\geckodriver.exe");
			  driver=new FirefoxDriver();
		  }
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(TestUtil.implicit_time, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time, TimeUnit.SECONDS);
		  
		  driver.get(prop.getProperty("url"));
		  
		  
	  }
	 
	  
	 
	
	
	

}
