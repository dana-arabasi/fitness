     @tag
     Feature: Update User
     Background: 
     Given i am loged in as an admin
    
   Scenario: Update user information
    Given I am on the admin dashboard
    And I select "1" from the dashboard options
    And I am on the user management page
    When I choose to update the user with oldusername "emad" and I enter the new username "emad" and I enter the new password "000" 
    And I submit the updated user details
    Then I should see all users in the list
    And I should see a success message "User updated successfully."
    
    Scenario: Update instructor information
    Given I am on the admin dashboard
    And I select "1" from the dashboard options
    And I am on the user management page
    When I choose to update the user with oldusername "Dana" and I enter the new username "Dana" and I enter the new password "123" 
    And I submit the updated user details
    Then I should see all users in the list
    And I should see a success message "User updated successfully."   
    
     Scenario: Update admin information
    Given I am on the admin dashboard
    And I select "1" from the dashboard options
    And I am on the user management page
    When I choose to update the user with oldusername "Tayma" and I enter the new username "Tayma" and I enter the new password "123" 
    And I submit the updated user details
    Then I should see all users in the list
    And I should see a success message "User updated successfully."  
    
