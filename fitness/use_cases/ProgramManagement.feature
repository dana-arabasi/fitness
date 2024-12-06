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
Feature: Instructor Features
  As an instructor
  I want to manage programs, interact with clients, track their progress, and send notifications
  So that I can provide a high-quality experience and keep clients engaged with the programs
  
   Background:
    Given I am logged in as an instructor
    And I am on the Instructor Dashboard

  @tag1
   Scenario: Instructor creates a fitness program with all required details and media
    Given the instructor is on the program management page
    When the instructor enters the program title, duration, difficulty level, and goals
    And the instructor uploads video tutorials, images, or documents
    And the instructor sets a price for the program if applicable
    And the instructor sets the schedule for group sessions
    Then the program should be created successfully
    And the instructor should see a confirmation message "Program created successfully"
    And the program should appear in the program list
    
   @tag2
     Scenario: Instructor creates a fitness program without a price
     Given the instructor is on the program management page
     When the instructor enters the program title, duration, difficulty level, and goals
     And the instructor uploads video tutorials, images, or documents
     And the instructor sets the schedule for group sessions
     And the instructor does not set a price
     Then the program should be created successfully without a price
     And the instructor should see a confirmation message "Program created successfully"
     And the program should appear in the program list
     
   @tag3
    Scenario: Instructor creates a fitness program without video, image, or document
    Given the instructor is on the program management page
    When the instructor does not upload any media
    And the instructor try to create this fitness program
    Then the instructor should see an error message "At least one media file (video, image, or document) is required"
    And the program should not be created
    
   @tag4
   Scenario: Instructor creates a fitness program with a missing title
    Given the instructor is on the program management page
    When the instructor does not enter a program title
    And the instructor try to create a fitness program
    Then the instructor should see an error message "Program title is required"
    And the program should not be created

    
  @tag5 
    Scenario: Instructor creates a fitness program with a missing duration
    Given the instructor is on the program management page
    When the instructor does not enter a program duration
    And the instructor try to create this fitness program
    Then the instructor should see an error message "Program duration is required"
    And the program should not be created
 
 
  @tag6 
   Scenario: Instructor creates a fitness program with a missing difficulty level
     Given the instructor is on the program management page
    When the instructor does not select a difficulty level
      And the instructor try to create this fitness program
    Then the instructor should see an error message "Program difficulty level is required"
    And the program should not be created
    
   @tag7
   Scenario: Instructor creates a fitness program with missing goals
    Given the instructor is on the program management page
    When the instructor does not enter goals for the program
    And the instructor try to create this fitness program
    Then the instructor should see an error message "Program goals are required"
    And the program should not be created
    
    @tag8
    Scenario: Invalid file type for media
    Given the instructor is on the program management page
    When the instructor uploads an invalid file type "invalid_file.exe"
    And the instructor try to create this fitness program
    Then the instructor should see an error message "Invalid file format"
    And the program should not be created
    
    @tag9
    Scenario: Price not set (if applicable)
    Given the instructor is on the program management page
    When the instructor does not set a price for the program
    And the instructor try to create this fitness program
    Then the instructor should see an error message "Program price is required"
    And the program should not be created
    
    @tag10
    Scenario: Program creation without group sessions
    Given the instructor is on the program management page
    When the instructor sets all required details (title, duration, difficulty level, goals, media)
    And the instructor does not set a schedule for group sessions
    Then the program should be created successfully without group sessions
    And the instructor should see a confirmation message "Program created successfully"
    And the program should appear in the program list without any group sessions scheduled
    
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
    	And the instructor updates the price to "-$100"
    	And the instructor saves the changes
    	Then the system should show an error message "Price must be a valid positive amount"
    	And the program should not be updated 
    	
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
    And: The program is deleted by another system process (for example, by an admin or automated system).
    When: The instructor tries to select and delete the program.
    Then: The system should inform the instructor that the program no longer exists and cannot be deleted.
    
   @tag25
   Scenario: Instructor cancels the deletion
	 Given: The instructor has an existing program.
	 And: The instructor is on the program management page.
	 When: The instructor selects the program to delete.
	 And: The instructor cancels the deletion process before confirming.
	 Then: The program should remain intact.
	 And: No confirmation message should be shown.
	 
	 
   
