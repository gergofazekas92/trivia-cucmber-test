Feature: Register as a new User

  Scenario Outline: Newly registered User can login to the game
    Given I am on the Register page
    When I enter a valid "<username>" and "<password>"
    And I click on the login button
    Then I am logged in as "<username>"

    Examples:
      | username   | password |
      | newUser113 | newUser5 |

  Scenario Outline: Used username cannot register again
    Given I am on the Register page
    When I log in with credentials "<username>" and "<password>"
    # code repetition to be removed (see login feature)
    Then I see an error message "Username already in use, please choose another!"

    Examples:
      | username | password |
      | testuser | testuser |