Feature: To test Reset Password functionality

  Scenario Outline: To test Reset Password functionality when user enter valid username
    Given Open the browser and navigate to login page for reset
    And Click on Forgotten Password link
    Then User should navigate to Reset access page
    When User enters "<username>" and click on Request a reset button
    Then If "<result>" is valid it should show email sent confirmation message
    Examples:
      | username        | result  |
      | vidushi         | invalid |
      | vidushi.gupta63 | valid   |


  Scenario: To test Reset Password Functionality when user click on Cancel button
    Given Open the browser and navigate to login page for reset
    And Click on Forgotten Password link
    Then User should navigate to Reset access page
    When User click on Cancel button at Request a reset page
    Then It should redirect user to login page