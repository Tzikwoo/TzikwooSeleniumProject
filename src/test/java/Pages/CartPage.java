package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = ".success-msg  span")
    private WebElement successAddedMessage;
    @FindBy (css = "[title='Qty']")
    private WebElement productQuantity;
    @FindBy (css = "[title='Update'] span span")
    private WebElement updateQuantityButton;
    @FindBy (css = ".product-cart-total .price")
    private WebElement cartTotalPrice;
    public String getSuccesAddedMessageText(){
        return successAddedMessage.getText();
    }
    public void clearAndSetQuantity (){
        productQuantity.clear();
        productQuantity.sendKeys("2");
    }
    public void clickUpdateButton(){
        updateQuantityButton.click();
    }
    public String getCartTotalPriceText(){
        return cartTotalPrice.getText();
    }
}
