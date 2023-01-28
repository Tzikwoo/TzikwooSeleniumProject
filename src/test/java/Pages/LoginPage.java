package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.IDN;

public class LoginPage {
    private WebDriver driver;
    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "email")
    private WebElement emailField;
    @FindBy (id = "pass")
    private WebElement passwordField;
    @FindBy (id = "send2")
    private WebElement loginButton;
    @FindBy (css = ".error-msg span")
    private WebElement invalidMessage;
    @FindBy (id = "advice-required-entry-email")
    private WebElement adviceEmail;
    @FindBy (id = "advice-required-entry-pass")
    private WebElement advicePassword;
    @FindBy (css = "h1 ")
    private WebElement loginOrRegisterMessage;
    public void setEmailField(String email){
        emailField.sendKeys(email);
    }
    public void setPasswordField(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public String getInvalidText (){
        return invalidMessage.getText();
    }
    public String getAdviceEmailText(){
        return adviceEmail.getText();
    }
    public String getAdvicePasswordText(){
        return advicePassword.getText();
    }
    public String getLoginOrRegisterMessage(){
        return loginOrRegisterMessage.getText();
    }
}
