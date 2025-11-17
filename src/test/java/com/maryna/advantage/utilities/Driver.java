package com.maryna.advantage.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object

    private Driver() {}

    //We make WebDriver private, because we want to close access from outside the class
    //We make it static because we want to use it in the static method

    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    //Create re-usable utility method which will return the same driver instance once we call it
    //If an instance does not exist, it will create at first and then will return the same one
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            //We will read our browser type from our conf prop. file
            //This way we can control which browser is opened from outside our code
            String broswerType = ConfigurationReader.getProperty("browser");

            //depending on the browser type return from conf.prop. file switch statement
            // will determine the case and open the matching browser
            switch (broswerType) {
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return driverPool.get();
    }

    public static void closeDriver() {

        if (driverPool.get() != null) {
            //this line will terminate the currently existing driver completely. It will not exist going forward.
            driverPool.get().quit();
            //we assign the value back to null, so my "singleton" can create the newer one if needed
            driverPool.remove();
        }

    }


}
