Feature: i-Tunes Search Testing
  Scenario Outline: Validate Search Result
    Given endpoint with query parameter "<artist>"
    Then  validate correct status code
    Examples:
      | artist        |
      | Pink          |
      | Green Day     |
      | 2 Pac         |
      | Amy Winehouse |
      | AC/DC         |
      | Bon Jovi      |