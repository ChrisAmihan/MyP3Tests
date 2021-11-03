package com.revature.gluecode;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.poms.RevibeHomePage;
import com.revature.poms.RevibeLoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberLogoutGluecode {

	private WebDriver driver;
	RevibeLoginPage loginPage;
	RevibeHomePage homePage = new RevibeHomePage(driver);

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://martiantools.s3-website.us-east-2.amazonaws.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		loginPage = new RevibeLoginPage(driver);
	}
	
	@Given("The user has logged in with correct credentials")
	public void the_user_has_logged_in_with_correct_credentials() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		loginPage.setUsername("TestUser01");
		loginPage.setPassword("test");
		loginPage.clickLogin();
	}
	
	@Given("the user is on the homepage of ReVibe")
	public void the_user_is_on_the_homepage_of_re_vibe() {
		Assert.assertEquals("http://martiantools.s3-website.us-east-2.amazonaws.com/login", driver.getCurrentUrl());
	}
	
	@When("the user clicks LOGOUT")
	public void the_user_clicks_logout() {
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(WebDriverException.class);
		homePage.clickLogoutTag();
	}
	
	@Then("the user is redirected to the login page after logging in")
	public void the_user_is_redirected_to_the_login_page_after_logging_in() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Assert.assertEquals("http://martiantools.s3-website.us-east-2.amazonaws.com/login", driver.getCurrentUrl());
	}
	
}
