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
Feature: User Activity
  Background: 
     Given i am loged in as an admin


   @tag33
    Scenario: Admin views overall user activity statistics
    Given the admin is on the user management page
    When the admin selects the "User Activity" section
    Then the admin should see an overview of user activity, including total logins, and active users
    
    @tag34
      Scenario: Admin views user engagement statistics 
    Given the admin is on the user management page
    When the admin selects the "User Engagement" section
    And the admin views the user engagement statistics
    Then the admin should see the engagement statistics, including average session time and interactions with platform features

    
    @tag35
    Scenario: Admin views detailed activity of a specific user
    Given the admin is on the user management page
    And the user with email "john.doe@email.com" exists
    When the admin selects the user account "john.doe@email.com"
    And the admin views the activity details of the user
    Then the admin should see detailed statistics about the user's activities, such as login history and page visits

