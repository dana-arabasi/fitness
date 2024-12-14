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
Feature: Delete Program
  As an instructor
  I want to delete fitness programs
  So that I can manage my program offerings effectively
  
   @tag23
     Scenario: Instructor deletes a fitness program
     Given the instructor has an existing program
     And the instructor is on the program management page
     When the instructor selects the program to delete
     And the instructor confirms the deletion
     Then the program should be deleted successfully
     And the instructor should see a confirmation message 
     
   @tag24
   	Scenario: 	Instructor selects a program that doesn't exist anymore
    Given: The instructor has a program listed.
    And the instructor is on the program management page
    And The program is deleted by another system process (for example, by an admin).
    When The instructor tries to select and delete the program.
    Then The system should inform the instructor that the program no longer exists and cannot be deleted.
    
   @tag25
   Scenario: Instructor cancels the deletion
	 Given The instructor has an existing program.
	 And The instructor is on the program management page.
	 When The instructor selects the program to delete.
	 And The instructor cancels the deletion process before confirming.
	 Then The program should remain intact.
	 And No confirmation message should be shown.
	 