package com.wiki.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },                                                          // I created plugin for parallel testing
        features = "src/test/resources/feature",                   // I created feature path way from feature file
        glue = "com/wiki/step_defs",                   // I created glue path way from stepDefinitions
        dryRun = false,
        tags = "@book"
)

public class CukesRunner {


}
