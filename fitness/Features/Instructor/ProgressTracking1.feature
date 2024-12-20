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
    Given I am logged in as an instructor

  Scenario: Generate progress report
    Given I am on the  Progress Tracking page
    When I select a client "ahmad" 
    Then I should see a detailed progress report
    And I should have the option to download the report as a PDF
    
    Scenario: Monitoring Client Progress (Completion Rate)
    Given I am on the  Progress Tracking page
    And the client "Alice" has completed 80% of the assigned tasks
    When I checks the "Alice" progress
    Then the system should display "Completion Rate: 80%" for the client
    And send a reminder message "Keep going, Alice! You’re almost there!"

  Scenario: Sending Motivational Reminders to Clients
   Given I am on the  Progress Tracking page
    And the client "Alice" has only completed 40% of their program
    When I review the progress
    Then the system should send a motivational reminder "Alice, you can do it! Let's pick up the pace!"

  Scenario: Monitoring Client Attendance
   Given I am on the  Progress Tracking page
    And the client "Bob" has attended 4 out of 6 sessions
    When I check the attendance records for "Bob"
    Then the system should display "Attendance Rate: 67%" for the client
    And send a reminder to "Bob" about" missing the last two sessions"