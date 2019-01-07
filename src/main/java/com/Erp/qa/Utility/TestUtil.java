package com.Erp.qa.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Erp.qa.BaseClass.TestBase;

public class TestUtil extends TestBase {

	public static long page_load_time = 30;
	public static long implicit_time = 30;

	public void swithToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void captureScreenShot(String screenshotname) throws Exception {

		TakesScreenshot edriver = (TakesScreenshot) driver;

		File srcFile = edriver.getScreenshotAs(OutputType.FILE);

		File dstFile = new File("./ScreenShot/" + screenshotname + ".png");

		FileUtils.copyFile(srcFile, dstFile);

		System.out.println("ScreenShot taken");

	}

}
