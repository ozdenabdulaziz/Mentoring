package com.wiki.pages;

import com.wiki.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearchPage {

    public EtsySearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='wt-grid wt-grid--block wt-pl-xs-0 tab-reorder-container']")
    public WebElement list;

}
