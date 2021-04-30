Feature: list food

  Scenario: 1
Given user list all food in cache
Then verify that status code is 200
Then verify that response contains all cached foods

