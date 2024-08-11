package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage extends BasePage{

    private static final String firstNameInputCSSLocator = "[data-test='firstName']";
    private static final String lastNameInputCSSLocator = "[data-test='lastName']";
    private static final String zipPostalCodeInputCSSLocator = "[data-test='postalCode']";
    private static final String continueButtonCSSLocator = "[data-test='continue']";
    private static final String cancelButtonCSSLocator = "[data-test='cancel']";

    @FindBy(css = firstNameInputCSSLocator)
    private WebElement firstNameInput;

    @FindBy(css = lastNameInputCSSLocator)
    private WebElement lastNameInput;

    @FindBy(css = zipPostalCodeInputCSSLocator)
    private WebElement zipPostalCode;

    @FindBy(css = continueButtonCSSLocator)
    private WebElement continueButton;

    @FindBy(css = cancelButtonCSSLocator)
    private WebElement cancelButton;

    public CheckoutYourInformationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void enterFirstName(String name){
        enterText(firstNameInput, name);
    }

    public void enterLastName(String surname){
        enterText(lastNameInput, surname);
    }

    public void enterZipPostalCode(String zip){
        enterText(zipPostalCode, zip);

    }

}
