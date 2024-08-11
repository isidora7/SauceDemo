package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage{

    private static final String myCartCSSLocator = "[data-test='shopping-cart-link']";
    private static final String addToCartButtonCSSLocator = "button.btn_primary";
    private static final String burgerMenuButtonCSSLocator = "#react-burger-menu-btn";
    private static final String logoutSidebarLinkCSSLocator = "[data-test='logout-sidebar-link']";
    private static final String resetAppStateSidebarLinkCSSLocator = "[data-test='reset-sidebar-link']";
    private static final String twitterLinkCSSLocator = "[data-test='social-twitter']";
    private static final String facebookLinkCSSLocator = "[data-test='social-facebook']";
    private static final String linkedinLinkCSSLocator = "[data-test='social-linkedin']";
    private static final String closeBurgerMenuButtonCSSLocator = "#react-burger-cross-btn";


    @FindBy(css = myCartCSSLocator)
    private WebElement myCart;

    @FindBy(css = addToCartButtonCSSLocator)
    private WebElement addToCartButton;

    @FindBy(css = burgerMenuButtonCSSLocator)
    private WebElement burgerMenuButton;

    @FindBy(css = logoutSidebarLinkCSSLocator)
    private WebElement logoutSidebarLink;

    @FindBy(css = resetAppStateSidebarLinkCSSLocator)
    private WebElement resetAppStateSidebarLink;

    @FindBy(css = twitterLinkCSSLocator)
    private WebElement twitterLink;

    @FindBy(css = facebookLinkCSSLocator)
    private WebElement facebookLink;

    @FindBy(css = linkedinLinkCSSLocator)
    private WebElement linkedinLink;

    @FindBy(css = closeBurgerMenuButtonCSSLocator)
    private WebElement closeBurgerMenuButton;



    public ProductsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public void clickOnBurgerMenu(){
        burgerMenuButton.click();
    }

    public void closeBurgerMenu(){
        closeBurgerMenuButton.click();
    }

    public void clickOnMyCart(){
        myCart.click();
    }

    public void clickOnLogout(){
        logoutSidebarLink.click();
    }

    public void clickOnResetAppState(){
        resetAppStateSidebarLink.click();
    }

    public void clickOnFacebookLink(){
        facebookLink.click();
    }

    public void clickOnTwitterLink(){
        twitterLink.click();
    }

    public void clickOnLinkedinLink(){
        linkedinLink.click();
    }










}
