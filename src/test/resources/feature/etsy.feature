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

  @excel
  Scenario: User should list will be listed in excel file
    Given user is on the Etsy landing page
    When user searches for "davul"
    When user should see "Davul" in the Etsy title
    Then user should listed all davul option in excel file