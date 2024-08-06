package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends AuthenticationForm{
    @FindBy(xpath = "//button[text() = 'Register']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegisterPage(){
        driver.get(REGISTER_PAGE_URL);
    }

    private void fillUserNameAndPassword(String userName, String password){
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
    }
    private void clickRegisterButton(){
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
    public void register(String userName, String password){
        fillUserNameAndPassword(userName, password);
        clickRegisterButton();
    }

    public String getErrorMessage() {
        return "Username already in use, please choose another!";
    }
}
