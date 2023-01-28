package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }
    @Test
    public void loginWithValidData()  {
        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("bogdi_perte98@yahoo.com");
        loginPage.setPasswordField("300798");
        loginPage.clickLoginButton();
        String actualTextElement = accountPage.getTextElement();
        String expectedTextElement= "Hello, Bogdan Perte!";
        Assert.assertEquals(expectedTextElement,actualTextElement);
    }
    @Test
    public void loginWithInvalidData(){
        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("bogdi_perte98@yahoo.com");
        loginPage.setPasswordField("3007980");
        loginPage.clickLoginButton();
        Assert.assertEquals("Invalid login or password.",loginPage.getInvalidText());
    }
    @Test
    public void loginWithoutUsername() throws InterruptedException {
        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setPasswordField("3007980");
        loginPage.clickLoginButton();
        Thread.sleep(3000);
        String actualText = loginPage.getAdviceEmailText();
        String expectedText = "This is a required field.";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void loginWithoutPassword(){
        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("bogdi_perte98@yahoo.com");
        loginPage.clickLoginButton();
        String actualText = loginPage.getAdvicePasswordText();
        String expectedText = "This is a required field.";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
