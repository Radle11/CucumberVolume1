Feature: Pet Store API
  @API
  Scenario Outline: Validate Post/Get/Delete Request Body
    Given the end point
    When user sends a POST request with "<id>","<name>","<status>"
    Then the status codes is OK
    And pet is created
    When user sends a GET request
    Then the status codes is OK
    And validate pet's info
    When user sends  a DELETE request
    Then the status codes is OK
    And validate if pet's info is deleted
    Examples:
      | id  | name | status      |
      | 123 | bibi | dead        |
      | 345 | mimi | available   |
      | 653 | bobo | unavailable |