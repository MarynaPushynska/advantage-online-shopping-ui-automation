package com.maryna.advantage.pages;

import com.maryna.advantage.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//a[@class='floatRigth ng-scope'])[1]")
    public WebElement editNameButton;

    @FindBy (xpath = "//input[@name='first_nameAccountDetails']")
    public WebElement firstNameField;

    @FindBy (xpath = "//input[@name='last_nameAccountDetails']")
    public WebElement lastNameField;

    @FindBy (xpath = "//button[@id='save_btn']")
    public WebElement saveButton;

    @FindBy (xpath = "(//label[@class='ng-binding'])[1]")
    public WebElement myAccountDetails;

    public void clearFirstNameField() {
        firstNameField.clear();
    }

    public void clearLastNameField() {
        lastNameField.clear();
    }

}
