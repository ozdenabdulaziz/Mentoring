package com.wiki.step_defs;

import com.wiki.pages.EtsySearchPage;
import com.wiki.utilities.ConfigurationReader;
import com.wiki.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EtsyStepDefs {


    EtsySearchPage etsySearchPage = new EtsySearchPage();

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;


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


    @Then("user should listed all davul option in excel file")
    public void user_should_listed_all_davul_option_in_excel_file() throws IOException {   // I added IOException here for the accept al abject methods

        System.out.println(etsySearchPage.list.getSize());

        String path = "EtsyDavulSheet.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");                                        //  Sheet1 is come from excel file

        for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
            row = sheet.getRow(rowNum);
            if (row.getCell(0) == null) {
                row.createCell(0);
            }

            row.getCell(1).setCellValue(etsySearchPage.list.getText());

        }

        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy:MM:dd:hh:mm:ss a");
        sheet.getRow(1).getCell(1).setCellValue(LocalDateTime.now().format(DTF));
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }
}
