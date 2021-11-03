package com.revature.gluecode;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.poms.RevibeLoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberLoginGluecode {

private WebDriver driver;
RevibeLoginPage loginPage;

@Before
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://martiantools.s3-website.us-east-2.amazonaws.com");
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	loginPage = new RevibeLoginPage(driver);
}
	
@Given("On the login page of ReVibe")
public void on_the_login_page_of_re_vibe() {
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	Assert.assertEquals("http://martiantools.s3-website.us-east-2.amazonaws.com/login", driver.getCurrentUrl());
}

@When("the user inputs their username")
public void the_user_inputs_their_username() {
	loginPage.setUsername("TestUser01");
	
}

@When("the user inputs their password")
public void the_user_inputs_their_password() {
	loginPage.setPassword("test");
	
}

@When("the user clicks the login button")
public void the_user_clicks_the_login_button() {
	loginPage.clickLogin();
}

@Then("the user is redirected to the homepage of ReVibe")
public void the_user_is_redirected_to_the_homepage_of_re_vibe() {
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	Assert.assertEquals("element not found", "HOMEPAGE", driver.findElement(By.xpath("/html/body/app-root/app-home/h1")).getText());
}
	
}
