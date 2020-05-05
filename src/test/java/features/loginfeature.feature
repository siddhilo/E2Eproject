Feature: Application Login functionality

  Scenario Outline: Application Valid login
    Given User initiates chrome browser
    And User opens application url :"http://www.qaclickacademy.com/"
    And Navigates to LoginPage
    When User provides username: <username> and password: <password> and clicks on login
    Then User is successfully logged in <value>
    And closes the browser

    Examples:
    |username   |password   |value|
    |siddhi.surange@gmail.com   |pass12|true  |
    |user2                      |pass2 |false |
