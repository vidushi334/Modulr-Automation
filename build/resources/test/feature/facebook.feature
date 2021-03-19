Feature: Totest login facebook login functionality

  Scenario Outline: To test login functionality with multiple data sets
    Given Open the browser and navigate to facebook login page
    When Enter "<userid>" and "<password>"
    And Click on login button
    Then user should be able to login on valid "<result>" otherwise it willdisplay a error message

    Examples:
      | userid                     | password   | result  |
      | test 1                     | test1      | invalid |
      | guptavidushi1994@gmail.com | myjob@2015 | valid   |