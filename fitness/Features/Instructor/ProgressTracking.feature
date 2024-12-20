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
Feature: Progress Tracking
  As an instructor, I want to monitor client progress and send motivational reminders or recommendations, so I can support clients in achieving their goals.

  Background:
    Given the system is configured with client data
    And clients have profiles with attendance and completion metrics

  Scenario: View client progress
    Given I am logged into the system as an instructor
    When I navigate to the "Client Progress" page
    Then I should see a list of clients
    And for each client, I should see their completion rate
    And their attendance records

  Scenario: Monitor progress for a specific client
    Given I am on the "Client Progress" page
    When I select a client from the list
    Then I should see detailed progress metrics for that client
    And I should see a chart visualizing their completion over time
    And I should see a list of their recent activities

  Scenario: Send a motivational reminder
    Given I am viewing the detailed progress for a client
    When I click on "Send Motivational Reminder"
    And I select a pre-written motivational message or compose a custom one
    Then the client should receive the message
    And the system should log that the reminder was sent

  Scenario: Recommend additional resources
    Given I am viewing the detailed progress for a client
    When I click on "Recommend Resources"
    And I select a resource from the system’s library
    Then the client should receive the resource recommendation
    And the system should log that the resource was recommended

  Scenario: Notify about lack of progress
    Given a client has not attended sessions or completed tasks for two weeks
    When I log into the system
    Then I should see a notification about the client’s lack of progress
    And I should have the option to send a follow-up reminder or schedule a check-in

  Scenario: Generate progress report
    Given I am logged into the system as an instructor
    When I navigate to the "Reports" page
    And I select a client and a date range
    Then I should see a detailed progress report
    And I should have the option to download the report as a PDF