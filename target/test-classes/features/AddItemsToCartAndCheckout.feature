Feature: Add Items and Checkout

Scenario Outline: Add two items to the cart and place order
Given User is on "http://automationpractice.com/index.php" home page
When Adds two items to the cart and proceeds to checkout
And Verify shopping cart summary contains two items and proceeds to checkout
And Authenticates using existing login credentials username <username> and password <password>
And Use default address and proceed to checkout
And Agrees to Shipping terms of service
And Selects Pay by bank wire as the payment method
And Confirms the order
Then Gets the Order Confirmation


Examples:
|username									|password					|
|wolliesqacodechallengeumesh@gmail.com		|Test123!					|

