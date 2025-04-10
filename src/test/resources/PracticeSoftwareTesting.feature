Feature: Phase 3 - E2E Purchase Flow
    As a registered user
    I want to complete a purchase
    To obtain tools from different categories

    Background:
        Given the user is on the home page
        And the user is authenticated with valid credentials

    Scenario: Successful purchase using combined filters
        When the user searches for a Leather toolbelt in the 'Other' category, with a price between '50' and '150', sorting the results by price from 'Low to High'
        And adds the Leather toolbelt to the cart
        And the user proceeds to checkout
        And the user completes the payment process
        Then the purchase is completed successfully
        And the invoice is successfully associated with the user account

    Scenario: Complete a purchase with multiple products
        When the user searches for a Hammer using the search bar
        And adds the Hammer to the cart
        And the user goes to the cart
        And the user proceeds to checkout
        And the user fills in shipping information
        And the user fills in payment information
        And the user places the order
        Then the order should be confirmed
        And the user should see the order number
        And the user should be able to view the invoice

    Scenario: Successful purchase with multiple products
        When the user searches for a Hammer using the search bar
        And adds the Hammer to the cart
        And the user selects a Cordless Drill 24V using category filters
        And adds the Cordless Drill 24V to the cart
        And the user searches for a Leather toolbelt in the 'Other' category, with a price between '50' and '150', sorting the results by price from 'Low to High'
        And adds the Leather toolbelt to the cart
        And the user proceeds to checkout
        And the user completes the payment process
        Then the purchase is completed successfully
        And the invoice is successfully associated with the user account

    Scenario: Successful purchase using category filters
        When the user selects a Cordless Drill 24V using category filters
        And adds the Cordless Drill 24V to the cart
        And the user proceeds to checkout
        And the user completes the payment process
        Then the purchase is completed successfully
        And the invoice is successfully associated with the user account
