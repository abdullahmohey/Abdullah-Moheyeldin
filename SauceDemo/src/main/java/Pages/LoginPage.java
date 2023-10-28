package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By Username = By.id("user-name");
    By Password = By.id("password");
    By LoginButton = By.id("login-button");
    By ErrorMessage = By.xpath("//h3[@data-test='error']");

    public void enterUsername(String username) {
        driver.findElement(Username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(Password).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return driver.findElement(ErrorMessage).getText();
    }
    public WebElement getLoginButtonElement(){
        return driver.findElement(LoginButton);
    }
}
