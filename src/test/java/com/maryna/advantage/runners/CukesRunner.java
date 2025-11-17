package com.maryna.advantage.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber_reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/feature",
        glue = "com/maryna/advantage/step_definitions",
        dryRun = false,
        tags = "@smoke",
        publish = true


)

public class CukesRunner {
}
