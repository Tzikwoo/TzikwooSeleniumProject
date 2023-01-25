import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void registerNewUserTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("li [title='Register']")).click();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Laurentiu");
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Petre");
        WebElement email = driver.findElement(By.id("email_address"));
        String emailText = "laurentiupetre73@yahoo.com";
        email.sendKeys(emailText);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement confirmpassword = driver.findElement(By.id("confirmation"));
        confirmpassword.sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set span span")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String actualText = welcomeTextElement.getText();
        String expectedText = "Hello, Laurentiu Petre!";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
