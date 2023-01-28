package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "p strong")
    private WebElement welcomeTextElement;
    @FindBy (css = ".hello strong")
    private WebElement registrationWelcomeTextElement ;
    public String getTextElement(){
        return welcomeTextElement.getText();
    }
    public String getRegistrationWelcomeText(){
        return registrationWelcomeTextElement.getText();
    }
}
