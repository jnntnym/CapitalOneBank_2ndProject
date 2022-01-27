Feature: Login feature test
  @login
  Scenario: login with valid credential
    Given I am at Capital one bank home page
    And I enter valid email
    And I enter invalid password
    When I click login button
    Then I am not able to login successfully
    Then I able to fetch the error message
    Then I clicked on Okay button to return to Signin
    Then I am at Signin page
