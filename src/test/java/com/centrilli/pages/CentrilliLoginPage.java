package com.centrilli.pages;

import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CentrilliLoginPage {

    public CentrilliLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    public void loginWithConfig() {
        inputEmail.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("web.table.password"));
        loginButton.click();
    }

}
