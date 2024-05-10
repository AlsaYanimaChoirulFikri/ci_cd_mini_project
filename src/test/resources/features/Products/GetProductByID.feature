@GetProductByID
Feature: Get Product Using Valid ID
  As a user
  I want to input valid ID to get product
  So that i can get "200 OK" response

  Scenario: As a user i want to get complete product with valid product ID
    Given I set API endpoint to get product by ID
    When I send request to get product using valid ID
    Then I receive status code 200
    And I receive a product details