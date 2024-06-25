Feature: User Login
  As a registered user
  I want to be able to log in to my account
  So that I can access my personalized content

  Scenario : Successful Login
    Given I am on the login page
    When I enter username "existingUser1" and password "pass123"
    And I click the login button
    Then I should be redirected to the home page


  Scenario Outline: Login with invalid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message "Invalid username or password"

    Examples:
      | username        | password    |
      | existingUser1   | invalidpass |
      | existingUser1   |             |
      | nonExistingUser | invalidpass |


