#Author: federicoperetti21@gmail.com
@AllWebTable
Feature: As an Engr. Candidate
  I need to automate http://www.way2automation.com/angularjs-protractor/webtables/ 
  So that I can show my awesome automation skills
  
  @addUser
  Scenario Outline: Add a user to the table and validate is inserted
   	Given Webtable page is open
    When The user add a new user <firstName>, <lastName>, <userName>, <password>, <customer>, <role>, <email>, <cellphone>
    Then The user is displayed on the table <userName>

  Examples: 
    | firstName | lastName | userName | password | customer    | role       | email          | cellphone |
    | John      | Doe      | DJ1      |  2345678 | Company BBB | Admin      | jd@example.com |  87654321 |
    | John      | Doe      | DJ2      |  2345678 | Company AAA | Customer   | jd@example.com |  87654321 |
    | John      | Doe      | DJ3      |  2345678 | Company AAA | Sales Team | jd@example.com |  87654321 |

	@delete
  Scenario: Delete user Novak from the table and validate user has been deleted
    Given Webtable page open
    And The user name <userName> exists
    When The user delete the user <userName>
    Then The user <userName> is deleted from the table

   Examples:
   | userName |
   | novak 	  |