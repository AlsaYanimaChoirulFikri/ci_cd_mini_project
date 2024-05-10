@CreateNewOrder
Feature: Create a New Order
  As a user
  I want to create a new order
  So that my order is saved

  Scenario: As a user I can create a new order category with valid inputs
    Given I set API endpoint for create new order
    When I send request to fill new order with valid credentials(product id, quantity)
    Then I receive status code 200
    And I receive valid data for my order