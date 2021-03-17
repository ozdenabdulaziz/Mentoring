@login
Feature: Login
  As user, I want to be able to login with username and password
#  Agile story

#  Test Method = Test Case = Scenario
#  Test + DataProvider = Scenario Outline + Examples table

  Background: open login page
    Given user is on the login page

  @scenario_outline
  Scenario Outline: User names test for user <name>
    When user enters "<username>" username and "<password>" password
    Then user name should be "<name>"

    Examples: credentials
      | username        | password    | name           |
      | user159         | UserUser123 | Jhon Wick      |
      | user160         | UserUser123 | Brian O'Conner |
      | storemanager89  | UserUser123 | Kobe Bryant    |
      | storemanager90  | UserUser123 | Neymar Junior  |
      | salesmanager257 | UserUser123 | Donald Trump   |
      | salesmanager258 | UserUser123 | Pablo Escobar  |
