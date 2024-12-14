     @tag
     Feature: Update User
     Background: 
     Given i am loged in as an admin
    @tag15
    Scenario: Admin updates an account with valid details
    Given there is an existing account with email "john.doe@email.com" already exists
    And the admin is on the user management page
    When the admin select the account with email "john.doe@email.com" to edit 
    And the admin updates the account  First Name ,Last Name ,Email ,Phone or Role
    And the admin submits the form
    Then the account should be updated successfully
    And the admin should see a confirmation message
    And the user should receive an updated confirmation email

    
    @tag16
     Scenario: Admin updates an account with an invalid email format (missing "@")
     Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with an invalid email format (e.g., "john.doeemail.com")
     And the admin tries to submit the form   
     Then the system should display an error message "Please provide a valid email address"
     And the admin should not be able to submit the form
     
     @tag17
     Scenario: Admin updates an account with an invalid email format (contains multiple "@")
     Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with an invalid email format (e.g., "john.doe@@email.com")
     And the admin tries to submit the form   
     Then the system should display an error message "Please provide a valid email address"
     And the admin should not be able to submit the form
     
     
     @tag18
     Scenario: Admin updates an account with an invalid email format (contains special characters)
     Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with an invalid email format (e.g., "john.doe@em@il.com")
     And the admin tries to submit the form   
     Then the system should display an error message "Please provide a valid email address"
     And the admin should not be able to submit the form
     
     
     @tag19
     Scenario: Admin updates an account with an invalid email format (missing domain)
     Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with an invalid email format (e.g., "john.doe@")
     And the admin tries to submit the form   
     Then the system should display an error message "Please provide a valid email address"
     And the admin should not be able to submit the form
     
     
      @tag20
     Scenario: Admin updates an account with an invalid email format (missing local part)
     Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with an invalid email format (e.g., "@email.com")
     And the admin tries to submit the form   
     Then the system should display an error message "Please provide a valid email address"
     And the admin should not be able to submit the form
     
     
      @tag21
     Scenario: Admin updates an account with an invalid email format (contains spaces)
     Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with an invalid email format (e.g., "john doe@email.com")
     And the admin tries to submit the form   
     Then the system should display an error message "Please provide a valid email address"
     And the admin should not be able to submit the form
    
    
    @tag22
    Scenario: Admin updates an account with missing phone number
     Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with a missing phone number
     And the admin tries to submit the form 
     Then the system should display an error message "Phone number is required"
     And the admin should not be able to submit the form

    
    @tag23
    Scenario Outline: Admin updates an account with missing email 
    Given there is an existing account with email "john.doe@email.com" already exists
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with a missing email
     And the admin tries to submit the form 
    Then the system should display an error message "Email is required"
    And the admin should not be able to submit the form
    
    @tag24
    Scenario: Admin tries to update an account with a deactivated email 
    Given there is an existing account with email "john.doe@email.com" that is deactivated
    And the admin is on the user management page
    When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with a deactivated email 
    And the admin tries to submit the form
    Then the system should display an error message "This email has already been deactivated"
    And the admin should not be able to submit the form

    
    @tag25
    Scenario: Admin tries to update an account with a duplicate email 
    Given there is an existing account with the email "john.doe@email.com"
    And there is another account with the email "alice.smith@email.com"
    And the admin is on the user management page
    When the admin selects the account with email "john.doe@email.com" to edit
    And the admin updates the account with the email "alice.smith@email.com"
     And the admin tries to submit the form
    Then the system should display an error message "Email is already in use"
    And the admin should not be able to submit the form
    
    @tag26
    Scenario: Admin updates an account with an invalid phone number
     Given there is an existing account with the email "john.doe@email.com"
     And the admin is on the user management page
     When the admin selects the account with email "john.doe@email.com" to edit
     And the admin updates the account with an invalid phone number "12345AB678"
     And the admin tries to submit the form
     Then the system should display an error message "Phone number is invalid"
     And the admin should not be able to submit the form