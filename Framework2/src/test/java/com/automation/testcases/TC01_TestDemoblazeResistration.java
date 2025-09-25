package com.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utilities.BaseClass;

public class TC01_TestDemoblazeResistration extends BaseClass {

	@Test
	public void testLogin() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.register("user" + System.currentTimeMillis(), "abc123");
		
		
		//assertEquals(loginPage.successfulPopup(), "Sign up successful.");
		try {
		    Alert alert = driver.switchTo().alert();
		    System.out.println("Alert: " + alert.getText());
		    alert.accept();
		} catch (NoAlertPresentException e) {
		   
		}
		
		
	}
}
