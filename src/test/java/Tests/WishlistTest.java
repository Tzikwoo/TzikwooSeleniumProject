package Tests;

import Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WishlistTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SaleCategoryResultsPage saleCategoryResultsPage;
    private ProductPage productPage;
    private WishlistPage wishlistPage;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        saleCategoryResultsPage = new SaleCategoryResultsPage(driver);
        productPage = new ProductPage(driver);
        wishlistPage = new WishlistPage(driver);

    }
    @Test
    public void WishlistTestWithLogin() {
        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("bogdi_perte98@yahoo.com");
        loginPage.setPasswordField("300798");
        loginPage.clickLoginButton();
        homePage.clickSaleLinkCategory();
        saleCategoryResultsPage.clickViewDetailsButton();
        productPage.clickWishlistLink();
        String actualText= wishlistPage.getAddedToWishlistMessage();
        String expectedText = "SLIM FIT DOBBY OXFORD SHIRT";
        Assert.assertEquals(expectedText,actualText);
   }
    @Test
    public void addToWishlistTest() throws InterruptedException {
        homePage.clickSaleLinkCategory();
        saleCategoryResultsPage.clickViewDetailsButton();
        productPage.clickWishlistLink();
        String actualText = loginPage.getLoginOrRegisterMessage();
        String expectedText = "LOGIN OR CREATE AN ACCOUNT";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}

