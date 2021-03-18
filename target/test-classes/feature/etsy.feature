@etsyDavul
Feature: Etsy search feature

  @etsy
  Scenario: Etsy default title verification
    Given user is on the Etsy landing page
    Then user should see Etsy title as expected

    #expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @davul
  Scenario: Etsy search title verification
    Given user is on the Etsy landing page
    When user searches for "davul"
    Then user should see "Davul" in the Etsy title

  @scenarioOutline
  Scenario Outline: Etsy search header verification
    Given user is on the Etsy landing page
    When user types "<searchProduct>" in the etsy search box
    Then user sees "<expectedTitle>" is in the etsy title

    Examples: search product we are going to search in etsy
      | searchProduct      | expectedTitle      |
      | davul              | Davul              |
      | zurna              | Zurna              |
      | rose               | Rose               |
      | turkish coffee set | Turkish coffee set |

