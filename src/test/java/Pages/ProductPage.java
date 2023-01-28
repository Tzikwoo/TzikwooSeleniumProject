package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = ".link-wishlist")
    private WebElement wishlistLink;
    @FindBy (css = ".swatch-label img")
    private WebElement colorButton;
    @FindBy (css = "#configurable_swatch_size .swatch-label")
    private WebElement sizeButton;
    @FindBy (css = ".add-to-cart span span")
    private WebElement addToCartButton;
    public void clickWishlistLink(){
        wishlistLink.click();
    }
    public void selectColor(){
        colorButton.click();
    }
    public void selectSize(){
        sizeButton.click();
    }
    public void clickAddToCart(){
        addToCartButton.click();
    }
}
