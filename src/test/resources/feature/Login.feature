Feature: To test Login functionality

  Scenario Outline: To test login functionality with various datasets
    Given Open the browser and navigate to login page
    When User enters "<username>" and "<password>" and click on login button
    Then Sign in button should be disabled to prevent duplicate requests being triggered
    Then User should be able to login on valid "<result>" and show error message on invalid result
    Examples:
      | username        | password     | result   |
      | vidushi.gupta63 | Vidushi@1234 | valid    |
      | vishal          | test         | invalid  |
      |                 |              | required |
      | dcdcdc          |              | required |
      |                 | cdcdcd       | required |
