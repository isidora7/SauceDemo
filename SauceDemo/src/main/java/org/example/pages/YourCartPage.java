package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BasePage{

    private static final String itemInCartNameCSSLocator = "[data-test='inventory-item-name']";
    private static final String priceOfItemInCartCSSLocator = "[data-test='inventory-item-price']";
    private static final String quantityOfAnItemInCartCSSLocator = "[data-test='item-quantity']";
    private static final String removeFromCartButtonCSSLocator = "button.btn_secondary";
    private static final String continueShoppingButtonCSSLocator = "[data-test='continue-shopping']";
    private static final String checkoutButtonCSSLocator = "[data-test='checkout']";

    @FindBy(css = itemInCartNameCSSLocator)
    private WebElement itemInCartName;

    @FindBy(css = priceOfItemInCartCSSLocator)
    private WebElement priceOfItemInCart;

    @FindBy(css = quantityOfAnItemInCartCSSLocator)
    private WebElement amountOfAnItemInCart;

    @FindBy(css = removeFromCartButtonCSSLocator)
    private WebElement removeFromCartButton;

    @FindBy(css = continueShoppingButtonCSSLocator)
    private WebElement continueShoppingButton;

    @FindBy(css = checkoutButtonCSSLocator)
    private WebElement checkoutButton;

    public YourCartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getNameOfItemInCart(){
        return itemInCartName.getText();
    }

    public String getPriceOfItemInCart(){
        return priceOfItemInCart.getText();
    }

    public String getQuantityOfItemInCart(){
        return amountOfAnItemInCart.getText();
    }
    public void clickOnRemoveFromCartButton(){
        removeFromCartButton.click();
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }


}
