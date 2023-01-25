import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest {
    private WebDriver driver;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Ignore
    @Test
    public void placeOrderLoggedIn(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("bogdi_perte98@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("300798");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".level0.nav-5 a")).click();
        driver.findElement(By.cssSelector(".actions a.button")).click();
        driver.findElement(By.cssSelector(".swatch-label img")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart span span")).click();
        driver.findElement(By.cssSelector(".bottom button")).click();
        driver.findElement(By.id("billing:street1")).sendKeys("25 Grigore Alexandrescu Street");
        driver.findElement(By.id("billing:city")).sendKeys("Cluj-Napoca");

    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
