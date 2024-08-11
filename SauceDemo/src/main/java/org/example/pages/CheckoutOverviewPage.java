package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage{

    private static final String boughtItemNameCSSLocator = "[data-test='inventory-item-name']";
    private static final String boughtItemPriceCSSLocator = "[data-test='inventory-item-price']";
    private static final String boughtItemQuantityCSSLocator = "[data-test='item-quantity']";
    private static final String boughtItemSubtotalCSSLocator = "[data-test='subtotal-label']";
    private static final String finishPurchaseButtonCSSLocator = "[data-test='finish']";

    @FindBy(css = boughtItemNameCSSLocator)
    private WebElement boughtItemName;

    @FindBy(css = boughtItemPriceCSSLocator)
    private WebElement boughtItemPrice;

    @FindBy(css = boughtItemQuantityCSSLocator)
    private WebElement boughtItemQuantity;

    @FindBy(css = boughtItemSubtotalCSSLocator)
    private WebElement boughtItemSubtotal;

    @FindBy(css = finishPurchaseButtonCSSLocator)
    private WebElement finishPurchaseButton;



    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getBoughtItemName(WebElement boughtItemName){
        return boughtItemName.getText();
    }

    public String getBoughtItemPrice(WebElement boughtItemPrice){
        return boughtItemPrice.getText();
    }

    public String getBoughtItemQuantity(WebElement boughtItemQuantity){
        return boughtItemQuantity.getText();
    }

    public String getBoughtItemSubtotal(WebElement boughtItemSubtotal){
        return boughtItemSubtotal.getText();
    }

    public void clickOnFinishPurchaseButton(){
        finishPurchaseButton.click();
    }









}
