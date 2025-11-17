@registration
Feature: User registration

  Background:
    Given I open the AOS application
    And I open new login popup
    And I navigate to "Create New Account" form

  Scenario: Successful registration with unique username
    And pass my username as "qa_marinka"
    And pass my email as "qa_email@gmail.com"
    And pass my password as " Pasw0rd11!"
    And confirm my password passing " Pasw0rd11!"
    And write my first name as "Marinka"
    And write my last name as "TestTest"
    And check agree box
    Then I should see "qa_marinka" in my header
