Feature: All Products
  Scenario: Validation of all products
    Given the demoUser enters username,password and click login button
    When the user clicks the all products button
    Then the user validates the product details
      |Product name | Price|Discount|
      |MyMoney      |$100  |  8%    |
      |FamilyAlbum  |$80   |15%     |
      |ScreenSaver  | $20  |10%     |