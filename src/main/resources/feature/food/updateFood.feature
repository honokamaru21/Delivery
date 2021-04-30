Feature: update food

  Scenario: 1
Given user updates "T-Bone steak"'s price to 100.00
Then verify that status code is 200
Then verify that price have been updated

  Scenario: 2
Given user updates "T-Bone steak"'s price to 125.50
Then verify that status code is 403
Then verify that error message "Invalid request - Food price should be kept less than 125" is displayed

