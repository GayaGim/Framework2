package com.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utilities.BaseClass;

public class TC01_TestDemoblazeResistration extends BaseClass {

	@Test
	public void testLogin() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.register("abc100", "abc123");
		
		try {
			assertEquals(loginPage.successfulPopup(), "Sign up successful.");
		}catch (Exception e) {
			loginPage.successfulPopup();
		}
		
		
	}
}
