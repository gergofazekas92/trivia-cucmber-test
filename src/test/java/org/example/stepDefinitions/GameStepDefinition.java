package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.GamePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class GameStepDefinition {
    public static final int NUMBER_OF_QUIZZES = 10;
    private final LoginPage loginPage = Hook.getLoginPage();
    private final GamePage gamePage = Hook.getGamePage();
    private final WebDriver driver = Hook.getDriver();
    private int points;

    @Given("I am logged in")
    public void loggingIn() {
        gamePage.navigateToLoginPage();
        loginPage.login(loginPage.getUsername(), loginPage.getPassword());
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

    @Given("I don't have points")
    public void iDonTHavePoints() {
        points = gamePage.getPlayerPoints();
    }

    @When("I submitted the wrong answer")
    public void iSubmittedTheWrongAnswer() {
        gamePage.giveWrongAnswer();
    }

    @Then("I still don't have points")
    public void iStillDonTHavePoints() {
        int actualPoints = gamePage.getPlayerPoints();

        assertEquals(points, actualPoints);
    }

    @When("I submitted the right answer")
    public void iSubmittedTheRightAnswer() {
        gamePage.giveCorrectAnswer();
    }

    @Then("my points are increased")
    public void myPointsAreIncreased() {
        driver.get(gamePage.getHomePageUrl());
        int actualPoints = gamePage.getPlayerPoints();

        assertTrue(points < actualPoints);
    }

    @When("I give several correct answers")
    public void iGiveSeveralCorrectAnswers() {
        for (int i = 0; i < NUMBER_OF_QUIZZES; i++) {
            gamePage.giveCorrectAnswer();
            gamePage.clickNextQuestionButton();
        }

        gamePage.clickOnCloseButton();
    }

    @Then("my name is on the leaderboard")
    public void myNameIsOnTheLeaderboard() {
        boolean isUserPresentOnLeaderboard = gamePage.checkIfUserIsOnTheLeaderboard();

        assertTrue(isUserPresentOnLeaderboard);
    }

    @Then("the answer turns green")
    public void theAnswerTurnsGreen() {
        boolean isItGreen = gamePage.isAnswerGreen();

        assertTrue(isItGreen);
    }

    @Then("the answer turns red")
    public void theAnswerTurnsRed() {
        boolean isItRed = gamePage.isAnswerRed();

        assertTrue(isItRed);
    }

    @When("refreshed the page")
    public void refreshedThePage() {
        gamePage.navigateToHomePage();
    }

    @When("I select any answer")
    public void selectingFirstAnswer() {
        gamePage.selectingFirstAnswer();
    }

    @Then("the answer turns blue")
    public void theAnswerTurnsBlue() {
        boolean isItBlue = gamePage.isAnswerBlue();

        assertTrue(isItBlue);
    }
}
