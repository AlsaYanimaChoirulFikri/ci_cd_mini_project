@GetUserInformation
Feature: Get User Information
  As a User
  I want to get user information
  So That i can get "200 OK" response

  Scenario: As a user i want to get user information
    Given I set API endpoint to get user information
    When I send request to get user information
    Then I receive status code 200
    And I receive all of user information