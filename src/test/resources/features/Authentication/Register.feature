@RegisterUser
Feature: Register
  As a User
  I want to register

  Background:
    Given I set API endpoint to register

  Scenario: As a user i want to register using valid credential
    When I send request to register and fill valid credential(email, password, fullname)
    Then I receive status code 200
    And I receive my registered account data

  Scenario: As a user i want to register using invalid email
    When I send request to register and fill invalid email (password and fullname stay valid)
    Then I receive status code 400

  Scenario: As a user i want to register using blank fullname
    When I send request to register and fill blank one credential
    Then I receive status code 400