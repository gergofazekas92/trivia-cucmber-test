package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static final String LOGIN_PAGE_URL = "http://localhost:8090/";
    protected static final String HOME_PAGE_URL = "http://localhost:8090/home";
    protected static final String REGISTER_PAGE_URL = "http://localhost:8090/register";
    protected static final int WAIT_DURATION_SEC = 5;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION_SEC));
    }

    public String getHomePageUrl() {
        return HOME_PAGE_URL;
    }
    public String getLoginPageUrl() {
        return LOGIN_PAGE_URL;
    }

}
