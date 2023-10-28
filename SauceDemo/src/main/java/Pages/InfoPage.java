package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage {
    WebDriver driver;
    public InfoPage(WebDriver driver){
        this.driver=driver;
    }
    By FirstName = By.id("first-name");
    By LastName = By.id("last-name");
    By PostalCode = By.id("postal-code");
    By Continue = By.id("continue");
    By ErrorMessage = By.xpath("//h3[@data-test='error']");
    public void enterFirstName(String firstName){
        driver.findElement(FirstName).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(LastName).sendKeys(lastName);
    }
    public void enterPostalCode(String postalCode){
        driver.findElement(PostalCode).sendKeys(postalCode);
    }
    public void enterInfo(String firstName, String lastName, String postalCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }
    public void clickContinue(){
        driver.findElement(Continue).click();
    }
    public String getErrorMessage(){
        return driver.findElement(ErrorMessage).getText();
    }
    public void clearAllFields(){
        driver.findElement(FirstName).clear();
        driver.findElement(LastName).clear();
        driver.findElement(PostalCode).clear();
    }
}
