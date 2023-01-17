import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LoginTest loginTest = new LoginTest();
        loginTest.loginWithValidData();
        WishlistTest wishlistTest = new WishlistTest();
        wishlistTest.addToWishlistTest();
        RegisterTest registerTest = new RegisterTest();
        registerTest.registerNewUserTest();
    }
}
