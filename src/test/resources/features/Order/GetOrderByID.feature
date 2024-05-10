@GetOrderById
Feature: Get My Order Depends on ID
  As a User
  I want to get my order depends on id
  So That i can get "200 OK" response

  Scenario: As a user i want to get my order depends on id
    Given I set API endpoint to get my order depends on id
    When I send request to get my order depends on id
    Then I receive status code 200
    And I receive my order depends on id