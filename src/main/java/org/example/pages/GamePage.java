package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GamePage extends BasePage {
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

    public GamePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get(getLoginPageUrl());
    }

    public void navigateToHomePage() {
        driver.get(getHomePageUrl());
    }

    public void startGameAndAnswerAnyNumberOfQuestions(int numberOfQuestion) {
        clickOnRankedButton();
        String question = getQuestion();

        for (int i = 0; i < numberOfQuestion; i++) {
            selectFirstAnswer();
            clickOnSubmitButton();
            clickNextQuestionButton();
            wait.until(driver -> !question.equals(getQuestion()));
        }

        clickOnCloseButton();
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

    public void answeringTheQuestion() {
        selectFirstAnswer();
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

    public String getQuestion() {
        wait.until(ExpectedConditions.visibilityOf(submitAnswerButton));
        return question.getText();
    }

    public void clickNextQuestionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextQuestionButton));
        nextQuestionButton.click();
    }

    public int getPlayerPoints() {
        wait.until(ExpectedConditions.visibilityOf(points));
        return Integer.parseInt(points.getText().substring(8));
    }

    private void clickOnSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitAnswerButton));
        submitAnswerButton.click();
    }

    private void selectFirstAnswer() {
        wait.until(ExpectedConditions.visibilityOf(submitAnswerButton));
        firstAnswer.click();
    }

    private void selectNthAnswer(int answerNumber) {
        wait.until(ExpectedConditions.visibilityOf(submitAnswerButton));
        driver.findElement(By.cssSelector(".answers div:nth-of-type(" + answerNumber + ")")).click();
    }
}
