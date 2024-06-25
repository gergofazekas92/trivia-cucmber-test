package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterPageTest {
    private RegisterPage registerPage;
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        registerPage = new RegisterPage;
    }

    @Given("User navigate to the Register page")
    public void userNavigateToRegisterPage(){

    }
}
