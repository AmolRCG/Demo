#Feature: Add products to cart

#  Scenario:Add products to cart and verify details
#    Given user launches the browser and opens the products page
#    When the user hovers over the first product and clicks Add to cart
#    And the user verifies that Product added to cart message is visible
#    And the user clicks View Cart button
#    Then the user should be navigated to the Cart page successfully
#    And the product should be listed in the cart with correct details
#    | Product Name | Quantity | Price |
#    | Blue Top     | 1        | 500  |

#  Scenario: Verify total price in cart
#    When the user adds another product to the cart
#    And the user verifies that total price is updated correctly
#    Then the total price should reflect both products' prices correctly