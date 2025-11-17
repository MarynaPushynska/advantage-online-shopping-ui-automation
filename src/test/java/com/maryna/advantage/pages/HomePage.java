package com.maryna.advantage.pages;

import com.maryna.advantage.utilities.BrowserUtils;
import com.maryna.advantage.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@id='menuUserLink']")
    public WebElement menuUserLink;

    @FindBy (xpath = "//a[@id='hrefUserIcon']")
    public WebElement signInMenuUser;


    @FindBy (xpath = "/html/body/login-modal/div/div/div[3]/a[2]")
    public WebElement createNewAccountForm;

    @FindBy (xpath = "//input[@name='usernameRegisterPage']")
    public WebElement userNameField;

    @FindBy (xpath = "//input[@name='first_nameRegisterPage']")
    public WebElement firstNameField;

    @FindBy (xpath = "//input[@name='last_nameRegisterPage']")
    public WebElement lastNameField;

    @FindBy (xpath = " //input[@name='emailRegisterPage']")
    public WebElement emailField;

    @FindBy (xpath = "//input[@name='passwordRegisterPage'] ")
    public WebElement passwordField;

    @FindBy (xpath = " //input[@name='confirm_passwordRegisterPage']")
    public WebElement confirmPasswordField;

    @FindBy (xpath = " //input[@name='i_agree']")
    public WebElement checkAgreeButton;

    @FindBy (xpath = "//button[@id='register_btn']")
    public WebElement registerButton;

    @FindBy (xpath = "//span[@class='hi-user containMiniTitle ng-binding']")
    public WebElement headerUser;

    @FindBy (xpath = "//input[@name='username']")
    public WebElement userNameLogin;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordLogin;

    @FindBy (xpath = "//button[@id='sign_in_btn']")
    public WebElement signInButton;

    @FindBy (xpath = "//label[@id='signInResultMessage']")
    public WebElement wrongPasswordMessage;

    @FindBy (xpath = "//*[@id=\"loginMiniTitle\"]/label[3]")
    public WebElement signOutButton;

    @FindBy (xpath = "//*[@id=\"loginMiniTitle\"]/label[1]")
    public WebElement myAccountButton;

    @FindBy (xpath = "//*[@id='search']//input")
    public WebElement searchField;

    public String headerUserText() {
        BrowserUtils.sleep(10);
        return headerUser.getText().trim();
    }

}
