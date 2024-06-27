Feature: Register as a new User

  Scenario Outline: Newly registered User can login to the game
    Given User navigate to the Register page
    When User successfully enter valid "<username>" and "<password>"
    Then User should be able to log in the game with "<username>" and "<password>"

    Examples:
      | username | password |
      | newUser107 | newUser5 |