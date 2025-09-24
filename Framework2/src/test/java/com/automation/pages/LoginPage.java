package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utilities.BrowserFactory;

public class LoginPage {
	public WebDriver driver;
  
	//constructor
//  public LoginPage(WebDriver ldriver) {
//	  this.driver = ldriver;
//  }
  
  @FindBy(xpath="//label[text()='Username:']/following-sibling::input[@id='loginusername']")
  WebElement loginUserName;
  
  @FindBy(xpath="//label[text()='Username:']/following-sibling::input[@id='sign-username']")
  WebElement signUpUserName;
  
  @FindBy(xpath="//label[text()='Password:']/following-sibling::input[@id='loginpassword']")
  WebElement loginPassword;
  
  @FindBy(xpath="//label[text()='Password:']/following-sibling::input[@id='sign-password']")
  WebElement signUpPassword;
  
  @FindBy(xpath="//a[text()='Sign up']")
  WebElement signUpLink;
  
  @FindBy(xpath="//button[text()='Sign up']")
  WebElement signUpButton;
  
  @FindBy(xpath="//a[text()='Log in']")
  WebElement loginlink;
  
  @FindBy(xpath="//button[text()='Log in']")
  WebElement loginButton;
  
  @FindBy(xpath="//a[@id='nameofuser']")
  WebElement nameOfUser;
  
  public void register(String uname, String upassword) {
	  signUpLink.click();
	  BrowserFactory.sleep(2);
	  signUpUserName.sendKeys(uname);
	  BrowserFactory.sleep(2);
	  signUpPassword.sendKeys(upassword);
	  BrowserFactory.sleep(2);
	  signUpButton.click();
	  BrowserFactory.sleep(2);
	  	  
  }
  
  public void login(String uname, String upassword) {
	  loginlink.click();
	  BrowserFactory.sleep(2);
	  loginUserName.sendKeys(uname);
	  BrowserFactory.sleep(2);
	  loginPassword.sendKeys(upassword);
	  BrowserFactory.sleep(2);
	  loginButton.click();
	  BrowserFactory.sleep(2);
	  	  
  }
  public String nameOfUser() {
	  BrowserFactory.sleep(2);
	  String name = nameOfUser.getText();
	  System.out.println(name);
	  return name;
  }
  
  public String successfulPopup(){
	  BrowserFactory.sleep(2);
	  String popupMessage = driver.switchTo().alert().getText();
	  System.out.println(popupMessage);
	  return popupMessage;
  }
  
  
  
}
