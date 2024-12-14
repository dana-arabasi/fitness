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
Feature: Program Monitoring
Background: 
 Given i am loged in as an admin


  @tag1
   Scenario: View Most Popular Programs by Enrollment
    Given the admin navigates to the program monitoring section
    When the admin views program statistics
    Then the system should list the programs with the highest enrollments.
    
    @tag2
    Scenario: Generate Reports on Revenue, Attendance, and Client Progress
    Given the admin is on the reporting page
    When the admin generates a report
    Then the system should allow filtering by date range, program, and user type
    And provide data on revenue, attendance, and client progress in a downloadable format
    
    @tag3
    Scenario: Track Active and Completed Programs
    Given the admin is on the program tracking page
    When the admin reviews program statuses
    Then the system should list all active programs with progress metrics
    And display completed programs with summary statistics.   
    
    @tag4
    Scenario: Analyze Program Completion Rates
  Given the admin is on the program analytics page
  When the admin filters programs by completion rates
  Then the system should display the percentage of participants who completed each program
  And allow sorting by highest or lowest completion rates.
  
   @tag5
   Scenario: View User Feedback on Programs
  Given the admin is on the program feedback page
  When the admin selects a specific program
  Then the system should display aggregated user feedback and ratings for the program
  And allow the admin to respond to user feedback if necessary.
  
    