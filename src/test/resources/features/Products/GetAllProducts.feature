@GetAllProducts
Feature: Get All Products
  As a user
  I want to get all products
  So that i can get "200 OK" response

  Scenario: As a user i want to get all products
    Given I set API endpoint to get all products
    When I send request to get all products
    Then I receive status code 200
    And I receive all products details