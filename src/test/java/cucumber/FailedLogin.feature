@tag
Feature: User is not able to login using invalid credentials
	
	Background:
	Given User is landed on the landing page
	
  @tag1
  Scenario Outline: Warning message is thrown when user try to login with invalid credentials
    Given User is on the login page
    When User try to login with <email> and <password>
    Then "Warning: No match for E-Mail Address and/or Password." warning message is thrown

    Examples: 
      | email                   | password | 
      | thakurdpk786@gmail.com  |   msl    | 
      | deepak@mysutra.life     |   Msl    | 
      
   
