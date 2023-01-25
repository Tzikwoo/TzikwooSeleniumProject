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
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void loginWithValidData()  {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("bogdi_perte98@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("300798");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector("p strong"));
        String actualTextElement = welcomeTextElement.getText();
        String expectedTextElement= "Hello, Bogdan Perte!";
        Assert.assertEquals(expectedTextElement,actualTextElement);
    }
    @Test
    public void loginWithoutUsername() throws InterruptedException {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("pass")).sendKeys("300798");
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);
        WebElement requiredText = driver.findElement(By.id("advice-required-entry-email"));
        String actualText = requiredText.getText();
        String expectedText = "This is a required field.";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void loginWithoutPassword(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("bogdi_perte98@yahoo.com");
        driver.findElement(By.id("send2")).click();
        WebElement requiredField = driver.findElement(By.id("advice-required-entry-pass"));
        String actualText = requiredField.getText();
        String expectedText = "This is a required field.";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
