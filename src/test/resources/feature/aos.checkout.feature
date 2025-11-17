
  Feature: Checkout flow(until payment)

    Background:
      Given I open the AOS application
      And I open login popup
      And I login as "marinatester" with password "Password11"

      Scenario: Logged-in user can start checkout
        Given I search for "headphones"
        And I open the first product of the list
        And I add product to cart
        When I open cart
        And I start checkout
        Then shipping address step should be shown

    @checkout
    Scenario: Guest user is asked to sign in at checkout
      When I logout
      And I search for "speakers"
      And I open first product of the list
      And I add product to cart
      When I open cart
      And I start checkout
      Then I should be asked to sign in or register