package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaleCategoryResultsPage {
    private WebDriver driver;
    public SaleCategoryResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = ".actions a.button")
    private WebElement viewDetailsButton;

    public void clickViewDetailsButton (){
        viewDetailsButton.click();
    }
}
