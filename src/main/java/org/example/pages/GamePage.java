package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GamePage extends BasePage {
    private static final String RED = "rgba(255, 0, 0, 1)";
    private static final String BLUE = "rgba(173, 216, 230, 1)";
    private static final String GREEN = "rgba(144, 238, 144, 1)";
    @FindBy(xpath = "//h1[text() = 'Home']")
    private WebElement homeHeader;
    @FindBy(xpath = "//button[text() = 'Ranked']")
    private WebElement rankedButton;
    @FindBy(xpath = "//button[text() = 'Close']")
    private WebElement closeQuestionButton;
    @FindBy(xpath = "//button[text() = 'Submit']")
    private WebElement submitAnswerButton;
    @FindBy(xpath = "//button[text() = 'Next']")
    private WebElement nextQuestionButton;
    @FindBy(css = ".answers div:nth-of-type(1)")
    private WebElement firstAnswer;
    @FindBy(xpath = "//div[@class = 'question']")
    private WebElement question;
    @FindBy(id = "points")
    private WebElement points;
    @FindBy(xpath = "//div[contains(text(), 'CORRECT')]")
    private WebElement correctAnswer;
    @FindBy(xpath = "//div[contains(text(), 'incorrect')]")
    private WebElement wrongAnswer;
    @FindBy(xpath = "//li[@class = 'playerList' and contains(text(), '" + USERNAME + "')]")
    private WebElement userOnLeaderboard;

    public GamePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    public void navigateToHomePage() {
        driver.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(points));
    }

    public void checkIfGamePageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(homeHeader));
    }

    public boolean checkIfQuestionIsPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(submitAnswerButton));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean checkIfUserIsOnTheLeaderboard() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userOnLeaderboard));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAnswerGreen() {
        wait.until(ExpectedConditions.elementToBeClickable(nextQuestionButton));
        String color = correctAnswer.getCssValue("background-color");

        return color.equals(GREEN);
    }

    public boolean isAnswerRed() {
        wait.until(ExpectedConditions.elementToBeClickable(nextQuestionButton));
        String color = wrongAnswer.getCssValue("background-color");

        return color.equals(RED);
    }

    public boolean isAnswerBlue() {
        wait.until(ExpectedConditions.elementToBeClickable(submitAnswerButton));
        String color = firstAnswer.getCssValue("background-color");

        return color.equals(BLUE);
    }

    public void selectingFirstAnswer() {
        wait.until(ExpectedConditions.visibilityOf(question));
        firstAnswer.click();
    }

    public void giveCorrectAnswer() {
        selectCorrectAnswer();
        clickOnSubmitButton();
    }

    public void giveWrongAnswer() {
        selectWrongAnswer();
        clickOnSubmitButton();
    }

    public void clickOnRankedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(rankedButton));
        rankedButton.click();
    }

    public void clickOnCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeQuestionButton));
        closeQuestionButton.click();
    }

    public void clickNextQuestionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextQuestionButton));
        nextQuestionButton.click();
    }

    public int getPlayerPoints() {
        driver.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(points));
        return Integer.parseInt(points.getText().substring(8));
    }

    private void clickOnSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitAnswerButton));
        submitAnswerButton.click();
    }

    private void selectCorrectAnswer() {
        wait.until(ExpectedConditions.visibilityOf(question));
        correctAnswer.click();
    }

    private void selectWrongAnswer() {
        wait.until(ExpectedConditions.visibilityOf(question));
        wrongAnswer.click();
    }

    private void selectNthAnswer(int answerNumber) {
        wait.until(ExpectedConditions.visibilityOf(submitAnswerButton));
        driver.findElement(By.cssSelector(".answers div:nth-of-type(" + answerNumber + ")")).click();
    }
}
