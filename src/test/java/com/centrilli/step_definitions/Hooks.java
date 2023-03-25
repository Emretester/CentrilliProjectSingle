package com.centrilli.step_definitions;

import com.centrilli.utilities.BrowserUtils;
import com.centrilli.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario) {


        BrowserUtils.sleep(5);
        Driver.closeDriver();


    }

}
