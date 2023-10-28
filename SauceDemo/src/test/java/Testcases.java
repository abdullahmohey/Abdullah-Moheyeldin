import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcases extends TestBase {
    LoginPage loginPage;
    Homepage homepage;
    CartPage cartPage;
    InfoPage infoPage;
    ConfirmationPage confirmationPage;
    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(driver);
        homepage = new Homepage(driver);
        cartPage = new CartPage(driver);
        infoPage = new InfoPage(driver);
        confirmationPage = new ConfirmationPage(driver);
    }
    @Test
    public void TC1_orderBoltShirt(){
        loginPage.login("standard_user", "secret_sauce");
        homepage.orderBoltShirt();
        cartPage.clickCheckout();
        infoPage.enterInfo("Abdullah","Moheyeldin","11111");
        infoPage.clickContinue();
        Assert.assertTrue(confirmationPage.returnSubtotal().contains("15.99"));
        confirmationPage.clickFinish();
    }
    @Test
    public void TC2_lockedOutUser(){
        loginPage.login("locked_out_user","secret_sauce");
        Assert.assertEquals(infoPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    public void TC3_verifyMandatoryFields() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        homepage.orderBoltShirt();
        cartPage.clickCheckout();
        infoPage.clickContinue();
        Assert.assertEquals(infoPage.getErrorMessage(),"Error: First Name is required");
        infoPage.enterFirstName("Abdullah");
        infoPage.clickContinue();
        Assert.assertEquals(infoPage.getErrorMessage(),"Error: Last Name is required");
        infoPage.enterLastName("Moheyeldin");
        infoPage.clickContinue();
        Assert.assertEquals(infoPage.getErrorMessage(),"Error: Postal Code is required");
    }
    @Test
    public void TC4_orderHighestPricePerformanceGlitchUser(){
        loginPage.login("performance_glitch_user", "secret_sauce");
        homepage.setSortBy("Price (high to low)");
        homepage.orderFirstItem();
        cartPage.clickCheckout();
        infoPage.enterInfo("Abdullah","Moheyeldin","11111");
        infoPage.clickContinue();
        Assert.assertTrue(confirmationPage.returnSubtotal().contains("49.99"));
        confirmationPage.clickFinish();
    }
    @Test
    public void TC5_orderLowestPriceVisualUser(){
        loginPage.login("visual_user","secret_sauce");
        homepage.setSortBy("Price (low to high)");
        homepage.orderFirstItem();
        cartPage.clickCheckout();
        infoPage.enterInfo("Abdullah","Moheyeldin","11111");
        infoPage.clickContinue();
        Assert.assertTrue(confirmationPage.returnSubtotal().contains("7.99"));
        confirmationPage.clickFinish();
    }
    @Test
    public void TC6_loginWithoutUsername(){
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }
    @Test
    public void TC7_loginWithoutPassword(){
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
    }
    @Test
    public void TC8_RemoveItemThenOrderAllItems(){
        loginPage.login("standard_user", "secret_sauce");
        homepage.orderBoltShirt();
        cartPage.clickRemoveItem();
        cartPage.clickContinueShopping();
        homepage.orderAllItems();
        cartPage.clickCheckout();
        infoPage.enterInfo("Abdullah","Moheyeldin","11111");
        infoPage.clickContinue();
        Assert.assertTrue(confirmationPage.returnSubtotal().contains("129.94"));
        confirmationPage.clickFinish();
    }
    @Test
    public void TC9_logout(){
        loginPage.login("standard_user", "secret_sauce");
        homepage.logout();
        Assert.assertTrue(loginPage.getLoginButtonElement().isDisplayed());
    }
}
