package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterStepDefinition{
    private final RegisterPage registerPage = Hook.getRegisterPage();
    private final LoginPage loginPage = Hook.getLoginPage();
    private final WebDriver driver = Hook.getDriver();
    private final WebDriverWait wait = Hook.getWait();

    @Given("User navigate to the Register page")
    public void userNavigateToTheRegisterPage() {
        registerPage.navigateToRegisterPage();
    }

    @When("User successfully enter valid {string} and {string}")
    public void userSuccessfullyEnterValidUsernameAndPassword(String username, String password) throws InterruptedException {
        registerPage.register(username,password);
    }

    @Then("User should be able to log in the game with {string} and {string}")
    public void userShouldBeAbleToLogInTheGameWithUsernameAndPassword(String username, String password) throws InterruptedException {
        wait.until(ExpectedConditions.urlToBe(loginPage.getLoginPageUrl()));
        loginPage.login(username, password);
        String actual = driver.getCurrentUrl();
        String expected = registerPage.getHomePageUrl();
        assertEquals(expected, actual);
    }
}
