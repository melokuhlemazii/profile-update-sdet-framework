@login @regression @sanity
Feature: editProfile

  Scenario Outline: as a user i want to login to ndosi website
    Given I am on the login page
    And I enter email <email>
    And I enter password <password>
    When I click login button
    Then i should be logged in successfully
    And I click menu button
    And I click on the my profile
    And I click on the edit profile button
    Examples:
      | email                     | password  |
      | melomazibuko8@gmail.com   | Mwelase@1031 |