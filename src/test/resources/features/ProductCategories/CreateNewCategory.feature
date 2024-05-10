@CreateCategory
Feature: Create a Product Category
  As a user
  I want to create a new product category
  So that the product category is saved

  Scenario: As a user I can create a product category with valid inputs
    Given I set API endpoint for create new product category
    When I send request to fill product category with valid credentials
    Then I receive status code 200
    And I receive valid data for create new product category