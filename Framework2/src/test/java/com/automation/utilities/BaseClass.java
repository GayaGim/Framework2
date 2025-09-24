package com.automation.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and Test are getting ready", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter
				(new File(System.getProperty("user.dir")+"/Reports/Extentreports" + Helper.getCurrentDatTime()+ ".html"));
	
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		Reporter.log("Setting up done. Test can be started", true);

	
	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting application ready.", true);

		BrowserFactory factory = new BrowserFactory();

		driver = factory.startApp(config.getBrowser(), config.getUrl());
		
		Reporter.log("Browser and application up and running.", true);

	}

	@AfterClass
	public void driverQuit() {
		driver.quit();
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			//Helper.captureScreenshots(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.fail("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.fail("Test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		
		report.flush(); //keep on adding reports into a single report
	}

}
