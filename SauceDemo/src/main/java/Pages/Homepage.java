package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    WebDriver driver;
    public Homepage(WebDriver driver){
        this.driver = driver;
    }
    By AddToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    By AddToCartBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    By AddToCartBoltShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By AddToCartFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By AddToCartOnesie = By.id("add-to-cart-sauce-labs-onesie");
    By AddToCartRedShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By AddToCartFirstItem = By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]");
    By SortBy = By.xpath("//select[@data-test='product_sort_container']");
    By MenuButton = By.id("react-burger-menu-btn");
    By Logout = By.id("logout_sidebar_link");
    By Cart = By.id("shopping_cart_container");
    public void setAddToCartBackpack(){
        driver.findElement(AddToCartBackpack).click();
    }
    public void setAddToCartBikeLight(){
        driver.findElement(AddToCartBikeLight).click();
    }
    public void setAddToCartBoltShirt(){
        driver.findElement(AddToCartBoltShirt).click();
    }
    public void setAddToCartFleeceJacket(){
        driver.findElement(AddToCartFleeceJacket).click();
    }
    public void setAddToCartOnesie(){
        driver.findElement(AddToCartOnesie).click();
    }
    public void setAddToCartRedShirt(){
        driver.findElement(AddToCartRedShirt).click();
    }
    public void setSortBy(String option){
        Select options = new Select(driver.findElement(SortBy));
        options.selectByVisibleText(option);
    }
    public void clickCart(){
        driver.findElement(Cart).click();
    }
    public void orderBoltShirt(){
        setAddToCartBoltShirt();
        clickCart();
    }
    public void orderFirstItem(){
        driver.findElement(AddToCartFirstItem).click();
        clickCart();
    }
    public void orderAllItems(){
        setAddToCartBackpack();
        setAddToCartBoltShirt();
        setAddToCartBikeLight();
        setAddToCartOnesie();
        setAddToCartFleeceJacket();
        setAddToCartRedShirt();
        clickCart();
    }
    public void logout(){
        driver.findElement(MenuButton).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(Logout));
        driver.findElement(Logout).click();
    }
}
