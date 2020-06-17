Feature: DuckDuckGo search testing

  Scenario: Validation of Search in DuckDuckGo
    Given the user goes to duckduckgo
    When the user sends the selenium keyword
    Then the user clicks search button
    And the user validates if title contains the selenium keyword
    And the user validates if url contains the selenium keyword
    * the user validates if all results contain the selenium keyword
    @smoke @Techtorial1 @tech
    Scenario: Validation of Search with TestNG
    Given the user goes to duckduckgo
    When the user search with "TestNG"
    Then the user clicks search button
    And the user validate title contains "TestNG"
    And the user validate all results contains "Test"
    And the user validate number of result is 10
  @smoke @Techtorial2 @tech
  Scenario: Validation of Search with Java
    Given the user goes to duckduckgo
    When the user search with "Java"
    Then the user clicks search button
    And the user validate title contains "Java"
    And the user validate all results contains "Java"
    And the user validate number of result is 10