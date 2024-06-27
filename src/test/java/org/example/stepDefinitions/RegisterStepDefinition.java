package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterStepDefinition{
    private final RegisterPage registerPage = Hook.getRegisterPage();
    private final LoginPage loginPage = Hook.getLoginPage();
    private final WebDriver driver = Hook.getDriver();

    @Given("User navigate to the Register page")
    public void userNavigateToTheRegisterPage() {
        System.out.println("GIVEN");
        registerPage.navigateToRegisterPage();
    }

    @When("User successfully enter valid {string} and {string}")
    public void userSuccessfullyEnterValidUsernameAndPassword(String username, String password) {
        System.out.println("WHEN");
        registerPage.register(username,password);
    }

    @Then("User should be able to log in the game with {string} and {string}")
    public void userShouldBeAbleToLogInTheGameWithAnd(String username, String password) throws InterruptedException {
        System.out.println("THEN");
        loginPage.login(username, password);
        Thread.sleep(3000);
        String actual = driver.getCurrentUrl();
        String expected = registerPage.getHomePageUrl();
        assertEquals(expected, actual);
    }
}
