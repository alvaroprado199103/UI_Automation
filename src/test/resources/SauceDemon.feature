Feature: Login for SauceDemo page
    Validate behavior when login using valid and invalid credentials for standard and locked users

    Background:
        Given I navigate to www.saucedemo.com

    Scenario: Successful login with valid credentials
        When standard user logs in with valid credentials
        Then the user should be able to access the inventory page

    Scenario: Failed login with incorrect credentials
        When standard user logs in with invalid credentials
        Then an error message should be displayed

    Scenario: Login using a blocked account
        When a blocked user attempts to log in
        Then an error message should be displayed
