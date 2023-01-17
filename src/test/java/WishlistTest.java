import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WishlistTest {

//    public void WishlistTestWithLogin() {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://testfasttrackit.info/selenium-test/");
//        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
//        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
//        driver.findElement(By.id("email")).sendKeys("bogdi_perte98@yahoo.com");
//        driver.findElement(By.id("pass")).sendKeys("300798");
//        driver.findElement(By.id("send2")).click();
//    }

    public void addToWishlistTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        Thread.sleep(3000);
        driver.close();

    }
}

