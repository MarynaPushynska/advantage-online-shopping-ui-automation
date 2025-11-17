package com.maryna.advantage.step_definitions;

import com.maryna.advantage.pages.HomePage;
import com.maryna.advantage.pages.SearchPage;
import com.maryna.advantage.utilities.BrowserUtils;
import com.maryna.advantage.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchSteps {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    @When("I search for the {string}")
    public void i_search_for_the(String string) {

        homePage.searchField.sendKeys(string + Keys.ENTER);
        BrowserUtils.sleep(5);

    }


    @And("I open first product of the list")
    public void iOpenFirstProductOfTheList() {
        searchPage.openFirstProduct();
    }

    @Then("product page title should be displayed")
    public void productPageTitleShouldBeDisplayed() {

        Boolean actualTittle = searchPage.productTitle.isDisplayed();
        Assert.assertTrue(actualTittle);
    }


    @When("I search the {string}")
    public void iSearchThe(String arg0) {

        homePage.searchField.sendKeys(arg0+Keys.ENTER);

    }

    @And("I open product {string}")
    public void iOpenProduct(String arg0) {

        searchPage.speakerName.click();
        BrowserUtils.sleep(5);
    }

    @When("I choose color {string}")
    public void iChooseColor(String arg0) {

        searchPage.whiteButton.click();
        searchPage.addToCartButton.click();
    }

    @Then("selected color should be {string}")
    public void selectedColorShouldBe(String arg0) {

        Assert.assertEquals(arg0, searchPage.getSelectedColor());

    }

}
