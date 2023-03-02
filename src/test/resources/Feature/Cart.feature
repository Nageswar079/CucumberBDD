
Feature: As a user,
  			I want to add products to the cart
  			So that I can see the product in my cart
  			
  Scenario: Verify if the product is added in the cart successfully or not
  Given user is on homepage
  When user navigates to the product needed
  And user clicks on add to cart button
  Then user can see the product is added into application
  
  