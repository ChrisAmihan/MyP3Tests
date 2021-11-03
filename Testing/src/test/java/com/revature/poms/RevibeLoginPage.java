package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevibeLoginPage {
	
	public RevibeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-login-username']")
	private WebElement usernameTxtBox;
	@FindBy(xpath = "//input[@id='input-login-password']")
	private WebElement passwordTxtBox;
	@FindBy(xpath = "//a[@id='button-login-forgotPassword']")
	private WebElement forgotPasswordLink;
	@FindBy(xpath = "//button[@id='button-login-submit']")
    private WebElement loginBtn;
	@FindBy(xpath = "//*[@id=\"button-login-newAccount\"]/span[1]")
	private WebElement createNewAccountBtn;
	
	public void setUsername(String username) {
		usernameTxtBox.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordTxtBox.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickForgotPassword() {
		forgotPasswordLink.click();
	}
	
	public void clickCreateNewAccount() {
		createNewAccountBtn.click();
	}
	
}