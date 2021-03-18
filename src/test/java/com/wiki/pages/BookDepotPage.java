package com.wiki.pages;

import com.wiki.utilities.BrowserUtils;
import com.wiki.utilities.ConfigurationReader;
import com.wiki.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class BookDepotPage {

    public BookDepotPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='cookieBannerClose']")
    public WebElement cookiesAgreeButton;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement bookDropdown;

    @FindBy(xpath = "(//a[@class='dropdown-header'])[1]")
    public WebElement browseAllBooks;

//    @FindBy(xpath = "//div[@class='pull-right fa fa-chevron-down']")
//    public WebElement quantityModule;

    // (//input[@value='25'])[3]
    @FindBy(xpath = "(//div/div/label/input[@value='25'])[3]")
    public WebElement quantity25CheckBox;

    @FindBy(xpath = "(//button[@class='btn btn-default btn-sm pull-right'])[11]")
    public WebElement quantityApplyButton;

    @FindBy(xpath = "(//input[@value='52'])[4]")
    public WebElement paperbackCheckBox;

    @FindBy(xpath = "(//input[@value='66'])[4]")
    public WebElement softCoverCheckBox;

    @FindBy(xpath = "(//button[@class='btn btn-default btn-sm pull-right'])[13]")
    public WebElement formatCheckBox;

    @FindBy(xpath = "//div[@class='caption']//h2//a")
    public List<WebElement> allInformation;

    @FindBy(xpath = "//input[@class='search-bar']")
    public WebElement searchBox;


    public void landingPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("bookDepotUrl"));
        BrowserUtils.sleep(1);
    }

}
