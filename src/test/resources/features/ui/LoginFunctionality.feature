@Smoke
Feature: Login Functionality

  Background:
    Given Login Page is present

  Scenario: Valid Login
    When I enter username and password
    And I click on login button
    Then I should be logged in

  Scenario Outline: Invalid Login
    When I enter invalid "<username>" and "<password>"
    And I click on login button
    Then I shouldn't be able to login

    Examples:
      | username       | password       |
      | RandomUsername | RandomPassword |
      | RandomUsername | Neotech@123    |
      | Admin          | RandomPassword |
      | Admin          |                |
      |                | Neotech@123    |