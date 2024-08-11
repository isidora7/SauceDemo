package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage{

    private static final String thankYouMessageCSSLocator = "[data-test='complete-header']";
    private static final String completedOrderMessageCSSLocator = "[data-test='complete-text']";
    private static final String backHomeButtonCSSLocator = "[data-test='back-to-products']";

    @FindBy(css = thankYouMessageCSSLocator)
    private WebElement thankYouMessage;

    @FindBy(css = completedOrderMessageCSSLocator)
    private WebElement completedOrderMessage;

    @FindBy(css = backHomeButtonCSSLocator)
    private WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getThankYouMessage(){
        return thankYouMessage.getText();
    }

    public String getCompletedOrderMessage(){
        return completedOrderMessage.getText();
    }

    public void clickOnBackHomeButton(){
        backHomeButton.click();
    }

    public void waitForThankYouMessage(String message) {
        wait.until(ExpectedConditions.textToBePresentInElement(thankYouMessage, message));
    }

    public void waitForCompletedOrderMessage(String text){
        wait.until(ExpectedConditions.textToBePresentInElement(completedOrderMessage,text));
    }

}
