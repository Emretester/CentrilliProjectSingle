package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesOdometerPage {

    public VehiclesOdometerPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//li[@id='menu_more_container']/a[@class='dropdown-toggle']")
    public WebElement moreButton;

    @FindBy(xpath = "//a[@data-menu='134']")
    public WebElement fleetButton;

    @FindBy(xpath = "//a[@data-menu='140']")
    public WebElement vehiclesOdometerButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "//div[@class='o_form_sheet']")
    public WebElement newVehiclesOdometerForm;


    @FindBy(xpath = "//ol[@class='breadcrumb']/li[@class='active']")
    public WebElement newText;

    @FindBy(xpath = "//input[@class='o_input ui-autocomplete-input']")
    public WebElement vehicleSelectDropdown;

    @FindBy(xpath = "//input[@class='o_field_float o_field_number o_field_widget o_input oe_inline']")
    public WebElement odometerValueInputBox;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm o_form_button_cancel']")
    public WebElement discardButton;

    @FindBy(xpath = "//button[contains(text(),'Attachment(s)')]")
    public WebElement attachmentButton;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "//li[@class='o-selection-focus']/a/em")
    public WebElement searchOdometerValue;

    @FindBy(xpath = "//td[@class='o_list_number']")
    public WebElement listedOdometerValue;

    @FindBy(xpath = "//button[@data-original-title='Kanban']")
    public WebElement kanbanButton;

    @FindBy(xpath = "//button[@data-original-title='List']")
    public WebElement listButton;

    @FindBy(xpath = "//button[@data-original-title='Graph']")
    public WebElement graphButton;

    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement odometerNumber;

    @FindBy(xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement vehicleClearButton;


}