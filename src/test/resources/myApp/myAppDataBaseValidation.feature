@myApp
Feature: My App Data Base Validation
  Scenario: Validating UI data with DB data
    Given  go to myApp home page
    When  gets the data from UI
    Then  validates UI data with DB