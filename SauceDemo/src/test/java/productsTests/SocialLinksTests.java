package productsTests;

import loginTests.BaseTests;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SocialLinksTests extends BaseTests {

    @Test
    public void twitterLinkSuccessfulRedirection() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnTwitterLink();

        String originalWindow = driver.getWindowHandle();


        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("x.com/saucelabs"), "The URL should contain 'x.com/saucelabs'");
        driver.switchTo().window(originalWindow);




    }

    @Test
    public void facebookLinkSuccessfulRedirection(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnFacebookLink();

        String originalWindow = driver.getWindowHandle();


        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("https://www.facebook.com/saucelabs"), "The URL should contain 'https://www.facebook.com/saucelabs'");
        driver.switchTo().window(originalWindow);



    }

    @Test
    public void linkedinLinkSuccessfulRedirection(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnLinkedinLink();

        String originalWindow = driver.getWindowHandle();


        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("https://www.linkedin.com/"), "The URL should contain 'https://www.linkedin.com/'");
        driver.switchTo().window(originalWindow);



    }


}
