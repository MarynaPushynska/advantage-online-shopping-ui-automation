package com.maryna.advantage.step_definitions;

import com.maryna.advantage.pages.HomePage;
import com.maryna.advantage.pages.MyAccountPage;
import com.maryna.advantage.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProfileSteps {

    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Given("I open {string} page")
    public void i_open_page(String string) {


        BrowserUtils.waitForLoaderToDisappear(15);
        BrowserUtils.safeClick(homePage.signInMenuUser,10);

        BrowserUtils.waitForLoaderToDisappear(15);
        BrowserUtils.safeClick(homePage.myAccountButton, 10);

        BrowserUtils.sleep(2);



    }
    @When("I update my first name as {string}")
    public void i_update_my_first_name_as(String string) {

        myAccountPage.editNameButton.click();
        myAccountPage.clearFirstNameField();
        myAccountPage.firstNameField.sendKeys(string);


    }
    @When("I update my last name as {string}")
    public void i_update_my_last_name_as(String string) {

        myAccountPage.clearLastNameField();
        myAccountPage.lastNameField.sendKeys(string);

    }
    @When("I save profile")
    public void i_save_profile() {

        myAccountPage.saveButton.click();

    }



    @Then("I should see at Account Details field {string}")
    public void iShouldSeeAtAccountDetailsField(String arg0) {


        String actualDetails = myAccountPage.myAccountDetails.getText().trim();
        Assert.assertEquals(arg0, actualDetails);


    }
}
