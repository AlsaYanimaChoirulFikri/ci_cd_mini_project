@GetProductCategoryByID
Feature: Get Product Category By Valid ID
  As a user
  I want to input valid product id to get category
  So that I can receive "200" response

  Scenario: As a user i want to get complete category with valid product ID
    Given I set API endpoint with an valid ID to get product category by ID
    When I send request to get product category using valid ID
    Then I receive status code 200
    And I receive a product category