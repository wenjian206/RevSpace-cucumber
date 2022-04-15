package com.training.cucumber;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

//Glue code - selenium stuffs
public class DarkModeSteps {
	String browserName = "edge";
	WebDriver driver;

	@Given("new browser is open")
	public void browser_is_open() {
		System.out.println("#Step - browser is open");
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("#Step - user is on login page");
		driver.get("http://localhost:4200/");
		assertTrue(driver.findElement(By.id("darkMode")).isDisplayed());
	}

	@When("user clicks on the Dark Mode check box")
	public void user_clicks_on_the_dark_mode_check_box() {
		System.out.println("#Step - user clicks on the Dark Mode check box");
		driver.findElement(By.id("darkMode")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("dark mode is applied to the web page")
	public void dark_mode_is_applied_to_the_web_page() {
		System.out.println("#Step - dark mode is applied to the web page");
		String bckgclr = driver.findElement(By.tagName("body")).getCssValue("background-color");
//		System.out.println(bckgclr);
		assertFalse(bckgclr.equals("rgba(241,242,246)"));
	}



}
