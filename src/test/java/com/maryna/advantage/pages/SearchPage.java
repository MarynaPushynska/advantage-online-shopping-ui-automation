package com.maryna.advantage.pages;

import com.maryna.advantage.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    public SearchPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (xpath = "(//a[contains(@class, 'productName ng-binding')])[1]")
    public WebElement firstProduct;


    @FindBy (xpath = "//a[@class='select ng-binding']")
    public WebElement productTitle;


    @FindBy (xpath = "(//a[contains(@class, 'productName ng-binding')])[1]")
    public WebElement speakerName;

    @FindBy (xpath = "//span[@class='rabbit productColor ng-scope WHITE']")
    public WebElement whiteButton;

    @FindBy (xpath = "//button[@name='save_to_cart']")
    public WebElement addToCartButton;

    @FindBy (xpath = "//span[@class='ng-binding']")
    public WebElement selectedColorElement;


    public void openFirstProduct() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }

    public String getSelectedColor() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(selectedColorElement));
        return selectedColorElement.getText().trim();
    }


}
