Feature: New Order Validation
  Background: Log In Web Order
    Given the demoUser enters username,password and click login button
  Scenario Outline:Validate new order in web order page
    When the user enters product info "<product>" and "<Quantity>"
    Then the user enters address info "<Customer name>","<Street>","<City>","<State>","<Zip>"
    * the user enters payment info "<Card Type>", "<Card Number>","<Card Expiration Date>"
    Then the user validate success message
    Examples:
      | product | Quantity | Customer name | Street        | City       | State    | Zip   | Card Type | Card Number      | Card Expiration Date |
      | MyMoney | 10       | David         | 2200 E Devon  | Des Plains | Illinois | 60018 | Visa      | 1111222233334444 | 08/22                |
      | MyMoney | 7       | Silvester     | 1117 S Karlov | Chicago    | Illinois | 60624 | Visa      | 1111222233334444 | 12/20                |
      | FamilyAlbum | 5       | Jessica         | 2 Main  | Pensacola | Florida | 43532 | MasterCard      | 1111222233334444 | 02/26                |
      | ScreenSaver | 3       | John     | 17 S Petrenko | Kharkov    | Donetsk | 2354553 | AmericanExpress      | 1111222233334444 | 10/21                |