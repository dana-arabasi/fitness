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
Feature: Instructor Registration 
 Background: 
     Given i am loged in as an admin

  @tag29
    Scenario: Admin views pending instructor registrations
    Given the admin is on the user management page
    When the admin navigates to the pending registrations section
    And the admin views the list of pending instructor registrations
    Then the admin should see a list of all pending instructor registrations
    And each pending registration should display the instructor's name and email
    
    
    @tag30
    Scenario: Admin approves a new instructor registration
    Given the admin is on the user management page
    And the instructor with email "john.doe@email.com" is in the pending registrations list
    When the admin selects the instructor to approve
    And the admin confirms the approval
    Then the instructor registration should be approved successfully
    And the instructor should receive an approval confirmation email
    And the admin should see a confirmation message

    
    @tag31
    Scenario: Admin rejects a new instructor registration
    Given the admin is on the user management page
    And the instructor with email "john.doe@email.com" is in the pending registrations list
    When the admin selects the instructor to reject
    And the admin confirms the rejection
    Then the instructor registration should be rejected
    And the instructor should receive a rejection email
    And the admin should see a rejection confirmation message
