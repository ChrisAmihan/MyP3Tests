package com.revature.gluecode;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.poms.RevibeHomePage;
import com.revature.poms.RevibeLoginPage;
import com.revature.poms.RevibeRegistrationPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberCreateNewAccountGluecode {

	private WebDriver driver;
	RevibeLoginPage loginPage;
	RevibeHomePage homePage;
	RevibeRegistrationPage registrationPage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://martiantools.s3-website.us-east-2.amazonaws.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new RevibeLoginPage(driver);
		homePage = new RevibeHomePage(driver);
		registrationPage = new RevibeRegistrationPage(driver);
	}
	
	@Given("The user is on the registration page")
	public void the_user_is_on_the_registration_page() {
		loginPage.clickCreateNewAccount();
	}

	@When("the user inputs their name")
	public void the_user_inputs_their_name() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		registrationPage.setName("TestUser2");
	}

	@When("the user inputs a username")
	public void the_user_inputs_a_username() {
		registrationPage.setUsername("TestUsername2");
	}

	@When("the user inputs a password")
	public void the_user_inputs_a_password() {
		registrationPage.setPassword("test");
	}

	@When("the user inputs an email")
	public void the_user_inputs_an_email() {
		registrationPage.setEmail("TestUser@email.com");
	}

	@When("the user clicks the submit button")
	public void the_user_clicks_the_submit_button() {
		registrationPage.clickSubmit();
	}
	
	@Then("the user is redirected to the login page")
	public void user_redirected_back_to_login() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals("http://martiantools.s3-website.us-east-2.amazonaws.com/login", driver.getCurrentUrl());
	}
		

}
