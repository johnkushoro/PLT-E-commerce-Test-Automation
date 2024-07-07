Feature: Shopping Functionality

  Background:
    Given I am on the homepage

  Scenario: Adding Product to Bag
    When User navigates to PLP by selecting a product category
    And User verifies PLP is displayed
    And User selects a product from PLP Category
    And the user selects product options and adds it to the bag
    And User clicks on the bag icon
    Then Product in the bag should match the selected product
    And the cart subtotal is stored

    When User proceeds to checkout
    And User enters email address and selects continue
    And User enters password and selects continue
    Then The product name, size, and subtotal should match in the bag section on the checkout page
    And The bag section should display the delivery total and grand total

    When User scrolls to the payment method
    Then User selects and verifies a payment method