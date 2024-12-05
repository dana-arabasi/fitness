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
     When the instructor selects the program to edit
     And the instructor updates the program title, duration, difficulty level, goals, price,media or group sessions
     And the instructor saves the changes
     Then the program should be updated successfully
     And the instructor should see a confirmation message "Program updated successfully"
     
   @tag3
    Scenario: Instructor deletes a fitness program
    Given the instructor has an existing program
    When the instructor selects the program to delete
    And the instructor confirms the deletion
    Then the program should be deleted successfully
    And the instructor should see a confirmation message 
