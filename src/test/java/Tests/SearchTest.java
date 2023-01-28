package Tests;

import Pages.HomePage;
import Pages.SearchResultsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }
    @Test
    public void searchForSpecificItem(){
        homePage.setSearchField("Shirt");
        homePage.clickSearchButton();
        Assert.assertTrue(searchResultsPage.isProductInList("CORE STRIPED SPORT SHIRT"));
        homePage.setSearchField("Neck");
        homePage.clickSearchButton();
        Assert.assertTrue(searchResultsPage.isProductInList("SILVER DESERT NECKLACE"));
    }
    @Test
    public void searchForInexistentItem(){
        homePage.setSearchField("Nothing");
        homePage.clickSearchButton();
        String actualText = searchResultsPage.getResultMessageText();
        String expectedText = "Your search returns no results.";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
