@GetProductComment
Feature: Get Product Comment
  As a user
  I want to input valid product id to get product comment
  So that I can receive "200" response

  Scenario: As a user i want to get complete product comment with valid product ID
    Given I set API endpoint with an valid ID to get product comment by ID
    When I send request to get product comment using valid ID
    Then I receive status code 200
    And I receive all of product comment using valid ID