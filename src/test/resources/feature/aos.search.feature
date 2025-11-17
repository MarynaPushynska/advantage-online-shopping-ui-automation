@search

  Feature: Search and open product page

    Background:
      Given I open the AOS application

      Scenario: Search by name and open PDP
        When I search for the "laptop"
        And I open first product of the list
        Then product page title should be displayed



    Scenario: Choose color on PDP
      When I search the "speakers"
      And I open product "BOSE SOUNDLINK BLUETOOTH SPEAKER III"
      When I choose color "WHITE"
      Then selected color should be "WHITE"
