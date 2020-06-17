Feature: data table practice
  Scenario: Practice
    Then the user validate the product titles
      | Product:*         |
      | Quantity:*        |
      | Price per unit:   |
      | Discount:         |
      | Total:            |
    Then the user login to the page
      | username | Tester |
      | password | test   |
    Then the user validate order details
      |Paul Brown |ScreenSaver |  2   |03/12/2010 |5, Ringer Street |
      |Mark Smith |FamilyAlbum |  1   | 03/07/2010|9, Maple Valley  |
    Then the user validate order details list of map
      | Name      |Product     |  #   |Date       |   Street        |
      |Paul Brown |ScreenSaver |  2   |03/12/2010 |5, Ringer Street |
      |Mark Smith |FamilyAlbum |  1   | 03/07/2010|9, Maple Valley  |