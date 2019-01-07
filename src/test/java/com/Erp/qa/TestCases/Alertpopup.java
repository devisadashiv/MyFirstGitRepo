package com.Erp.qa.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alertpopup {

	@Test
	public void alertverify() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(2000);

		Alert alt = driver.switchTo().alert();

		String text = alt.getText();

		Assert.assertTrue(text.contains("Please enter a valid user name"));
		
		System.out.println(text);

		alt.accept();// click on ok button

		System.out.println(driver.getTitle());

	}

}
