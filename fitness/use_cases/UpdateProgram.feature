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
Feature: Update Program
  As an instructor
  I want to  update fitness programs
  So that I can manage my program offerings effectively
  
   Background:
    Given I am logged in as an instructor
   
  @tag11
   Scenario: Instructor updates a fitness program
     Given the instructor has an existing program
     And the instructor is on the program management page
     When the instructor selects the program to edit
     And the instructor updates the program title, duration, difficulty level, goals, price,media or group sessions
     And the instructor saves the changes
     Then the program should be updated successfully
     And the instructor should see a confirmation message "Program updated successfully"
   
   @tag12
   Scenario: Instructor updates a program with missing title
   Given the instructor has an existing program
   And the instructor is on the program management page
   When the instructor selects the program to edit
   And the instructor leaves the program title empty
   And the instructor saves the changes
   Then the instructor should see an error message "Program title is required"
   And the program should not be updated  
  @tag13
   Scenario: Instructor updates a program with missing duration
   Given the instructor has an existing program
   And the instructor is on the program management page
   When the instructor selects the program to edit
   And the instructor leaves the duration empty
   And the instructor saves the changes
   Then the instructor should see an error message "Program duration is required"
   And the program should not be updated  
   
   @tag14
    Scenario: Instructor updates a program with missing goals
    Given the instructor has an existing program
    And the instructor is on the program management page
    When the instructor selects the program to edit
    And the instructor leaves the goals field empty
    And the instructor saves the changes
    Then the instructor should see an error message "Program goals are required"
    And the program should not be updated
    
    @tag15
     Scenario: Instructor updates a program with missing media
     Given the instructor has an existing program
     And the instructor is on the program management page
     When the instructor selects the program to edit
     And the instructor leaves the media fields empty
     And the instructor saves the changes
     Then the instructor should see an error message "At least one media file (video, image, or document) is required"
     And the program should not be updated
     
     @tag16
      Scenario: Instructor updates a program with invalid media file format
      Given the instructor has an existing program
      And the instructor is on the program management page
    	When the instructor selects the program to edit
  		And the instructor uploads an invalid media file type (e.g., "file.exe")
  		And the instructor saves the changes
 		  Then the instructor should see an error message "Invalid file format"
 		  And the program should not be updated
 		  
 		@tag17
 		Scenario: Instructor updates a program with missing price (optional)
    Given the instructor has an existing program
    And the instructor is on the program management page
    When the instructor selects the program to edit
    And the instructor leaves the price field empty (if not required)
    And the instructor saves the changes
    Then the program should be updated successfully without a price
    And the instructor should see a confirmation message "Program updated successfully" 
    
    @tag18
     Scenario: Instructor updates a program with missing group session schedule
 		 Given the instructor has an existing program
     And the instructor is on the program management page 		 
 		 When the instructor selects the program to edit
 		 And the instructor leaves the group session schedule empty
	   And the instructor saves the changes
 		 Then the instructor should see an error message "Group session schedule is required"
 		 And the program should not be updated
 		 
 	 @tag19
 	   Scenario: Instructor cancels the program update
 		 Given the instructor has an existing program
 		 And the instructor is on the program management page 	
 		 When the instructor selects the program to edit
 		 And the instructor decides to cancel the changes
 		 Then the program should not be updated
 		 And the instructor should be returned to the program list page without saving changes
 	 @tag20
 	   Scenario: Instructor attempts to save a program update without making any changes
  	 Given the instructor has an existing program
  	 And the instructor is on the program management page 	
  	 When the instructor selects the program to edit
  	 And the instructor does not make any changes to the program details
  	 And the instructor saves the changes
 	   Then the instructor should see a message "No changes to save"
  	 And the program should remain unchanged
  	 
  	@tag21
  	  Scenario: Instructor tries to update the program with a missing difficulty level
  	  Given the instructor has an existing program
  	 	And the instructor is on the program management page 
  	  When the instructor selects the program to edit
    	And the instructor leaves the difficulty level field empty
    	And the instructor saves the changes
    	Then the system should show an error message "Program difficulty level is required"
    	And the program should not be updated
  	@tag22
  	  Scenario: Instructor tries to update the program with an invalid price format
  	  Given the instructor has an existing program
  	 	And the instructor is on the program management page 
    	When the instructor selects the program to edit
    	And the instructor updates the price to "$"-100
    	And the instructor saves the changes
    	Then the system should show an error message "Price must be a valid positive amount"
    	And the program should not be updated 