package com.maryna.advantage.step_definitions;

import com.maryna.advantage.pages.HomePage;
import com.maryna.advantage.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class RegisterSteps {

    HomePage homePage = new HomePage();


    @Given("I open new login popup")
    public void i_open_new_login_popup() {

        homePage.menuUserLink.click();

    }
    @Given("I navigate to {string} form")
    public void i_navigate_to_form(String string) {

        homePage.createNewAccountForm.click();


    }


    @And("pass my username as {string}")
    public void passMyUsernameAs(String arg0) {

        homePage.userNameField.sendKeys(arg0);
        BrowserUtils.sleep(2);

    }

    @And("pass my email as {string}")
    public void passMyEmailAs(String arg0) {

        homePage.emailField.sendKeys(arg0);
        BrowserUtils.sleep(2);

    }

    @And("pass my password as {string}")
    public void passMyPasswordAs(String arg0) {

        homePage.passwordField.sendKeys(arg0);
        BrowserUtils.sleep(2);
    }

    @And("confirm my password passing {string}")
    public void confirmMyPasswordPassing(String arg0) {

        homePage.confirmPasswordField.sendKeys(arg0);
        BrowserUtils.sleep(2);
    }

    @And("write my first name as {string}")
    public void writeMyFirstNameAs(String arg0) {

        homePage.firstNameField.sendKeys(arg0);
        BrowserUtils.sleep(2);

    }

    @And("write my last name as {string}")
    public void writeMyLastNameAs(String arg0) {

        homePage.lastNameField.sendKeys(arg0);
        BrowserUtils.sleep(2);
    }



    @And("check agree box")
    public void checkAgreeBox() {

        BrowserUtils.waitForClickability(homePage.checkAgreeButton, 10);
        homePage.checkAgreeButton.click();

        BrowserUtils.sleep(2);

    }

    @Then("I should see {string} in my header")
    public void i_should_see_in_my_header(String string) {


        String actual = homePage.headerUserText();
        Assert.assertTrue(actual.contains(string));


    }


}


