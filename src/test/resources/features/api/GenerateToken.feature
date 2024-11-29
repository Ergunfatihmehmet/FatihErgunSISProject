@API
Feature: Generate Token

  Background:
    Given I created post a request
    And I provided the body information
    And I provided the header information

  Scenario: Generate Token
    When I make a POST Request to GenerateToken endpoint
    Then I validate that the status code is 200
    And I validate that the body contains "accessToken"
    And I validate that the success is true
    Then I update token