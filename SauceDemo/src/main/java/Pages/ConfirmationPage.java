package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
    }
    By Subtotal = By.xpath("//div[@class='summary_subtotal_label']");
    By Finish = By.id("finish");
    public String returnSubtotal(){
        return driver.findElement(Subtotal).getText();
    }
    public void clickFinish(){
        driver.findElement(Finish).click();
    }
}
