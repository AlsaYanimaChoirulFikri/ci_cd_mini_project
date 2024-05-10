@GetAllOrder
Feature: Get All My Order
  As a User
  I want to get all my order
  So That i can get "200 OK" response

  Scenario: As a user i want to get all my order
    Given I set API endpoint to get all my order
    When I send request to get all my order
    Then I receive status code 200
    And I receive all of my order