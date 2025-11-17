package com.maryna.advantage.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep method for given duration
     */

    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Driver URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }

        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    /*
  Name: verifyTitle()
  Return type: void
  Arg1: WebDriver
  Arg2: String expectedTitle

  1. Create a new method for title verification
  2. Create a method to make title verification logic re-usable
  3. When method is called, it should simply verify expected title with actual
title
     */

    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    public static void verifyTitleContains(String expectedTitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }

    public static List<String> dropdownOptionsAsAString (WebElement dropdownWebElement) {

        Select month = new Select(dropdownWebElement);
        List<WebElement> actualMonths_asWebElement = month.getOptions();

        List<String> actualMonths = new ArrayList<>();
        for (WebElement each : actualMonths_asWebElement) {
            actualMonths.add(each.getText());
        }
        return actualMonths;



    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }

    }

    public static WebElement waitForClickability(WebElement el, int sec) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sec)).until(ExpectedConditions.elementToBeClickable(el));
    }

    public static void scrollIntoView(WebElement el) {
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }

    public static void hover(WebElement el) {
        new Actions(Driver.getDriver()).moveToElement(el)
                .pause(Duration.ofMillis(200)).perform();
    }


    public static void safeClick(WebElement el, int seconds) {
        waitForLoaderToDisappear(seconds);
        try {
            waitForClickability(el, seconds).click();
        } catch (ElementClickInterceptedException e) {
            scrollIntoView(el);
            hover(el);
            try {
                el.click();
            } catch (ElementClickInterceptedException ex) {
                ((JavascriptExecutor) Driver.getDriver()).executeScript(
                        "if(arguments[0] instanceof HTMLElement) { arguments[0].click(); } " +
                                "else if(arguments[0].ownerSVGElement) { arguments[0].dispatchEvent(new MouseEvent('click', {bubbles:true})); }",
                        el);
            }
        }
    }

    public static void clearAndType(WebElement el, String text) {
        waitForClickability(el,10);
        el.clear();
        el.sendKeys(text);

    }

    public static WebElement waitForVisibility( WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean waitForLoaderToDisappear(int seconds) {
        By overlays = By.cssSelector(
                "div.Loader, div.loader, .loader, .Loader, .modal-backdrop, .overlay, .spinner, .blockUI"
        );

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        return wait.until(driver -> {
            List<WebElement> els = driver.findElements(overlays);
            // true тільки якщо або немає жодного, або всі НЕ відображаються
            for (WebElement el : els) {
                try {
                    if (el.isDisplayed()) return false;
                } catch (StaleElementReferenceException ignored) { /* оновився DOM — ок */ }
            }
            return true;
        });
    }


    public static boolean waitForInvisibility(WebElement element, int seconds) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.invisibilityOf(element));

    }



}
