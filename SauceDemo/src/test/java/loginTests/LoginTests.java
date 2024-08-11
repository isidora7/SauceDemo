package loginTests;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTests extends BaseTests{

  @Test
    public void successfulLoginValidCredentials() throws InterruptedException {
      LoginPage loginPage = new LoginPage(driver);
      loginPage.enterUsername("standard_user");
      loginPage.enterPassword("secret_sauce");
      loginPage.clickLoginButton();

      String expectedUrl = "https://www.saucedemo.com/inventory.html";
      String actualUrl = driver.getCurrentUrl();
      Assertions.assertEquals(expectedUrl, actualUrl);



  }
  @Test
   public void unsuccessfulLoginMissingUsername(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLoginButton();

      String expectedErrorMessage = "Epic sadface: Username is required";
      loginPage.waitForErrorMessageToContain(expectedErrorMessage);

      Assertions.assertEquals(expectedErrorMessage, loginPage.getErrorMessage());


  }

  @Test
  public void unsuccessfulLoginMissingPassword(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsername("standard_user");
    loginPage.clickLoginButton();

      String expectedErrorMessage = "Epic sadface: Password is required";
      loginPage.waitForErrorMessageToContain(expectedErrorMessage);

      Assertions.assertEquals(expectedErrorMessage, loginPage.getErrorMessage());


  }





}
