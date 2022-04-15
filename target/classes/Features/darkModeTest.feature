Feature: feature to test dark mode functionality

  @darkmodetest
  Scenario: check if the dark mode features functions correctly
    Given new browser is open
    And user is on login page
    When user clicks on the Dark Mode check box
    Then dark mode is applied to the web page
