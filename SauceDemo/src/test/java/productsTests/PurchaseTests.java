package productsTests;

import com.github.javafaker.Faker;
import loginTests.BaseTests;
import org.example.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PurchaseTests extends BaseTests {

    @Test
    public void successfulPurchaseTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();


        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnAddToCartButton();
        productsPage.clickOnMyCart();

        YourCartPage yourCart = new YourCartPage(driver);
        yourCart.clickOnCheckoutButton();

        CheckoutYourInformationPage checkoutYourInformation = new CheckoutYourInformationPage(driver);
        Faker faker = new Faker();
        checkoutYourInformation.enterFirstName(faker.name().firstName());
        checkoutYourInformation.enterLastName(faker.name().lastName());
        checkoutYourInformation.enterZipPostalCode(faker.address().zipCode());
        checkoutYourInformation.clickOnContinueButton();

        CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
        checkoutOverview.clickOnFinishPurchaseButton();

        CheckoutCompletePage checkoutComplete = new CheckoutCompletePage(driver);
        checkoutComplete.getThankYouMessage();
        checkoutComplete.getCompletedOrderMessage();

        Assertions.assertEquals("Thank you for your order!",checkoutComplete.getThankYouMessage() );
        Assertions.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkoutComplete.getCompletedOrderMessage() );

        checkoutComplete.waitForThankYouMessage("Thank you for your order!");
        checkoutComplete.waitForCompletedOrderMessage("Your order has been dispatched, and will arrive just as fast as the pony can get there!");


        //checkoutComplete.clickOnBackHomeButton();





    }

    @Test
    public void removeProductFromMyCartTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();


        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnAddToCartButton();
        productsPage.clickOnAddToCartButton();
        productsPage.clickOnAddToCartButton();
        productsPage.clickOnMyCart();

        YourCartPage yourCart = new YourCartPage(driver);
        yourCart.waitForElementsToBeVisible(By.cssSelector("[data-test='checkout']"));
        String itemToRemove = yourCart.getNameOfItemInCart();

        System.out.println("I want to remove this product - " + itemToRemove);

        Assertions.assertTrue(driver.getPageSource().contains(itemToRemove), "Couldn't find the text");

        yourCart.clickOnRemoveFromCartButton();
        Assertions.assertFalse(driver.getPageSource().contains(itemToRemove), "Found the text");

        String firstItemLeftInCart = yourCart.getNameOfItemInCart();
        System.out.println("This is the first product in the cart after I removed one - " + firstItemLeftInCart);

        Assertions.assertNotSame(itemToRemove, firstItemLeftInCart, "The item to remove and the item that's left in the cart are the same");
        Assertions.assertFalse(driver.getPageSource().contains(itemToRemove), "Found the text that shouldn't be there");

    }

}
