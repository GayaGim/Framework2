package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;        // ✅ correct one
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshots(WebDriver driver) {
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		String screenShotPath = System.getProperty("user.dir")+ "./Screenshots/" + Helper.getCurrentDatTime() + ".png";
		
		try {
			FileHandler.copy(src, new File(screenShotPath));
			//FileHandler.copy(src, new File("./Screenshots/" + System.currentTimeMillis() + ".png"));

		} catch (IOException e) {
			System.out.println("Unable to capture screeshot" + e.getMessage());
		}
		return screenShotPath;
	}

	public static String getCurrentDatTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
		
	}
	
	public void alerts() {

	}
	
	public void frames() {

	}
	
	public void windows() {

	}
}
