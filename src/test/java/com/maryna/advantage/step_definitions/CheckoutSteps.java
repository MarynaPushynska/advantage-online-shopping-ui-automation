package com.maryna.advantage.step_definitions;

import com.maryna.advantage.pages.CartPage;
import com.maryna.advantage.pages.HomePage;
import com.maryna.advantage.pages.SearchPage;
import com.maryna.advantage.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class CheckoutSteps {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();


    @Given("I search for {string}")
    public void i_search_for(String string) {

        homePage.searchField.sendKeys(string + Keys.ENTER);
        BrowserUtils.sleep(5);

    }


    @And("I open the first product of the list")
    public void iOpenTheFirstProductOfTheList() {

        searchPage.firstProduct.click();
        BrowserUtils.sleep(5);

    }


    @Given("I add product to cart")
    public void i_add_product_to_cart() {

        searchPage.addToCartButton.click();

    }
    @When("I open cart")
    public void i_open_cart() {

        cartPage.goToCart.click();

    }
    @When("I start checkout")
    public void i_start_checkout() {

        BrowserUtils.waitForClickability(cartPage.checkoutButton, 10).click();

    }
    @Then("shipping address step should be shown")
    public void shipping_address_step_should_be_shown() {

        Assert.assertTrue(cartPage.shippingDetails.isDisplayed());


    }

    @Then("I should be asked to sign in or register")
    public void iShouldBeAskedToSignInOrRegister() {

        Assert.assertTrue(cartPage.noUserSection.isDisplayed());

    }


}
