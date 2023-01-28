package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "firstname")
    private WebElement firstnameField;
    @FindBy (id = "lastname")
    private WebElement lastnameField;
    @FindBy (id = "email_address")
    private WebElement emailField;
    @FindBy (id = "password")
    private WebElement passwordField;
    @FindBy (id = "confirmation")
    private WebElement confirmationPasswordField;
    @FindBy (id = "is_subscribed")
    private WebElement subscribedCheckBox;
    @FindBy (css = ".buttons-set span span")
    private WebElement registerButton;

    public void setFirstnameField(String firstname){
        firstnameField.sendKeys(firstname);
    }
    public void setLastnameField(String lastname){
        lastnameField.sendKeys(lastname);
    }
    public void setEmailField(String email){
        emailField.sendKeys(email);
    }
    public void setPasswordField(String password){
        passwordField.sendKeys(password);
    }
    public void setConfirmationPasswordField(String confirmation){
        confirmationPasswordField.sendKeys(confirmation);
    }
    public void checkBox(){
        subscribedCheckBox.click();
    }
    public void clickRegisterButton(){
        registerButton.click();
    }


}
