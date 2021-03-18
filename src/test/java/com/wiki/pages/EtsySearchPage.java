package com.wiki.pages;

import com.wiki.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsySearchPage {

    public EtsySearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy(xpath = "(//h3[@class='wt-text-truncate wt-mb-xs-0 wt-text-caption '])")
    public List<WebElement> list;
}
