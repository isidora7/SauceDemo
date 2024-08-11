package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String usernameInputCSSLocator = "[data-test='username']";
    private static final String passwordInputCSSLocator = "[data-test='password']";
    private static final String loginButtonInputCSSLocator = "[data-test='login-button']";
    private static final String errorMessageLabelCSSLocator = "[data-test='error']";

    @FindBy(css = usernameInputCSSLocator)
    private WebElement usernameInput;

    @FindBy(css = passwordInputCSSLocator)
    private WebElement passwordInput;

    @FindBy(css = loginButtonInputCSSLocator)
    private WebElement loginButton;

    @FindBy(css = errorMessageLabelCSSLocator)
    private WebElement errorMessageLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        enterText(usernameInput, username);

    }

    public void enterPassword(String password){
        enterText(passwordInput, password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessageLabel.getText();
    }

    public void waitForErrorMessageToContain(String err) {
        wait.until(ExpectedConditions.textToBePresentInElement(errorMessageLabel, err));
    }






}
