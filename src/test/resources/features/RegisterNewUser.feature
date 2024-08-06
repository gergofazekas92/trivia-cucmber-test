Feature: Register as a new User
  As a new user
  I want to be able to create a new account
  So I can log in to the main page

  Scenario Outline: Newly registered User can login to the game
    Given User navigate to the Register page
    When User successfully enter valid "<username>" and "<password>"
    Then User should be able to log in the game with "<username>" and "<password>"

    Examples:
      | username | password |
      | newUser113 | newUser5 |

  Scenario Outline: Used username cannot register again
    Given User navigate to the Register page
    When User successfully enter used "<username>" and "<password>"
    Then User should see an error message "Username already in use, please choose another!"

    Examples:
      | username | password |
      | testuser | testuser |