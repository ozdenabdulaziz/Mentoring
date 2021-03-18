@book
Feature: getting information from book depots book

  Scenario: getting information books
    Given user should go to book depot landing page
    When user should able to click on browse module
    When user should able to click on browse all books section
    When user should to choose 25+ quantity and click to apply button
    When user should to choose softCover and PaperBack format and click to apply button
    Then user should getting all information about books and cell on the xml file
