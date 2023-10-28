package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    By RemoveItem = By.id("remove-sauce-labs-bolt-t-shirt");
    By Checkout = By.id("checkout");
    By ContinueShopping = By.id("continue-shopping");
    public void clickRemoveItem(){
        driver.findElement(RemoveItem).click();
    }
    public void clickCheckout(){
        driver.findElement(Checkout).click();
    }
    public void clickContinueShopping(){
        driver.findElement(ContinueShopping).click();
    }
}
