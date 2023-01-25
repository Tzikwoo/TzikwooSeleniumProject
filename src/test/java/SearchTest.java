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
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void searchForSpecificItem(){
        driver.findElement(By.id("search")).sendKeys("Shirt");
        driver.findElement(By.cssSelector(".search-button")).click();
        WebElement shirtText = driver.findElement(By.cssSelector("h2:first-child a"));
        String actualText = shirtText.getText();
        String expectedText = "CORE STRIPED SPORT SHIRT";
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void searchForInexistentItem(){
        driver.findElement(By.id("search")).sendKeys("Nothing");
        driver.findElement(By.cssSelector(".search-button")).click();
        WebElement noResultsText = driver.findElement(By.cssSelector(".note-msg"));
        String actualText = noResultsText.getText();
        String expectedText = "Your search returns no results.";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
