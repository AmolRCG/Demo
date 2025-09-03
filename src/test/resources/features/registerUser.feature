Feature: User Registration and Deletion

    Background:
        Given user launches the browser and opens the home page
        Then user verifies that home page is visible successfully
  #Complete 1
  Scenario: Register a new user and delete the account
    When user clicks on Signup_Login button
    Then user verifies 'New User Signup' is visible
    When user enters name and email address
    And user clicks 'Signup' button
    Then user verifies that 'ENTER ACCOUNT INFORMATION' is visible
    When user fills account information
    And user selects newsletter and special offers checkboxes
    And user fills address details
    | First Name  | AMOL        |
    | Last Name   | RATHOD      |
    | Company     | Testing     |
    | Address1    | ShreeNagar  |
    | Address2    | Rahatani    |
    | Country     | India       |
    | State       | Maharashtra |
    | City        | Pune        |
    | Zipcode     | 411017      |
    | Mobile Number| 1234567890 |
    And user clicks 'Create Account' button
    Then user verifies that 'ACCOUNT CREATED' is visible
    When user clicks 'Continue' button
    Then user verifies that Logged in as username is visible
    When user clicks 'Delete Account' button
    Then user verifies that 'ACCOUNT DELETED' is visible
    And user clicks 'Continue' button

  #Complete 2
  Scenario: Login with valid credentials
