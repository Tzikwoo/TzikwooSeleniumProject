import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public void registerNewUserTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Laurentiu");
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Petre");
        WebElement email = driver.findElement(By.id("email_address"));
        email.sendKeys("laurentiupetre71@yahoo.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement confirmpassword = driver.findElement(By.id("confirmation"));
        confirmpassword.sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        String actualText = welcomeTextElement.getText();
        String expectedText = "Hello, Laurentiu Petre!";
        if (actualText.equals(expectedText)){
            System.out.println("S-a inregistrat cu succes!");
        }else {
            System.err.println("Nu s-a inregistrat.");
        }
        driver.close();
    }
}
