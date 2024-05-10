@GetAllProductCategories
Feature: Get All Product Categories
  As a User
  I want to get all product categories
  So That i can get "200 OK" response

  Scenario: As a user i want to get all product categories
    Given I set API endpoint to get all product categories
    When I send request to get all product categories
    Then I receive status code 200
    And I receive all of product categories