#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Rest API Testing
  I want to use this to test all the Rest API methods
  
Background: user generates tocken for authorisation
				Given I am an authorised user
				

  Scenario: user is able to create a booking, update a booking and Delete a booking
    Given List of Bookings are available when i create a booking
    Then Booking is added
    When I update a booking
    Then Booking is updated
    When I Delete a booking
    Then Booking is Deleted
  