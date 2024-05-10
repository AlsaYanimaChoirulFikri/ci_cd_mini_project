@LoginUser
Feature: Login
  As a User
  I want to Login

  Background:
    Given I set API endpoint to Login

  Scenario: As a user i want to Login using valid credential
    When I send request to login and fill valid credential(email, password)
    Then I receive status code 200
    And I receive my logged in account data

  Scenario: As a user i want to login using invalid email
    When I send request to login and fill invalid email
    Then I receive status code 400

  Scenario: As a user i want to login using blank email
    When I send request to login and fill blank email
    Then I receive status code 400

  Scenario: As a user i want to login using wrong password
    When I send request to login and fill wrong password
    Then I receive status code 400