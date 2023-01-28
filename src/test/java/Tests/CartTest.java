package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SaleCategoryResultsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    private WebDriver driver;
    private HomePage homePage;
    private SaleCategoryResultsPage saleCategoryResultsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        homePage = new HomePage(driver);
        saleCategoryResultsPage = new SaleCategoryResultsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }
    @Test
    public void addAnItemToCartSale(){
        homePage.clickSaleLinkCategory();
        saleCategoryResultsPage.clickViewDetailsButton();
        productPage.selectColor();
        productPage.selectSize();
        productPage.clickAddToCart();
        String actualText= cartPage.getSuccesAddedMessageText();
        String expectedText = "Slim fit Dobby Oxford Shirt was added to your shopping cart.";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void changeQuantityInCartTo2(){
        homePage.clickSaleLinkCategory();
        saleCategoryResultsPage.clickViewDetailsButton();
        productPage.selectColor();
        productPage.selectSize();
        productPage.clickAddToCart();
        cartPage.clearAndSetQuantity();
        cartPage.clickUpdateButton();
        String actualPrice = cartPage.getCartTotalPriceText();
        String expectedPrice = "280,00 RON";
        Assert.assertEquals(expectedPrice,actualPrice);
    }

    @After
    public void closeDriver(){
        driver.close();
    }
}
