@Slack
Feature: Slack Message
  Scenario: Validate Slack Message via API
    When user sends a message via POST request
    Then verify message via GET request
  Scenario: Validate Slack Message via Selenium WebDriver
    When user sends a message via POST request
    Then Verify the message with Selenium Webdriver in UI
  Scenario: Validate UI sent message with Selenium Webdriver
    When user sends message with Selenium Webdriver in UI
    Then Verify the message with Selenium Webdriver in UI
  Scenario: Validate UI sent Message via GET request
    When user sends message with Selenium Webdriver in UI
    Then verify message via GET request
  Scenario: Validate deleted message via GET request
    When Delete message from slack via POST request
    Then Verify the message is gone via GET request
  Scenario: Validate deleted message via Selenium Webdriver
    When Delete message from slack via POST request
    Then Verify the message is gone via Selenium Webdriver in UI