package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterStepDefinition {
    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("User navigate to the Register page")
    public void user_navigate_to_the_register_page() {
        registerPage.navigateToRegisterPage();
    }

    @When("User successfully enter valid {string} and {string}")
    public void user_successfully_enter_valid_username_and_password(String username, String password) {
        registerPage.register(username,password);
    }

    @Then("User should be able to log in the game with {string} and {string}")
    public void userShouldBeAbleToLogInTheGameWithAnd(String username, String password) {
        //loginPage.login(username, password);
        String actual = driver.getCurrentUrl();
        String expected = "http://localhost:8090";
        assertEquals(expected, actual);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
