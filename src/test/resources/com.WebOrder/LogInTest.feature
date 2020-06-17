Feature: WebOrder Login Page Test
  @smoke
  Scenario: Login Page Positive Test
    Given the demoUser enters username,password and click login button
    And the demoUser validate the home page

    Scenario: Login Functionality Negative Test
      Given the demoUser enters "techtorial","test" and click login button
      And the demoUser validate the "Invalid Login or Password."

  @negative @smoke @conditional
  Scenario: Login Functionality Negative Test 2
    Given the demoUser enters "Tester","tets" and click login button
    And the demoUser validate the "Invalid Login or Password."
@negative @smoke
  Scenario: Login Functionality Negative Test 3
    Given the demoUser enters "techtorial","academy" and click login button
    And the demoUser validate the "Invalid Login or Password."