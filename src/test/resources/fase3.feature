Feature: Phase 3 - E2E Purchase Flow
    As a registered user
    I want to complete a purchase
    To obtain tools from different categories

    Background:
        Given the user is on the home page
        And the user is authenticated with valid credentials

    Scenario: Successful purchase using search bar
        When the user searches for a hand tool using the search bar
        And adds the hand tool to the cart
        And the user proceeds to checkout
        And completes the payment process
        Then the purchase is completed successfully
        And the invoice is successfully associated with the user account

    Scenario: Successful purchase using category filters
        When the user selects a power tool using category filters
        And adds the power tool to the cart
        And the user proceeds to checkout
        And completes the payment process
        Then the purchase is completed successfully
        And the invoice is successfully associated with the user account

    Scenario: Successful purchase using combined filters
        When the user searches for another tool using combined filters
        And adds the third tool to the cart
        And the user proceeds to checkout
        And completes the payment process
        Then the purchase is completed successfully
        And the invoice is successfully associated with the user account

    Scenario: Successful purchase with multiple products
        When the user searches for a hand tool using the search bar
        And adds the hand tool to the cart
        And the user selects a power tool using category filters
        And adds the power tool to the cart
        And the user searches for another tool using combined filters
        And adds the third tool to the cart
        And the user proceeds to checkout
        And completes the payment process
        Then the purchase is completed successfully
        And the invoice is successfully associated with the user account