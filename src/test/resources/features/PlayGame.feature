Feature: Play the game
  As a registered user
  I want to get random questions
  So I can answer them

  Scenario: Start a ranked game
    Given I am logged in
    And I am on the game page
    When clicking on the Ranked button
    Then a question pops up

  Scenario: Close a game
    Given I am logged in
    And I opened a game
    When I click the Close button
    Then the question disappears

  Scenario: Not getting points if the answer is wrong
    Given I am logged in
    And I don't have points
    And I opened a game
    When I submitted the wrong answer
    And refreshed the page
    Then I still don't have points

  Scenario: Get points if the answer is correct
    Given I am logged in
    And I don't have points
    And I opened a game
    When I submitted the right answer
    And refreshed the page
    Then my points are increased

  Scenario: Selected answer is highlighted in blue
    Given I am logged in
    And I opened a game
    When I select any answer
    Then the answer turns blue

  Scenario: Correct answer is highlighted in green
    Given I am logged in
    And I opened a game
    When I submitted the right answer
    Then the answer turns green

  Scenario: Wrong answer is highlighted in red
    Given I am logged in
    And I opened a game
    When I submitted the wrong answer
    Then the answer turns red

  Scenario: I can see my name on the leaderboard
    Given I am logged in
    And I opened a game
    When I give several correct answers
    Then my name is on the leaderboard