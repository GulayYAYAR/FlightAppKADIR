Feature: SignUp and Login


  @smoke
  Scenario: SignUp
    Given User navigates to website and verify title as "React App"
    When User verify Home Page header title as "Search Flight"
    Then User clicks signup button and verifies signup page header as "Sign Up"
    And User fill up signup form
    Then User clicks signup button
    And User verify success message as "User Created"
