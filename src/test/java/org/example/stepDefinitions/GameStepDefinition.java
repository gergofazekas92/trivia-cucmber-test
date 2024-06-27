package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.GamePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class GameStepDefinition {
    public static final String baseUrl = "http://localhost:8090/";
    public static final String USERNAME = "testuser";
    public static final String PASSWORD = "testuser";
    public static final int NUMBER_OF_QUIZES = 10;
    private LoginPage loginPage;
    private GamePage gamePage;
    private WebDriver driver;
    private String question;
    private int points;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        gamePage = new GamePage(driver);
        gamePage.navigateToHomePage();
        loginPage.login(USERNAME, PASSWORD);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the game page")
    public void iAmOnTheGamePage() {
        gamePage.checkIfGamePageIsLoaded();
    }

    @When("clicking on the Ranked button")
    public void clickingOnTheRankedButton() {
        gamePage.clickOnRankedButton();
    }

    @Then("a question pops up")
    public void aQuestionPopsUp() {
        boolean isGamePresent = gamePage.checkIfQuestionIsPresent();
        assertTrue(isGamePresent);
    }

    @Given("I opened a game")
    public void openingAGame() {
        gamePage.clickOnRankedButton();
    }

    @When("I click the Close button")
    public void closeTheGame() {
        gamePage.clickOnCloseButton();
    }

    @Then("the question disappears")
    public void checkIfQuestionIsPresent() {
        boolean isGamePresent = gamePage.checkIfQuestionIsPresent();
        assertFalse(isGamePresent);
    }

    @Given("I answered a question")
    public void answeringTheQuestion() {
        gamePage.clickOnRankedButton();
        gamePage.answeringTheQuestion();
        question = gamePage.getQuestion();
    }

    @When("I click the Next button")
    public void clickingNextButton() {
        gamePage.clickNextQuestionButton();
    }

    @Then("I see a new question")
    public void checkingIsQuestionChanged() {
        String actualQuestion = gamePage.getQuestion();
        assertNotEquals(question, actualQuestion);
    }

    @When("I answer a few questions")
    public void answeringQuestions() {
        points = gamePage.getPlayerPoints();
        gamePage.startGameAndAnswerAnyNumberOfQuestions(NUMBER_OF_QUIZES);
    }

    @Then("I want to see my points increased")
    public void checkIfPointsWereRegistered() {
        gamePage.navigateToHomePage();
        int actualPoints = gamePage.getPlayerPoints();
        assertTrue(actualPoints > points);
    }
}
