@DeleteProductCategoryByID
Feature: Delete product category by ID
  As a user
  I want to delete product category by valid id
  So that the product category can be removed

  Scenario: As a user I can delete product category with valid ID
    Given I set API endpoint for delete product category with valid id
    When I send request to delete product category with valid ID
    Then I receive status code 200