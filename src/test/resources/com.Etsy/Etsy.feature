Feature: Validate search in Etsy
  Background: It Will Run Before Each Scenario
    Given the user goes to the Etsy
  @Etsy
  Scenario: Validation of search in etsy
    When the user search in etsy with "Winter hat"
    Then the user validate title "Winter hat | Etsy" and url "Winter"

  @Etsy
  Scenario: Validation of search in etsy
    When the user search in etsy with "hat"
    Then the user validate title "Hat | Etsy" and url "hat"


  @Etsy @conditional
  Scenario: Validation of search in etsy
    When the user search in etsy with "Winter soldier"
    Then the user validate title "Winter soldier | Etsy" and url "soldier"