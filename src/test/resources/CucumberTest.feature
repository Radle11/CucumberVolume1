@smoke @regression
Feature: Cucumber first test
  Scenario: First steps
    Given the user school name
    When the user print the name
    Then the user print the last name
    And the user print the city
    * the user print the state
    #for cucumber we need too use Gherkin Language
  #Feature file starts with Feature: keyword
  #for every test cases we create Scenario
  #we need to write java code inside StepDefinition