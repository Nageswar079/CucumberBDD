@Regression
Feature: As a user,
  			I want to login to the application
  			So that I can see the homepage
	@Smoke
  Scenario: Verify if login is successfull when entered correct username and password
  Given user is on loginpage
  When user enters correct username and password
  And user clicks on login button
  Then user is logged into application
  
  Scenario Outline: Verify the login is sucessfull whe entered correct username and password
    Given user is on loginpage
    When user enters correct '<username>' and '<password>'
    And user clicks on login button
    Then user validates the login functionality based on the '<testDataType>'

    Examples: 
      | username      | password     | testDataType |
      | dfdfdfdf      | dfdfdfdf     | invalid      |
      | dfdfdfdf      | Admin123     | invalid      |
      | Admin123      | dfdfdfdf     | invalid      |
      | standard_user | secret_sauce | valid        |
