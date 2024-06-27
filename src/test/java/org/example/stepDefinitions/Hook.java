package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.GamePage;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hook {

    private static WebDriver driver;
    private static WebDriverWait wait;
    protected static final int WAIT_DURATION_SEC = 5;
    private static RegisterPage registerPage;
    private static LoginPage loginPage;
    protected static GamePage gamePage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION_SEC));
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        gamePage = new GamePage(driver);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
    public static RegisterPage getRegisterPage() {
        return registerPage;
    }

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static GamePage getGamePage() {
        return gamePage;
    }
}