#    When user clicks on Signup_Login button
#    Then user verifies 'New User Signup' is visible
#    When user enters name and email address
#    And user clicks 'Signup' button
#    Then user verifies that 'ENTER ACCOUNT INFORMATION' is visible
#    When user fills account information
#    And user selects newsletter and special offers checkboxes
#    And user fills address details
#    And user clicks 'Create Account' button
#    Then user verifies that 'ACCOUNT CREATED' is visible
#    When user clicks 'Continue' button
#    Then user verifies that Logged in as username is visible
#    And user clicks on Logout button
#    Then user verifies that home page is visible successfully
    When user clicks on Signup_Login button
    Then user verifies Login to your account is visible
    When user enters valid email address and password
    And user clicks login button
    Then user verifies that Logged in as username is visible
    And user clicks on Logout button

    #Complete 3
  Scenario: Login user with invalid email and password and verify error message
    When user clicks on Signup_Login button
    When user enters invalid email address and password
    And user clicks login button
    Then user verifies that 'Your email or password is incorrect!' message is visible

    #Complete 4
  Scenario: Register User with existing email and verify error message
    When user clicks on Signup_Login button
    Then user verifies 'New User Signup' is visible
    When user enters existing Name and email address
    And user clicks 'Signup' button
    Then an error message 'Email Address already exist!' should be visible

    #Complete 5
  Scenario:Add products to cart and verify details
    When user clicks on Products button
    When the user hovers over the first product and clicks Add to cart
    Then the user verifies that Product added to cart message is visible
    And the user clicks View Cart button
    Then the user should be navigated to the Cart page successfully
    And the product should be listed in the cart with correct details

   #Complete 6
  Scenario: Verify Contact Us form
    When user clicks on Contact Us button
    Then user verifies that GET IN TOUCH is visible
    When user enters name, email, subject, and message
    And user uploads a file
    And user clicks Submit button
    Then user verifies that success message 'Success! Your details have been submitted successfully.' is visible

    #Complete 7
  Scenario: Verify All Product and detail page
    When user clicks on Products button
    Then user verify all products list is visible
    When user hovers the mouse and clicks first View Product button
    Then user should be landed on the product detail page successfully and verify product details

  #Complete 8
  Scenario: Search for products and verify search results
    When user clicks on Products button
    When user enters the 'Tshirt' in the search input and clicks the search button
    Then 'Men Tshirt' should be visible

    #Complete 9
  Scenario: Verify Subscription in home page
    When user scrolls down to footer
    And user verifies text SUBSCRIPTION
    And user enters email address in input and clicks Subscribe button
    Then user verifies that You have been successfully subscribed message is visible

    #10 Complete
  Scenario: Add two products to the cart and verify details
    When user clicks on Products button
    When the user hovers over the first product and clicks Add to cart
    And user clicks Continue Shopping button
    And user hovers over the second product and clicks Add to cart
    Then user verifies products are added to the cart successfully
    And the user clicks View Cart button
    And user verifies that both products are listed in the cart with correct details
    | Product Name | Quantity | Price | Total Price |
    | Blue Top     | 1        | 500   | 500         |
    | Men Tshirt   | 1        | 400   | 400         |


  #Complete 11
  Scenario: Verify Product quantity in cart
    When user clicks on Products button
    And the user click on view product for any product
    Then user should be landed on the product detail page successfully
    When user increases the quantity to 4 clicks on Add to cart button
    And the user clicks View Cart button
    Then user verifies product is added with exact quantity in cart

  #Complete 12
  Scenario: Place Order And Register while checkout
    When user clicks on Products button
    And the user hovers over the first product and clicks Add to cart
    And the user clicks View Cart button
    Then the user verifies that cart page is visible
    And user clicks on Proceed To Checkout button
    When user clicks on Register  Login button
    Then user verifies 'New User Signup' is visible
    When user enters name and email address
    And user clicks 'Signup' button
    Then user verifies that 'ENTER ACCOUNT INFORMATION' is visible
    When user fills account information
    And user selects newsletter and special offers checkboxes
    And user fills address details
    And user clicks 'Create Account' button
    Then user verifies that 'ACCOUNT CREATED' is visible
    When user clicks 'Continue' button
    Then user verifies that Logged in as username is visible
    When the user clicks on Cart button
    And user clicks on Proceed To Checkout button
    And user verifies address details and order review is visible
    When user enters a description in the comment text area
    And user clicks on Place Order button
    When user verifies payment details is visible
    And user enters payment details
    When user clicks on 'Pay and Confirm Order' button
    Then user verifies that 'Your order has been placed successfully!' message is visible
    When user clicks 'Delete Account' button
    Then user verifies that 'ACCOUNT DELETED' is visible
    And user clicks 'Continue' button

    #Complete 13
  Scenario: Place Order Register Before Checkout
    When user clicks on Signup_Login button
    Then user verifies 'New User Signup' is visible
    When user enters name and email address
    And user clicks 'Signup' button
    Then user verifies that 'ENTER ACCOUNT INFORMATION' is visible
    When user fills account information
    And user selects newsletter and special offers checkboxes
    And user fills address details
    And user clicks 'Create Account' button
    Then user verifies that 'ACCOUNT CREATED' is visible
    When user clicks 'Continue' button
    Then user verifies that Logged in as username is visible
    When user clicks on Products button
    And the user hovers over the first product and clicks Add to cart
    And the user clicks View Cart button
    Then the user verifies that cart page is visible
    And user clicks on Proceed To Checkout button
    And user verifies address details and order review is visible
    When user enters a description in the comment text area
    And user clicks on Place Order button
    When user verifies payment details is visible
    And user enters payment details
    When user clicks on 'Pay and Confirm Order' button
    Then user verifies that 'Your order has been placed successfully!' message is visible
    When user clicks 'Delete Account' button
    Then user verifies that 'ACCOUNT DELETED' is visible
    And user clicks 'Continue' button

    #Complete 14
  Scenario: Remove product from cart
    When user clicks on Products button
    And the user hovers over the first product and clicks Add to cart
    And the user clicks View Cart button
    Then the user verifies that cart page is visible
    And the user clicks on Remove Product button
    Then the user verifies that product is removed from cart successfully

    #Complete 15
  Scenario: View Category Product
    Then verify the 'Category' is visible on left side of the page
    When user clicks on 'Women' category button and click on 'Tops' category
    Then user verify that category page is displayed and confirm text 'Women - Tops Products'
    And user clicks on the 'Men' category button and click on 'Tshirts' category
    Then user verify that category page is displayed and confirm text 'Men - Tshirts Products'

    #Complete 16
  Scenario: View And Cart Brand Products
    When user clicks on Products button
    Then verify the 'Brands' is visible on left side of the page
    And user clicks on 'Polo' brand
    Then user verify that brand page is displayed and confirm text 'Brand - Polo Products'
    And user clicks on 'H&M' brand
    Then user verify that brand page is displayed and confirm text 'Brand - H&M Products'

  #Complete 17
  Scenario: Search Products And Verify After Login
    When user clicks on Products button
    And user enters the 'Tshirt' in the search input and clicks the search button
    And add all visible products to cart and click on view cart button
    Then verify all products are added to cart successfully
    And user clicks login button
    When user enters valid email address and password
    And user clicks login button
    When the user clicks on Cart button
    Then verify all products are added to cart successfully

    #Complete 18
  Scenario: Add review on product
    When user clicks on Products button
    Then user verify all products list is visible
    And user hovers the mouse and clicks first View Product button
    And Verify the text 'Write Your Review' text is visible
    When user enters name, email, and review
    And the user clicks Submit button
    Then Verify the 'Thank you for your review.' text is visible

  Scenario: Add to cart from recommended items section
    When user clicks on Products button
    And user scrolls down to footer
    Then user verifies the 'Recomended Items' text is visible
    And user clicks on 'Add to cart' button for the first product
    Then user verifies that Product added in cart sucessfully


 #Complete 19
 Scenario: Download Invoice After purchase Order
    When user clicks on Products button
    And the user hovers over the first product and clicks Add to cart
    And the user clicks View Cart button
    Then the user verifies that cart page is visible
    And user clicks on Proceed To Checkout button
    When user clicks on Register  Login button
    Then user verifies 'New User Signup' is visible
    When user enters name and email address
    And user clicks 'Signup' button
    Then user verifies that 'ENTER ACCOUNT INFORMATION' is visible
    When user fills account information
    And user selects newsletter and special offers checkboxes
    And user fills address details
    And user clicks 'Create Account' button
    Then user verifies that 'ACCOUNT CREATED' is visible
    When user clicks 'Continue' button
    Then user verifies that Logged in as username is visible
    When the user clicks on Cart button
    And user clicks on Proceed To Checkout button
    And user verifies address details and order review is visible
    When user enters a description in the comment text area
    And user clicks on Place Order button
    When user verifies payment details is visible
    And user enters payment details
    When user clicks on 'Pay and Confirm Order' button
    Then user verifies that 'Your order has been placed successfully!' message is visible
    Then User click on Download and user verifies that Invoice is downloaded successfully
    When user clicks 'Delete Account' button
    Then user verifies that 'ACCOUNT DELETED' is visible

   #Complete 20
 Scenario: Verify Scroll Down And Scroll Up Functionality using Arrow Button
    When user clicks on Products button
    When user scrolls down to footer
    And user verifies text SUBSCRIPTION
    When user clicks on arrow button right side scrolls up to top of the page using arrow button
    Then user verifies that home page is visible successfully

  #Complete 21
 Scenario: Verify Scroll Down And Scroll Up Functionality without Arrow Button
    When user clicks on Products button
    When user scrolls down to footer
    And user verifies text SUBSCRIPTION
    When user scrolls up to top of the page using mouse wheel
    Then user verifies that home page is visible successfully

  #Complete 22
 Scenario: Verify Address details while checkout
    When user clicks on Signup_Login button
    Then user verifies 'New User Signup' is visible
    When user enters name and email address
    And user clicks 'Signup' button
    Then user verifies that 'ENTER ACCOUNT INFORMATION' is visible
    When user fills account information
    And user selects newsletter and special offers checkboxes
    And user fills address details
    | First Name  | AMOL        |
    | Last Name   | RATHOD      |
    | Company     | Testing     |
    | Address1    | ShreeNagar  |
    | Address2    | Rahatani    |
    | Country     | India       |
    | State       | Maharashtra |
    | City        | Pune        |
    | Zipcode     | 411017      |
    | Mobile Number| 1234567890 |
   And user clicks 'Create Account' button
   Then user verifies that 'ACCOUNT CREATED' is visible
   When user verifies that Logged in as username is visible
   When user clicks on Products button
   And the user hovers over the first product and clicks Add to cart
   And the user clicks View Cart button
   Then the user verifies that cart page is visible
   And user clicks on Proceed To Checkout button
   Then user verifies address details and order review is visible
   Then user verifies that 'address_delivery' is same as entered during registration
   Then user verifies that 'address_invoice' is same as entered during registration
   When user enters a description in the comment text area
   And user clicks 'Delete Account' button
   Then user verifies that 'ACCOUNT DELETED' is visible