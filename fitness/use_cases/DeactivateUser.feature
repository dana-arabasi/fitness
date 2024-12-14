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
Feature: Deactivate User
 
Background: 
     Given i am loged in as an admin
 @tag27
    Scenario: Admin deactivates an account 
    Given there is an existing account with the email "john.doe@email.com"
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to deactivate
    And the admin confirms the deactivation
    Then the account with the email "john.doe@email.com" should be deactivated successfully
    And the admin should see a confirmation message
    And the user should receive a deactivation confirmation email

  
    @tag28
    Scenario: Admin attempts to deactivate a non-existing account
    Given there is no account with the email "nonexistent@email.com"
    And the admin is on the user management page
    When the admin tries to select the account with the email "nonexistent@email.com" to deactivate
    Then the system should display an error message "Account not found"
    And the admin should not be able to deactivate the account