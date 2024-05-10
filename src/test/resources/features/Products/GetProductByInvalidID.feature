@GetProductInvalidID
Feature: Get Product Using Invalid ID
  As a user
  I want to input invalid product id to get product
  So that I can receive "404 not found" response

  Scenario: As a user i want to get complete product with invalid product ID
    Given I set API endpoint with an invalid ID to get product
    When I send request to get product using invalid ID
    Then I receive error message and "404 Not Found" response