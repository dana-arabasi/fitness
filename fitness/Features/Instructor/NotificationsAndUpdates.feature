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
Feature: Notifications and Updates
  As an instructor, I want to notify clients about changes to program schedules and announce new programs or special offers, so they stay informed and engaged.

  Background:
    Given the system is configured with client contact information
    And clients have opted in to receive notifications

  Scenario: Notify clients about schedule changes
    Given I am logged into the system as an instructor
    When I update the program schedule
    And I select clients affected by the change
    Then the clients should receive a notification about the updated schedule
    And the system should log the notification activity

  Scenario: Announce new programs
    Given I am logged into the system as an instructor
    When I create a new program
    And I select to announce it to all clients
    Then clients should receive a notification about the new program
    And the system should log the announcement activity

  Scenario: Announce special offers
    Given I am logged into the system as an instructor
    When I create a special offer
    And I select to announce it to all clients
    Then clients should receive a notification about the special offer
    And the system should log the announcement activity