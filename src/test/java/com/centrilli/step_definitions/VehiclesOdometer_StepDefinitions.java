package com.centrilli.step_definitions;

import com.centrilli.pages.CentrilliLoginPage;
import com.centrilli.pages.VehiclesOdometerPage;
import com.centrilli.utilities.BrowserUtils;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class VehiclesOdometer_StepDefinitions {

    CentrilliLoginPage centrilliLoginPage = new CentrilliLoginPage();
    VehiclesOdometerPage vehiclesOdometerPage = new VehiclesOdometerPage();

    int firstOdometerNumber;
    int secondOdometerNumber;

    @Given("user has logged in the web site")
    public void user_has_logged_in_the_web_site() {

        String url = ConfigurationReader.getProperty("web.table.url");
        Driver.getDriver().get(url);
        centrilliLoginPage.loginWithConfig();

    }


    @Then("user is on fleet page")
    public void user_is_on_fleet_page() {

        BrowserUtils.waitFor(5);
        if (vehiclesOdometerPage.moreButton.isDisplayed()) {
            vehiclesOdometerPage.moreButton.click();
            vehiclesOdometerPage.fleetButton.click();
        } else {
            vehiclesOdometerPage.fleetButton.click();
        }
    }

    @Then("user is on vehicles odometer page")
    public void user_is_on_vehicles_odometer_page() {
        vehiclesOdometerPage.vehiclesOdometerButton.click();
    }

    //1. Verify that user can create a Vehicle Odometer

    @When("user clicks create button")
    public void user_clicks_create_button() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.createButton.click();
    }

    @Then("user sees the new vehicles odometer form")
    public void user_sees_the_new_vehicles_odometer_form() {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(vehiclesOdometerPage.newVehiclesOdometerForm.isDisplayed());
    }

    // 2. Verify that user cannot create a Vehicle Odometer without selecting vehicle

    @When("user clicks save button without selecting vehicle")
    public void user_clicks_save_button_without_selecting_vehicle() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.saveButton.click();
    }

    @Then("new vehicle odometer is not created")
    public void new_vehicle_odometer_is_not_created() {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(vehiclesOdometerPage.saveButton.isDisplayed());
    }

    // 5. Verify that user can cancel creating by clicking Discard button

    @When("user clicks discard button")
    public void user_clicks_discard_button() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.discardButton.click();
    }

    @Then("creation is cancelled")
    public void creation_is_cancelled() {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(vehiclesOdometerPage.createButton.isDisplayed());

    }

    // 4. Verify that page title is changed to the new Odometer value after user create the Odometer

    @Then("page title is changed to new odometer")
    public void page_title_is_changed_to_new_odometer() {
        BrowserUtils.waitFor(5);
        Assert.assertEquals("New - Odoo", Driver.getDriver().getTitle());
    }

    //5. Verify that “Attachment” and Action buttons are displayed at the top of the page (after creating a new Odometer).

    @When("user enters {string} as vehicle value")
    public void user_enters_as_vehicle_value(String vehicleValue) {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.vehicleSelectDropdown.click();
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.vehicleSelectDropdown.sendKeys(vehicleValue + Keys.ENTER);

    }

    @When("user enters {string} as odometer value")
    public void user_enters_as_odometer_value(String odometerValue) {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.odometerValueInputBox.clear();
        vehiclesOdometerPage.odometerValueInputBox.sendKeys(odometerValue);
    }

    @When("user clicks save button")
    public void user_clicks_save_button() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.saveButton.click();

    }

    @Then("attachment and action buttons are displayed at the top of the page")
    public void attachment_and_action_buttons_are_displayed_at_the_top_of_the_page() {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(vehiclesOdometerPage.attachmentButton.isDisplayed());
        Assert.assertTrue(vehiclesOdometerPage.actionButton.isDisplayed());

    }

    // 6. Verify that user can find the new created Odometer value under Odometer list by using search box.

    @When("user enters {string} as odometer value in search box")
    public void user_enters_as_odometer_value_in_search_box(String odometerValue) {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.searchBox.sendKeys(odometerValue);

    }

    @When("user selects odometer value search option")
    public void user_selects_odometer_value_search_option() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.searchBox.sendKeys(Keys.DOWN);
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.searchOdometerValue.click();

    }

    @Then("{string} odometer value is found")
    public void odometer_value_is_found(String odometerValue) {
        BrowserUtils.waitFor(5);
        Assert.assertEquals(odometerValue, vehiclesOdometerPage.listedOdometerValue.getText());
    }

    // 7. Verify that user can change Odometer display to Kanban / List / Graph

    @When("user clicks Kanban button odometer display changes to Kanban")
    public void user_clicks_kanban_button_odometer_display_changes_to_kanban() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.kanbanButton.click();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("kanban"));
    }


    @When("user clicks List button odometer display changes to List")
    public void user_clicks_list_button_odometer_display_changes_to_list() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.listButton.click();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("list"));
    }

    @When("user clicks Graph button odometer display changes Graph")
    public void user_clicks_graph_button_odometer_display_changes_graph() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.graphButton.click();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("graph"));
    }

    // 8- Verify that the number of Odometer increased 1

    @When("user can see the number of odometer")
    public void user_can_see_the_number_of_odometer() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.vehicleClearButton.click();
        BrowserUtils.waitFor(5);
        firstOdometerNumber = Integer.parseInt(vehiclesOdometerPage.odometerNumber.getText());

    }

    @Then("user can see the number of odometer increased one")
    public void user_can_see_the_number_of_odometer_increased_one() {
        BrowserUtils.waitFor(5);
        secondOdometerNumber = Integer.parseInt(vehiclesOdometerPage.odometerNumber.getText());
        BrowserUtils.waitFor(5);
        Assert.assertEquals(secondOdometerNumber, firstOdometerNumber + 1);
    }




/*
    @When("user clicks create button and see the number of odometer increased one")
    public void user_clicks_create_button_and_see_the_number_of_odometer_increased_one() {
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.vehicleClearButton.click();
        BrowserUtils.waitFor(5);
        int firstOdometerNumber = Integer.parseInt(vehiclesOdometerPage.odometerNumber.getText());
        BrowserUtils.waitFor(5);
        vehiclesOdometerPage.createButton.click();
        BrowserUtils.waitFor(5);
        int secondOdometerNumber = Integer.parseInt(vehiclesOdometerPage.odometerNumber.getText());
        BrowserUtils.waitFor(5);
        Assert.assertEquals(secondOdometerNumber, firstOdometerNumber + 1);
    }

 */

}
