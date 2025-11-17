package com.maryna.advantage.step_definitions;

import com.maryna.advantage.utilities.BrowserUtils;
import com.maryna.advantage.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupMethod(){
        System.out.println("---> @BEFORE: RUNNING BEFORE EACH SCENARIO");

    }

    @After
    public void tearDownMethod(Scenario scenario){

        if(scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());

        }



        // System.out.println("---> @AFTER: RUNNING AFTER EACH SCENARIO");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }


}
