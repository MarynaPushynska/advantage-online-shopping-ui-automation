@cart
Feature: Shopping cart operations

  Background:
    Given I open the AOS application

  Scenario: Add single product to the cart
    When I search for "laptop"
    And I open first product of the list
    And I set quantity 1
    And I add product to cart
    Then picked product should be visible in the cart



