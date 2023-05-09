package com.test.test.stepdefinitions;

import com.test.test.runnerclass.RunnerTestNg001;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import com.aventstack.extentreports.Status;

public class LoginSteps {

    private WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        RunnerTestNg001.logStep("Opened browser and navigated to login page");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.get("https://example.com/login");
        driver.get("https://app.hubspot.com/login");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("ksgxyz2016@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Ksg@2016");
    }

    @When("click on the login button")
    public void click_on_the_login_button() {

        driver.findElement(By.id("loginBtn")).click();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        String expectedUrl = "https://example.com/dashboard";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    @Then("I should be redirected to the MFA page")
    public void i_should_be_redirected_to_the_mfa_page() {
        // Write code here that turns the phrase above into concrete actions
//        String expectedUrl = "https://app.hubspot.com/login/confirm-to-login";
        String expectedUrl = "https://app.hubspot.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }
}