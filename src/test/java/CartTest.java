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
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void addAnItemToCartSale(){
        driver.findElement(By.cssSelector(".level0.nav-5 a")).click();
        driver.findElement(By.cssSelector(".actions a.button")).click();
        driver.findElement(By.cssSelector(".swatch-label img")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart span span")).click();
        WebElement succesfullText = driver.findElement(By.cssSelector(".success-msg  span"));
        String actualText= succesfullText.getText();
        String expectedText = "Slim fit Dobby Oxford Shirt was added to your shopping cart.";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void changeQuantityInCartTo2(){
        driver.findElement(By.cssSelector(".level0.nav-5 a")).click();
        driver.findElement(By.cssSelector(".actions a.button")).click();
        driver.findElement(By.cssSelector(".swatch-label img")).click();
        driver.findElement(By.cssSelector("#configurable_swatch_size .swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart span span")).click();
        driver.findElement(By.cssSelector("[title='Qty']")).clear();
        driver.findElement(By.cssSelector("[title='Qty']")).sendKeys("2");
        driver.findElement(By.cssSelector("[title='Update'] span span")).click();
        WebElement updatedPrice = driver.findElement(By.cssSelector(".product-cart-total .price"));
        String actualPrice = updatedPrice.getText();
        String expectedPrice = "280,00 RON";
        Assert.assertEquals(expectedPrice,actualPrice);
    }

    @After
    public void closeDriver(){
        driver.close();
    }
}
