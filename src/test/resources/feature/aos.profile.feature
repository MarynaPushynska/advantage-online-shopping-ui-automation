@profile
Feature: Update profile

  Background:
    Given I open the AOS application
    And I open login popup
    And I login as "marinatester" with password "Password11"
    And I open "My account" page

    Scenario: Update first and last name
      When I update my first name as "Marina"
      And I update my last name as "Stone"
      And I save profile
      Then I should see at Account Details field "Marina Stone"
