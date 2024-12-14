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
Feature: User Management
Background: 
Given i am loged in as an admin
  #Add account (Instructor or Client)
  @tag1
 Scenario: Admin adds a new account (Instructor or Client) with valid details
  Given the admin is on the user management page
  When the admin adds a new account with the First Name,Last Name ,Email,Phone and  Role
  And the admin submits the form
  Then the  account should be created successfully
  And the admin should see a confirmation message
  And the user should receive a confirmation email

  @tag2
   Scenario: Admin adds an account with missing first name
  Given the admin is on the user management page
  When the admin does not enter a first name for the account 
  And the admin tries to submits the form
  Then the system should display an error message "First Name is required"
  And the admin should not be able to submit the form
  
    @tag3
     Scenario: Admin adds an account with missing last name 
    Given the admin is on the user management page
     When the admin does not enter a last name for the account 
    And the admin tries to submits the form
    Then the system should display an error message "Last Name is required"
    And the admin should not be able to submit the form
    
    @tag4
    Scenario: Admin adds an account with missing email 
    Given the admin is on the user management page
    When the admin does not enter an email for the account 
    And the admin tries to submits the form
    Then the system should display an error message "Email is required"
    And the admin should not be able to submit the form
    
    @tag5
     Scenario: Admin adds an account with an invalid email format (missing "@") 
  Given the admin is on the user management page
   When the admin enter an invalid email format for the account (e.g., "john.doeemail.com ")
   And the admin tries to submits the form
   Then the system should display an error message "Please provide a valid email address"
   And the admin should not be able to submit the form
   
    
    @tag6
    Scenario: Admin adds an account with an invalid email format (missing domain) 
    Given the admin is on the user management page
    When the admin enters an invalid email format for the account (e.g., "john.doe@")
    And the admin tries to submit the form
    Then the system should display an error message "Please provide a valid email address"
    And the admin should not be able to submit the form
    
    @tag7
    Scenario: Admin adds an account with an invalid email format (missing local part)
    Given the admin is on the user management page
    When the admin enters an invalid email format for the account (e.g., "@email.com")
    And the admin tries to submit the form
    Then the system should display an error message "Please provide a valid email address"
    And the admin should not be able to submit the form
    
    @tag8
    Scenario: Admin adds an account with an invalid email format (contains spaces) 
    Given the admin is on the user management page
    When the admin enters an invalid email format for the account (e.g., "john doe@email.com")
    And the admin tries to submit the form
    Then the system should display an error message "Please provide a valid email address"
    And the admin should not be able to submit the form

		@tag9
    Scenario: Admin adds an account with an invalid email format (contains special characters)
    Given the admin is on the user management page
    When the admin enters an invalid email format for the account (e.g., "john.doe@em@il.com")
    And the admin tries to submit the form
    Then the system should display an error message "Please provide a valid email address"
    And the admin should not be able to submit the form
    
    @tag10
    Scenario: Admin adds an account with an already used email 
    Given the admin is on the user management page
    When the admin enters an email address that is already in use (e.g., "john.doe@email.com")
    And the admin tries to submit the form
    Then the system should display an error message "Email is already in use"
    And the admin should not be able to submit the form
    
    @tag11
    Scenario: Admin adds an account with missing phone number
    Given the admin is on the user management page
    When the admin does not enter a phone for the account 
    And the admin tries to submits the form
    Then the system should display an error message "Phone number is required"
    And the admin should not be able to submit the form
    
    
    @tag13
     Scenario: Admin adds an account with an excessively long first name 
    Given the admin is on the user management page
    When the admin enters an excessively long first name for the account (e.g., "JonathanAlexanderTheGreatOfTheWorld")
    And the admin tries to submit the form
    Then the system should display an error message "First Name is too long"
    And the admin should not be able to submit the form
    
		@tag14
  	 Scenario: Admin adds an account with an invalid phone number 
    Given the admin is on the user management page
    When the admin enters an invalid phone number for the account (e.g., "12345abc678")
    And the admin tries to submit the form          
    Then the system should display an error message "Phone number is invalid"
    And the admin should not be able to submit the form