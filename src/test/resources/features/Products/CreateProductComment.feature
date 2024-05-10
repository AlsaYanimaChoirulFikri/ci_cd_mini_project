@CreateProductComment
Feature: Create a Comment for Product
  As a user
  I want to create a comment for product
  So that the comment for product is saved

  Scenario: As a user I can create a comment for product
    Given I set API endpoint for create comment for product
    When I send request to fill comment for product
    Then I receive status code 200
    And I receive valid data for create comment for product