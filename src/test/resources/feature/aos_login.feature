
@login
Feature: Login and logout (Advantage Online Shopping)

  Background:
    Given I open the AOS application

  Scenario: Valid login shows user in header
    When I open login popup
    And I login as "marinatester" with password "Password11"
    Then I should see "marinatester" in header


  Scenario: Invalid password shows an error
    When I open login popup
    And I login as "marinatester" with wrong password "wrongpassword11"
    Then I should see login error message

  Scenario: Logout hides user menu
    When I open login popup
    And I login as "marinatester" with password "Password11"
    When I logout
    Then I should not see user name in header