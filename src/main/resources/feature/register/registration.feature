Feature: registration

Given user registers to food delivery app with the following fields:
|username|password| fullName|  address  |  city |state| zip |phone    |
|John    |Test123 |John Doe |123 main st|Chicago| IL  |60625|112131321|
Then verify that status code is 200
Then verify that response message is "User registration successful."
Then verify that user information successfully saved in DB

Given user registers to food delivery app with an existing username:
Then verify that status code is 400
Then verify that response message is "Username unavailable. Please choose another one."
Then verify that user information successfully saved in DB

Given user registers to food delivery app with empty username
Then verify that status code is 400
Then verify that response message is "Username cannot be null or empty."
Then verify that user information is not saved in DB

Given user registers to food delivery app with null username
Then verify that status code is 400
Then verify that response message is "Username cannot be null or empty."
Then verify that user information is not saved in DB

Given user registers to food delivery app with empty fullname
Then verify that status code is 400
Then verify that response message is "Fullname cannot be null or empty."
Then verify that user information is not saved in DB

Given user registers to food delivery app with null fullname
Then verify that status code is 400
Then verify that response message is "Fullname cannot be null or empty."
Then verify that user information is not saved in DB

Given user registers to food delivery app without password
Then verify that status code is 500
Then verify that response message is "Password cannot be null or empty."
Then verify that user information is not saved in DB

Given user registers to food delivery app empty password
Then verify that status code is 500
Then verify that response message is "Password cannot be null or empty."
Then verify that user information is not saved in DB

