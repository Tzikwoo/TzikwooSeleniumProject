package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.RegisterPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private AccountPage accountPage;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        accountPage = new AccountPage(driver);
    }
    @Test
    public void registerNewUserTest() {
        homePage.clickAccountButton();
        homePage.clickRegisterLink();
        registerPage.setFirstnameField("Laurentiu");
        registerPage.setLastnameField("Petre");
        registerPage.setEmailField("laurentiupetre73@yahoo.com");
        registerPage.setPasswordField("123456");
        registerPage.setConfirmationPasswordField("123456");
        registerPage.checkBox();
        registerPage.clickRegisterButton();
        String actualText = accountPage.getRegistrationWelcomeText();
        String expectedText = "Hello, Laurentiu Petre!";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
