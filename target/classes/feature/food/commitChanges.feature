Feature: changes

  Scenario: 1
Given user saves all chached food
Then verify that status code is 200
Then verify number of saved food
Then verify response message "Food Cache is committed to db"
Then verify that all food information is saved in DB
 Scenario: 2
Given user saves all chached food excluding "Diet Coke"
Then verify that status code is 200
Then verify number of saved food
Then verify response message "Food Cache is committed to db"
Then verify that all food information is saved in DB

