@GetProductRating
Feature: Get Product Ratings
  As a user
  I want to input valid product id to get product ratings
  So that I can receive "200" response

  Scenario: As a user i want to get complete rating product with valid product ID
    Given I set API endpoint with an valid ID to get product ratings by ID
    When I send request to get product ratings using valid ID
    Then I receive status code 200
    And I receive all of product ratings using valid ID