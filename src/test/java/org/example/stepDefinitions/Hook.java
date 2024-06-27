package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    protected static WebDriver driver;
    protected static RegisterPage registerPage;
    protected static LoginPage loginPage;

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

    public static WebDriver getDriver() {
        return driver;
    }

    public static RegisterPage getRegisterPage() {
        return registerPage;
    }

    public static LoginPage getLoginPage() {
        return loginPage;
    }
}
