Feature: Practice_Automation3

  @TC_01
  Scenario: Demosite registration-Login
    Given open the url
    When url is launched login to the application
    When enters the email and password and click on login
    Then click on logout

  @TC_02
  Scenario: Demosite registration-Remove file
    Given the url is opened in the website
    When the more is mouse overed and click on the File Upload
    When File is Selected
    Then remove the uploaded file

  @TC_03
  Scenario: Demosite registration-Leave mandatory fields
    Given the url is open in the browser
    When the demosite is clicked
    When the details are given and leaving the mandatory fields
    Then click on submit and take screenshot

  @TC_04
  Scenario: Demosite registration-Video play
    Given the url is opened in the browser
    When the url is launched click on demosite
    When mouseover to the video and click on vimeo
    When play the video
    Then tap on escape key and quit

  @TC_05
  Scenario: Demosite registration-Alerts
    Given Opens url in the browser
    When automation site is opens
    Then Click on SwitchTo and alerts
    Then get the alert text
