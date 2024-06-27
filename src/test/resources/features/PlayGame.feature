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

  Scenario: Can I skip to next question
    Given I am logged in
    And I answered a question
    When I click the Next button
    Then I see a new question

#  Scenario: Not getting points if the answer is wrong
#    Given I am logged in
#    And I opened a game
#    When I selected the wrong answer
#    Then I am not getting points
#
#  Scenario: Get points if the answer is correct
#    Given I am logged in
#    And I opened a game
#    When I selected the right answer
#    Then I my points are increased
#
#  Scenario: Correct answer is highlighted
#    Given I am logged in
#    And I opened a game
#    When I select an answer
#    Then An answer is highlighted in green
#
#  Scenario: I can see my name on the leaderboard
#    Given I am logged in
#    And I opened a game
#    When I give several correct answers
#    Then my name is on the leaderboard