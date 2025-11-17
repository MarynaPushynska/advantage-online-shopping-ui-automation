package com.maryna.advantage.step_definitions;

import com.maryna.advantage.pages.HomePage;
import com.maryna.advantage.utilities.BrowserUtils;
import com.maryna.advantage.utilities.ConfigurationReader;
import com.maryna.advantage.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    HomePage homePage = new HomePage();

    @Given("I open the AOS application")
    public void i_open_the_aos_application() {

        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));



    }
    @When("I open login popup")
    public void i_open_login_popup() {

        homePage.menuUserLink.click();


    }
    @When("I login as {string} with password {string}")
    public void i_login_as_with_password(String string, String string2) {

        homePage.userNameLogin.sendKeys(string);
        homePage.passwordLogin.sendKeys(string2);
        homePage.signInButton.click();

    }
    @Then("I should see {string} in header")
    public void i_should_see_in_header(String string) {

        String actual = homePage.headerUserText();
        Assert.assertTrue(actual.contains(string));

    }


    @And("I login as {string} with wrong password {string}")
    public void iLoginAsWithWrongPassword(String arg0, String arg1) {
        homePage.userNameLogin.sendKeys(arg0);
        homePage.passwordLogin.sendKeys(arg1);
        homePage.signInButton.click();
    }

    @Then("I should see login error message")
    public void iShouldSeeLoginErrorMessage() {

        Assert.assertTrue(homePage.wrongPasswordMessage.isDisplayed());

    }

    @When("I logout")
    public void iLogout() {

        BrowserUtils.waitForLoaderToDisappear(15);
        BrowserUtils.safeClick(homePage.signInMenuUser,10);

        BrowserUtils.waitForLoaderToDisappear(15);
        BrowserUtils.safeClick(homePage.signOutButton,10);

        BrowserUtils.waitForLoaderToDisappear(15);
        BrowserUtils.sleep(5);

    }

    @Then("I should not see user name in header")
    public void iShouldNotSeeUserNameInHeader() {

        boolean gone = BrowserUtils.waitForInvisibility(homePage.headerUser,10);
        Assert.assertTrue(gone);

    }
}
