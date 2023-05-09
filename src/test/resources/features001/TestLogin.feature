@Test1
Feature: Login Feature

  Scenario: Successful Login
    Given I am on the login page
    When I enter valid username and password
    And click on the login button
#    Then I should be redirected to the dashboard page
    Then I should be redirected to the MFA page