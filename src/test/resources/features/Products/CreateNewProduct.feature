@CreateNewProduct
Feature: Create a Product
  As a user
  I want to create a new product
  So that i can get "200 OK" response

  Scenario: As a user i want to create a new product
    Given I set API endpoint to create a new product
    When I send request to fill product data with valid credentials
    Then I receive status code 200
    And I receive valid data to create a new product