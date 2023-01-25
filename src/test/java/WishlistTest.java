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
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void WishlistTestWithLogin() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("bogdi_perte98@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("300798");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".level0.nav-5 a")).click();
        driver.findElement(By.cssSelector(".actions a.button")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        WebElement wishlistText = driver.findElement(By.cssSelector("h3 a"));
        String actualText= wishlistText.getText();
        String expectedText = "SLIM FIT DOBBY OXFORD SHIRT";
        Assert.assertEquals(expectedText,actualText);
   }
    @Test
    public void addToWishlistTest() throws InterruptedException {
        driver.findElement(By.cssSelector(".level0.nav-5 a")).click();
        driver.findElement(By.cssSelector(".actions a.button")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        WebElement registrationText = driver.findElement(By.cssSelector("h1 "));
        String actualText = registrationText.getText();
        String expectedText = "LOGIN OR CREATE AN ACCOUNT";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}

