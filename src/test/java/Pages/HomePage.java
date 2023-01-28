package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".skip-account .label")
    private WebElement accountButton;
    @FindBy(css = "[title='Log In']")
    private WebElement loginlink;
    @FindBy (id = "search")
    private WebElement searchField;
    @FindBy (css = ".search-button")
    private WebElement searchButton;
    @FindBy (css = "li [title='Register']")
    private WebElement registerLink;
    @FindBy (css = ".level0.nav-5 a")
    private WebElement saleLinkCategory;

    public void clickAccountButton(){
        accountButton.click();
    }
    public void clickLoginLink(){
        loginlink.click();
    }
    public void setSearchField (String value){
        searchField.clear();
        searchField.sendKeys(value);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public void clickRegisterLink(){
        registerLink.click();
    }
    public void clickSaleLinkCategory(){
        saleLinkCategory.click();
    }
}
