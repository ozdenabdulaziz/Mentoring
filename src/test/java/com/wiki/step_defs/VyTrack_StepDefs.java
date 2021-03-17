package com.wiki.step_defs;

import com.wiki.pages.VyTrackPage;
import com.wiki.utilities.ConfigurationReader;
import com.wiki.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VyTrack_StepDefs {

    VyTrackPage loginPage = new VyTrackPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver().get(URL);
    }


    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.printf("Login with user name %s and %s password\n", string, string2);
        loginPage.login(string , string2);
    }
    @Then("user name should be {string}")
    public void user_name_should_be(String name) {
        String name2 = name;
        Assert.assertEquals(name, name2);
    }


}
