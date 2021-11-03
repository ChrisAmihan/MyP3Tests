package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevibeResetPasswordPage {

	public RevibeResetPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	private WebElement inputEmailBox;
	@FindBy(xpath="//*[@id=\"button-login-submit\"]/span[1]")
	private WebElement resetPasswordButton;

	public void setEmail(String email) {
		inputEmailBox.sendKeys(email);
	}
	
	public void clickResetPasswordButton() {
		resetPasswordButton.click();
	}
	
}
