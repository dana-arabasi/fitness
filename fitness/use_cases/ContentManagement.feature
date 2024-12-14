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
Feature:  Content Management
Background: 
Given i am loged in as an admin
  @tag1
  Scenario: Approve wellness articles, tips, or recipes shared by instructors
    Given an instructor has submitted a wellness article titled "The Benefits of Meditation"
    When I review the article in the admin dashboard
    Then I should be able to approve the article
    And the article status should be updated to "Approved"
    And the instructor should be notified of the approval

  @tag2
  Scenario: Reject wellness articles, tips, or recipes shared by instructors
    Given an instructor has submitted a wellness recipe titled "Healthy Smoothie Recipe"
    When I review the recipe in the admin dashboard
    Then I should be able to reject the recipe
    And the recipe status should be updated to "Rejected"
    And the instructor should be notified of the rejection with feedback

  @tag3
  Scenario: Approve health and wellness tips shared by instructors
    Given an instructor has submitted a health tip titled "How to Stay Hydrated"
    When I review the tip in the admin dashboard
    Then I should be able to approve the tip
    And the tip status should be updated to "Approved"
    And the instructor should be notified of the approval

  @tag4
  Scenario: Addressing user feedback and complaints
    Given a user has submitted feedback saying "The article on healthy eating was helpful, but could use more detail."
    When I review the feedback in the admin dashboard
    Then I should be able to mark the feedback as "Reviewed"
    And I should send a response to the user thanking them for their feedback
    And I should forward the suggestion to the content team for improvements

  @tag5
  Scenario: Handle user complaints about inappropriate or inaccurate content
    Given a user has submitted a complaint saying "The article on exercise routines is misleading"
    When I review the complaint in the admin dashboard
    Then I should be able to mark the complaint as "Under Review"
    And I should initiate an investigation into the content
    And I should notify the user that their complaint is being reviewed