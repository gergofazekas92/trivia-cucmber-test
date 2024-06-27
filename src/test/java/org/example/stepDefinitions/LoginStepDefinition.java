package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefinition {
    private LoginPage loginPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I enter username {string}, password {string} and I click the login button")
    public void iEnterUsernamePasswordAndIClickTheLoginButton(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        String actual = driver.getCurrentUrl();
        String expected = loginPage.getHomePageUrl();
        assertEquals(expected, actual);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
