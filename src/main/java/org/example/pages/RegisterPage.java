package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int WAIT_DURATION_SEC = 10;
    private final String registerUrl;
    private final String userName;
    private final String password;
    @FindBy(css = "input[name='userName']")
    private WebElement userNameInput;
    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[text() = 'Register']")
    private WebElement registerButton;
    @FindBy(tagName = "p")
    private WebElement userNameError;
    public RegisterPage(WebDriver driver,String baseUrl, String userName, String password) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION_SEC));
        PageFactory.initElements(driver, this);
        this.registerUrl = baseUrl + "/register";
        this.userName = userName;
        this.password = password;
    }

    public void navigateToRegisterPage(){
        driver.get(registerUrl);
    }
    private void fillUserNameAndPassword(){
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
    }
    private void clickRegisterButton(){
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
    public void register(){
        fillUserNameAndPassword();
        clickRegisterButton();
    }
    public boolean errorMessageIsShowed(){
        //wait.until(ExpectedConditions.visibilityOf(userNameError));
        return userNameError.isDisplayed();
    }
}
