package com.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utilities.BaseClass;
import com.automation.utilities.Helper;

public class TC02_TestDemoblazeLogin extends BaseClass {

	@Test
	public void testLogin() {

		logger = report.createTest("Login to DemoBlaze");
		//excel.getStringData("Shee1", 0, 0); //user name
		//excel.getStringData("Shee1", 0, 1); // password
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//loginPage.login("gtjay", "abc123");
		
		logger.info("Starting the Application");
		
		loginPage.login(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		try {
			assertEquals(loginPage.nameOfUser(), "Welcome gtjay");
		}catch (Exception e) {
			loginPage.successfulPopup();
		}
		
		Helper.captureScreenshots(driver);
		
		logger.fail("Login Unsuccessful");
	}
}
