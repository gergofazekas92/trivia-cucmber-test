Feature: Register as a new User

  Scenario: Registered User can login to the game
    Given User navigate to the Register page
    When User succesfully enter valid details
    Then User should be able to log in the game