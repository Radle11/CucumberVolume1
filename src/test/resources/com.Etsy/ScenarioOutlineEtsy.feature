Feature: scenario outline Test

  Background: Etsy navigation
    Given the user goes to the Etsy

  @EtsyOutline
  Scenario Outline: Etsy search validation with outline
    When the user search in etsy with "<searchValue>"
    Then the user validate title "<title>" and url "<currentURL>"
    Examples:
      | searchValue    | title                  | currentURL |
      | winter hat     | Winter hat \| Etsy     | winter     |
      | hat            | Hat \| Etsy            | hat        |
      | winter soldier | Winter soldier \| Etsy | winter     |
