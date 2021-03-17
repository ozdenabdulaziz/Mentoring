@wiki1
Feature: Wikipedia search feature
  As a user, I should be able to search terms and see related results

  @wiki2
  Scenario: Wikipedia search title verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

  @wiki
  Scenario: Wikipedia search header verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" in the main header

  @scenarioOutline1
  Scenario Outline: Wikipedia search header verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedMainHeader>" in the main header
    Then User sees "<expectedTitle>" is in the wiki title

    Examples: search terms we are going to search in wikipedia
      | searchValue  | expectedMainHeader | expectedTitle |
      | Steve Jobs   | Steve Jobs         | Steve Jobs    |
      | Kobe Bryant  | Kobe Bryant        | Kobe Bryant   |
      | Elon Musk    | Elon Musk          | Elon Musk     |
      | Bill Gates   | Bill Gates         | Bill Gates    |
      | Chuck Norris | Chuck Norris       | Chuck Norris  |
      | Marie Curie  | Marie Curie        | Marie Curie   |