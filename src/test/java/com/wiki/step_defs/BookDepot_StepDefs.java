package com.wiki.step_defs;

import com.wiki.pages.BookDepotPage;
import com.wiki.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class BookDepot_StepDefs extends BookDepotPage {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;


    @Given("user should go to book depot landing page")
    public void user_should_go_to_book_depot_landing_page() {
        landingPage();
        cookiesAgreeButton.click();
    }

    @When("user should able to click on browse module")
    public void user_should_able_to_click_on_browse_module() {
        bookDropdown.click();
        BrowserUtils.sleep(1);
    }

    @When("user should able to click on browse all books section")
    public void user_should_able_to_click_on_browse_all_books_section() {
        browseAllBooks.click();
        BrowserUtils.sleep(1);

    }

    @When("user should to choose {int}+ quantity and click to apply button")
    public void user_should_to_choose_quantity_and_click_to_apply_button(Integer int1) {
        quantity25CheckBox.click();
        quantityApplyButton.click();
        BrowserUtils.sleep(1);

    }

    @When("user should to choose softCover and PaperBack format and click to apply button")
    public void user_should_to_choose_soft_cover_and_paper_back_format_and_click_to_apply_button() {
        paperbackCheckBox.click();
        softCoverCheckBox.click();
        formatCheckBox.click();
        BrowserUtils.sleep(1);

    }

    @Then("user should getting all information about books and cell on the xml file")
    public void user_should_getting_all_information_about_books_and_cell_on_the_xml_file() throws IOException {

        String path = "BookDepotSheet.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            row = sheet.getRow(1);
            if (row.getCell(1) == null) {
                row.createCell(1);
            }

            row.getCell(0).setCellValue(allInformation.getText());
        }

        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy:MM:dd:hh:mm:ss a");
        sheet.getRow(2).getCell(2).setCellValue(LocalDate.now().format(DTF));
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

        System.out.println(allInformation.getSize());



    }
}
