Feature: Navigation bar
    To see the subpages
    Without logging in
    I can the login workflow

    Scenario: I can try to login using a correct and wrong password.
        Given I navigate to www.saucedemo.com
        Then Login using a correct password
        When Login using incorrect password

    Scenario: I can try to login using a blocked account.
        Given I navigate to www.saucedemo.com
        Then Login using a blocked account

