Feature: Vehicle odometer functionality
  Agile story: As a user I can create a Vehicle Odometer

  Background: user is on vehicles odometer Page
    Given user has logged in the web site
    When user is on fleet page
    And user is on vehicles odometer page

  Scenario: user can create a vehicle odometer
    When user clicks create button
    Then user sees the new vehicles odometer form

  Scenario: user cannot create a vehicle odometer without selecting vehicle
    When user clicks create button
    When user clicks save button without selecting vehicle
    Then new vehicle odometer is not created

  Scenario: user can cancel creating by clicking discard button
    When user clicks create button
    When user clicks discard button
    Then creation is cancelled

  Scenario: page title is changed to the new odometer value after user create the Odometer
    When user clicks create button
    Then page title is changed to new odometer

  Scenario: Attachment and Action buttons are displayed at the top of the page (after creating a new Odometer).
    When user clicks create button
    And user enters "audi" as vehicle value
    And user enters "132.00" as odometer value
    And user clicks save button
    Then attachment and action buttons are displayed at the top of the page

  Scenario: user can find the new created odometer value under odometer list by using search box.
    When user enters "132.00" as odometer value in search box
    And user selects odometer value search option
    Then "132.00" odometer value is found

  Scenario: user can change odometer display to Kanban / List / Graph
    When user clicks Kanban button odometer display changes to Kanban
    When user clicks List button odometer display changes to List
    When user clicks Graph button odometer display changes Graph

  Scenario: user can see the number of odometer increased 1
    When user can see the number of odometer
    And user clicks create button
    Then user can see the number of odometer increased one




