package org.example.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AuthenticationForm {
    @FindBy(xpath = "//button[text() = 'Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    private void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    private void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        try {
            wait.until(ExpectedConditions.urlToBe(HOME_PAGE_URL));
        } catch (TimeoutException ignore) {
            System.out.println("Invalid credentials, could not redirect to home page ");
        }
    }
}
