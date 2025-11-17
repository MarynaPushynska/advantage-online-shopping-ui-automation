package com.maryna.advantage.step_definitions;

import com.maryna.advantage.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @When("I set quantity {int}")
    public void i_set_quantity(Integer int1) {

        Assert.assertTrue(cartPage.quantityIsOne(int1));

    }



    @Then("{string} should be present in cart")
    public void shouldBePresentInCart(String arg0) {

        Assert.assertTrue(cartPage.cartContainsProduct(arg0));

    }
}
