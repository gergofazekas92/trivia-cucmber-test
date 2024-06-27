package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterStepDefinition{

    private RegisterPage registerPage = Hook.getRegisterPage();
    private WebDriver driver = Hook.getDriver();

    @Given("User navigate to the Register page")
    public void userNavigateToTheRegisterPage() {
        registerPage.navigateToRegisterPage();
    }

    @When("User successfully enter valid {string} and {string}")
    public void userSuccessfullyEnterValidUsernameAndPassword(String username, String password) {
        registerPage.register(username,password);
    }

    @Then("User should be able to log in the game with {string} and {string}")
    public void userShouldBeAbleToLogInTheGameWithAnd(String username, String password) throws InterruptedException {
        //loginPage.login(username, password);
        Thread.sleep(3000);
        String actual = driver.getCurrentUrl();
        String expected = "http://localhost:8090/";
        assertEquals(expected, actual);
    }
}
