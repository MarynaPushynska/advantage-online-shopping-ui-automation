package com.maryna.advantage.pages;

import com.maryna.advantage.utilities.BrowserUtils;
import com.maryna.advantage.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//*[@id=\"menuCart\"]")
    public WebElement goToCart;

    @FindBy (xpath = "//button[@id='checkOutButton']")
    public WebElement checkoutButton;

    @FindBy (xpath = "//div[@id='detailslink']")
    public WebElement shippingDetails;

    @FindBy (xpath = "//div[@class='noUserSection']")
    public WebElement noUserSection;

    @FindBy (xpath = "//div[@id='shoppingCart']")
    public WebElement cartProducts;


    public boolean quantityIsOne(int quantity) {
        return quantity == 1;
    }


    public boolean cartContainsProduct (String product) {
        BrowserUtils.waitForVisibility(cartProducts, 5);
        String cartProductsText = cartProducts.getText();
        return cartProductsText.contains(product);
    }



}
