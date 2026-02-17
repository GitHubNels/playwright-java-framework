Feature: Login functionality

  Scenario Outline: Valid the successfull login
    Given user is on the login page
    When user enters username <username> and password <password>
    Then user should see login success message
    And Logout the page

    Examples:
      | username  |  | password      |
      | "student" |  | "Password123" |
      #| "student" |  | "Password"    |

    Scenario: Get Data from Excel

      Given user is on the login page
      When Get Data from Excel