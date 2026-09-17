@login @regression @sanity
Feature: editProfile

  Scenario Outline: login to ndosi website and update profile
    Given I am on the login page
    And I enter email <email>
    And I enter password <password>
    When I click login button
    Then i should be logged in successfully
    And I click menu button
    And I click on the my profile
    And I click on the edit profile button
    And I click on choose photo
    Examples:
      | email                     | password  |
      | melomazibuko8@gmail.com   | Mwelase@1031 |