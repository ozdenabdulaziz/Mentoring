package com.wiki.pages;

import com.wiki.utilities.BrowserUtils;
import com.wiki.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VyTrackPage {

    public VyTrackPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText() {
        return warningMessage.getText();
    }



    /**
     * this method stands for login based on user type
     * For example: if parameter is equals to driver, user will login as a driver
     * If role parameter is not correct, method will throw exception
     * @param userName
     * @param role - driver, sales manager or store manager
     */
    public void login(String userName, String role){
        //String userName1 = "";
        if (role.equalsIgnoreCase("driver")){
            userName = "user15";
        }else if (role.equalsIgnoreCase("sales manager")){
            userName = "salesmanager110";
        }else if (role.equalsIgnoreCase("store manager")){
            userName = "storemanager85";
        }else {
            throw new RuntimeException("Invalid role!");
        }
        System.out.println("Login as "+role);
        login(userName, "UserUser123");
    }

}
