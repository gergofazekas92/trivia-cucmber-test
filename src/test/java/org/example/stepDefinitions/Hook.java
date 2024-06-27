package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
