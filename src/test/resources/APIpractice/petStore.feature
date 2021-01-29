Feature: Pet Store
  Scenario: validate pet 10
    Given a header accept type is "application/json"
    When make a GET request to endpoint
    Then validate status code is 200, content type is "application/json"
    And deserialize the reponse