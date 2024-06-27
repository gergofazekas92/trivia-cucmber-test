Feature: Play the game
  As a registered user
  I want to get random questions
  So I can answer them

  Scenario: Start a ranked game
    Given I am on the game page
    When clicking on the Ranked button
    Then a question pops up

  Scenario: Close a game
    Given I opened a game
    When I click the Close button
    Then the question disappears

#  Scenario: Can I answer a question
#    Given I opened a game
#    When I select an answer
#    Then I can see if it was correct
#
  Scenario: Can I skip to next question
    Given I answered a question
    When I click the Next button
    Then I see a new question

  Scenario: Get points by answering a lot of questions
    Given I am on the game page
    When I answer a few questions
    Then I want to see my points increased