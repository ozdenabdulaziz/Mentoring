package com.wiki.step_defs;

import com.wiki.pages.EtsySearchPage;
import com.wiki.utilities.BrowserUtils;
import com.wiki.utilities.ConfigurationReader;
import com.wiki.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EtsyStepDefs {


    EtsySearchPage etsySearchPage = new EtsySearchPage();

    XSSFWorkbook workbook1;
    XSSFSheet sheet1;
//    XSSFRow row;
//    XSSFCell cell;


    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String actual = Driver.getDriver().getTitle();
        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertTrue(actual.equals(expected));

    }

    @When("user searches for {string}")
    public void userSearchesFor(String arg0) {

        etsySearchPage.searchBox.sendKeys(arg0 + Keys.ENTER);

    }

    @Then("user should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String arg0) {

        String actual = Driver.getDriver().getTitle();
        String expected = arg0 + " | Etsy CA";

        Assert.assertEquals(actual, expected);
    }


    @When("user types {string} in the etsy search box")
    public void user_types_in_the_etsy_search_box(String string) {
        etsySearchPage.searchBox.sendKeys(string + Keys.ENTER);
    }


    @Then("user sees {string} is in the etsy title")
    public void user_sees_is_in_the_etsy_title(String string) {
        System.out.println(Driver.getDriver().getTitle());
        String actualTitle = Driver.getDriver().getTitle();
        String expected = string + " | Etsy CA";
    }


}
