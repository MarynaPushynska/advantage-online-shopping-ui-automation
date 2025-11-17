
  @smoke
    Feature: Smoke path
      Scenario: Login -> search -> add to cart -> verify -> logout

        Given I open the AOS application
        When I open login popup
        And I login as "marinatester" with password "Password11"
        And I search for "speakers"
        And I open first product of the list
        When I add product to cart
        And I open cart
        Then "HP S9500 BLUETOOTH WIRELESS SPEAKER" should be present in cart
        When I logout
        Then I should not see user name in header