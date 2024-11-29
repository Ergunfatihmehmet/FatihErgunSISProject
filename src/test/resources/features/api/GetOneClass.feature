@API @Smoke
Feature: Get One Class Functionality

  Background:
    Given I created a request
    And I provided the ClassID 578 as the path parameter

  Scenario: Get one class and validate the response
    When I make a GET request to the GetOneClass endpoint
    Then I validate that the status code is 200
    And I validate that the Id is 578
    And I validate that the class term is "Winter"