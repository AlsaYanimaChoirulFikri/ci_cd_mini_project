@AssignProductRating
Feature: Assign a Product Rating
  As a user
  I want to assign a product rating
  So that the product rating is saved

  Scenario: As a user I can assign a product rating
    Given I set API endpoint for assign a product rating
    When I send request to fill product rating
    Then I receive status code 200
    And I receive valid data for assign a product rating