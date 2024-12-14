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
Feature: Subscription Management
Background: 
Given i am loged in as an admin

  @tag1
   Scenario: View subscription plans for clients and instructors
    Given there are subscription plans for both clients and instructors
    When I navigate to the subscription management page
    Then I should be able to see a list of available subscription plans for clients and instructors
    And the plans should include their names, features, and pricing

  @tag2
  Scenario: Add a new subscription plan for clients or instructors
    Given I am on the subscription management page
    When I add a new subscription plan with the name "Premium Plus" for clients
    And I set the features and price for the new plan
    Then the "Premium Plus" plan should be successfully added to the available plans
    And the plan should be visible to clients and instructors on the subscription page

  @tag3
  Scenario: Edit an existing subscription plan for clients or instructors
    Given an existing "Basic" subscription plan for instructors
    When I edit the plan to include additional features and change the price
    Then the "Basic" plan should be updated with the new features and price
    And the changes should be reflected for all instructors currently subscribed to the plan

  @tag4
  Scenario: Delete an existing subscription plan for clients or instructors
    Given the "Basic" subscription plan exists for clients
    When I delete the "Basic" subscription plan
    Then the "Basic" plan should be removed from the available subscription plans
    And any clients currently subscribed to the "Basic" plan should be notified of the removal
    And they should be given an option to switch to a different plan

  @tag5
  Scenario: Assign a subscription plan to a client or instructor
    Given I am on the subscription management page
    When I assign the "Premium" subscription plan to a new instructor
    Then the "Premium" plan should be successfully assigned to the instructor
    And the instructor should receive a notification of the successful assignment

  @tag6
  Scenario: Upgrade a subscription plan for a client or instructor
    Given a client is currently subscribed to the "Basic" subscription plan
    When I upgrade the client to the "Premium" subscription plan
    Then the client should be upgraded to the "Premium" plan
    And the client should be notified of the upgrade

  @tag7
  Scenario: Downgrade a subscription plan for a client or instructor
    Given an instructor is subscribed to the "Premium" subscription plan
    When I downgrade the instructor to the "Basic" subscription plan
    Then the instructor should be downgraded to the "Basic" plan
    And the instructor should be notified of the downgrade

  @tag8
  Scenario: Handle subscription payment and renewal for clients and instructors
    Given a client is subscribed to the "Premium" subscription plan
    When the subscription renewal is due
    Then I should be able to process the payment and renew the subscription
    And the client should be notified of the successful renewal

  @tag9
  Scenario: View subscription history for clients and instructors
    Given I am on the subscription management page
    When I view the subscription history for a particular instructor
    Then I should be able to see all past and current subscriptions for that instructor
    And I should be able to see the details of plan changes, upgrades, downgrades, and payment status