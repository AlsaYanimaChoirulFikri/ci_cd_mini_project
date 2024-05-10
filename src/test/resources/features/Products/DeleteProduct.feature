@DeleteProduct
Feature: Delete Product
  As a user
  i want to delete product with valid ID
  So that the product can be removed

  Scenario: As a user i can delete product with valid ID
    Given I set API endpoint to delete product with valid ID
    When I send request to delete product with valid ID
    Then I receive status code 200
