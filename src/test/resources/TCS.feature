Feature: Navigation bar
    To see the subpages
    Without logging in
    I can the login workflow

    @test
    Scenario: I can try to login using a correct and wrong password.
        Given I navigate to www.saucedemo.com
        When Login using a correct password
        Then Login using incorrect password

    @test
    Scenario: I can try to login using a blocked account.
        Given I navigate to www.saucedemo.com
        Then Login using a blocked account

